package org.sourcepit.jd.client;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.sourcepit.jd.client.core.NoContentException;
import org.sourcepit.jd.client.core.ResponseValue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContainerDeleteResponse implements Closeable {
	public static interface Matcher<T> {
		default T caseNoContent() throws IOException {
			throw new NoContentException();
		}

		default T caseBadRequest(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, BadRequestErrorResponseException {
			throw new BadRequestErrorResponseException(responseValue.get());
		}

		default T caseNotFound(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, NotFoundErrorResponseException {
			throw new NotFoundErrorResponseException(responseValue.get());
		}

		default T caseConflict(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, ConflictErrorResponseException {
			throw new ConflictErrorResponseException(responseValue.get());
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

	public ContainerDeleteResponse(ObjectMapper objectMapper, HttpResponse httpResponse) {
		this.objectMapper = objectMapper;
		this.httpResponse = httpResponse;
	}

	public <T> T match(Matcher<T> matcher) throws IOException, JsonParseException, JsonMappingException,
			NoContentException, BadRequestErrorResponseException, NotFoundErrorResponseException,
			ConflictErrorResponseException, InternalServerErrorErrorResponseException {
		T value;
		switch (httpResponse.getStatusLine().getStatusCode()) {
		case 204: {
			value = matcher.caseNoContent();
			break;
		}
		case 400: {
			value = matcher.caseBadRequest(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
			break;
		}
		case 404: {
			value = matcher.caseNotFound(new ResponseValue<>(objectMapper, ErrorResponse.class, httpResponse));
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
		default:
			value = null;
			break;
		}
		if (value == null) {
			value = matcher.caseDefault(httpResponse);
		}
		return value;
	}

	public void unwrap() throws IOException, JsonParseException, JsonMappingException, BadRequestErrorResponseException,
			NotFoundErrorResponseException, ConflictErrorResponseException, InternalServerErrorErrorResponseException {
		match(new Matcher<Void>() {
			@Override
			public Void caseNoContent() {
				return null;
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
