package org.sourcepit.jd.client;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemEventsOkResponse {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Actor {
		@JsonProperty("ID")
		private String iD;

		@JsonProperty("Attributes")
		private Map<String, String> attributes;

	}

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Action")
	private String action;

	@JsonProperty("Actor")
	private Actor actor;

	@JsonProperty("time")
	private Long time;

	@JsonProperty("timeNano")
	private Long timeNano;

}
