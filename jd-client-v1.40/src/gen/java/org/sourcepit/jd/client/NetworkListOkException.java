package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class NetworkListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<Network> responseValue;

	public NetworkListOkException(List<Network> responseValue) {
		this.responseValue = responseValue;
	}
}
