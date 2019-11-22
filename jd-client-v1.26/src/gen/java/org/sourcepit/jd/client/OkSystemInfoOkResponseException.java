package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemInfoOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemInfoOkResponse responseValue;

	public OkSystemInfoOkResponseException(SystemInfoOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
