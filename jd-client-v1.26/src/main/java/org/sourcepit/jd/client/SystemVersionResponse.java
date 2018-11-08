package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemVersionResponse {
	@JsonProperty("Version")
	private String version;

	@JsonProperty("ApiVersion")
	private String apiVersion;

	@JsonProperty("MinAPIVersion")
	private String minApiVersion;

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
