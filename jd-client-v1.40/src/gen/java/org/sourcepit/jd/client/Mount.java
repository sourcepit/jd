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
	public static enum Type {
		BIND("bind"), VOLUME("volume"), TMPFS("tmpfs"), NPIPE("npipe");

		@Getter
		private final String literal;

		private Type(String literal) {
			this.literal = literal;
		}
	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class BindOptions {
		public static enum Propagation {
			PRIVATE("private"), RPRIVATE("rprivate"), SHARED("shared"), RSHARED("rshared"), SLAVE("slave"),
			RSLAVE("rslave");

			@Getter
			private final String literal;

			private Propagation(String literal) {
				this.literal = literal;
			}
		}

		@JsonProperty("Propagation")
		private Propagation propagation;

		@JsonProperty(value = "NonRecursive", defaultValue = "false")
		private Boolean nonRecursive;

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
	private String source;

	@JsonProperty("Type")
	private Type type;

	@JsonProperty("ReadOnly")
	private Boolean readOnly;

	@JsonProperty("Consistency")
	private String consistency;

	@JsonProperty("BindOptions")
	private BindOptions bindOptions;

	@JsonProperty("VolumeOptions")
	private VolumeOptions volumeOptions;

	@JsonProperty("TmpfsOptions")
	private TmpfsOptions tmpfsOptions;

}
