package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class ServiceUnavailableException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public ServiceUnavailableException() {
		super(503, "ServiceUnavailable");
	}
}