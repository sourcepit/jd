package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Task {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Status {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class ContainerStatus {
			@JsonProperty("ContainerID")
			private String containerID;

			@JsonProperty("PID")
			private Long pID;

			@JsonProperty("ExitCode")
			private Long exitCode;

		}

		@JsonProperty("Timestamp")
		private String timestamp;

		@JsonProperty("State")
		private TaskState state;

		@JsonProperty("Message")
		private String message;

		@JsonProperty("Err")
		private String err;

		@JsonProperty("ContainerStatus")
		private ContainerStatus containerStatus;

	}

	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Version")
	private ObjectVersion version;

	@JsonProperty("CreatedAt")
	private String createdAt;

	@JsonProperty("UpdatedAt")
	private String updatedAt;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("Spec")
	private TaskSpec spec;

	@JsonProperty("ServiceID")
	private String serviceID;

	@JsonProperty("Slot")
	private Long slot;

	@JsonProperty("NodeID")
	private String nodeID;

	@JsonProperty("AssignedGenericResources")
	private List<GenericResources> assignedGenericResources;

	@JsonProperty("Status")
	private Status status;

	@JsonProperty("DesiredState")
	private TaskState desiredState;

}
