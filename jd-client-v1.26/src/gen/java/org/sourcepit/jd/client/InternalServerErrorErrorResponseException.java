package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.InternalServerErrorException;

import lombok.Getter;

public class InternalServerErrorErrorResponseException extends InternalServerErrorException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public InternalServerErrorErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
