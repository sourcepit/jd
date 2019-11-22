package org.sourcepit.jd.client;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VolumeCreateRequest {
	@JsonProperty("Name")
	private String name;

	@JsonProperty(value = "Driver", defaultValue = "local")
	private String driver;

	@JsonProperty("DriverOpts")
	private Map<String, String> driverOpts;

	@JsonProperty("Labels")
	private Map<String, String> labels;

}
