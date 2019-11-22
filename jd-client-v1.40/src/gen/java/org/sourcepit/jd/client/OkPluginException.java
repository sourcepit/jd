package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkPluginException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Plugin responseValue;

	public OkPluginException(Plugin responseValue) {
		this.responseValue = responseValue;
	}
}
