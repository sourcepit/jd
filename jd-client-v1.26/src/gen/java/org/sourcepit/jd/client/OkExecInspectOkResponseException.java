package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkExecInspectOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ExecInspectOkResponse responseValue;

	public OkExecInspectOkResponseException(ExecInspectOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
