package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerLogsRequest {
	@JsonIgnore
	@PathParameter(value = "tail", defaultValue = "all")
	private String tail;

	@JsonIgnore
	@PathParameter(value = "timestamps", defaultValue = "false")
	private Boolean timestamps;

	@JsonIgnore
	@PathParameter(value = "since", defaultValue = "0")
	private Long since;

	@JsonIgnore
	@PathParameter(value = "stderr", defaultValue = "false")
	private Boolean stderr;

	@JsonIgnore
	@PathParameter(value = "stdout", defaultValue = "false")
	private Boolean stdout;

	@JsonIgnore
	@PathParameter(value = "follow", defaultValue = "false")
	private Boolean follow;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
