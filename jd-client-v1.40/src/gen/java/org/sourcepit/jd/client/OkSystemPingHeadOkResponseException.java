package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemPingHeadOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemPingHeadOkResponse responseValue;

	public OkSystemPingHeadOkResponseException(SystemPingHeadOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
