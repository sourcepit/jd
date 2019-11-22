package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class NodeListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<Node> responseValue;

	public NodeListOkException(List<Node> responseValue) {
		this.responseValue = responseValue;
	}
}
