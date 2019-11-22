package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerUpdateOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerUpdateOkResponse responseValue;

	public OkContainerUpdateOkResponseException(ContainerUpdateOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
