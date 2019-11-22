package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class GetPluginPrivilegesOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<GetPluginPrivilegesOkResponse> responseValue;

	public GetPluginPrivilegesOkException(List<GetPluginPrivilegesOkResponse> responseValue) {
		this.responseValue = responseValue;
	}
}
