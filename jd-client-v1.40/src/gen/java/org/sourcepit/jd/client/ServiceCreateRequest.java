package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class ServiceCreateRequest extends ServiceSpec {
	@JsonIgnore
	@HeaderParameter("X-Registry-Auth")
	private String xRegistryAuth;

}
