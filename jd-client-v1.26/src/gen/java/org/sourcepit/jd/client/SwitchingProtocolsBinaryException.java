package org.sourcepit.jd.client;

import java.io.InputStream;

import org.sourcepit.jd.client.core.SwitchingProtocolsException;

import lombok.Getter;

public class SwitchingProtocolsBinaryException extends SwitchingProtocolsException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final InputStream responseValue;

	public SwitchingProtocolsBinaryException(InputStream responseValue) {
		this.responseValue = responseValue;
	}
}
