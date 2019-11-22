package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ConfigListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<Config> responseValue;

	public ConfigListOkException(List<Config> responseValue) {
		this.responseValue = responseValue;
	}
}
