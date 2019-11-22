package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ImageHistoryOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<ImageHistoryOkResponse> responseValue;

	public ImageHistoryOkException(List<ImageHistoryOkResponse> responseValue) {
		this.responseValue = responseValue;
	}
}
