package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemVersionOkResponse {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Platform {
		@JsonProperty("Name")
		private String name;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Components {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Details {
		}

		@JsonProperty("Name")
		private String name;

		@JsonProperty("Version")
		private String version;

		@JsonProperty("Details")
		private Details details;

	}

	@JsonProperty("Platform")
	private Platform platform;

	@JsonProperty("Components")
	private List<Components> components;

	@JsonProperty("Version")
	private String version;

	@JsonProperty("ApiVersion")
	private String apiVersion;

	@JsonProperty("MinAPIVersion")
	private String minAPIVersion;

	@JsonProperty("GitCommit")
	private String gitCommit;

	@JsonProperty("GoVersion")
	private String goVersion;

	@JsonProperty("Os")
	private String os;

	@JsonProperty("Arch")
	private String arch;

	@JsonProperty("KernelVersion")
	private String kernelVersion;

	@JsonProperty("Experimental")
	private Boolean experimental;

	@JsonProperty("BuildTime")
	private String buildTime;

}
