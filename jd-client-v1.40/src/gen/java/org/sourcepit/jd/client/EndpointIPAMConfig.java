package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class EndpointIPAMConfig {
	@JsonProperty("IPv4Address")
	private String iPv4Address;

	@JsonProperty("IPv6Address")
	private String iPv6Address;

	@JsonProperty("LinkLocalIPs")
	private List<String> linkLocalIPs;

}
