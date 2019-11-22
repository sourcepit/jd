package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ServiceInspectRequest {
	@JsonIgnore
	@QueryParameter(value = "insertDefaults", defaultValue = "false")
	private Boolean insertDefaults;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
