package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class ForbiddenException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public ForbiddenException() {
		super(403, "Forbidden");
	}
}
