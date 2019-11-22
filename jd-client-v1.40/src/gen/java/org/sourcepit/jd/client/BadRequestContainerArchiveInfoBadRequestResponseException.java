package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.BadRequestException;

import lombok.Getter;

public class BadRequestContainerArchiveInfoBadRequestResponseException extends BadRequestException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerArchiveInfoBadRequestResponse responseValue;

	public BadRequestContainerArchiveInfoBadRequestResponseException(
			ContainerArchiveInfoBadRequestResponse responseValue) {
		this.responseValue = responseValue;
	}
}
