package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSwarmException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Swarm responseValue;

	public OkSwarmException(Swarm responseValue) {
		this.responseValue = responseValue;
	}
}
