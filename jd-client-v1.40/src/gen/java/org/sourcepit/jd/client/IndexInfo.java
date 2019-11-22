package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class IndexInfo {
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Mirrors")
	private List<String> mirrors;

	@JsonProperty("Secure")
	private Boolean secure;

	@JsonProperty("Official")
	private Boolean official;

}
