package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.ServiceUnavailableException;

import lombok.Getter;

public class ServiceUnavailableErrorResponseException extends ServiceUnavailableException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ErrorResponse responseValue;

	public ServiceUnavailableErrorResponseException(ErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
