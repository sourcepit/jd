package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class NotFoundException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(404, "NotFound");
	}
}