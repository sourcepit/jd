package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class EndpointSettings {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class IPAMConfig {
		@JsonProperty("IPv4Address")
		private String iPv4Address;

		@JsonProperty("IPv6Address")
		private String iPv6Address;

		@JsonProperty("LinkLocalIPs")
		private List<String> linkLocalIPs;

	}

	@JsonProperty("IPAMConfig")
	private IPAMConfig iPAMConfig;

	@JsonProperty("Links")
	private List<String> links;

	@JsonProperty("Aliases")
	private List<String> aliases;

	@JsonProperty("NetworkID")
	private String networkID;

	@JsonProperty("EndpointID")
	private String endpointID;

	@JsonProperty("Gateway")
	private String gateway;

	@JsonProperty("IPAddress")
	private String iPAddress;

	@JsonProperty("IPPrefixLen")
	private Long iPPrefixLen;

	@JsonProperty("IPv6Gateway")
	private String iPv6Gateway;

	@JsonProperty("GlobalIPv6Address")
	private String globalIPv6Address;

	@JsonProperty("GlobalIPv6PrefixLen")
	private Long globalIPv6PrefixLen;

	@JsonProperty("MacAddress")
	private String macAddress;

}
