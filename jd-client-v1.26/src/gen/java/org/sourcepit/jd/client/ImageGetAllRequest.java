package org.sourcepit.jd.client;

import java.util.List;

import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageGetAllRequest {
	@JsonIgnore
	@QueryParameter("names")
	private List<String> names;

}
