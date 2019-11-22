package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SwarmJoinRequest {
	@JsonProperty("ListenAddr")
	private String listenAddr;

	@JsonProperty("AdvertiseAddr")
	private String advertiseAddr;

	@JsonProperty("RemoteAddrs")
	private String remoteAddrs;

	@JsonProperty("JoinToken")
	private String joinToken;

}
