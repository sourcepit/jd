package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.BadRequestException;

import lombok.Getter;

public class BadRequestContainerGetArchiveBadRequestResponseException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerGetArchiveBadRequestResponse responseValue;

	public BadRequestContainerGetArchiveBadRequestResponseException(
			ContainerGetArchiveBadRequestResponse responseValue) {
		this.responseValue = responseValue;
	}
}
