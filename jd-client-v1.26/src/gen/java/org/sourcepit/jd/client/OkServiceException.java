package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkServiceException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Service responseValue;

	public OkServiceException(Service responseValue) {
		this.responseValue = responseValue;
	}
}
