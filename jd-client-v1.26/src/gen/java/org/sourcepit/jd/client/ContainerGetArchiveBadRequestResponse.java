package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerGetArchiveBadRequestResponse {
	@JsonProperty("ErrorResponse")
	private ErrorResponse errorResponse;

	@JsonProperty("message")
	private String message;

}
