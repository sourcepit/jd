package org.sourcepit.jd.client;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.sourcepit.jd.client.core.InternalServerErrorException;
import org.sourcepit.jd.client.core.ResponseValue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SystemPingHeadResponse implements Closeable {
	public static interface Matcher<T> {
		default T caseOk(ResponseValue<SystemPingHeadOkResponse> responseValue)
				throws IOException, JsonParseException, JsonMappingException, OkSystemPingHeadOkResponseException {
			throw new OkSystemPingHeadOkResponseException(responseValue.get());
		}

		default T caseInternalServerError() throws IOException {
			throw new InternalServerErrorException();
		}

		default T caseDefault(HttpResponse httpResponse) throws IOException, HttpResponseException {
			final StatusLine statusLine = httpResponse.getStatusLine();
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

	}

	private final ObjectMapper objectMapper;

	private final HttpResponse httpResponse;

	public SystemPingHeadResponse(ObjectMapper objectMapper, HttpResponse httpResponse) {
		this.objectMapper = objectMapper;
		this.httpResponse = httpResponse;
	}

	public <T> T match(Matcher<T> matcher) throws IOException, JsonParseException, JsonMappingException,
			OkSystemPingHeadOkResponseException, InternalServerErrorException {
		T value;
		switch (httpResponse.getStatusLine().getStatusCode()) {
		case 200: {
			value = matcher.caseOk(new ResponseValue<>(objectMapper, SystemPingHeadOkResponse.class, httpResponse));
			break;
		}
		case 500: {
			value = matcher.caseInternalServerError();
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

	public SystemPingHeadOkResponse unwrap()
			throws IOException, JsonParseException, JsonMappingException, InternalServerErrorException {
		return match(new Matcher<SystemPingHeadOkResponse>() {
			@Override
			public SystemPingHeadOkResponse caseOk(ResponseValue<SystemPingHeadOkResponse> responseValue)
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
