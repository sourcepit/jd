package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkServiceUpdateResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ServiceUpdateResponse responseValue;

	public OkServiceUpdateResponseException(ServiceUpdateResponse responseValue) {
		this.responseValue = responseValue;
	}
}
