package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SwarmInitRequest {
	@JsonProperty("ListenAddr")
	private String listenAddr;

	@JsonProperty("AdvertiseAddr")
	private String advertiseAddr;

	@JsonProperty("ForceNewCluster")
	private Boolean forceNewCluster;

	@JsonProperty("Spec")
	private SwarmSpec spec;

}
