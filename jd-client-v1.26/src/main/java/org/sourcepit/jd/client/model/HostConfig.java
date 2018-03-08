package org.sourcepit.jd.client.model;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Container configuration that depends on the host we are running on
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class HostConfig extends Resources
{
	// # Applicable to all platforms

	/**
	 * A list of volume bindings for this container. Each volume binding is a string in one of these forms:
	 * <ul>
	 * <li><code>host-src:container-dest</code> to bind-mount a host path into the container. Both
	 * <code>host-src</code>, and <code>container-dest</code> must be an <i>absolute</i> path.</li>
	 * <li><code>host-src:container-dest:ro</code> to make the bind-mount read-only inside the container. Both
	 * <code>host-src</code>, and <code>container-dest</code> must be an <i>absolute</i> path.</li>
	 * <li><code>volume-name:container-dest</code> to bind-mount a volume managed by a volume driver into the container.
	 * <code>container-dest</code> must be an <i>absolute</i> path.</li>
	 * <li><code>volume-name:container-dest:ro</code> to mount the volume read-only inside the container.
	 * <code>container-dest</code> must be an <i>absolute</i> path.</li>
	 * </ul>
	 * </br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("Binds")
	private List<String> binds;

	/**
	 * Path to a file where the container ID is written</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("ContainerIDFile")
	private String containerIdFile;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class LogConfig
	{
		public static enum Type
		{
			JSON_FILE("json-file"),
			SYSLOG("syslog"),
			JOURNALD("journald"),
			GELF("gelf"),
			FLUENTD("fluentd"),
			AWSLOGS("awslogs"),
			SPLUNK("splunk"),
			ETWLOGS("etwlogs"),
			NONE("none");

			private final String literal;

			private Type(String literal)
			{
				this.literal = literal;
			}

			@JsonValue
			public String getLiteral()
			{
				return literal;
			}
		}

		@JsonProperty("Type")
		private Type type;

		@JsonProperty("Config")
		private Map<String, String> config;
	}

	/**
	 * The logging configuration for this container</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("LogConfig")
	private LogConfig logConfig;

	/**
	 * Network mode to use for this container. Supported standard values are: <code>bridge</code>, <code>host</code>,
	 * <code>none</code>, and <code>container:&lt;name|id&gt;</code>. Any other value is taken as a custom network's
	 * name to which this container should connect to.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("NetworkMode")
	private String networkMode;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class HostPort
	{
		/**
		 * The host IP address
		 */
		@JsonProperty("HostIp")
		private String hostIp;

		/**
		 * The host port number, as a string
		 */
		@JsonProperty("HostPort")
		private String hostPort;
	}

	/**
	 * A map of exposed container ports and the host port they should map to.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("PortBindings")
	private Map<String, HostPort> portBindings;

	/**
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("RestartPolicy")
	private RestartPolicy restartPolicy;

	/**
	 * Automatically remove the container when the container's process exits. This has no effect if
	 * <code>RestartPolicy</code> is set.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("AutoRemove")
	private Boolean autoRemove;

	/**
	 * Driver that this container uses to mount volumes.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("VolumeDriver")
	private String volumeDriver;

	/**
	 * A list of volumes to inherit from another container, specified in the form <code>&lt;container
	 * name&gt;[:&lt;ro|rw&gt;]<code>.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("VolumesFrom")
	private List<String> volumesFrom;

	/**
	 * Specification for mounts to be added to the container.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("Mounts")
	private List<Mount> mounts;

	//
	// # Applicable to UNIX platforms

	/**
	 * A list of kernel capabilities to add to the container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CapAdd")
	private List<String> capAdd;

	/**
	 * A list of kernel capabilities to drop from the container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CapDrop")
	private List<String> capDrop;

	/**
	 * A list of DNS servers for the container to use.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Dns")
	private List<String> dns;

	/**
	 * A list of DNS options.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("DnsOptions")
	private List<String> dnsOptions;

	/**
	 * A list of DNS search domains.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("DnsSearch")
	private List<String> dnsSearch;

	/**
	 * A list of hostnames/IP mappings to add to the container's <code>/etc/hosts</code> file. Specified in the form
	 * <code>["hostname:IP"]</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("ExtraHosts")
	private List<String> extraHosts;

	/**
	 * A list of additional groups that the container process will run as.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("GroupAdd")
	private List<String> groupAdd;

	/**
	 * IPC namespace to use for the container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("IpcMode")
	private String ipcMode;

	/**
	 * Cgroup to use for the container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Cgroup")
	private String cGroup;

	/**
	 * A list of links for the container in the form <code>container_name:alias</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Links")
	private List<String> links;

	/**
	 * An integer value containing the score given to the container in order to tune OOM killer preferences.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("OomScoreAdj")
	private Integer oomScoreAdj;

	/**
	 * Set the PID (Process) Namespace mode for the container. It can be either:
	 * <ul>
	 * <li><code>"container:&lt;name|id&gt;"<code>: joins another container's PID namespace</li>
	 * <li><code>"host"<code>: use the host's PID namespace inside the container</li>
	 * </ul>
	 * </br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("PidMode")
	private String pidMode;

	/**
	 * Gives the container full access to the host.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Privileged")
	private Boolean privileged;

	/**
	 * Allocates a random host port for all of a container's exposed ports.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("PublishAllPorts")
	private Boolean publishAllPorts;

	/**
	 * Mount the container's root filesystem as read only.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("ReadonlyRootfs")
	private Boolean readonlyRootfs;

	/**
	 * A list of string values to customize labels for MLS systems, such as SELinux.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("SecurityOpt")
	private List<String> securityOpt;

	/**
	 * Storage driver options for this container, in the form <code>{"size": "120G"}</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("StorageOpt")
	private Map<String, String> storageOpt;

	/**
	 * A map of container directories which should be replaced by tmpfs mounts, and their corresponding mount options.
	 * For example: <code>{ "/run": "rw,noexec,nosuid,size=65536k" }</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Tmpfs")
	private Map<String, String> tmpfs;

	/**
	 * UTS namespace to use for the container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("UTSMode")
	private String utsMode;

	/**
	 * Sets the usernamespace mode for the container when usernamespace remapping option is enabled.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("UsernsMode")
	private String usernsMode;

	/**
	 * Size of <code>/dev/shm</code> in bytes. If omitted, the system uses 64MB.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 * 
	 * @minimum 0
	 */
	@JsonProperty("ShmSize")
	@Min(0)
	private Integer shmSize;

	/**
	 * A list of kernel parameters (sysctls) to set in the container. For example:
	 * <code>{"net.ipv4.ip_forward": "1"}</code></br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Sysctls")
	private Map<String, String> sysctls;

	/**
	 * Runtime to use with this container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Runtime")
	private String runtime;

	// # Applicable to Windows

	/**
	 * Initial console size, as an <code>[height, width]</code> array.</br>
	 * </br>
	 * <i><b>Applicable to Windows</b></i>
	 * 
	 * @minItems: 2
	 * @maxItems: 2
	 */
	@JsonProperty("ConsoleSize")
	@Size(min = 2, max = 2)
	private List<Integer> consoleSize;

	public static enum Isolation
	{
		DEFAULT("default"),
		PROCESS("process"),
		HYPERV("hyperv");

		private final String literal;

		private Isolation(String literal)
		{
			this.literal = literal;
		}

		@JsonValue
		public String getLiteral()
		{
			return literal;
		}
	}

	/**
	 * Isolation technology of the container.</br>
	 * </br>
	 * <i><b>Applicable to Windows</b></i>
	 */
	@JsonProperty("Isolation")
	private Isolation Isolation;
}
