package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class Service {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Endpoint {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class VirtualIPs {
			@JsonProperty("NetworkID")
			private String networkID;

			@JsonProperty("Addr")
			private String addr;

		}

		@JsonProperty("Spec")
		private EndpointSpec spec;

		@JsonProperty("Ports")
		private List<EndpointPortConfig> ports;

		@JsonProperty("VirtualIPs")
		private List<VirtualIPs> virtualIPs;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class UpdateStatus {
		public static enum State {
			UPDATING("updating"), PAUSED("paused"), COMPLETED("completed");

			@Getter
			private final String literal;

			private State(String literal) {
				this.literal = literal;
			}
		}

		@JsonProperty("State")
		private State state;

		@JsonProperty("StartedAt")
		private String startedAt;

		@JsonProperty("CompletedAt")
		private String completedAt;

		@JsonProperty("Message")
		private String message;

	}

	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Version")
	private ObjectVersion version;

	@JsonProperty("CreatedAt")
	private String createdAt;

	@JsonProperty("UpdatedAt")
	private String updatedAt;

	@JsonProperty("Spec")
	private ServiceSpec spec;

	@JsonProperty("Endpoint")
	private Endpoint endpoint;

	@JsonProperty("UpdateStatus")
	private UpdateStatus updateStatus;

}
