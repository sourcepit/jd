package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerArchiveInfoOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerArchiveInfoOkResponse responseValue;

	public OkContainerArchiveInfoOkResponseException(ContainerArchiveInfoOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
