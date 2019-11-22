package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SwarmInspectOkResponse {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class JoinTokens {
		@JsonProperty("Worker")
		private String worker;

		@JsonProperty("Manager")
		private String manager;

	}

	@JsonProperty("ClusterInfo")
	private ClusterInfo clusterInfo;

	@JsonProperty("JoinTokens")
	private JoinTokens joinTokens;

}
