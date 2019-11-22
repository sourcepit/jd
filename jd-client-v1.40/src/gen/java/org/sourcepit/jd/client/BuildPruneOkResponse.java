package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class BuildPruneOkResponse {
	@JsonProperty("CachesDeleted")
	private List<String> cachesDeleted;

	@JsonProperty("SpaceReclaimed")
	private Long spaceReclaimed;

}
