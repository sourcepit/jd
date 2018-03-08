package org.sourcepit.jd.client.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * A container's resources (cgroups config, ulimits, etc)
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Resources
{
	// # Applicable to all platforms

	/**
	 * 
	 * An integer value representing this container's relative CPU weight versus other containers.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 */
	@JsonProperty("CpuShares")
	private Integer cpuShares;

	/**
	 * Memory limit in bytes.</br>
	 * </br>
	 * <i><b>Applicable to all platforms</b></i>
	 * 
	 * @default 0
	 */
	@JsonProperty(value = "Memory", defaultValue = "0")
	private Integer memory;

	// # Applicable to UNIX platforms

	/**
	 * Path to <code>cgroups</code> under which the container's <code>cgroup</code> is created. If the path is not
	 * absolute, the path is considered to be relative to the <code>cgroups</code> path of the init process. Cgroups are
	 * created if they do not already exist.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CgroupParent")
	private String cGroupParent;

	/**
	 * Block IO weight (relative weight).</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 * 
	 * @minimum 0
	 * @maximum 1000
	 */
	@JsonProperty("BlkioWeight")
	@Min(0)
	@Max(1000)
	/**
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	private Integer blkioWeight;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class BlkioWeightDevice
	{
		@JsonProperty("Path")
		private String path;

		/**
		 * @minimum 0
		 */
		@JsonProperty("Weight")
		@Min(0)
		private Integer weight;
	}

	/**
	 * Block IO weight (relative device weight) in the form
	 * <code>[{"Path": "device_path", "Weight": weight}]</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("BlkioWeightDevice")
	private List<BlkioWeightDevice> blkioWeightDevice;

	/**
	 * Limit read rate (bytes per second) from a device, in the form
	 * <code>[{"Path": "device_path", "Rate": rate}]</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("BlkioDeviceReadBps")
	private List<ThrottleDevice> blkioDeviceReadBps;

	/**
	 * Limit write rate (bytes per second) to a device, in the form
	 * <code>[{"Path": "device_path", "Rate": rate}]</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("BlkioDeviceWriteBps")
	private List<ThrottleDevice> blkioDeviceWriteBps;

	/**
	 * Limit read rate (IO per second) from a device, in the form
	 * <code>[{"Path": "device_path", "Rate": rate}]</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("BlkioDeviceReadIOps")
	private List<ThrottleDevice> blkioDeviceReadIOps;

	/**
	 * Limit write rate (IO per second) to a device, in the form
	 * <code>[{"Path": "device_path", "Rate": rate}]</code>.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("BlkioDeviceWriteIOps")
	private List<ThrottleDevice> blkioDeviceWriteIOps;

	/**
	 * The length of a CPU period in microseconds.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CpuPeriod")
	private Long cpuPeriod;

	/**
	 * Microseconds of CPU time that the container can get in a CPU period.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CpuQuota")
	private Long cpuQuota;

	/**
	 * The length of a CPU real-time period in microseconds. Set to 0 to allocate no time allocated to real-time
	 * tasks.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CpuRealtimePeriod")
	private Long cpuRealtimePeriod;

	/**
	 * The length of a CPU real-time runtime in microseconds. Set to 0 to allocate no time allocated to real-time
	 * tasks.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CpuRealtimeRuntime")
	private Long cpuRealtimeRuntime;

	/**
	 * CPUs in which to allow execution (e.g., <code>0-3</code>, <code>0,1</code>)</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CpusetCpus")
	private String cpusetCpus;

	/**
	 * Memory nodes (MEMs) in which to allow execution (0-3, 0,1). Only effective on NUMA systems.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("CpusetMems")
	private String cpusetMems;

	/**
	 * A list of devices to add to the container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Devices")
	private List<DeviceMapping> devices;

	/**
	 * Disk limit (in bytes).</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("DiskQuota")
	private Long diskQuota;

	/**
	 * Kernel memory limit in bytes.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("KernelMemory")
	private Long kernelMemory;

	/**
	 * Memory soft limit in bytes.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("MemoryReservation")
	private Long memoryReservation;

	/**
	 * Total memory limit (memory + swap). Set as <code>-1</code> to enable</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("MemorySwap")
	private Long memorySwap;

	/**
	 * Tune a container's memory swappiness behavior. Accepts an integer between 0 and 100.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 * 
	 * @minimum: 0
	 * @maximum: 100
	 */
	@JsonProperty("MemorySwappiness")
	@Min(0)
	@Max(100)
	private Long memorySwappiness;

	/**
	 * CPU quota in units of 10<sup>-9</sup> CPUs.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("NanoCPUs")
	private Long nanoCPUs;

	/**
	 * Disable OOM Killer for the container.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("OomKillDisable")
	private Boolean oomKillDisable;

	/**
	 * Tune a container's pids limit. Set -1 for unlimited.</br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("PidsLimit")
	private Long pidsLimit;

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Ulimit
	{
		/**
		 * Name of ulimit
		 */
		@JsonProperty("Name")
		private String name;

		/**
		 * Soft limit
		 */
		@JsonProperty("Soft")
		private Integer soft;

		/**
		 * Hard limit
		 */
		@JsonProperty("Hard")
		private Integer hard;

	}

	/**
	 * A list of resource limits to set in the container. For example:
	 * <code>{"Name": "nofile", "Soft": 1024, "Hard": 2048}</code></br>
	 * </br>
	 * <i><b>Applicable to UNIX platforms</b></i>
	 */
	@JsonProperty("Ulimits")
	private List<Ulimit> ulimits;

	// # Applicable to Windows

	/**
	 * The number of usable CPUs (Windows only).</br>
	 * </br>
	 * On Windows Server containers, the processor resource controls are mutually exclusive. The order of precedence is
	 * <code>CPUCount</code> first, then <code>CPUShares</code>, and <code>CPUPercent</code> last.</br>
	 * </br>
	 * <i><b>Applicable to Windows</b></i>
	 */
	@JsonProperty("CpuCount")
	private Long cpuCount;

	/**
	 * The usable percentage of the available CPUs (Windows only).</br>
	 * </br>
	 * On Windows Server containers, the processor resource controls are mutually exclusive. The order of precedence is
	 * <code>CPUCount</code> first, then <code>CPUShares</code>, and <code>CPUPercent</code> last.</br>
	 * </br>
	 * <i><b>Applicable to Windows</b></i>
	 */
	@JsonProperty("CpuPercent")
	private Long cpuPercent;

	/**
	 * Maximum IOps for the container system drive (Windows only)</br>
	 * </br>
	 * <i><b>Applicable to Windows</b></i>
	 */
	@JsonProperty("IOMaximumIOps")
	private Long ioMaximumIOps;

	/**
	 * Maximum IO in bytes per second for the container system drive (Windows only)</br>
	 * </br>
	 * <i><b>Applicable to Windows</b></i>
	 */
	@JsonProperty("IOMaximumBandwidth")
	private Long ioMaximumBandwidth;

}
