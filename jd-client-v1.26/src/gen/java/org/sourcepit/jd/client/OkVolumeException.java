package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkVolumeException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Volume responseValue;

	public OkVolumeException(Volume responseValue) {
		this.responseValue = responseValue;
	}
}
