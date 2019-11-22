package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerInspectOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerInspectOkResponse responseValue;

	public OkContainerInspectOkResponseException(ContainerInspectOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
