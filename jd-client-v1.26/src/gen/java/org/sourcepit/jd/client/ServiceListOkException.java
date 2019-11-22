package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.OkException;

import lombok.Getter;

public class ServiceListOkException extends OkException {
	private static final long serialVersionUID = 1L;

	@Getter
	private final List<Service> responseValue;

	public ServiceListOkException(List<Service> responseValue) {
		this.responseValue = responseValue;
	}
}
