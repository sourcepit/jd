package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class NodeDescription {
	@JsonProperty("Hostname")
	private String hostname;

	@JsonProperty("Platform")
	private Platform platform;

	@JsonProperty("Resources")
	private ResourceObject resources;

	@JsonProperty("Engine")
	private EngineDescription engine;

	@JsonProperty("TLSInfo")
	private TLSInfo tLSInfo;

}
