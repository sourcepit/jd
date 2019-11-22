package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SwarmInfo {
	@JsonProperty(value = "NodeID", defaultValue = "")
	private String nodeID;

	@JsonProperty(value = "NodeAddr", defaultValue = "")
	private String nodeAddr;

	@JsonProperty("LocalNodeState")
	private LocalNodeState localNodeState;

	@JsonProperty(value = "ControlAvailable", defaultValue = "false")
	private Boolean controlAvailable;

	@JsonProperty(value = "Error", defaultValue = "")
	private String error;

	@JsonProperty("RemoteManagers")
	private List<PeerNode> remoteManagers;

	@JsonProperty("Nodes")
	private Long nodes;

	@JsonProperty("Managers")
	private Long managers;

	@JsonProperty("Cluster")
	private ClusterInfo cluster;

}
