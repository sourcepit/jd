package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ImageDeleteOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<ImageDeleteResponse> responseValue;

	public ImageDeleteOkException(List<ImageDeleteResponse> responseValue) {
		this.responseValue = responseValue;
	}
}
