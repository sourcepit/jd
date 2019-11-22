package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageCreateRequest {
	@JsonIgnore
	@QueryParameter("platform")
	private String platform;

	@JsonIgnore
	@HeaderParameter("X-Registry-Auth")
	private String xRegistryAuth;

	@JsonIgnore
	@QueryParameter("tag")
	private String tag;

	@JsonIgnore
	@QueryParameter("repo")
	private String repo;

	@JsonIgnore
	@QueryParameter("fromSrc")
	private String fromSrc;

	@JsonIgnore
	@QueryParameter("fromImage")
	private String fromImage;

}
