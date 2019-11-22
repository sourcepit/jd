package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSwarmUnlockkeyOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SwarmUnlockkeyOkResponse responseValue;

	public OkSwarmUnlockkeyOkResponseException(SwarmUnlockkeyOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
