package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class NoContentException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public NoContentException() {
		super(204, "NoContent");
	}
}