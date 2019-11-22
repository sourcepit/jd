package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Node {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Description {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Platform {
			@JsonProperty("Architecture")
			private String architecture;

			@JsonProperty("OS")
			private String oS;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Resources {
			@JsonProperty("NanoCPUs")
			private Long nanoCPUs;

			@JsonProperty("MemoryBytes")
			private Long memoryBytes;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Engine {
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

		@JsonProperty("Hostname")
		private String hostname;

		@JsonProperty("Platform")
		private Platform platform;

		@JsonProperty("Resources")
		private Resources resources;

		@JsonProperty("Engine")
		private Engine engine;

	}

	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Version")
	private ObjectVersion version;

	@JsonProperty("CreatedAt")
	private String createdAt;

	@JsonProperty("UpdatedAt")
	private String updatedAt;

	@JsonProperty("Spec")
	private NodeSpec spec;

	@JsonProperty("Description")
	private Description description;

}
