package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.CreatedException;

import lombok.Getter;

public class CreatedSecretCreateCreatedResponseException extends CreatedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SecretCreateCreatedResponse responseValue;

	public CreatedSecretCreateCreatedResponseException(SecretCreateCreatedResponse responseValue) {
		this.responseValue = responseValue;
	}
}
