package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ContainerListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<ContainerSummary> responseValue;

	public ContainerListOkException(List<ContainerSummary> responseValue) {
		this.responseValue = responseValue;
	}
}
