package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NodeStatus {
	@JsonProperty("State")
	private NodeState state;

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Addr")
	private String addr;

}
