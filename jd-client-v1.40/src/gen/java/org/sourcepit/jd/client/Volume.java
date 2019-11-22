package org.sourcepit.jd.client;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class Volume {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Status {
	}

	public static enum Scope {
		LOCAL("local"), GLOBAL("global");

		@Getter
		private final String literal;

		private Scope(String literal) {
			this.literal = literal;
		}
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class UsageData {
		@JsonProperty("Size")
		private Long size;

		@JsonProperty("RefCount")
		private Long refCount;

	}

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("Mountpoint")
	private String mountpoint;

	@JsonProperty("CreatedAt")
	private String createdAt;

	@JsonProperty("Status")
	private Map<String, Status> status;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty(value = "Scope", defaultValue = "local")
	private Scope scope;

	@JsonProperty("Options")
	private Map<String, String> options;

	@JsonProperty("UsageData")
	private UsageData usageData;

}
