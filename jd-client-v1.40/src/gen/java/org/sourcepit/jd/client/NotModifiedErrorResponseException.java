package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.NotModifiedException;

import lombok.Getter;

public class NotModifiedErrorResponseException extends NotModifiedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public NotModifiedErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
