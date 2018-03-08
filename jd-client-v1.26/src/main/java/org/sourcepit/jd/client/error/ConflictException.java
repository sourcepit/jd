package org.sourcepit.jd.client.error;

import org.sourcepit.jd.client.model.ErrorResponse;

public class ConflictException extends ErrorResponseException
{
	private static final long serialVersionUID = 1L;

	public ConflictException(ErrorResponse errorResponse)
	{
		super(errorResponse);
	}
}
