package org.sourcepit.jd.client.error;

import org.sourcepit.jd.client.model.ErrorResponse;

public class ServerErrorException extends ErrorResponseException {
	private static final long serialVersionUID = 1L;

	public ServerErrorException(ErrorResponse errorResponse) {
		super(errorResponse);
	}

}
