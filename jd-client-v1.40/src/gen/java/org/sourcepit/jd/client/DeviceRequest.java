package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DeviceRequest {
	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("Count")
	private Long count;

	@JsonProperty("DeviceIDs")
	private List<String> deviceIDs;

	@JsonProperty("Capabilities")
	private List<List<String>> capabilities;

	@JsonProperty("Options")
	private Map<String, String> options;

}
