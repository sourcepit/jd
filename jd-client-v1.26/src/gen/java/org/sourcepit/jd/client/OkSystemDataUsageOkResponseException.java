package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemDataUsageOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemDataUsageOkResponse responseValue;

	public OkSystemDataUsageOkResponseException(SystemDataUsageOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
