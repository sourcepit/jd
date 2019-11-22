package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ProcessConfig {
	@JsonProperty("privileged")
	private Boolean privileged;

	@JsonProperty("user")
	private String user;

	@JsonProperty("tty")
	private Boolean tty;

	@JsonProperty("entrypoint")
	private String entrypoint;

	@JsonProperty("arguments")
	private List<String> arguments;

}
