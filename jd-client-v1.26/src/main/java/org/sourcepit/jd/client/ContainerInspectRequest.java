package org.sourcepit.jd.client;

import javax.validation.constraints.NotNull;

import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerInspectRequest {
	/**
	 * ID or name of the container
	 */
	@PathParameter
	@JsonIgnore
	@NotNull
	private String id;

	/**
	 * Return the size of container as fields <code>SizeRw</code> and
	 * <code>SizeRootFs</code>
	 * 
	 * @default false
	 */
	@QueryParameter
	@JsonIgnore
	private Boolean size;
}
