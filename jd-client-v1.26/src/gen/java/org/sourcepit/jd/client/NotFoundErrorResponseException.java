package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.NotFoundException;

import lombok.Getter;

public class NotFoundErrorResponseException extends NotFoundException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public NotFoundErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
