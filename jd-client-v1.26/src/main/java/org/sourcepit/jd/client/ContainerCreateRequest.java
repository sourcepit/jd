package org.sourcepit.jd.client;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.sourcepit.jd.client.core.annotation.QueryParameter;
import org.sourcepit.jd.client.model.Config;
import org.sourcepit.jd.client.model.EndpointSettings;
import org.sourcepit.jd.client.model.HostConfig;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Container to create
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class ContainerCreateRequest extends Config
{
	/**
	 * Assign the specified name to the container. Must match <code>/?[a-zA-Z0-9_-]+</code>.
	 */
	@QueryParameter
	@Pattern(regexp = "/?[a-zA-Z0-9_-]+")
	@JsonIgnore
	private String name;

	@JsonProperty("HostConfig")
	@Valid
	private HostConfig hostConfig;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class NetworkingConfig
	{
		/**
		 * A mapping of network name to endpoint configuration for that network.
		 */
		@JsonProperty("EndpointsConfig")
		@Valid
		private Map<String, EndpointSettings> endpointsConfig;
	}

	/**
	 * This container's networking configuration.
	 */
	@JsonProperty("NetworkingConfig")
	@Valid
	private NetworkingConfig networkingConfig;
}
