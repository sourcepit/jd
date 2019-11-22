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

public class ConfigCreateResponse implements Closeable {
	public static interface Matcher<T> {
		default T caseCreated(ResponseValue<IdResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, CreatedIdResponseException {
			throw new CreatedIdResponseException(responseValue.get());
		}

		default T caseConflict(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, ConflictErrorResponseException {
			throw new ConflictErrorResponseException(responseValue.get());
		}

		default T caseInternalServerError(ResponseValue<ErrorResponse> responseValue) throws IOException,
				JsonParseException, JsonMappingException, InternalServerErrorErrorResponseException {
			throw new InternalServerErrorErrorResponseException(responseValue.get());
		}

		default T caseServiceUnavailable(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, ServiceUnavailableErrorResponseException {
			throw new ServiceUnavailableErrorResponseException(responseValue.get());
		}

		default T caseDefault(HttpResponse httpResponse) throws IOException, HttpResponseException {
			final StatusLine statusLine = httpResponse.getStatusLine();
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

	}

	private final ObjectMapper objectMapper;

	private final HttpResponse httpResponse;

	public ConfigCreateResponse(ObjectMapper objectMapper, HttpResponse httpResponse) {
		this.objectMapper = objectMapper;
		this.httpResponse = httpResponse;
	}

	public <T> T match(Matcher<T> matcher) throws IOException, JsonParseException, JsonMappingException,
			CreatedIdResponseException, ConflictErrorResponseException, InternalServerErrorErrorResponseException,
			ServiceUnavailableErrorResponseException {
		T value;
		switch (httpResponse.getStatusLine().getStatusCode()) {
		case 201: {
			value = matcher.caseCreated(new ResponseValue<>(objectMapper, IdResponse.class, httpResponse));
			break;
		}
		case 409: {
			value = matcher.caseConflict(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
			break;
		}
		case 500: {
			value = matcher
					.caseInternalServerError(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
			break;
		}
		case 503: {
			value = matcher
					.caseServiceUnavailable(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
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

	public IdResponse unwrap()
			throws IOException, JsonParseException, JsonMappingException, ConflictErrorResponseException,
			InternalServerErrorErrorResponseException, ServiceUnavailableErrorResponseException {
		return match(new Matcher<IdResponse>() {
			@Override
			public IdResponse caseCreated(ResponseValue<IdResponse> responseValue)
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
