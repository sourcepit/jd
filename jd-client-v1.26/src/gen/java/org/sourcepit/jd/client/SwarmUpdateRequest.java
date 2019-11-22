package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class SwarmUpdateRequest extends SwarmSpec {
	@JsonIgnore
	@QueryParameter(value = "rotateManagerUnlockKey", defaultValue = "false")
	private Boolean rotateManagerUnlockKey;

	@JsonIgnore
	@QueryParameter(value = "rotateManagerToken", defaultValue = "false")
	private Boolean rotateManagerToken;

	@JsonIgnore
	@QueryParameter(value = "rotateWorkerToken", defaultValue = "false")
	private Boolean rotateWorkerToken;

	@JsonIgnore
	@QueryParameter("version")
	private Long version;

}
