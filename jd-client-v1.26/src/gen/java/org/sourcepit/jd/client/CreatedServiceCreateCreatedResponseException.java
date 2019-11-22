package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.CreatedException;

import lombok.Getter;

public class CreatedServiceCreateCreatedResponseException extends CreatedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ServiceCreateCreatedResponse responseValue;

	public CreatedServiceCreateCreatedResponseException(ServiceCreateCreatedResponse responseValue) {
		this.responseValue = responseValue;
	}
}
