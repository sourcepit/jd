package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerWaitOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerWaitOkResponse responseValue;

	public OkContainerWaitOkResponseException(ContainerWaitOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
