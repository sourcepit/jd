package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.CreatedException;

import lombok.Getter;

public class CreatedIdResponseException extends CreatedException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final IdResponse responseValue;

	public CreatedIdResponseException(IdResponse responseValue) {
		this.responseValue = responseValue;
	}
}
