package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class SwitchingProtocolsException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public SwitchingProtocolsException() {
		super(101, "SwitchingProtocols");
	}
}