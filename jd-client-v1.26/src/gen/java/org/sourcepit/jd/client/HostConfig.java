package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class HostConfig extends Resources {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class LogConfig {
		public static enum Type {
			JSONFILE("json-file"), SYSLOG("syslog"), JOURNALD("journald"), GELF("gelf"), FLUENTD("fluentd"),
			AWSLOGS("awslogs"), SPLUNK("splunk"), ETWLOGS("etwlogs"), NONE("none");

			@Getter
			private final String literal;

			private Type(String literal) {
				this.literal = literal;
			}
		}

		@JsonProperty("Type")
		private Type type;

		@JsonProperty("Config")
		private Map<String, String> config;

	}

	public static enum Isolation {
		DEFAULT("default"), PROCESS("process"), HYPERV("hyperv");

		@Getter
		private final String literal;

		private Isolation(String literal) {
			this.literal = literal;
		}
	}

	@JsonProperty("Binds")
	private List<String> binds;

	@JsonProperty("ContainerIDFile")
	private String containerIDFile;

	@JsonProperty("LogConfig")
	private LogConfig logConfig;

	@JsonProperty("NetworkMode")
	private String networkMode;

	@JsonProperty("PortBindings")
	private Map<String, String> portBindings;

	@JsonProperty("RestartPolicy")
	private RestartPolicy restartPolicy;

	@JsonProperty("AutoRemove")
	private Boolean autoRemove;

	@JsonProperty("VolumeDriver")
	private String volumeDriver;

	@JsonProperty("VolumesFrom")
	private List<String> volumesFrom;

	@JsonProperty("Mounts")
	private List<Mount> mounts;

	@JsonProperty("CapAdd")
	private List<String> capAdd;

	@JsonProperty("CapDrop")
	private List<String> capDrop;

	@JsonProperty("Dns")
	private List<String> dns;

	@JsonProperty("DnsOptions")
	private List<String> dnsOptions;

	@JsonProperty("DnsSearch")
	private List<String> dnsSearch;

	@JsonProperty("ExtraHosts")
	private List<String> extraHosts;

	@JsonProperty("GroupAdd")
	private List<String> groupAdd;

	@JsonProperty("IpcMode")
	private String ipcMode;

	@JsonProperty("Cgroup")
	private String cgroup;

	@JsonProperty("Links")
	private List<String> links;

	@JsonProperty("OomScoreAdj")
	private Long oomScoreAdj;

	@JsonProperty("PidMode")
	private String pidMode;

	@JsonProperty("Privileged")
	private Boolean privileged;

	@JsonProperty("PublishAllPorts")
	private Boolean publishAllPorts;

	@JsonProperty("ReadonlyRootfs")
	private Boolean readonlyRootfs;

	@JsonProperty("SecurityOpt")
	private List<String> securityOpt;

	@JsonProperty("StorageOpt")
	private Map<String, String> storageOpt;

	@JsonProperty("Tmpfs")
	private Map<String, String> tmpfs;

	@JsonProperty("UTSMode")
	private String uTSMode;

	@JsonProperty("UsernsMode")
	private String usernsMode;

	@JsonProperty("ShmSize")
	private Long shmSize;

	@JsonProperty("Sysctls")
	private Map<String, String> sysctls;

	@JsonProperty("Runtime")
	private String runtime;

	@JsonProperty("ConsoleSize")
	private List<Long> consoleSize;

	@JsonProperty("Isolation")
	private Isolation isolation;

}
