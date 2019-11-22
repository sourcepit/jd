package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemEventsRequest {
	@JsonIgnore
	@QueryParameter("filters")
	private String filters;

	@JsonIgnore
	@QueryParameter("until")
	private String until;

	@JsonIgnore
	@QueryParameter("since")
	private String since;

}
