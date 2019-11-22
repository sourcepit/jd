package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkBuildPruneOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final BuildPruneOkResponse responseValue;

	public OkBuildPruneOkResponseException(BuildPruneOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
