package org.sourcepit.jd.client.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ErrorResponse implements Serializable
{
	private static final long serialVersionUID = 1L;

	@JsonProperty(required = true)
	private String message;
}
