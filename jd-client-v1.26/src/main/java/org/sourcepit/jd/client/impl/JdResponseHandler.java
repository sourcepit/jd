package org.sourcepit.jd.client.impl;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;
import org.sourcepit.jd.client.model.ErrorResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JdResponseHandler<T> extends JacksonResponseHandler<T>
{
	public interface ErrorResponseHandler
	{
		void handleErrorResponse(int statusCode, ErrorResponse errorResponse)
				throws ClientProtocolException, IOException;
	}

	private final int codeOk;

	private final Class<T> responseType;

	private final ErrorResponseHandler errorResponseHandler;

	public JdResponseHandler(ObjectMapper objectMapper, Class<T> responseType,
			ErrorResponseHandler errorResponseHandler)
	{
		this(objectMapper, 200, responseType, errorResponseHandler);
	}

	public JdResponseHandler(ObjectMapper objectMapper, int codeOk, Class<T> responseType,
			ErrorResponseHandler errorResponseHandler)
	{
		super(objectMapper);
		this.codeOk = codeOk;
		this.responseType = responseType;
		this.errorResponseHandler = errorResponseHandler;
	}

	@Override
	protected T handleResponse(StatusLine statusLine, HttpEntity entity) throws ClientProtocolException, IOException
	{
		final int statusCode = statusLine.getStatusCode();
		if (statusCode == codeOk)
		{
			return deserialize(entity, responseType);
		}

		final ErrorResponse errorResponse = tryGetErrorResponse(entity);
		if (errorResponse != null)
		{
			errorResponseHandler.handleErrorResponse(statusCode, errorResponse);
		}

		EntityUtils.consume(entity);
		final String msg = errorResponse == null ? statusLine.getReasonPhrase() : errorResponse.getMessage();
		throw new HttpResponseException(statusCode, msg);
	}

	private ErrorResponse tryGetErrorResponse(HttpEntity entity) throws IOException
	{
		ErrorResponse errorResponse;
		try
		{
			errorResponse = deserialize(entity, ErrorResponse.class, DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		}
		catch (JsonProcessingException e)
		{
			errorResponse = null;
		}
		return errorResponse != null && errorResponse.getMessage() != null ? errorResponse : null;
	}
}
