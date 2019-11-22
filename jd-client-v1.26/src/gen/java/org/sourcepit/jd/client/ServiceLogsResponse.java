package org.sourcepit.jd.client;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.sourcepit.jd.client.core.ResponseValue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ServiceLogsResponse implements Closeable {
	public static interface Matcher<T> {
		default T caseSwitchingProtocols(ResponseValue<InputStream> responseValue)
				throws IOException, JsonParseException, JsonMappingException, SwitchingProtocolsBinaryException {
			throw new SwitchingProtocolsBinaryException(responseValue.get());
		}

		default T caseOk(ResponseValue<InputStream> responseValue)
				throws IOException, JsonParseException, JsonMappingException, OkBinaryException {
			throw new OkBinaryException(responseValue.get());
		}

		default T caseNotFound(ResponseValue<ErrorResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, NotFoundErrorResponseException {
			throw new NotFoundErrorResponseException(responseValue.get());
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

	public ServiceLogsResponse(ObjectMapper objectMapper, HttpResponse httpResponse) {
		this.objectMapper = objectMapper;
		this.httpResponse = httpResponse;
	}

	public <T> T match(Matcher<T> matcher) throws IOException, JsonParseException, JsonMappingException,
			SwitchingProtocolsBinaryException, OkBinaryException, NotFoundErrorResponseException,
			InternalServerErrorErrorResponseException, ServiceUnavailableErrorResponseException {
		T value;
		switch (httpResponse.getStatusLine().getStatusCode()) {
		case 101: {
			value = matcher.caseSwitchingProtocols(new ResponseValue<>(objectMapper, InputStream.class, httpResponse));
			break;
		}
		case 200: {
			value = matcher.caseOk(new ResponseValue<>(objectMapper, InputStream.class, httpResponse));
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

	public InputStream unwrap() throws IOException, JsonParseException, JsonMappingException,
			SwitchingProtocolsBinaryException, NotFoundErrorResponseException,
			InternalServerErrorErrorResponseException, ServiceUnavailableErrorResponseException {
		return match(new Matcher<InputStream>() {
			@Override
			public InputStream caseOk(ResponseValue<InputStream> responseValue)
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
