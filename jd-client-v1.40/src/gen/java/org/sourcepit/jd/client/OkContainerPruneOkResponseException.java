package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerPruneOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerPruneOkResponse responseValue;

	public OkContainerPruneOkResponseException(ContainerPruneOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
