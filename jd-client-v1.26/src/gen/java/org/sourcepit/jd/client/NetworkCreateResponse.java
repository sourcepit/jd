package org.sourcepit.jd.client;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.sourcepit.jd.client.core.ResponseValue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NetworkCreateResponse implements Closeable {
	public static interface Matcher<T> {
		default T caseCreated(ResponseValue<NetworkCreateCreatedResponse> responseValue) throws IOException,
				JsonParseException, JsonMappingException, CreatedNetworkCreateCreatedResponseException {
			throw new CreatedNetworkCreateCreatedResponseException(responseValue.get());
		}

		default T caseForbidden(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, ForbiddenErrorResponseException {
			throw new ForbiddenErrorResponseException(responseValue.get());
		}

		default T caseNotFound(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, NotFoundErrorResponseException {
			throw new NotFoundErrorResponseException(responseValue.get());
		}

		default T caseInternalServerError(ResponseValue<ErrorResponse> responseValue) throws IOException,
				JsonParseException, JsonMappingException, InternalServerErrorErrorResponseException {
			throw new InternalServerErrorErrorResponseException(responseValue.get());
		}

		default T caseDefault(HttpResponse httpResponse) throws IOException, HttpResponseException {
			final StatusLine statusLine = httpResponse.getStatusLine();
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

	}

	private final ObjectMapper objectMapper;

	private final HttpResponse httpResponse;

	public NetworkCreateResponse(ObjectMapper objectMapper, HttpResponse httpResponse) {
		this.objectMapper = objectMapper;
		this.httpResponse = httpResponse;
	}

	public <T> T match(Matcher<T> matcher)
			throws IOException, JsonParseException, JsonMappingException, CreatedNetworkCreateCreatedResponseException,
			ForbiddenErrorResponseException, NotFoundErrorResponseException, InternalServerErrorErrorResponseException {
		T value;
		switch (httpResponse.getStatusLine().getStatusCode()) {
		case 201: {
			value = matcher
					.caseCreated(new ResponseValue<>(objectMapper, NetworkCreateCreatedResponse.class, httpResponse));
			break;
		}
		case 403: {
			value = matcher.caseForbidden(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
			break;
		}
		case 404: {
			value = matcher.caseNotFound(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
			break;
		}
		case 500: {
			value = matcher
					.caseInternalServerError(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
			break;
		}
		default:
			value = null;
			break;
		}
		if (value == null) {
			value = matcher.caseDefault(httpResponse);
		}
		return value;
	}

	public NetworkCreateCreatedResponse unwrap() throws IOException, JsonParseException, JsonMappingException,
			ForbiddenErrorResponseException, NotFoundErrorResponseException, InternalServerErrorErrorResponseException {
		return match(new Matcher<NetworkCreateCreatedResponse>() {
			@Override
			public NetworkCreateCreatedResponse caseCreated(ResponseValue<NetworkCreateCreatedResponse> responseValue)
					throws IOException, JsonParseException, JsonMappingException {
				return responseValue.get();
			}
		});
	}

	@Override
	public void close() throws IOException {
		EntityUtils.consume(httpResponse.getEntity());
		if (httpResponse instanceof Closeable) {
			((Closeable) httpResponse).close();
		}
	}

}
