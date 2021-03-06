package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NetworkConnectRequest {
	@JsonIgnore
	@PathParameter("id")
	private String id;

	@JsonProperty("Container")
	private String container;

	@JsonProperty("EndpointConfig")
	private EndpointSettings endpointConfig;

}
