package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.InternalServerErrorException;

import lombok.Getter;

public class InternalServerErrorSystemPingInternalServerErrorResponseException extends InternalServerErrorException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemPingInternalServerErrorResponse responseValue;

	public InternalServerErrorSystemPingInternalServerErrorResponseException(
			SystemPingInternalServerErrorResponse responseValue) {
		this.responseValue = responseValue;
	}
}
