package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;
import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImagePushRequest {
	@JsonIgnore
	@HeaderParameter("X-Registry-Auth")
	private String xRegistryAuth;

	@JsonIgnore
	@PathParameter("tag")
	private String tag;

	@JsonIgnore
	@PathParameter("name")
	private String name;

}
