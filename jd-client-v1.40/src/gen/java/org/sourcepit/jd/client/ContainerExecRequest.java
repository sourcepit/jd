package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerExecRequest {
	@JsonIgnore
	@PathParameter("id")
	private String id;

	@JsonProperty("AttachStdin")
	private Boolean attachStdin;

	@JsonProperty("AttachStdout")
	private Boolean attachStdout;

	@JsonProperty("AttachStderr")
	private Boolean attachStderr;

	@JsonProperty("DetachKeys")
	private String detachKeys;

	@JsonProperty("Tty")
	private Boolean tty;

	@JsonProperty("Env")
	private List<String> env;

	@JsonProperty("Cmd")
	private List<String> cmd;

	@JsonProperty(value = "Privileged", defaultValue = "false")
	private Boolean privileged;

	@JsonProperty("User")
	private String user;

	@JsonProperty("WorkingDir")
	private String workingDir;

}
