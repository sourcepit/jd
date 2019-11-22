package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.ForbiddenException;

import lombok.Getter;

public class ForbiddenErrorResponseException extends ForbiddenException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public ForbiddenErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
