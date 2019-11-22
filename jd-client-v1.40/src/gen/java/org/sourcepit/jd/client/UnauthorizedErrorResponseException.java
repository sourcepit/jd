package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.UnauthorizedException;

import lombok.Getter;

public class UnauthorizedErrorResponseException extends UnauthorizedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public UnauthorizedErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
