package org.sourcepit.jd.client;

import lombok.Getter;

public enum LocalNodeState {
	NOOP(""), INACTIVE("inactive"), PENDING("pending"), ACTIVE("active"), ERROR("error"), LOCKED("locked");

	@Getter
	private final String literal;

	private LocalNodeState(String literal) {
		this.literal = literal;
	}
}
