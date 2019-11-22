package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PluginsInfo {
	@JsonProperty("Volume")
	private List<String> volume;

	@JsonProperty("Network")
	private List<String> network;

	@JsonProperty("Authorization")
	private List<String> authorization;

	@JsonProperty("Log")
	private List<String> log;

}
