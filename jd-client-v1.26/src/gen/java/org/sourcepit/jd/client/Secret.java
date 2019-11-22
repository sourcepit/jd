package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Secret {
	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Version")
	private ObjectVersion version;

	@JsonProperty("CreatedAt")
	private String createdAt;

	@JsonProperty("UpdatedAt")
	private String updatedAt;

	@JsonProperty("Spec")
	private ServiceSpec spec;

}
