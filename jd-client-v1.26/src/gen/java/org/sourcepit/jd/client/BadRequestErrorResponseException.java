package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.BadRequestException;

import lombok.Getter;

public class BadRequestErrorResponseException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public BadRequestErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
