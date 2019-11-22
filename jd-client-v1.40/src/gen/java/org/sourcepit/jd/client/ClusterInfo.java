package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ClusterInfo {
	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Version")
	private ObjectVersion version;

	@JsonProperty("CreatedAt")
	private String createdAt;

	@JsonProperty("UpdatedAt")
	private String updatedAt;

	@JsonProperty("Spec")
	private SwarmSpec spec;

	@JsonProperty("TLSInfo")
	private TLSInfo tLSInfo;

	@JsonProperty("RootRotationInProgress")
	private Boolean rootRotationInProgress;

	@JsonProperty("DataPathPort")
	private Long dataPathPort;

	@JsonProperty("DefaultAddrPool")
	private List<String> defaultAddrPool;

	@JsonProperty("SubnetSize")
	private Long subnetSize;

}
