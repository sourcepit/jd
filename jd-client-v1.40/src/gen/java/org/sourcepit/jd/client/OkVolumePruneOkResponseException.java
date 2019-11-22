package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkVolumePruneOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final VolumePruneOkResponse responseValue;

	public OkVolumePruneOkResponseException(VolumePruneOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
