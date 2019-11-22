package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NetworkConfig {
	@JsonProperty("Bridge")
	private String bridge;

	@JsonProperty("Gateway")
	private String gateway;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("IPPrefixLen")
	private Long iPPrefixLen;

	@JsonProperty("MacAddress")
	private String macAddress;

	@JsonProperty("PortMapping")
	private String portMapping;

	@JsonProperty("Ports")
	private List<Port> ports;

}
