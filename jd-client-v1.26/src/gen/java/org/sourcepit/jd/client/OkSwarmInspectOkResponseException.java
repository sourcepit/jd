package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSwarmInspectOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SwarmInspectOkResponse responseValue;

	public OkSwarmInspectOkResponseException(SwarmInspectOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
