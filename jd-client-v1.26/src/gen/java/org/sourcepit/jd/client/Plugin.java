package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Plugin {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Settings {
		@JsonProperty("Mounts")
		private List<PluginMount> mounts;

		@JsonProperty("Env")
		private List<String> env;

		@JsonProperty("Args")
		private List<String> args;

		@JsonProperty("Devices")
		private List<PluginDevice> devices;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Config {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Interface {
			@JsonProperty("Types")
			private List<PluginInterfaceType> types;

			@JsonProperty("Socket")
			private String socket;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class User {
			@JsonProperty("UID")
			private Long uID;

			@JsonProperty("GID")
			private Long gID;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Network {
			@JsonProperty("Type")
			private String type;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Linux {
			@JsonProperty("Capabilities")
			private List<String> capabilities;

			@JsonProperty("AllowAllDevices")
			private Boolean allowAllDevices;

			@JsonProperty("Devices")
			private List<PluginDevice> devices;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Args {
			@JsonProperty("Name")
			private String name;

			@JsonProperty("Description")
			private String description;

			@JsonProperty("Settable")
			private List<String> settable;

			@JsonProperty("Value")
			private List<String> value;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Rootfs {
			@JsonProperty("type")
			private String type;

			@JsonProperty("diff_ids")
			private List<String> diff_ids;

		}

		@JsonProperty("Description")
		private String description;

		@JsonProperty("Documentation")
		private String documentation;

		@JsonProperty("Interface")
		private Interface _interface;

		@JsonProperty("Entrypoint")
		private List<String> entrypoint;

		@JsonProperty("WorkDir")
		private String workDir;

		@JsonProperty("User")
		private User user;

		@JsonProperty("Network")
		private Network network;

		@JsonProperty("Linux")
		private Linux linux;

		@JsonProperty("PropagatedMount")
		private String propagatedMount;

		@JsonProperty("Mounts")
		private List<PluginMount> mounts;

		@JsonProperty("Env")
		private List<PluginEnv> env;

		@JsonProperty("Args")
		private Args args;

		@JsonProperty("rootfs")
		private Rootfs rootfs;

	}

	@JsonProperty("Id")
	private String id;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Enabled")
	private Boolean enabled;

	@JsonProperty("Settings")
	private Settings settings;

	@JsonProperty("PluginReference")
	private String pluginReference;

	@JsonProperty("Config")
	private Config config;

}
