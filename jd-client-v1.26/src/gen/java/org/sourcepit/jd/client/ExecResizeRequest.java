package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ExecResizeRequest {
	@JsonIgnore
	@PathParameter("w")
	private Long w;

	@JsonIgnore
	@PathParameter("h")
	private Long h;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
