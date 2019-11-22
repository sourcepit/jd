package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerSummary {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class HostConfig {
		@JsonProperty("NetworkMode")
		private String networkMode;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class NetworkSettings {
		@JsonProperty("Networks")
		private Map<EndpointSettings, EndpointSettings> networks;

	}

	@JsonProperty("Id")
	private String id;

	@JsonProperty("Names")
	private List<String> names;

	@JsonProperty("Image")
	private String image;

	@JsonProperty("ImageID")
	private String imageID;

	@JsonProperty("Command")
	private String command;

	@JsonProperty("Created")
	private Long created;

	@JsonProperty("Ports")
	private List<Port> ports;

	@JsonProperty("SizeRw")
	private Long sizeRw;

	@JsonProperty("SizeRootFs")
	private Long sizeRootFs;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("State")
	private String state;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("HostConfig")
	private HostConfig hostConfig;

	@JsonProperty("NetworkSettings")
	private NetworkSettings networkSettings;

	@JsonProperty("Mounts")
	private List<Mount> mounts;

}
