package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class EndpointSettings {
	@JsonProperty("IPAMConfig")
	private EndpointIPAMConfig iPAMConfig;

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

	@JsonProperty("DriverOpts")
	private Map<String, String> driverOpts;

}
