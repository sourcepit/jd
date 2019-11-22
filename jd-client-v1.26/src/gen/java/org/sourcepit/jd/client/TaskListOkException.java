package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class TaskListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<Task> responseValue;

	public TaskListOkException(List<Task> responseValue) {
		this.responseValue = responseValue;
	}
}
