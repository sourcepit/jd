package org.sourcepit.jd.client.error;

import java.io.IOException;

import org.sourcepit.jd.client.model.ErrorResponse;

public abstract class ErrorResponseException extends IOException
{
	private static final long serialVersionUID = 1L;

	private final ErrorResponse errorResponse;

	public ErrorResponseException(ErrorResponse errorResponse)
	{
		super(errorResponse.getMessage());
		this.errorResponse = errorResponse;
	}

	public ErrorResponse getErrorResponse()
	{
		return errorResponse;
	}
}
