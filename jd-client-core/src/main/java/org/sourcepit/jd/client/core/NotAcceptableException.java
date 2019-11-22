package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class NotAcceptableException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public NotAcceptableException() {
		super(406, "NotAcceptable");
	}
}