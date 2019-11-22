package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkImageException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Image responseValue;

	public OkImageException(Image responseValue) {
		this.responseValue = responseValue;
	}
}
