package org.sourcepit.jd.client.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;

/**
 * Configuration for a container that is portable between hosts
 */
@Data
@JsonInclude(Include.NON_NULL)
public class Config {
	@Data
	public static class EmptyObject {
	}

	/**
	 * The hostname to use for the container, as a valid RFC 1123 hostname.
	 */
	@JsonProperty("Hostname")
	private String hostname;

	/**
	 * The domain name to use for the container.
	 */
	@JsonProperty("Domainname")
	private String domainname;

	/**
	 * The user that commands are run as inside the container.
	 */
	@JsonProperty("User")
	private String user;

	/**
	 * Whether to attach to <code>stdin</code>.
	 * 
	 * @default false
	 */
	@JsonProperty(value = "AttachStdin", defaultValue = "false")
	private Boolean attachStdin;

	/**
	 * Whether to attach to <code>stdout</code>.
	 * 
	 * @default true
	 */
	@JsonProperty(value = "AttachStdout", defaultValue = "true")
	private Boolean attachStdout;

	/**
	 * Whether to attach to <code>stderr</code>.
	 * 
	 * @default true
	 */
	@JsonProperty(value = "AttachStderr", defaultValue = "true")
	private Boolean attachStderr;

	/**
	 * An object mapping ports to an empty object in the form:
	 * <code>{"&lt;port&gt/&lt;tcp|udp&gt": {}}</code>
	 */
	@JsonProperty("ExposedPorts")
	private Map<String, EmptyObject> exposedPorts;

	/**
	 * Attach standard streams to a TTY, including <code>stdin</code> if it is not
	 * closed.
	 * 
	 * @default false
	 */
	@JsonProperty(value = "Tty", defaultValue = "false")
	private Boolean tty;

	/**
	 * Open <code>stdin</code>
	 * 
	 * @default false
	 */
	@JsonProperty(value = "OpenStdin", defaultValue = "false")
	private Boolean openStdin;

	/**
	 * Close <code>stdin</code> after one attached client disconnects
	 * 
	 * @default false
	 */
	@JsonProperty(value = "StdinOnce", defaultValue = "false")
	private Boolean stdinOnce;

	/**
	 * A list of environment variables to set inside the container in the form
	 * <code>["VAR=value", ...]</code>
	 */
	@JsonProperty("Env")
	private List<String> env;

	/**
	 * Command to run specified as a string or an array of strings.
	 */
	@JsonProperty("Cmd")
	@JsonDeserialize(using = StringOrStringList.Deserializer.class)
	@JsonSerialize(using = StringOrStringList.Serializer.class)
	private StringOrStringList cmd;

	/**
	 * A test to perform to check that the container is healthy.
	 */
	@JsonProperty("Healthcheck")
	private HealthConfig healthcheck;

	/**
	 * Command is already escaped (Windows only)
	 */
	@JsonProperty("ArgsEscaped")
	private Boolean argsEscaped;

	/**
	 * The name of the image to use when creating the container
	 */
	@JsonProperty("Image")
	private String image;

	/**
	 * An object mapping mount point paths inside the container to empty objects.
	 */
	@JsonProperty("Volumes")
	private Map<String, EmptyObject> volumes;

	/**
	 * The working directory for commands to run in.
	 */
	@JsonProperty("WorkingDir")
	private String workingDir;

	/**
	 * The entry point for the container as a string or an array of strings. </br>
	 * </br>
	 * If the array consists of exactly one empty string (<code>[""]</code>) then
	 * the entry point is reset to system default (i.e., the entry point used by
	 * docker when there is no <code>ENTRYPOINT</code> instruction in the
	 * <code>Dockerfile</code>).
	 */
	@JsonProperty("Entrypoint")
	@JsonDeserialize(using = StringOrStringList.Deserializer.class)
	@JsonSerialize(using = StringOrStringList.Serializer.class)
	private StringOrStringList entrypoint;

	/**
	 * Disable networking for the container.
	 */
	@JsonProperty("NetworkDisabled")
	private Boolean networkDisabled;

	/**
	 * MAC address of the container.
	 */
	@JsonProperty("MacAddress")
	private String macAddress;

	/**
	 * <code>ONBUILD</code> metadata that were defined in the image's
	 * <code>Dockerfile</code>.
	 */
	@JsonProperty("OnBuild")
	private List<String> onBuild;

	/**
	 * User-defined key/value metadata.
	 */
	@JsonProperty("Labels")
	private Map<String, String> labels;

	/**
	 * Signal to stop a container as a string or unsigned integer.
	 * 
	 * @default SIGTERM
	 */
	@JsonProperty(value = "StopSignal", defaultValue = "SIGTERM")
	private String stopSignal;

	/**
	 * Timeout to stop a container in seconds.
	 * 
	 * @default 10
	 */
	@JsonProperty(value = "StopTimeout", defaultValue = "10")
	private Integer stopTimeout;

	/**
	 * Shell for when <code>RUN</code>, <code>CMD</code>, and
	 * <code>ENTRYPOINT</code> uses a shell.
	 */
	@JsonProperty("Shell")
	private String shell;

}
