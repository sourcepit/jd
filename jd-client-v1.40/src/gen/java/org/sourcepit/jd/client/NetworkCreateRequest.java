package org.sourcepit.jd.client;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NetworkCreateRequest {
	@JsonProperty("Name")
	private String name;

	@JsonProperty("CheckDuplicate")
	private Boolean checkDuplicate;

	@JsonProperty(value = "Driver", defaultValue = "bridge")
	private String driver;

	@JsonProperty("Internal")
	private Boolean internal;

	@JsonProperty("Attachable")
	private Boolean attachable;

	@JsonProperty("Ingress")
	private Boolean ingress;

	@JsonProperty("IPAM")
	private IPAM iPAM;

	@JsonProperty("EnableIPv6")
	private Boolean enableIPv6;

	@JsonProperty("Options")
	private Map<String, String> options;

	@JsonProperty("Labels")
	private Map<String, String> labels;

}
