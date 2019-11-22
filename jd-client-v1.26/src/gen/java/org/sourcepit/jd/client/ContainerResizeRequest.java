package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerResizeRequest {
	@JsonIgnore
	@QueryParameter("w")
	private Long w;

	@JsonIgnore
	@QueryParameter("h")
	private Long h;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
