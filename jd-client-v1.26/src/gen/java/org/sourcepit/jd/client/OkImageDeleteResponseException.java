package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkImageDeleteResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ImageDeleteResponse responseValue;

	public OkImageDeleteResponseException(ImageDeleteResponse responseValue) {
		this.responseValue = responseValue;
	}
}
