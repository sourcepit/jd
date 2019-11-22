package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkTaskException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final Task responseValue;

	public OkTaskException(Task responseValue) {
		this.responseValue = responseValue;
	}
}
