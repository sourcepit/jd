package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class GenericResources {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class NamedResourceSpec {
		@JsonProperty("Kind")
		private String kind;

		@JsonProperty("Value")
		private String value;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class DiscreteResourceSpec {
		@JsonProperty("Kind")
		private String kind;

		@JsonProperty("Value")
		private Long value;

	}

	@JsonProperty("NamedResourceSpec")
	private NamedResourceSpec namedResourceSpec;

	@JsonProperty("DiscreteResourceSpec")
	private DiscreteResourceSpec discreteResourceSpec;

}
