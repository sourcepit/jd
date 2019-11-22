package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ManagerStatus {
	@JsonProperty(value = "Leader", defaultValue = "false")
	private Boolean leader;

	@JsonProperty("Reachability")
	private Reachability reachability;

	@JsonProperty("Addr")
	private String addr;

}
