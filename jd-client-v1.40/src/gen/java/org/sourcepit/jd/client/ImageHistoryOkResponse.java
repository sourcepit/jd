package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageHistoryOkResponse {
	@JsonProperty("Id")
	private String id;

	@JsonProperty("Created")
	private Long created;

	@JsonProperty("CreatedBy")
	private String createdBy;

	@JsonProperty("Tags")
	private List<String> tags;

	@JsonProperty("Size")
	private Long size;

	@JsonProperty("Comment")
	private String comment;

}
