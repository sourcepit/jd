package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NetworkContainer {
	@JsonProperty("EndpointID")
	private String endpointID;

	@JsonProperty("MacAddress")
	private String macAddress;

	@JsonProperty("IPv4Address")
	private String iPv4Address;

	@JsonProperty("IPv6Address")
	private String iPv6Address;

}
