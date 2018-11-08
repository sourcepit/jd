package org.sourcepit.jd.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Configuration for a network endpoint.
 */
@Data
@JsonInclude(Include.NON_NULL)
public class EndpointSettings {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class IPAMConfig {
		@JsonProperty("IPv4Address")
		private String ipv4Address;

		@JsonProperty("IPv6Address")
		private String ipv6Address;

		@JsonProperty("LinkLocalIPs")
		private List<String> linkLocalIPs;
	}

	/**
	 * IPAM configurations for the endpoint
	 */
	@JsonProperty("IPAMConfig")
	private IPAMConfig ipamConfig;

	@JsonProperty("Links")
	private List<String> links;

	@JsonProperty("Aliases")
	private List<String> aliases;

	@JsonProperty("NetworkID")
	private String networkId;

	@JsonProperty("EndpointID")
	private String endpointId;

	@JsonProperty("Gateway")
	private String gateway;

	@JsonProperty("IPAddress")
	private String ipAddress;

	@JsonProperty("IPPrefixLen")
	private Integer ipPrefixLen;

	@JsonProperty("IPv6Gateway")
	private String ipv6Gateway;

	@JsonProperty("GlobalIPv6Address")
	private String globalIpv6Address;

	@JsonProperty("GlobalIPv6PrefixLen")
	private Long globalIpv6PrefixLen;

	@JsonProperty("MacAddress")
	private String macAddress;
}
