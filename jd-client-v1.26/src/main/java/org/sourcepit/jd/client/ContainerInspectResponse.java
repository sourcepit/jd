package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public class ContainerInspectResponse {
	/**
	 * The ID of this container
	 */
	@JsonProperty("Id")
	private String id;

	/**
	 * The time the container was created
	 */
	@JsonProperty("Created")
	private String created;

	/**
	 * The path to the command being run
	 */
	@JsonProperty("Path")
	private String path;

	/**
	 * The arguments to the command being run
	 */
	@JsonProperty("Args")
	private List<String> args;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class State {

		/**
		 * The status of the container. For example, <code>running</code> or
		 * <code>exited</code>.
		 */
		@JsonProperty("Status")
		private String status;

		/**
		 * Whether this container is running.
		 */
		@JsonProperty("Running")
		private Boolean running;

		/**
		 * Whether this container is paused.
		 */
		@JsonProperty("Paused")
		private Boolean paused;

		/**
		 * Whether this container is restarting.
		 */
		@JsonProperty("Restarting")
		private Boolean restarting;

		/**
		 * Whether this container has been killed because it ran out of memory.
		 */
		@JsonProperty("OOMKilled")
		private Boolean oomKilled;

		@JsonProperty("Dead")
		private Boolean dead;

		/**
		 * The process ID of this container
		 */
		@JsonProperty("Pid")
		private Integer pid;

		/**
		 * The last exit code of this container
		 */
		@JsonProperty("ExitCode")
		private Integer exitCode;

		@JsonProperty("Error")
		private String error;

		/**
		 * The time when this container was last started.
		 */
		@JsonProperty("StartedAt")
		private String startedAt;

		/**
		 * The time when this container last exited.
		 */
		@JsonProperty("FinishedAt")
		private String finishedAt;
	}

	/**
	 * The state of the container.
	 */
	@JsonProperty("State")
	private State state;

//      Image:
//        description: "The container's image"
//        type: "string"
//      ResolvConfPath:
//        type: "string"
//      HostnamePath:
//        type: "string"
//      HostsPath:
//        type: "string"
//      LogPath:
//        type: "string"
//      Node:
//        description: "TODO"
//        type: "object"
//      Name:
//        type: "string"
//      RestartCount:
//        type: "integer"
//      Driver:
//        type: "string"
//      MountLabel:
//        type: "string"
//      ProcessLabel:
//        type: "string"
//      AppArmorProfile:
//        type: "string"
//      ExecIDs:
//        type: "string"
//      HostConfig:
//        $ref: "#/definitions/HostConfig"
//      GraphDriver:
//        $ref: "#/definitions/GraphDriver"
//      SizeRw:
//        description: "The size of files that have been created or changed by this container."
//        type: "integer"
//        format: "int64"
//      SizeRootFs:
//        description: "The total size of all the files in this container."
//        type: "integer"
//        format: "int64"
//      Mounts:
//        type: "array"
//        items:
//          $ref: "#/definitions/MountPoint"
//      Config:
//        $ref: "#/definitions/Config"
//      NetworkSettings:
//        $ref: "#/definitions/NetworkConfig"
}
