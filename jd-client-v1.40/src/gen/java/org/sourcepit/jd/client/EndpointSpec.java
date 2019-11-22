package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class EndpointSpec {
	public static enum Mode {
		VIP("vip"), DNSRR("dnsrr");

		@Getter
		private final String literal;

		private Mode(String literal) {
			this.literal = literal;
		}
	}

	@JsonProperty(value = "Mode", defaultValue = "vip")
	private Mode mode;

	@JsonProperty("Ports")
	private List<EndpointPortConfig> ports;

}
