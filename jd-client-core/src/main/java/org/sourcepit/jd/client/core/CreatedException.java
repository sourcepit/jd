package org.sourcepit.jd.client.core;

import org.apache.http.client.HttpResponseException;

public class CreatedException extends HttpResponseException {
	private static final long serialVersionUID = 1L;

	public CreatedException() {
		super(201, "Created");
	}
}