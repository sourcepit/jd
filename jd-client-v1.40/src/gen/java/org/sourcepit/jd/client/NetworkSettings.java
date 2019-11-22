package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NetworkSettings {
	@JsonProperty("Bridge")
	private String bridge;

	@JsonProperty("SandboxID")
	private String sandboxID;

	@JsonProperty("HairpinMode")
	private Boolean hairpinMode;

	@JsonProperty("LinkLocalIPv6Address")
	private String linkLocalIPv6Address;

	@JsonProperty("LinkLocalIPv6PrefixLen")
	private Long linkLocalIPv6PrefixLen;

	@JsonProperty("Ports")
	private Map<List<PortBinding>, List<PortBinding>> ports;

	@JsonProperty("SandboxKey")
	private String sandboxKey;

	@JsonProperty("SecondaryIPAddresses")
	private List<Address> secondaryIPAddresses;

	@JsonProperty("SecondaryIPv6Addresses")
	private List<Address> secondaryIPv6Addresses;

	@JsonProperty("EndpointID")
	private String endpointID;

	@JsonProperty("Gateway")
	private String gateway;

	@JsonProperty("GlobalIPv6Address")
	private String globalIPv6Address;

	@JsonProperty("GlobalIPv6PrefixLen")
	private Long globalIPv6PrefixLen;

	@JsonProperty("IPAddress")
	private String iPAddress;

	@JsonProperty("IPPrefixLen")
	private Long iPPrefixLen;

	@JsonProperty("IPv6Gateway")
	private String iPv6Gateway;

	@JsonProperty("MacAddress")
	private String macAddress;

	@JsonProperty("Networks")
	private Map<EndpointSettings, EndpointSettings> networks;

}
