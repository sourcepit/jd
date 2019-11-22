package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.CreatedException;

import lombok.Getter;

public class CreatedVolumeException extends CreatedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Volume responseValue;

	public CreatedVolumeException(Volume responseValue) {
		this.responseValue = responseValue;
	}
}
