package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class UnauthorizedException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {
		super(401, "Unauthorized");
	}
}
