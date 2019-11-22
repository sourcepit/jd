package org.sourcepit.jd.client;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.sourcepit.jd.client.core.ConflictException;
import org.sourcepit.jd.client.core.NotFoundException;
import org.sourcepit.jd.client.core.OkException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExecStartResponse implements Closeable {
	public static interface Matcher<T> {
		default T caseOk() throws IOException {
			throw new OkException();
		}

		default T caseNotFound() throws IOException {
			throw new NotFoundException();
		}

		default T caseConflict() throws IOException {
			throw new ConflictException();
		}

		default T caseDefault(HttpResponse httpResponse) throws IOException, HttpResponseException {
			final StatusLine statusLine = httpResponse.getStatusLine();
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

	}

	@SuppressWarnings("unused")
	private final ObjectMapper objectMapper;

	private final HttpResponse httpResponse;

	public ExecStartResponse(ObjectMapper objectMapper, HttpResponse httpResponse) {
		this.objectMapper = objectMapper;
		this.httpResponse = httpResponse;
	}

	public <T> T match(Matcher<T> matcher) throws IOException, JsonParseException, JsonMappingException, OkException,
			NotFoundException, ConflictException {
		T value;
		switch (httpResponse.getStatusLine().getStatusCode()) {
		case 200: {
			value = matcher.caseOk();
			break;
		}
		case 404: {
			value = matcher.caseNotFound();
			break;
		}
		case 409: {
			value = matcher.caseConflict();
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

	public void unwrap()
			throws IOException, JsonParseException, JsonMappingException, NotFoundException, ConflictException {
		match(new Matcher<Void>() {
			@Override
			public Void caseOk() {
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
