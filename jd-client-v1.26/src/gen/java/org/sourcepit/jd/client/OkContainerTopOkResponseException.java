package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerTopOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerTopOkResponse responseValue;

	public OkContainerTopOkResponseException(ContainerTopOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
