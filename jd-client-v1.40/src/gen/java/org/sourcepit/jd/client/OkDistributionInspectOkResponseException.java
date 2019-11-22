package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkDistributionInspectOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final DistributionInspectOkResponse responseValue;

	public OkDistributionInspectOkResponseException(DistributionInspectOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
