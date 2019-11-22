package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class ContainerInspectOkResponse {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class State {
		public static enum Status {
			CREATED("created"), RUNNING("running"), PAUSED("paused"), RESTARTING("restarting"), REMOVING("removing"),
			EXITED("exited"), DEAD("dead");

			@Getter
			private final String literal;

			private Status(String literal) {
				this.literal = literal;
			}
		}

		@JsonProperty("Status")
		private Status status;

		@JsonProperty("Running")
		private Boolean running;

		@JsonProperty("Paused")
		private Boolean paused;

		@JsonProperty("Restarting")
		private Boolean restarting;

		@JsonProperty("OOMKilled")
		private Boolean oOMKilled;

		@JsonProperty("Dead")
		private Boolean dead;

		@JsonProperty("Pid")
		private Long pid;

		@JsonProperty("ExitCode")
		private Long exitCode;

		@JsonProperty("Error")
		private String error;

		@JsonProperty("StartedAt")
		private String startedAt;

		@JsonProperty("FinishedAt")
		private String finishedAt;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Node {
	}

	@JsonProperty("Id")
	private String id;

	@JsonProperty("Created")
	private String created;

	@JsonProperty("Path")
	private String path;

	@JsonProperty("Args")
	private List<String> args;

	@JsonProperty("State")
	private State state;

	@JsonProperty("Image")
	private String image;

	@JsonProperty("ResolvConfPath")
	private String resolvConfPath;

	@JsonProperty("HostnamePath")
	private String hostnamePath;

	@JsonProperty("HostsPath")
	private String hostsPath;

	@JsonProperty("LogPath")
	private String logPath;

	@JsonProperty("Node")
	private Node node;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("RestartCount")
	private Long restartCount;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("MountLabel")
	private String mountLabel;

	@JsonProperty("ProcessLabel")
	private String processLabel;

	@JsonProperty("AppArmorProfile")
	private String appArmorProfile;

	@JsonProperty("ExecIDs")
	private List<String> execIDs;

	@JsonProperty("HostConfig")
	private HostConfig hostConfig;

	@JsonProperty("GraphDriver")
	private GraphDriverData graphDriver;

	@JsonProperty("SizeRw")
	private Long sizeRw;

	@JsonProperty("SizeRootFs")
	private Long sizeRootFs;

	@JsonProperty("Mounts")
	private List<MountPoint> mounts;

	@JsonProperty("Config")
	private ContainerConfig config;

	@JsonProperty("NetworkSettings")
	private NetworkSettings networkSettings;

}
