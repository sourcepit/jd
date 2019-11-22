package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class ConflictException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public ConflictException() {
		super(409, "Conflict");
	}
}