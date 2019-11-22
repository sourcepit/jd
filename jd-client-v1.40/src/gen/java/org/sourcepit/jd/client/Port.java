package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class Port {
	public static enum Type {
		TCP("tcp"), UDP("udp"), SCTP("sctp");

		@Getter
		private final String literal;

		private Type(String literal) {
			this.literal = literal;
		}
	}

	@JsonProperty("IP")
	private String iP;

	@JsonProperty("PrivatePort")
	private Long privatePort;

	@JsonProperty("PublicPort")
	private Long publicPort;

	@JsonProperty("Type")
	private Type type;

}
