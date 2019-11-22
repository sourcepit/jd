package org.sourcepit.jd.client;

import lombok.Getter;

public enum Reachability {
	UNKNOWN("unknown"), UNREACHABLE("unreachable"), REACHABLE("reachable");

	@Getter
	private final String literal;

	private Reachability(String literal) {
		this.literal = literal;
	}
}
