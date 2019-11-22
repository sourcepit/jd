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
public class SystemInfo {
	public static enum CgroupDriver {
		CGROUPFS("cgroupfs"), SYSTEMD("systemd"), NONE("none");

		@Getter
		private final String literal;

		private CgroupDriver(String literal) {
			this.literal = literal;
		}
	}

	public static enum Isolation {
		DEFAULT("default"), HYPERV("hyperv"), PROCESS("process");

		@Getter
		private final String literal;

		private Isolation(String literal) {
			this.literal = literal;
		}
	}

	@JsonProperty("ID")
	private String iD;

	@JsonProperty("Containers")
	private Long containers;

	@JsonProperty("ContainersRunning")
	private Long containersRunning;

	@JsonProperty("ContainersPaused")
	private Long containersPaused;

	@JsonProperty("ContainersStopped")
	private Long containersStopped;

	@JsonProperty("Images")
	private Long images;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("DriverStatus")
	private List<List<String>> driverStatus;

	@JsonProperty("DockerRootDir")
	private String dockerRootDir;

	@JsonProperty("SystemStatus")
	private List<List<String>> systemStatus;

	@JsonProperty("Plugins")
	private PluginsInfo plugins;

	@JsonProperty("MemoryLimit")
	private Boolean memoryLimit;

	@JsonProperty("SwapLimit")
	private Boolean swapLimit;

	@JsonProperty("KernelMemory")
	private Boolean kernelMemory;

	@JsonProperty("CpuCfsPeriod")
	private Boolean cpuCfsPeriod;

	@JsonProperty("CpuCfsQuota")
	private Boolean cpuCfsQuota;

	@JsonProperty("CPUShares")
	private Boolean cPUShares;

	@JsonProperty("CPUSet")
	private Boolean cPUSet;

	@JsonProperty("PidsLimit")
	private Boolean pidsLimit;

	@JsonProperty("OomKillDisable")
	private Boolean oomKillDisable;

	@JsonProperty("IPv4Forwarding")
	private Boolean iPv4Forwarding;

	@JsonProperty("BridgeNfIptables")
	private Boolean bridgeNfIptables;

	@JsonProperty("BridgeNfIp6tables")
	private Boolean bridgeNfIp6tables;

	@JsonProperty("Debug")
	private Boolean debug;

	@JsonProperty("NFd")
	private Long nFd;

	@JsonProperty("NGoroutines")
	private Long nGoroutines;

	@JsonProperty("SystemTime")
	private String systemTime;

	@JsonProperty("LoggingDriver")
	private String loggingDriver;

	@JsonProperty(value = "CgroupDriver", defaultValue = "cgroupfs")
	private CgroupDriver cgroupDriver;

	@JsonProperty("NEventsListener")
	private Long nEventsListener;

	@JsonProperty("KernelVersion")
	private String kernelVersion;

	@JsonProperty("OperatingSystem")
	private String operatingSystem;

	@JsonProperty("OSType")
	private String oSType;

	@JsonProperty("Architecture")
	private String architecture;

	@JsonProperty("NCPU")
	private Long nCPU;

	@JsonProperty("MemTotal")
	private Long memTotal;

	@JsonProperty(value = "IndexServerAddress", defaultValue = "https://index.docker.io/v1/")
	private String indexServerAddress;

	@JsonProperty("RegistryConfig")
	private RegistryServiceConfig registryConfig;

	@JsonProperty("GenericResources")
	private List<GenericResources> genericResources;

	@JsonProperty("HttpProxy")
	private String httpProxy;

	@JsonProperty("HttpsProxy")
	private String httpsProxy;

	@JsonProperty("NoProxy")
	private String noProxy;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Labels")
	private List<String> labels;

	@JsonProperty("ExperimentalBuild")
	private Boolean experimentalBuild;

	@JsonProperty("ServerVersion")
	private String serverVersion;

	@JsonProperty("ClusterStore")
	private String clusterStore;

	@JsonProperty("ClusterAdvertise")
	private String clusterAdvertise;

	@JsonProperty("Runtimes")
	private Map<Runtime, Runtime> runtimes;

	@JsonProperty(value = "DefaultRuntime", defaultValue = "runc")
	private String defaultRuntime;

	@JsonProperty("Swarm")
	private SwarmInfo swarm;

	@JsonProperty(value = "LiveRestoreEnabled", defaultValue = "false")
	private Boolean liveRestoreEnabled;

	@JsonProperty(value = "Isolation", defaultValue = "default")
	private Isolation isolation;

	@JsonProperty("InitBinary")
	private String initBinary;

	@JsonProperty("ContainerdCommit")
	private Commit containerdCommit;

	@JsonProperty("RuncCommit")
	private Commit runcCommit;

	@JsonProperty("InitCommit")
	private Commit initCommit;

	@JsonProperty("SecurityOptions")
	private List<String> securityOptions;

	@JsonProperty("ProductLicense")
	private String productLicense;

	@JsonProperty("Warnings")
	private List<String> warnings;

}
