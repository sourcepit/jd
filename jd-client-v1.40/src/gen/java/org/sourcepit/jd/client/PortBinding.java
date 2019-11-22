package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PortBinding {
	@JsonProperty("HostIp")
	private String hostIp;

	@JsonProperty("HostPort")
	private String hostPort;

}
