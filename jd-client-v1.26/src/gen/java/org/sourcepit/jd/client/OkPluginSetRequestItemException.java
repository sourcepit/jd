package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkPluginSetRequestItemException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final String responseValue;

	public OkPluginSetRequestItemException(String responseValue) {
		this.responseValue = responseValue;
	}
}
