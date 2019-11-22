package org.sourcepit.jd.client;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class Mount {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Source {
	}

	public static enum Type {
		BIND("bind"), VOLUME("volume"), TMPFS("tmpfs");

		@Getter
		private final String literal;

		private Type(String literal) {
			this.literal = literal;
		}
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class BindOptions {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Propagation {
		}

		@JsonProperty("Propagation")
		private Propagation propagation;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class VolumeOptions {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class DriverConfig {
			@JsonProperty("Name")
			private String name;

			@JsonProperty("Options")
			private Map<String, String> options;

		}

		@JsonProperty(value = "NoCopy", defaultValue = "false")
		private Boolean noCopy;

		@JsonProperty("Labels")
		private Map<String, String> labels;

		@JsonProperty("DriverConfig")
		private DriverConfig driverConfig;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class TmpfsOptions {
		@JsonProperty("SizeBytes")
		private Long sizeBytes;

		@JsonProperty("Mode")
		private Long mode;

	}

	@JsonProperty("Target")
	private String target;

	@JsonProperty("Source")
	private Source source;

	@JsonProperty("Type")
	private Type type;

	@JsonProperty("ReadOnly")
	private Boolean readOnly;

	@JsonProperty("BindOptions")
	private BindOptions bindOptions;

	@JsonProperty("VolumeOptions")
	private VolumeOptions volumeOptions;

	@JsonProperty("TmpfsOptions")
	private TmpfsOptions tmpfsOptions;

}
