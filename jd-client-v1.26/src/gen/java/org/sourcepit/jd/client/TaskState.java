package org.sourcepit.jd.client;

import lombok.Getter;

public enum TaskState {
	NEW("new"), ALLOCATED("allocated"), PENDING("pending"), ASSIGNED("assigned"), ACCEPTED("accepted"),
	PREPARING("preparing"), READY("ready"), STARTING("starting"), RUNNING("running"), COMPLETE("complete"),
	SHUTDOWN("shutdown"), FAILED("failed"), REJECTED("rejected");

	@Getter
	private final String literal;

	private TaskState(String literal) {
		this.literal = literal;
	}
}
