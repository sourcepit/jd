package org.sourcepit.jd.client.model;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ThrottleDevice
{
	/**
	 * Device path
	 */
	@JsonProperty("Path")
	private String path;

	/**
	 * Rate
	 */
	@JsonProperty("Rate")
	@Min(0)
	private Long rate;
}
