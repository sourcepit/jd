package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class PluginMount {
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Description")
	private String description;

	@JsonProperty("Settable")
	private List<String> settable;

	@JsonProperty("Source")
	private String source;

	@JsonProperty("Destination")
	private String destination;

	@JsonProperty("Type")
	private String type;

	@JsonProperty("Options")
	private List<String> options;

}
