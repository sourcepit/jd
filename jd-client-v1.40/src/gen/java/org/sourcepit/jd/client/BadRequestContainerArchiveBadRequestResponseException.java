package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.BadRequestException;

import lombok.Getter;

public class BadRequestContainerArchiveBadRequestResponseException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerArchiveBadRequestResponse responseValue;

	public BadRequestContainerArchiveBadRequestResponseException(ContainerArchiveBadRequestResponse responseValue) {
		this.responseValue = responseValue;
	}
}
