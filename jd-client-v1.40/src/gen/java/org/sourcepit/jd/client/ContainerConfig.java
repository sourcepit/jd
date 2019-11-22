package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerConfig {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class ExposedPorts {
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Volumes {
	}

	@JsonProperty("Hostname")
	private String hostname;

	@JsonProperty("Domainname")
	private String domainname;

	@JsonProperty("User")
	private String user;

	@JsonProperty(value = "AttachStdin", defaultValue = "false")
	private Boolean attachStdin;

	@JsonProperty(value = "AttachStdout", defaultValue = "true")
	private Boolean attachStdout;

	@JsonProperty(value = "AttachStderr", defaultValue = "true")
	private Boolean attachStderr;

	@JsonProperty("ExposedPorts")
	private Map<String, ExposedPorts> exposedPorts;

	@JsonProperty(value = "Tty", defaultValue = "false")
	private Boolean tty;

	@JsonProperty(value = "OpenStdin", defaultValue = "false")
	private Boolean openStdin;

	@JsonProperty(value = "StdinOnce", defaultValue = "false")
	private Boolean stdinOnce;

	@JsonProperty("Env")
	private List<String> env;

	@JsonProperty("Cmd")
	private List<String> cmd;

	@JsonProperty("Healthcheck")
	private HealthConfig healthcheck;

	@JsonProperty("ArgsEscaped")
	private Boolean argsEscaped;

	@JsonProperty("Image")
	private String image;

	@JsonProperty("Volumes")
	private Map<String, Volumes> volumes;

	@JsonProperty("WorkingDir")
	private String workingDir;

	@JsonProperty("Entrypoint")
	private List<String> entrypoint;

	@JsonProperty("NetworkDisabled")
	private Boolean networkDisabled;

	@JsonProperty("MacAddress")
	private String macAddress;

	@JsonProperty("OnBuild")
	private List<String> onBuild;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty(value = "StopSignal", defaultValue = "SIGTERM")
	private String stopSignal;

	@JsonProperty("StopTimeout")
	private Long stopTimeout;

	@JsonProperty("Shell")
	private List<String> shell;

}
