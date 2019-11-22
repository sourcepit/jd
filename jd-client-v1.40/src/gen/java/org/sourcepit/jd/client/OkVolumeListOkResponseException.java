package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkVolumeListOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final VolumeListOkResponse responseValue;

	public OkVolumeListOkResponseException(VolumeListOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
