package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ExecInspectOkResponse {
	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Running")
	private Boolean running;

	@JsonProperty("ExitCode")
	private Long exitCode;

	@JsonProperty("ProcessConfig")
	private ProcessConfig processConfig;

	@JsonProperty("OpenStdin")
	private Boolean openStdin;

	@JsonProperty("OpenStderr")
	private Boolean openStderr;

	@JsonProperty("OpenStdout")
	private Boolean openStdout;

	@JsonProperty("ContainerID")
	private String containerID;

	@JsonProperty("Pid")
	private Long pid;

}
