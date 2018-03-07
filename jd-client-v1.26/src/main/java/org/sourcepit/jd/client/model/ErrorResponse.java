package org.sourcepit.jd.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResponse
{
	@JsonProperty(required = true)
	private String message;
}
