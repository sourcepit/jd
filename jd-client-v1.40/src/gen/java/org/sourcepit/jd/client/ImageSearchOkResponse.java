package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageSearchOkResponse {
	@JsonProperty("description")
	private String description;

	@JsonProperty("is_official")
	private Boolean is_official;

	@JsonProperty("is_automated")
	private Boolean is_automated;

	@JsonProperty("name")
	private String name;

	@JsonProperty("star_count")
	private Long star_count;

}
