package org.sourcepit.jd.client.error;

import org.sourcepit.jd.client.model.ErrorResponse;

public class BadParameterException extends ErrorResponseException
{
	private static final long serialVersionUID = 1L;

	public BadParameterException(ErrorResponse errorResponse)
	{
		super(errorResponse);
	}
}
