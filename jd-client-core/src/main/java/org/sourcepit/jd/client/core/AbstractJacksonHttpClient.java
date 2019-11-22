package org.sourcepit.jd.client.core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.sourcepit.jd.client.core.annotation.HeaderParameter;
import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbstractJacksonHttpClient {

	protected final HttpClient httpClient;
	protected final URI dockerHostUri;
	protected final ObjectMapper objectMapper;

	public AbstractJacksonHttpClient(HttpClient httpClient, URI dockerHostUri) {
		this.httpClient = httpClient;

		this.dockerHostUri = dockerHostUri;

		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.objectMapper = objectMapper;
	}

	private String genPath(String[] segments, Map<String, String> pathParams) {
		final StringBuilder pathBuilder = new StringBuilder();

		for (String segment : segments) {
			pathBuilder.append('/');
			final String replacement = pathParams == null ? null : pathParams.get(segment);
			pathBuilder.append(replacement == null ? segment : replacement);
		}

		return pathBuilder.toString();
	}

	protected HttpResponse execute(HttpMethod method, String[] path, Object request)
			throws IOException, ClientProtocolException {
		final URI uri;
		if (request == null) {
			uri = genUri(path, null, null);
		} else {
			final Map<String, String> pathParams = new LinkedHashMap<>();
			collectPathParameters(request, pathParams);
			final Map<String, String> queryParams = new LinkedHashMap<>();
			collectQueryParameters(request, queryParams);
			uri = genUri(path, pathParams, queryParams);
		}

		final HttpUriRequest httpRequest;
		switch (method) {
		case DELETE:
			httpRequest = new HttpDelete(uri);
			break;
		case GET:
			httpRequest = new HttpGet(uri);
			break;
		case HEAD:
			httpRequest = new HttpHead(uri);
			break;
		case OPTIONS:
			httpRequest = new HttpOptions(uri);
			break;
		case PATCH:
			httpRequest = new HttpPatch(uri);
			break;
		case POST:
			httpRequest = new HttpPost(uri);
			break;
		case PUT:
			httpRequest = new HttpPut(uri);
			break;
		case TRACE:
			httpRequest = new HttpTrace(uri);
			break;
		default:
			throw new IllegalStateException();
		}

		if (request != null) {
			final Map<String, String> headerParams = new LinkedHashMap<>();
			collectHeaderParameters(request, headerParams);
			for (Entry<String, String> entry : headerParams.entrySet()) {
				httpRequest.addHeader(entry.getKey(), entry.getValue());
			}

			if (hasJsonProperty(request)) {
				final byte[] bytes = objectMapper.writeValueAsBytes(request);
				final HttpEntity httpEntity = new ByteArrayEntity(bytes, ContentType.APPLICATION_JSON);
				((HttpEntityEnclosingRequest) httpRequest).setEntity(httpEntity);
			}
		}

		return httpClient.execute(httpRequest);
	}

	private URI genUri(String[] segments, Map<String, String> pathParams, Map<String, String> queryParams) {
		final URIBuilder uriBuilder = new URIBuilder(dockerHostUri);
		uriBuilder.setPath(genPath(segments, pathParams));

		if (queryParams != null && !queryParams.isEmpty()) {
			for (Entry<String, String> entry : queryParams.entrySet()) {
				final String value = entry.getValue();
				if (value != null) {
					final String name = entry.getKey();
					uriBuilder.addParameter(name, value);
				}
			}
		}

		try {
			return uriBuilder.build();
		} catch (URISyntaxException e) {
			throw new IllegalStateException(e);
		}
	}

	private static void collectPathParameters(Object bean, Map<String, String> params) {
		Class<?> c = bean.getClass();
		while (c != null) {
			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(PathParameter.class)) {
					final String paramName = "{" + field.getName() + "}";
					if (!params.containsKey(paramName)) {
						final Object fieldValue = getFieldValue(field, bean);
						if (fieldValue == null) {
							params.put(paramName, null);
						} else {
							params.put(paramName, toString(fieldValue));

						}
					}
				}
			}
			c = c.getSuperclass();
		}
	}

	private static void collectQueryParameters(Object bean, Map<String, String> params) {
		Class<?> c = bean.getClass();
		while (c != null) {
			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(QueryParameter.class)) {
					final String paramName = field.getName();
					if (!params.containsKey(paramName)) {
						final Object fieldValue = getFieldValue(field, bean);
						if (fieldValue == null) {
							params.put(paramName, null);
						} else {
							params.put(paramName, toString(fieldValue));

						}
					}
				}
			}
			c = c.getSuperclass();
		}
	}

	private static void collectHeaderParameters(Object bean, Map<String, String> params) {
		Class<?> c = bean.getClass();
		while (c != null) {
			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(HeaderParameter.class)) {
					final String paramName = field.getName();
					if (!params.containsKey(paramName)) {
						final Object fieldValue = getFieldValue(field, bean);
						if (fieldValue == null) {
							params.put(paramName, null);
						} else {
							params.put(paramName, toString(fieldValue));

						}
					}
				}
			}
			c = c.getSuperclass();
		}
	}

	private static boolean hasJsonProperty(Object bean) {
		Class<?> c = bean.getClass();
		while (c != null) {
			for (Field field : c.getDeclaredFields()) {
				if (field.isAnnotationPresent(JsonProperty.class)) {
					return true;
				}
			}
			c = c.getSuperclass();
		}
		return false;
	}

	private static String toString(Object value) {
		if (value instanceof String) {
			return value.toString();
		}

		if (value instanceof Integer) {
			return Integer.toString(((Integer) value).intValue());
		}

		if (value instanceof Boolean) {
			return Boolean.toString(((Boolean) value).booleanValue());
		}

		if (value instanceof Long) {
			return Long.toString(((Long) value).longValue());
		}

		throw new IllegalArgumentException(
				String.format("Don't know how to toString value %s of type %s", value, value.getClass()));
	}

	private static Object getFieldValue(Field field, Object bean) {
		if (!field.isAccessible()) {
			field.setAccessible(true);
		}

		final Object value;
		try {
			value = field.get(bean);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		return value;
	}

}