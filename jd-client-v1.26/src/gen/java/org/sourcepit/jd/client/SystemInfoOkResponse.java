package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemInfoOkResponse {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Plugins {
		@JsonProperty("Volume")
		private List<String> volume;

		@JsonProperty("Network")
		private List<String> network;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class RegistryConfig {
		@JsonProperty("IndexConfigs")
		private Map<List<String>, List<String>> indexConfigs;

		@JsonProperty("InsecureRegistryCIDRs")
		private List<String> insecureRegistryCIDRs;

	}

	@JsonProperty("Architecture")
	private String architecture;

	@JsonProperty("Containers")
	private Long containers;

	@JsonProperty("ContainersRunning")
	private Long containersRunning;

	@JsonProperty("ContainersStopped")
	private Long containersStopped;

	@JsonProperty("ContainersPaused")
	private Long containersPaused;

	@JsonProperty("CpuCfsPeriod")
	private Boolean cpuCfsPeriod;

	@JsonProperty("CpuCfsQuota")
	private Boolean cpuCfsQuota;

	@JsonProperty("Debug")
	private Boolean debug;

	@JsonProperty("DiscoveryBackend")
	private String discoveryBackend;

	@JsonProperty("DockerRootDir")
	private String dockerRootDir;

	@JsonProperty("Driver")
	private String driver;

	@JsonProperty("DriverStatus")
	private List<List<String>> driverStatus;

	@JsonProperty("SystemStatus")
	private List<List<String>> systemStatus;

	@JsonProperty("Plugins")
	private Plugins plugins;

	@JsonProperty("ExperimentalBuild")
	private Boolean experimentalBuild;

	@JsonProperty("HttpProxy")
	private String httpProxy;

	@JsonProperty("HttpsProxy")
	private String httpsProxy;

	@JsonProperty("ID")
	private String iD;

	@JsonProperty("IPv4Forwarding")
	private Boolean iPv4Forwarding;

	@JsonProperty("Images")
	private Long images;

	@JsonProperty("IndexServerAddress")
	private String indexServerAddress;

	@JsonProperty("InitPath")
	private String initPath;

	@JsonProperty("InitSha1")
	private String initSha1;

	@JsonProperty("KernelVersion")
	private String kernelVersion;

	@JsonProperty("Labels")
	private List<String> labels;

	@JsonProperty("MemTotal")
	private Long memTotal;

	@JsonProperty("MemoryLimit")
	private Boolean memoryLimit;

	@JsonProperty("NCPU")
	private Long nCPU;

	@JsonProperty("NEventsListener")
	private Long nEventsListener;

	@JsonProperty("NFd")
	private Long nFd;

	@JsonProperty("NGoroutines")
	private Long nGoroutines;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("NoProxy")
	private String noProxy;

	@JsonProperty("OomKillDisable")
	private Boolean oomKillDisable;

	@JsonProperty("OSType")
	private String oSType;

	@JsonProperty("OomScoreAdj")
	private Long oomScoreAdj;

	@JsonProperty("OperatingSystem")
	private String operatingSystem;

	@JsonProperty("RegistryConfig")
	private RegistryConfig registryConfig;

	@JsonProperty("SwapLimit")
	private Boolean swapLimit;

	@JsonProperty("SystemTime")
	private String systemTime;

	@JsonProperty("ServerVersion")
	private String serverVersion;

}
