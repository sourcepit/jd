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
public class ServiceSpec {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Mode {
		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Replicated {
			@JsonProperty("Replicas")
			private Long replicas;

		}

		@Data
		@JsonInclude(Include.NON_NULL)
		public static class Global {
		}

		@JsonProperty("Replicated")
		private Replicated replicated;

		@JsonProperty("Global")
		private Global global;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class UpdateConfig {
		public static enum FailureAction {
			CONTINUE("continue"), PAUSE("pause"), ROLLBACK("rollback");

			@Getter
			private final String literal;

			private FailureAction(String literal) {
				this.literal = literal;
			}
		}

		public static enum Order {
			STOPFIRST("stop-first"), STARTFIRST("start-first");

			@Getter
			private final String literal;

			private Order(String literal) {
				this.literal = literal;
			}
		}

		@JsonProperty("Parallelism")
		private Long parallelism;

		@JsonProperty("Delay")
		private Long delay;

		@JsonProperty("FailureAction")
		private FailureAction failureAction;

		@JsonProperty("Monitor")
		private Long monitor;

		@JsonProperty("MaxFailureRatio")
		private Boolean maxFailureRatio;

		@JsonProperty("Order")
		private Order order;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class RollbackConfig {
		public static enum FailureAction {
			CONTINUE("continue"), PAUSE("pause");

			@Getter
			private final String literal;

			private FailureAction(String literal) {
				this.literal = literal;
			}
		}

		public static enum Order {
			STOPFIRST("stop-first"), STARTFIRST("start-first");

			@Getter
			private final String literal;

			private Order(String literal) {
				this.literal = literal;
			}
		}

		@JsonProperty("Parallelism")
		private Long parallelism;

		@JsonProperty("Delay")
		private Long delay;

		@JsonProperty("FailureAction")
		private org.sourcepit.jd.client.ServiceSpec.RollbackConfig.FailureAction failureAction;

		@JsonProperty("Monitor")
		private Long monitor;

		@JsonProperty("MaxFailureRatio")
		private Boolean maxFailureRatio;

		@JsonProperty("Order")
		private org.sourcepit.jd.client.ServiceSpec.RollbackConfig.Order order;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Networks {
		@JsonProperty("Target")
		private String target;

		@JsonProperty("Aliases")
		private List<String> aliases;

	}

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Labels")
	private Map<String, String> labels;

	@JsonProperty("TaskTemplate")
	private TaskSpec taskTemplate;

	@JsonProperty("Mode")
	private Mode mode;

	@JsonProperty("UpdateConfig")
	private UpdateConfig updateConfig;

	@JsonProperty("RollbackConfig")
	private RollbackConfig rollbackConfig;

	@JsonProperty("Networks")
	private List<Networks> networks;

	@JsonProperty("EndpointSpec")
	private EndpointSpec endpointSpec;

}
