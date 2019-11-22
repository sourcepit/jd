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
public class SwarmSpec {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Orchestration {
		@JsonProperty("TaskHistoryRetentionLimit")
		private Long taskHistoryRetentionLimit;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Raft {
		@JsonProperty("SnapshotInterval")
		private Long snapshotInterval;

		@JsonProperty("KeepOldSnapshots")
		private Long keepOldSnapshots;

		@JsonProperty("LogEntriesForSlowFollowers")
		private Long logEntriesForSlowFollowers;

		@JsonProperty("ElectionTick")
		private Long electionTick;

		@JsonProperty("HeartbeatTick")
		private Long heartbeatTick;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Dispatcher {
		@JsonProperty("HeartbeatPeriod")
		private Long heartbeatPeriod;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class CAConfig {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class ExternalCAs {
			public static enum Protocol {
				CFSSL("cfssl");

				@Getter
				private final String literal;

				private Protocol(String literal) {
					this.literal = literal;
				}
			}

			@JsonProperty(value = "Protocol", defaultValue = "cfssl")
			private Protocol protocol;

			@JsonProperty("URL")
			private String uRL;

			@JsonProperty("Options")
			private Map<String, String> options;

		}

		@JsonProperty("NodeCertExpiry")
		private Long nodeCertExpiry;

		@JsonProperty("ExternalCAs")
		private List<ExternalCAs> externalCAs;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class EncryptionConfig {
		@JsonProperty("AutoLockManagers")
		private Boolean autoLockManagers;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class TaskDefaults {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class LogDriver {
			@JsonProperty("Name")
			private String name;

			@JsonProperty("Options")
			private Map<String, String> options;

		}

		@JsonProperty("LogDriver")
		private LogDriver logDriver;

	}

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("Orchestration")
	private Orchestration orchestration;

	@JsonProperty("Raft")
	private Raft raft;

	@JsonProperty("Dispatcher")
	private Dispatcher dispatcher;

	@JsonProperty("CAConfig")
	private CAConfig cAConfig;

	@JsonProperty("EncryptionConfig")
	private EncryptionConfig encryptionConfig;

	@JsonProperty("TaskDefaults")
	private TaskDefaults taskDefaults;

}
