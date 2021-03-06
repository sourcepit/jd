package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerLogsRequest {
	@JsonIgnore
	@QueryParameter(value = "tail", defaultValue = "all")
	private String tail;

	@JsonIgnore
	@QueryParameter(value = "timestamps", defaultValue = "false")
	private Boolean timestamps;

	@JsonIgnore
	@QueryParameter(value = "until", defaultValue = "0")
	private Long until;

	@JsonIgnore
	@QueryParameter(value = "since", defaultValue = "0")
	private Long since;

	@JsonIgnore
	@QueryParameter(value = "stderr", defaultValue = "false")
	private Boolean stderr;

	@JsonIgnore
	@QueryParameter(value = "stdout", defaultValue = "false")
	private Boolean stdout;

	@JsonIgnore
	@QueryParameter(value = "follow", defaultValue = "false")
	private Boolean follow;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
