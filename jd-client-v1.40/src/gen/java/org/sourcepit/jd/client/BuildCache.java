package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class BuildCache {
	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Parent")
	private String parent;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("InUse")
	private Boolean inUse;

	@JsonProperty("Shared")
	private Boolean shared;

	@JsonProperty("Size")
	private Long size;

	@JsonProperty("CreatedAt")
	private Long createdAt;

	@JsonProperty("LastUsedAt")
	private Long lastUsedAt;

	@JsonProperty("UsageCount")
	private Long usageCount;

}
