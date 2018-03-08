package org.sourcepit.jd.client.error;

import org.sourcepit.jd.client.model.ErrorResponse;

public class NoSuchContainerException extends ErrorResponseException
{
	private static final long serialVersionUID = 1L;

	public NoSuchContainerException(ErrorResponse errorResponse)
	{
		super(errorResponse);
	}
}
