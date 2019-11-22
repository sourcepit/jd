package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class PluginListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<Plugin> responseValue;

	public PluginListOkException(List<Plugin> responseValue) {
		this.responseValue = responseValue;
	}
}
