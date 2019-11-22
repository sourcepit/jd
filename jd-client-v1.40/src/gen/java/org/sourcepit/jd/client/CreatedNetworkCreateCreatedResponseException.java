package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.CreatedException;

import lombok.Getter;

public class CreatedNetworkCreateCreatedResponseException extends CreatedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final NetworkCreateCreatedResponse responseValue;

	public CreatedNetworkCreateCreatedResponseException(NetworkCreateCreatedResponse responseValue) {
		this.responseValue = responseValue;
	}
}
