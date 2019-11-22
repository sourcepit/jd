package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class OkContainerStatsOkResponseException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final ContainerStatsOkResponse responseValue;

	public OkContainerStatsOkResponseException(ContainerStatsOkResponse responseValue) {
		this.responseValue = responseValue;
	}
}
