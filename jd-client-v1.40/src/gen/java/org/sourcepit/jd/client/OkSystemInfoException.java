package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemInfoException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemInfo responseValue;

	public OkSystemInfoException(SystemInfo responseValue) {
		this.responseValue = responseValue;
	}
}
