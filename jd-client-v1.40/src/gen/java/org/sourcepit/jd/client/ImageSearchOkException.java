package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ImageSearchOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<ImageSearchOkResponse> responseValue;

	public ImageSearchOkException(List<ImageSearchOkResponse> responseValue) {
		this.responseValue = responseValue;
	}
}
