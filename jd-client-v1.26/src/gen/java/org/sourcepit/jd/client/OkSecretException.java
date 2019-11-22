package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSecretException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Secret responseValue;

	public OkSecretException(Secret responseValue) {
		this.responseValue = responseValue;
	}
}
