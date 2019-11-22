package org.sourcepit.jd.client.core;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class ResponseValue<T> implements Closeable {

	private final ObjectMapper objectMapper;

	private final Class<T> type;

	private final Class<?> itemType;

	private final HttpResponse response;

	public ResponseValue(ObjectMapper objectMapper, Class<T> type, HttpResponse response) {
		this(objectMapper, type, null, response);
	}

	@SuppressWarnings("unchecked")
	public ResponseValue(ObjectMapper objectMapper, Class<?> type, Class<?> itemType, HttpResponse response) {
		this.objectMapper = objectMapper;
		this.type = (Class<T>) type;
		this.itemType = itemType;
		this.response = response;
	}

	@SuppressWarnings("unchecked")
	public T get() throws IOException, JsonParseException, JsonMappingException {
		if (type.isAssignableFrom(InputStream.class)) {
			return (T) response.getEntity().getContent();
		}
		try {
			if (itemType == null) {
				return objectMapper.readValue(response.getEntity().getContent(), type);
			} else {
				final CollectionType collectionType = objectMapper.getTypeFactory()
						.constructCollectionType((Class<? extends Collection<?>>) type, itemType);
				return objectMapper.readValue(response.getEntity().getContent(), collectionType);
			}
		} finally {
			close();
		}
	}

	@Override
	public void close() throws IOException {
		EntityUtils.consume(response.getEntity());
		if (response instanceof CloseableHttpResponse) {
			((CloseableHttpResponse) response).close();
		}
	}
}