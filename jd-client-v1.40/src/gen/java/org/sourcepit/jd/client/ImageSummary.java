package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageSummary {
	@JsonProperty("Id")
	private String id;

	@JsonProperty("ParentId")
	private String parentId;

	@JsonProperty("RepoTags")
	private List<String> repoTags;

	@JsonProperty("RepoDigests")
	private List<String> repoDigests;

	@JsonProperty("Created")
	private Long created;

	@JsonProperty("Size")
	private Long size;

	@JsonProperty("SharedSize")
	private Long sharedSize;

	@JsonProperty("VirtualSize")
	private Long virtualSize;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("Containers")
	private Long containers;

}
