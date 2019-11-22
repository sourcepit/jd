package org.sourcepit.jd.client;

import lombok.Getter;

public enum NodeState {
	UNKNOWN("unknown"), DOWN("down"), READY("ready"), DISCONNECTED("disconnected");

	@Getter
	private final String literal;

	private NodeState(String literal) {
		this.literal = literal;
	}
}
