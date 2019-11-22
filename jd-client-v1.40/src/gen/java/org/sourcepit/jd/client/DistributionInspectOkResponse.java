package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class DistributionInspectOkResponse {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Descriptor {
		@JsonProperty("MediaType")
		private String mediaType;

		@JsonProperty("Size")
		private Long size;

		@JsonProperty("Digest")
		private String digest;

		@JsonProperty("URLs")
		private List<String> uRLs;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Platforms {
		@JsonProperty("Architecture")
		private String architecture;

		@JsonProperty("OS")
		private String oS;

		@JsonProperty("OSVersion")
		private String oSVersion;

		@JsonProperty("OSFeatures")
		private List<String> oSFeatures;

		@JsonProperty("Variant")
		private String variant;

		@JsonProperty("Features")
		private List<String> features;

	}

	@JsonProperty("Descriptor")
	private Descriptor descriptor;

	@JsonProperty("Platforms")
	private List<Platforms> platforms;

}
