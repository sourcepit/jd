package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.ConflictException;

import lombok.Getter;

public class ConflictErrorResponseException extends ConflictException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public ConflictErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
