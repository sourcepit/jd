package org.sourcepit.jd.client.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Port {
	@JsonProperty(value = "ID")
	private String ip;

	/**
	 * Port on the container
	 */
	@JsonProperty(value = "PrivatePort", required = true)
	@NotNull
	@Min(0)
	private Integer privatePort;

	/**
	 * Port exposed on the host
	 */
	@JsonProperty(value = "PublicPort", required = true)
	@NotNull
	@Min(0)
	private Integer publicPort;

	public static enum Type {
		TCP("tcp"), UDP("udp");

		private final String literal;

		private Type(String value) {
			this.literal = value;
		}

		@JsonValue
		public String getLiteral() {
			return literal;
		}
	}

	@JsonProperty(value = "Type", required = true)
	@NotNull
	private Type type;
}
