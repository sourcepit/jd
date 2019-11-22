package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class TaskSpec {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class ContainerSpec {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class DNSConfig {
			@JsonProperty("Nameservers")
			private List<String> nameservers;

			@JsonProperty("Search")
			private List<String> search;

			@JsonProperty("Options")
			private List<String> options;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Secrets {
			@Data
			@JsonInclude(Include.NON_NULL)
			public static class File {
				@JsonProperty("Name")
				private String name;

				@JsonProperty("UID")
				private String uID;

				@JsonProperty("GID")
				private String gID;

				@JsonProperty("Mode")
				private Long mode;

			}

			@JsonProperty("File")
			private File file;

			@JsonProperty("SecretID")
			private String secretID;

			@JsonProperty("SecretName")
			private String secretName;

		}

		@JsonProperty("Image")
		private String image;

		@JsonProperty("Labels")
		private Map<String, String> labels;

		@JsonProperty("Command")
		private List<String> command;

		@JsonProperty("Args")
		private List<String> args;

		@JsonProperty("Hostname")
		private String hostname;

		@JsonProperty("Env")
		private List<String> env;

		@JsonProperty("Dir")
		private String dir;

		@JsonProperty("User")
		private String user;

		@JsonProperty("Groups")
		private List<String> groups;

		@JsonProperty("TTY")
		private Boolean tTY;

		@JsonProperty("OpenStdin")
		private Boolean openStdin;

		@JsonProperty("ReadOnly")
		private Boolean readOnly;

		@JsonProperty("Mounts")
		private List<Mount> mounts;

		@JsonProperty("StopGracePeriod")
		private Long stopGracePeriod;

		@JsonProperty("HealthCheck")
		private HealthConfig healthCheck;

		@JsonProperty("Hosts")
		private List<String> hosts;

		@JsonProperty("DNSConfig")
		private DNSConfig dNSConfig;

		@JsonProperty("Secrets")
		private List<Secrets> secrets;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Resources {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Limits {
			@JsonProperty("NanoCPUs")
			private Long nanoCPUs;

			@JsonProperty("MemoryBytes")
			private Long memoryBytes;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Reservation {
			@JsonProperty("NanoCPUs")
			private Long nanoCPUs;

			@JsonProperty("MemoryBytes")
			private Long memoryBytes;

		}

		@JsonProperty("Limits")
		private Limits limits;

		@JsonProperty("Reservation")
		private Reservation reservation;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class RestartPolicy {
		public static enum Condition {
			NONE("none"), ONFAILURE("on-failure"), ANY("any");

			@Getter
			private final String literal;

			private Condition(String literal) {
				this.literal = literal;
			}
		}

		@JsonProperty("Condition")
		private Condition condition;

		@JsonProperty("Delay")
		private Long delay;

		@JsonProperty(value = "MaxAttempts", defaultValue = "0")
		private Long maxAttempts;

		@JsonProperty(value = "Window", defaultValue = "0")
		private Long window;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Placement {
		@JsonProperty("Constraints")
		private List<String> constraints;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Networks {
		@JsonProperty("Target")
		private String target;

		@JsonProperty("Aliases")
		private List<String> aliases;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class LogDriver {
		@JsonProperty("Name")
		private String name;

		@JsonProperty("Options")
		private Map<String, String> options;

	}

	@JsonProperty("ContainerSpec")
	private ContainerSpec containerSpec;

	@JsonProperty("Resources")
	private Resources resources;

	@JsonProperty("RestartPolicy")
	private RestartPolicy restartPolicy;

	@JsonProperty("Placement")
	private Placement placement;

	@JsonProperty("ForceUpdate")
	private Long forceUpdate;

	@JsonProperty("Networks")
	private List<Networks> networks;

	@JsonProperty("LogDriver")
	private LogDriver logDriver;

}
