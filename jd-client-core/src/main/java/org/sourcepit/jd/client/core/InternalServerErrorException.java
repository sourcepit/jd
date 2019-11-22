package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class InternalServerErrorException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public InternalServerErrorException() {
		super(500, "InternalServerError");
	}
}