package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerAttachRequest {
	@JsonIgnore
	@PathParameter(value = "stderr", defaultValue = "false")
	private Boolean stderr;

	@JsonIgnore
	@PathParameter(value = "stdout", defaultValue = "false")
	private Boolean stdout;

	@JsonIgnore
	@PathParameter(value = "stdin", defaultValue = "false")
	private Boolean stdin;

	@JsonIgnore
	@PathParameter(value = "stream", defaultValue = "false")
	private Boolean stream;

	@JsonIgnore
	@PathParameter(value = "logs", defaultValue = "false")
	private Boolean logs;

	@JsonIgnore
	@PathParameter("detachKeys")
	private String detachKeys;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
