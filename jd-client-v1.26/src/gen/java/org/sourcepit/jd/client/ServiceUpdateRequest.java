package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;
import org.sourcepit.jd.client.core.annotation.PathParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class ServiceUpdateRequest extends ServiceSpec {
	@JsonIgnore
	@HeaderParameter("X-Registry-Auth")
	private String xRegistryAuth;

	@JsonIgnore
	@QueryParameter(value = "registryAuthFrom", defaultValue = "spec")
	private String registryAuthFrom;

	@JsonIgnore
	@QueryParameter("version")
	private Long version;

	@JsonIgnore
	@PathParameter("id")
	private String id;

}
