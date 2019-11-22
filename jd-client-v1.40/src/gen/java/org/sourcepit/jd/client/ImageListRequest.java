package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageListRequest {
	@JsonIgnore
	@QueryParameter(value = "digests", defaultValue = "false")
	private Boolean digests;

	@JsonIgnore
	@QueryParameter("filters")
	private String filters;

	@JsonIgnore
	@QueryParameter(value = "all", defaultValue = "false")
	private Boolean all;

}
