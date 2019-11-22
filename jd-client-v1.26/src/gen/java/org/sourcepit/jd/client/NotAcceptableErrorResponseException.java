package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.NotAcceptableException;

import lombok.Getter;

public class NotAcceptableErrorResponseException extends NotAcceptableException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public NotAcceptableErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
