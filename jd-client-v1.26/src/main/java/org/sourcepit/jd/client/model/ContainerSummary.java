package org.sourcepit.jd.client.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerSummary {
	/**
	 * The ID of this container
	 */
	@JsonProperty("Id")
	private String id;

	/**
	 * The names that this container has been given
	 */
	@JsonProperty("Names")
	private List<String> names;

	/**
	 * The name of the image used when creating this container
	 */
	@JsonProperty("Image")
	private String image;

	/**
	 * The ID of the image that this container was created from
	 */
	@JsonProperty("ImageID")
	private String imageId;

	/**
	 * Command to run when starting the container
	 */
	@JsonProperty("Id")
	private String Command;

	/**
	 * When the container was created
	 */
	@JsonProperty("Created")
	private Long created;

	/**
	 * The ports exposed by this container
	 */
	@JsonProperty("Ports")
	private List<Port> ports;

	/**
	 * The size of files that have been created or changed by this container
	 */
	@JsonProperty("SizeRw")
	private Long sizeRw;

	/**
	 * The total size of all the files in this container
	 */
	@JsonProperty("SizeRootFs")
	private Long sizeRootFs;

	/**
	 * User-defined key/value metadata.
	 */
	@JsonProperty("Labels")
	private Map<String, String> labels;

	/**
	 * The state of this container (e.g. <code>Exited</code>)
	 */
	@JsonProperty("State")
	private String state;

	/**
	 * Additional human-readable status of this container (e.g. <code>Exit 0</code>)
	 */
	@JsonProperty("Status")
	private String status;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class HostConfig {
		@JsonProperty("NetworkMode")
		private String networkMode;
	}

	@JsonProperty("HostConfig")
	private HostConfig hostConfig;

	@Data
	@JsonInclude(Include.NON_NULL)
	private static class NetworkSettings {
		@JsonProperty("Networks")
		private Map<String, EndpointSettings> networks;
	}

	/**
	 * A summary of the container's network settings
	 */
	@JsonProperty("NetworkSettings")
	private NetworkSettings networkSettings;

	@JsonProperty("Mounts")
	private List<Mount> mounts;
}
