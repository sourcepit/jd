package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ImageListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<ImageSummary> responseValue;

	public ImageListOkException(List<ImageSummary> responseValue) {
		this.responseValue = responseValue;
	}
}
