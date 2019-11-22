package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkSystemEventsOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final SystemEventsOkResponse responseValue;

	public OkSystemEventsOkResponseException(SystemEventsOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
