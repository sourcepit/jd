package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerPutArchiveRequest {
	@JsonIgnore
	@PathParameter("noOverwriteDirNonDir")
	private String noOverwriteDirNonDir;

	@JsonIgnore
	@PathParameter("path")
	private String path;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
