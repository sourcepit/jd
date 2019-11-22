package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class HealthConfig {
	@JsonProperty("Test")
	private List<String> test;

	@JsonProperty("Interval")
	private Long interval;

	@JsonProperty("Timeout")
	private Long timeout;

	@JsonProperty("Retries")
	private Long retries;

}
