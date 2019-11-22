package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SecretSpec {
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("Data")
	private List<String> data;

}
