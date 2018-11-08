package org.sourcepit.jd.client.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Mount {
	/**
	 * Container path.
	 */
	@JsonProperty("Target")
	private String target;

	/**
	 * Mount source (e.g. a volume name, a host path).
	 */
	@JsonProperty("Source")
	private String source;

	public static enum Type {
		/**
		 * Mounts a file or directory from the host into the container. Must exist prior
		 * to creating the container.
		 */
		BIND("bind"),

		/**
		 * Creates a volume with the given name and options (or uses a pre-existing
		 * volume with the same name and options). These are <b>not</b> removed when the
		 * container is removed.
		 */
		VOLUME("volume"),

		/**
		 * Create a tmpfs with the given options. The mount source cannot be specified
		 * for tmpfs.
		 */
		TMPFS("tmpfs");

		private final String literal;

		private Type(String literal) {
			this.literal = literal;
		}

		@JsonValue
		public String getLiteral() {
			return literal;
		}
	}

	/**
	 * The mount type
	 */
	@JsonProperty("Type")
	private Type type;

	/**
	 * Whether the mount should be read-only.
	 */
	@JsonProperty("ReadOnly")
	private Boolean readOnly;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class BindOptions {
		public enum Propagation {
			PRIVATE("private"), RPRIVATE("rprivate"), SHARED("shared"), RSHARED("rshared"), SLAVE("slave"),
			RSLAVE("rslave");

			private final String literal;

			private Propagation(String literal) {
				this.literal = literal;
			}

			@JsonValue
			public String getLiteral() {
				return literal;
			}
		}

		/**
		 * A propagation mode with the value <code>[r]private</code>,
		 * <code>[r]shared</code>, or <code>[r]slave</code>.
		 */
		@JsonProperty("Propagation")
		private Propagation Propagation;
	}

	/**
	 * Optional configuration for the <code>bind</code> type.
	 */
	@JsonProperty("BindOptions")
	private BindOptions bindOptions;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class VolumeOptions {
		/**
		 * Populate volume with data from the target.
		 * 
		 * @default false
		 */
		@JsonProperty(value = "NoCopy", defaultValue = "false")
		private Boolean noCopy;

		/**
		 * User-defined key/value metadata.
		 */
		@JsonProperty("Labels")
		private Map<String, String> labels;

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class DriverConfig {
			/**
			 * Name of the driver to use to create the volume.
			 */
			@JsonProperty("Name")
			private String name;

			/**
			 * key/value map of driver specific options.
			 */
			@JsonProperty("Options")
			private Map<String, String> options;
		}

		/**
		 * Map of driver specific options
		 */
		@JsonProperty("DriverConfig")
		private DriverConfig driverConfig;
	}

	/**
	 * Optional configuration for the <code>volume</code> type.
	 */
	@JsonProperty("VolumeOptions")
	private VolumeOptions volumeOptions;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class TmpfsOptions {
		/**
		 * The size for the tmpfs mount in bytes.
		 */
		@JsonProperty("SizeBytes")
		private Long sizeBytes;

		/**
		 * The permission mode for the tmpfs mount in an integer.
		 */
		@JsonProperty("Mode")
		private Integer mode;
	}

	/**
	 * Optional configuration for the <code>tmpfs</code> type.
	 */
	@JsonProperty("TmpfsOptions")
	private TmpfsOptions tmpfsOptions;
}
