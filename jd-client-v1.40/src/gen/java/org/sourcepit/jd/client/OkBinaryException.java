package org.sourcepit.jd.client;

import java.io.InputStream;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkBinaryException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final InputStream responseValue;

	public OkBinaryException(InputStream responseValue) {
		this.responseValue = responseValue;
	}
}
