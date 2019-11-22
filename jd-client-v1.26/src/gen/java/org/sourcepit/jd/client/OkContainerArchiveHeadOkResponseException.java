package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerArchiveHeadOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerArchiveHeadOkResponse responseValue;

	public OkContainerArchiveHeadOkResponseException(ContainerArchiveHeadOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
