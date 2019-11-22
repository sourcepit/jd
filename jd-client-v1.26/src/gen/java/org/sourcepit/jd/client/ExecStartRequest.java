package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ExecStartRequest {
	@JsonIgnore
	@PathParameter("id")
	private String id;

	@JsonProperty("Detach")
	private Boolean detach;

	@JsonProperty("Tty")
	private Boolean tty;

}
