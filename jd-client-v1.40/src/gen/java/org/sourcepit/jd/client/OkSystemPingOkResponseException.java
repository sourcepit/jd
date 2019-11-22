package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemPingOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemPingOkResponse responseValue;

	public OkSystemPingOkResponseException(SystemPingOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
