package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class EndpointPortConfig {
	public static enum Protocol {
		TCP("tcp"), UDP("udp"), SCTP("sctp");

		@Getter
		private final String literal;

		private Protocol(String literal) {
			this.literal = literal;
		}
	}

	public static enum PublishMode {
		INGRESS("ingress"), HOST("host");

		@Getter
		private final String literal;

		private PublishMode(String literal) {
			this.literal = literal;
		}
	}

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Protocol")
	private Protocol protocol;

	@JsonProperty("TargetPort")
	private Long targetPort;

	@JsonProperty("PublishedPort")
	private Long publishedPort;

	@JsonProperty(value = "PublishMode", defaultValue = "ingress")
	private PublishMode publishMode;

}
