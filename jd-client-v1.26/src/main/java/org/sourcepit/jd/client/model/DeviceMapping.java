package org.sourcepit.jd.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * A device mapping between the host and container
 */
@Data
@JsonInclude(Include.NON_NULL)
public class DeviceMapping {
	@JsonProperty("PathOnHost")
	private String pathOnHost;

	@JsonProperty("PathInContainer")
	private String pathInContainer;

	@JsonProperty("CgroupPermissions")
	private String cGroupPermissions;
}
