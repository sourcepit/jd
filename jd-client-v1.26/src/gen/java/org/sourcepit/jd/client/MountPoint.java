package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class MountPoint {
	@JsonProperty("Type")
	private String type;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Source")
	private String source;

	@JsonProperty("Destination")
	private String destination;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("Mode")
	private String mode;

	@JsonProperty("RW")
	private Boolean rW;

	@JsonProperty("Propagation")
	private String propagation;

}
