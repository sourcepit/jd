package org.sourcepit.jd.client;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Container created successfully
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ContainerCreateResponse
{
	/**
	 * The ID of the created container
	 */
	@JsonProperty(value = "Id", required = true)
	@NotNull
	private String id;

	/**
	 * Warnings encountered when creating the container
	 */
	@JsonProperty(value = "Warnings", required = true)
	@NotNull
	private List<String> warnings;
}
