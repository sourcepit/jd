package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemAuthOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemAuthOkResponse responseValue;

	public OkSystemAuthOkResponseException(SystemAuthOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
