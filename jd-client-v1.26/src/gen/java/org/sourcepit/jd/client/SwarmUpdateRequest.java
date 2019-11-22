package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

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
	@PathParameter(value = "rotateManagerUnlockKey", defaultValue = "false")
	private Boolean rotateManagerUnlockKey;

	@JsonIgnore
	@PathParameter(value = "rotateManagerToken", defaultValue = "false")
	private Boolean rotateManagerToken;

	@JsonIgnore
	@PathParameter(value = "rotateWorkerToken", defaultValue = "false")
	private Boolean rotateWorkerToken;

	@JsonIgnore
	@PathParameter("version")
	private Long version;

}
