package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerStatsRequest {
	@JsonIgnore
	@QueryParameter(value = "stream", defaultValue = "true")
	private Boolean stream;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
