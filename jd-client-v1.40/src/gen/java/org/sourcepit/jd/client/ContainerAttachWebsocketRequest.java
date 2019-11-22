package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerAttachWebsocketRequest {
	@JsonIgnore
	@QueryParameter(value = "stderr", defaultValue = "false")
	private Boolean stderr;

	@JsonIgnore
	@QueryParameter(value = "stdout", defaultValue = "false")
	private Boolean stdout;

	@JsonIgnore
	@QueryParameter(value = "stdin", defaultValue = "false")
	private Boolean stdin;

	@JsonIgnore
	@QueryParameter(value = "stream", defaultValue = "false")
	private Boolean stream;

	@JsonIgnore
	@QueryParameter(value = "logs", defaultValue = "false")
	private Boolean logs;

	@JsonIgnore
	@QueryParameter("detachKeys")
	private String detachKeys;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
