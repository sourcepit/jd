package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageSearchRequest {
	@JsonIgnore
	@PathParameter("filters")
	private String filters;

	@JsonIgnore
	@PathParameter("limit")
	private Long limit;

	@JsonIgnore
	@PathParameter("term")
	private String term;

}
