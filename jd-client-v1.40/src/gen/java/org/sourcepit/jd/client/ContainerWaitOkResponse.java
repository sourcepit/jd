package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerWaitOkResponse {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Error {
		@JsonProperty("Message")
		private String message;

	}

	@JsonProperty("StatusCode")
	private Long statusCode;

	@JsonProperty("Error")
	private Error error;

}
