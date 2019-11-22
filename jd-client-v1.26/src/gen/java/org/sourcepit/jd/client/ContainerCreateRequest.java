package org.sourcepit.jd.client;

import java.util.Map;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class ContainerCreateRequest extends Config {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class NetworkingConfig {
		@JsonProperty("EndpointsConfig")
		private Map<EndpointSettings, EndpointSettings> endpointsConfig;

	}

	@JsonIgnore
	@PathParameter("name")
	private String name;

	@JsonProperty("HostConfig")
	private HostConfig hostConfig;

	@JsonProperty("NetworkingConfig")
	private NetworkingConfig networkingConfig;

}
