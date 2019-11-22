package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemVersionOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemVersionOkResponse responseValue;

	public OkSystemVersionOkResponseException(SystemVersionOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
