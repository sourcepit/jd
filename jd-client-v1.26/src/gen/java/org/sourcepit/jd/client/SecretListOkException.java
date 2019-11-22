package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class SecretListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<Secret> responseValue;

	public SecretListOkException(List<Secret> responseValue) {
		this.responseValue = responseValue;
	}
}
