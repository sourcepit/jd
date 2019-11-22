package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class EngineDescription {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Plugins {
		@JsonProperty("Type")
		private String type;

		@JsonProperty("Name")
		private String name;

	}

	@JsonProperty("EngineVersion")
	private String engineVersion;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("Plugins")
	private List<Plugins> plugins;

}
