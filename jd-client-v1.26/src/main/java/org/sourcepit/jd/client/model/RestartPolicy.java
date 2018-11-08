package org.sourcepit.jd.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

/**
 * The behavior to apply when the container exits. The default is not to
 * restart.</br>
 * </br>
 * An ever increasing delay (double the previous delay, starting at 100ms) is
 * added before each restart to prevent flooding the server.
 */
@Data
@JsonInclude(Include.NON_NULL)
public class RestartPolicy {
	public static enum Name {
		/**
		 * Always restart
		 */
		ALWAYS("always"),
		/**
		 * Restart always except when the user has manually stopped the container
		 */
		UNLESS_STOPPED("unless-stopped"),
		/**
		 * Restart only when the container exit code is non-zero
		 */
		ON_FAILURE("on-failure");

		private final String literal;

		private Name(String literal) {
			this.literal = literal;
		}

		@JsonValue
		public String getLiteral() {
			return literal;
		}
	}

	@JsonProperty("Name")
	private Name name;

	/**
	 * If <code>on-failure</code> is used, the number of times to retry before
	 * giving up
	 */
	@JsonProperty("MaximumRetryCount")
	private Integer maximumRetryCount;

}
