package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.CreatedException;

import lombok.Getter;

public class CreatedContainerCreateCreatedResponseException extends CreatedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerCreateCreatedResponse responseValue;

	public CreatedContainerCreateCreatedResponseException(ContainerCreateCreatedResponse responseValue) {
		this.responseValue = responseValue;
	}
}
