package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ContainerChangesOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<ContainerChangesOkResponse> responseValue;

	public ContainerChangesOkException(List<ContainerChangesOkResponse> responseValue) {
		this.responseValue = responseValue;
	}
}
