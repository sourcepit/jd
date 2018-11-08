package org.sourcepit.jd.client.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public abstract class JacksonResponseHandler<T> implements ResponseHandler<T> {
	private final ObjectMapper objectMapper;

	public JacksonResponseHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		final StatusLine statusLine = response.getStatusLine();
		return handleResponse(statusLine, response.getEntity());
	}

	protected abstract T handleResponse(StatusLine statusLine, HttpEntity entity)
			throws ClientProtocolException, IOException;

	protected <R> R deserialize(HttpEntity entity, Class<R> type, DeserializationFeature... deserializationFeatures)
			throws IOException, JsonParseException, JsonMappingException {
		ObjectReader objectReader = objectMapper.readerFor(type);
		if (deserializationFeatures != null) {
			objectReader = objectReader.withFeatures(deserializationFeatures);
		}

		final ContentType contentType = ContentType.get(entity);
		final Charset charset = contentType == null ? null : contentType.getCharset();
		if (charset == null) {
			return objectReader.readValue(entity.getContent());
		} else {
			return objectReader.readValue(new InputStreamReader(entity.getContent()));
		}
	}

	protected T handleUnmappedResponse(HttpResponse response) throws ClientProtocolException, IOException {
		EntityUtils.consume(response.getEntity());
		final StatusLine statusLine = response.getStatusLine();
		throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
	}

}
