package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class OkException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public OkException() {
		super(200, "Ok");
	}
}
