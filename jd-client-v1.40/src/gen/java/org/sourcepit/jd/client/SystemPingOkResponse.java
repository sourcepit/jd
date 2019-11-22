package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemPingOkResponse {
	@JsonIgnore
	@HeaderParameter("API-Version")
	private String aPIVersion;

	@JsonIgnore
	@HeaderParameter(value = "Pragma", defaultValue = "no-cache")
	private String pragma;

	@JsonIgnore
	@HeaderParameter("BuildKit-Version")
	private String buildKitVersion;

	@JsonIgnore
	@HeaderParameter(value = "Cache-Control", defaultValue = "no-cache, no-store, must-revalidate")
	private String cacheControl;

	@JsonIgnore
	@HeaderParameter("Docker-Experimental")
	private Boolean dockerExperimental;

}
