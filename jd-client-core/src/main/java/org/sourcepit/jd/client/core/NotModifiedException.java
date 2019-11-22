package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class NotModifiedException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public NotModifiedException() {
		super(304, "NotModified");
	}
}