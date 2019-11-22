package org.sourcepit.jd.client;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Network {
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Id")
	private String id;

	@JsonProperty("Created")
	private String created;

	@JsonProperty("Scope")
	private String scope;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("EnableIPv6")
	private Boolean enableIPv6;

	@JsonProperty("IPAM")
	private IPAM iPAM;

	@JsonProperty("Internal")
	private Boolean internal;

	@JsonProperty("Attachable")
	private Boolean attachable;

	@JsonProperty("Ingress")
	private Boolean ingress;

	@JsonProperty("Containers")
	private Map<NetworkContainer, NetworkContainer> containers;

	@JsonProperty("Options")
	private Map<String, String> options;

	@JsonProperty("Labels")
	private Map<String, String> labels;

}
