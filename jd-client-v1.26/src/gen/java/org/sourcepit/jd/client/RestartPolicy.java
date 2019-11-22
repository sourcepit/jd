package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class RestartPolicy {
	public static enum Name {
		ALWAYS("always"), UNLESSSTOPPED("unless-stopped"), ONFAILURE("on-failure");

		@Getter
		private final String literal;

		private Name(String literal) {
			this.literal = literal;
		}
	}

	@JsonProperty("Name")
	private Name name;

	@JsonProperty("MaximumRetryCount")
	private Long maximumRetryCount;

}
