package org.sourcepit.jd.client;

import java.util.List;

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

	@JsonProperty("DataPathAddr")
	private String dataPathAddr;

	@JsonProperty("DataPathPort")
	private Long dataPathPort;

	@JsonProperty("DefaultAddrPool")
	private List<String> defaultAddrPool;

	@JsonProperty("ForceNewCluster")
	private Boolean forceNewCluster;

	@JsonProperty("SubnetSize")
	private Long subnetSize;

	@JsonProperty("Spec")
	private SwarmSpec spec;

}
