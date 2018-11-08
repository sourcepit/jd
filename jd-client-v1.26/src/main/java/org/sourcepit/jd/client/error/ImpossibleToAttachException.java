package org.sourcepit.jd.client.error;

import org.sourcepit.jd.client.model.ErrorResponse;

public class ImpossibleToAttachException extends ErrorResponseException {
	private static final long serialVersionUID = 1L;

	public ImpossibleToAttachException(ErrorResponse errorResponse) {
		super(errorResponse);
	}
}
