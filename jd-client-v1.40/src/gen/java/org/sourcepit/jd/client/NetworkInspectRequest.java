package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NetworkInspectRequest {
	@JsonIgnore
	@QueryParameter("scope")
	private String scope;

	@JsonIgnore
	@QueryParameter(value = "verbose", defaultValue = "false")
	private Boolean verbose;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
