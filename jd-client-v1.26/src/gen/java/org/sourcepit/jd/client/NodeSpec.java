package org.sourcepit.jd.client;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class NodeSpec {
	public static enum Role {
		WORKER("worker"), MANAGER("manager");

		@Getter
		private final String literal;

		private Role(String literal) {
			this.literal = literal;
		}
	}

	public static enum Availability {
		ACTIVE("active"), PAUSE("pause"), DRAIN("drain");

		@Getter
		private final String literal;

		private Availability(String literal) {
			this.literal = literal;
		}
	}

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("Role")
	private Role role;

	@JsonProperty("Availability")
	private Availability availability;

}
