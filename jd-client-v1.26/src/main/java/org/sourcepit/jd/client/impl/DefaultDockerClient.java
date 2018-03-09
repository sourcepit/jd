package org.sourcepit.jd.client.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.sourcepit.jd.client.ContainerCreateRequest;
import org.sourcepit.jd.client.ContainerCreateResponse;
import org.sourcepit.jd.client.ContainerListRequest;
import org.sourcepit.jd.client.ContainerListResponse;
import org.sourcepit.jd.client.DockerClient;
import org.sourcepit.jd.client.SystemVersionResponse;
import org.sourcepit.jd.client.core.annotation.QueryParameter;
import org.sourcepit.jd.client.error.BadParameterException;
import org.sourcepit.jd.client.error.ConflictException;
import org.sourcepit.jd.client.error.ImpossibleToAttachException;
import org.sourcepit.jd.client.error.NoSuchContainerException;
import org.sourcepit.jd.client.error.ServerErrorException;
import org.sourcepit.jd.client.impl.JdResponseHandler.ErrorResponseHandler;
import org.sourcepit.jd.client.model.ErrorResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultDockerClient implements DockerClient
{
	private static final String API_VERSION = "v1.26";

	private static final String[] PATH_CONTAINER_LIST = { "containers", "json" };

	private static final String[] PATH_CONTAINER_CREATE = { "containers", "create" };

	private static final String[] PATH_SYSTEM_VERSION = { "version" };

	private final HttpClient httpClient;

	private final URI dockerHostUri;

	private final ObjectMapper objectMapper;

	public DefaultDockerClient(HttpClient httpClient, URI dockerHostUri)
	{
		this.httpClient = httpClient;

		this.dockerHostUri = dockerHostUri;

		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.objectMapper = objectMapper;
	}

	@Override
	public ContainerListResponse containerList(ContainerListRequest request)
			throws BadParameterException, ServerErrorException, IOException
	{
		final Map<String, String> queryParams = new LinkedHashMap<>();
		collectQueryParameters(request, queryParams);

		final HttpGet httpRequest = new HttpGet(genUri(PATH_CONTAINER_LIST, queryParams));
		final Class<ContainerListResponse> responseType = ContainerListResponse.class;
		final ErrorResponseHandler errorHandler = new ErrorResponseHandler()
		{
			@Override
			public void handleErrorResponse(int statusCode, ErrorResponse errorResponse)
					throws ClientProtocolException, IOException
			{
				switch (statusCode)
				{
					case 400:
						throw new BadParameterException(errorResponse);
					case 500:
						throw new ServerErrorException(errorResponse);
					default:
						break;
				}
			}
		};
		return httpClient.execute(httpRequest, new JdResponseHandler<>(objectMapper, responseType, errorHandler));
	}

	@Override
	public ContainerCreateResponse containerCreate(ContainerCreateRequest request) throws BadParameterException,
			NoSuchContainerException, ImpossibleToAttachException, ConflictException, ServerErrorException, IOException
	{
		final Map<String, String> queryParams = new LinkedHashMap<>();
		collectQueryParameters(request, queryParams);

		final URI uri = genUri(PATH_CONTAINER_CREATE, queryParams);

		final byte[] bytes;
		try
		{
			bytes = objectMapper.writeValueAsBytes(request);
		}
		catch (JsonProcessingException e)
		{
			throw new IllegalStateException(e);
		}

		final HttpEntity httpEntity = new ByteArrayEntity(bytes, ContentType.APPLICATION_JSON);

		final HttpPost httpRequest = new HttpPost(uri);
		httpRequest.setEntity(httpEntity);

		final ErrorResponseHandler errorHandler = new ErrorResponseHandler()
		{
			@Override
			public void handleErrorResponse(int statusCode, ErrorResponse errorResponse)
					throws ClientProtocolException, IOException
			{
				switch (statusCode)
				{
					case 400:
						throw new BadParameterException(errorResponse);
					case 404:
						throw new NoSuchContainerException(errorResponse);
					case 406:
						throw new ImpossibleToAttachException(errorResponse);
					case 409:
						throw new ConflictException(errorResponse);
					case 500:
						throw new ServerErrorException(errorResponse);
					default:
						break;
				}
			}
		};

		final Class<ContainerCreateResponse> responseType = ContainerCreateResponse.class;

		return httpClient.execute(httpRequest, new JdResponseHandler<>(objectMapper, 201, responseType, errorHandler));
	}

	@Override
	public SystemVersionResponse systemVersion() throws ServerErrorException, IOException
	{
		final HttpGet request = new HttpGet(genUri(PATH_SYSTEM_VERSION, null));
		final Class<SystemVersionResponse> responseType = SystemVersionResponse.class;
		final ErrorResponseHandler errorHandler = new ErrorResponseHandler()
		{
			@Override
			public void handleErrorResponse(int statusCode, ErrorResponse errorResponse)
					throws ClientProtocolException, IOException
			{
				if (statusCode == 500)
				{
					throw new ServerErrorException(errorResponse);
				}
			}
		};
		return httpClient.execute(request, new JdResponseHandler<>(objectMapper, responseType, errorHandler));
	}

	private URI genUri(String[] segments, Map<String, String> queryParams)
	{
		final URIBuilder uriBuilder = new URIBuilder(dockerHostUri);
		uriBuilder.setPath(genPath(segments));

		if (queryParams != null && !queryParams.isEmpty())
		{
			for (Entry<String, String> entry : queryParams.entrySet())
			{
				final String value = entry.getValue();
				if (value != null)
				{
					final String name = entry.getKey();
					uriBuilder.addParameter(name, value);
				}
			}
		}

		try
		{
			return uriBuilder.build();
		}
		catch (URISyntaxException e)
		{
			throw new IllegalStateException(e);
		}
	}

	private static String genPath(String[] segments)
	{
		final StringBuilder pathBuilder = new StringBuilder();
		pathBuilder.append('/');
		pathBuilder.append(API_VERSION);

		for (String segment : segments)
		{
			pathBuilder.append('/');
			pathBuilder.append(segment);
		}

		return pathBuilder.toString();
	}

	private static void collectQueryParameters(Object bean, Map<String, String> params)
	{
		Class<?> c = bean.getClass();
		while (c != null)
		{
			for (Field field : c.getDeclaredFields())
			{
				if (field.isAnnotationPresent(QueryParameter.class))
				{
					final String paramName = field.getName();
					if (!params.containsKey(paramName))
					{
						final Object fieldValue = getFieldValue(field, bean);
						if (fieldValue == null)
						{
							params.put(paramName, null);
						}
						else
						{
							params.put(paramName, toString(fieldValue));

						}
					}
				}
			}
			c = c.getSuperclass();
		}
	}

	private static String toString(Object value)
	{
		if (value instanceof String)
		{
			return value.toString();
		}

		if (value instanceof Integer)
		{
			return Integer.toString(((Integer) value).intValue());
		}

		if (value instanceof Boolean)
		{
			return Boolean.toString(((Boolean) value).booleanValue());
		}

		throw new IllegalArgumentException(
				String.format("Don't know how to toString value %s of type %s", value, value.getClass()));
	}

	private static Object getFieldValue(Field field, Object bean)
	{
		if (!field.isAccessible())
		{
			field.setAccessible(true);
		}

		final Object value;
		try
		{
			value = field.get(bean);
		}
		catch (Exception e)
		{
			throw new IllegalStateException(e);
		}
		return value;
	}

}
