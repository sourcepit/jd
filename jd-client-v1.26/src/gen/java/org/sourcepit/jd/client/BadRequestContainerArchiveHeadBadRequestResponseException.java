package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.BadRequestException;

import lombok.Getter;

public class BadRequestContainerArchiveHeadBadRequestResponseException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerArchiveHeadBadRequestResponse responseValue;

	public BadRequestContainerArchiveHeadBadRequestResponseException(
			ContainerArchiveHeadBadRequestResponse responseValue) {
		this.responseValue = responseValue;
	}
}
