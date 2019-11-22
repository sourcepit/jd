package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkNetworkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Network responseValue;

	public OkNetworkException(Network responseValue) {
		this.responseValue = responseValue;
	}
}
