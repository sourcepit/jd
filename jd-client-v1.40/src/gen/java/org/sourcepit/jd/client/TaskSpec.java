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
	public static class PluginSpec {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class PluginPrivilege {
			@JsonProperty("Name")
			private String name;

			@JsonProperty("Description")
			private String description;

			@JsonProperty("Value")
			private List<String> value;

		}

		@JsonProperty("Name")
		private String name;

		@JsonProperty("Remote")
		private String remote;

		@JsonProperty("Disabled")
		private Boolean disabled;

		@JsonProperty("PluginPrivilege")
		private List<PluginPrivilege> pluginPrivilege;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class ContainerSpec {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Privileges {
			@Data
			@JsonInclude(Include.NON_NULL)
			public static class CredentialSpec {
				@JsonProperty("Config")
				private String config;

				@JsonProperty("File")
				private String file;

				@JsonProperty("Registry")
				private String registry;

			}

			@Data
			@JsonInclude(Include.NON_NULL)
			public static class SELinuxContext {
				@JsonProperty("Disable")
				private Boolean disable;

				@JsonProperty("User")
				private String user;

				@JsonProperty("Role")
				private String role;

				@JsonProperty("Type")
				private String type;

				@JsonProperty("Level")
				private String level;

			}

			@JsonProperty("CredentialSpec")
			private CredentialSpec credentialSpec;

			@JsonProperty("SELinuxContext")
			private SELinuxContext sELinuxContext;

		}

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

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Configs {
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

			@Data
			@JsonInclude(Include.NON_NULL)
			public static class Runtime {
			}

			@JsonProperty("File")
			private org.sourcepit.jd.client.TaskSpec.ContainerSpec.Configs.File file;

			@JsonProperty("Runtime")
			private Runtime runtime;

			@JsonProperty("ConfigID")
			private String configID;

			@JsonProperty("ConfigName")
			private String configName;

		}

		public static enum Isolation {
			DEFAULT("default"), PROCESS("process"), HYPERV("hyperv");

			@Getter
			private final String literal;

			private Isolation(String literal) {
				this.literal = literal;
			}
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

		@JsonProperty("Privileges")
		private Privileges privileges;

		@JsonProperty("TTY")
		private Boolean tTY;

		@JsonProperty("OpenStdin")
		private Boolean openStdin;

		@JsonProperty("ReadOnly")
		private Boolean readOnly;

		@JsonProperty("Mounts")
		private List<Mount> mounts;

		@JsonProperty("StopSignal")
		private String stopSignal;

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

		@JsonProperty("Configs")
		private List<Configs> configs;

		@JsonProperty("Isolation")
		private Isolation isolation;

		@JsonProperty("Init")
		private Boolean init;

		@JsonProperty("Sysctls")
		private Map<String, String> sysctls;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class NetworkAttachmentSpec {
		@JsonProperty("ContainerID")
		private String containerID;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Resources {
		@JsonProperty("Limits")
		private ResourceObject limits;

		@JsonProperty("Reservation")
		private ResourceObject reservation;

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
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Preferences {
			@Data
			@JsonInclude(Include.NON_NULL)
			public static class Spread {
				@JsonProperty("SpreadDescriptor")
				private String spreadDescriptor;

			}

			@JsonProperty("Spread")
			private Spread spread;

		}

		@JsonProperty("Constraints")
		private List<String> constraints;

		@JsonProperty("Preferences")
		private List<Preferences> preferences;

		@JsonProperty(value = "MaxReplicas", defaultValue = "0")
		private Long maxReplicas;

		@JsonProperty("Platforms")
		private List<Platform> platforms;

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

	@JsonProperty("PluginSpec")
	private PluginSpec pluginSpec;

	@JsonProperty("ContainerSpec")
	private ContainerSpec containerSpec;

	@JsonProperty("NetworkAttachmentSpec")
	private NetworkAttachmentSpec networkAttachmentSpec;

	@JsonProperty("Resources")
	private Resources resources;

	@JsonProperty("RestartPolicy")
	private RestartPolicy restartPolicy;

	@JsonProperty("Placement")
	private Placement placement;

	@JsonProperty("ForceUpdate")
	private Long forceUpdate;

	@JsonProperty("Runtime")
	private String runtime;

	@JsonProperty("Networks")
	private List<Networks> networks;

	@JsonProperty("LogDriver")
	private LogDriver logDriver;

}
