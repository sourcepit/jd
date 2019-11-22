package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkConfigException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Config responseValue;

	public OkConfigException(Config responseValue) {
		this.responseValue = responseValue;
	}
}
