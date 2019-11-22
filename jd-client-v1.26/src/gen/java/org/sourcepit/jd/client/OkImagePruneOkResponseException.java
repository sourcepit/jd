package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkImagePruneOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ImagePruneOkResponse responseValue;

	public OkImagePruneOkResponseException(ImagePruneOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
