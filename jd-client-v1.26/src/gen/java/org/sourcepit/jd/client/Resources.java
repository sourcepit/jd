package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Resources {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class BlkioWeightDevice {
		@JsonProperty("Path")
		private String path;

		@JsonProperty("Weight")
		private Long weight;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Ulimits {
		@JsonProperty("Name")
		private String name;

		@JsonProperty("Soft")
		private Long soft;

		@JsonProperty("Hard")
		private Long hard;

	}

	@JsonProperty("CpuShares")
	private Long cpuShares;

	@JsonProperty("Memory")
	private Long memory;

	@JsonProperty("CgroupParent")
	private String cgroupParent;

	@JsonProperty("BlkioWeight")
	private Long blkioWeight;

	@JsonProperty("BlkioWeightDevice")
	private List<BlkioWeightDevice> blkioWeightDevice;

	@JsonProperty("BlkioDeviceReadBps")
	private List<ThrottleDevice> blkioDeviceReadBps;

	@JsonProperty("BlkioDeviceWriteBps")
	private List<ThrottleDevice> blkioDeviceWriteBps;

	@JsonProperty("BlkioDeviceReadIOps")
	private List<ThrottleDevice> blkioDeviceReadIOps;

	@JsonProperty("BlkioDeviceWriteIOps")
	private List<ThrottleDevice> blkioDeviceWriteIOps;

	@JsonProperty("CpuPeriod")
	private Long cpuPeriod;

	@JsonProperty("CpuQuota")
	private Long cpuQuota;

	@JsonProperty("CpuRealtimePeriod")
	private Long cpuRealtimePeriod;

	@JsonProperty("CpuRealtimeRuntime")
	private Long cpuRealtimeRuntime;

	@JsonProperty("CpusetCpus")
	private String cpusetCpus;

	@JsonProperty("CpusetMems")
	private String cpusetMems;

	@JsonProperty("Devices")
	private List<DeviceMapping> devices;

	@JsonProperty("DiskQuota")
	private Long diskQuota;

	@JsonProperty("KernelMemory")
	private Long kernelMemory;

	@JsonProperty("MemoryReservation")
	private Long memoryReservation;

	@JsonProperty("MemorySwap")
	private Long memorySwap;

	@JsonProperty("MemorySwappiness")
	private Long memorySwappiness;

	@JsonProperty("NanoCPUs")
	private Long nanoCPUs;

	@JsonProperty("OomKillDisable")
	private Boolean oomKillDisable;

	@JsonProperty("PidsLimit")
	private Long pidsLimit;

	@JsonProperty("Ulimits")
	private List<Ulimits> ulimits;

	@JsonProperty("CpuCount")
	private Long cpuCount;

	@JsonProperty("CpuPercent")
	private Long cpuPercent;

	@JsonProperty("IOMaximumIOps")
	private Long iOMaximumIOps;

	@JsonProperty("IOMaximumBandwidth")
	private Long iOMaximumBandwidth;

}
