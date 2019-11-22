package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class BadRequestException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		super(400, "BadRequest");
	}
}