package org.sourcepit.jd.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * A test to perform to check that the container is healthy.
 */
@Data
@JsonInclude(Include.NON_NULL)
public class HealthConfig {
	// Test:
	// description: |
	// The test to perform. Possible values are:
	//
	// - `{}` inherit healthcheck from image or parent image
	// - `{"NONE"}` disable healthcheck
	// - `{"CMD", args...}` exec arguments directly
	// - `{"CMD-SHELL", command}` run command with system's default shell
	// type: "array"
	// items:
	// type: "string"
	private List<String> test;

	// Interval:
	// description: "The time to wait between checks in nanoseconds. 0 means
	// inherit."
	// type: "integer"
	private Integer interval;

	// :
	// description: "The time to wait before considering the check to have hung. 0
	// means inherit."
	// type: "integer"
	private Integer timeout;

	// Retries:
	// description: "The number of consecutive failures needed to consider a
	// container as unhealthy. 0 means inherit."
	// type: "integer"
	private Integer retries;
}
