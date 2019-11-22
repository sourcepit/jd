package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerDeleteRequest {
	@JsonIgnore
	@PathParameter(value = "link", defaultValue = "false")
	private Boolean link;

	@JsonIgnore
	@PathParameter(value = "force", defaultValue = "false")
	private Boolean force;

	@JsonIgnore
	@PathParameter(value = "v", defaultValue = "false")
	private Boolean v;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
