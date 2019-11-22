package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkNetworkPruneOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final NetworkPruneOkResponse responseValue;

	public OkNetworkPruneOkResponseException(NetworkPruneOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
