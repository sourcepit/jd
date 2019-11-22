package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.Getter;

@Data
@JsonInclude(Include.NON_NULL)
public class ImageBuildRequest {
	public static enum ContentType {
		APPLICATIONTAR("application/tar");

		@Getter
		private final String literal;

		private ContentType(String literal) {
			this.literal = literal;
		}
	}

	@JsonIgnore
	@HeaderParameter("X-Registry-Config")
	private String xRegistryConfig;

	@JsonIgnore
	@HeaderParameter(value = "Content-type", defaultValue = "application/tar")
	private ContentType contentType;

	@JsonIgnore
	@QueryParameter("networkmode")
	private String networkmode;

	@JsonIgnore
	@QueryParameter("labels")
	private String labels;

	@JsonIgnore
	@QueryParameter("squash")
	private Boolean squash;

	@JsonIgnore
	@QueryParameter("shmsize")
	private Long shmsize;

	@JsonIgnore
	@QueryParameter("buildargs")
	private Long buildargs;

	@JsonIgnore
	@QueryParameter("cpuquota")
	private Long cpuquota;

	@JsonIgnore
	@QueryParameter("cpuperiod")
	private Long cpuperiod;

	@JsonIgnore
	@QueryParameter("cpusetcpus")
	private String cpusetcpus;

	@JsonIgnore
	@QueryParameter("cpushares")
	private Long cpushares;

	@JsonIgnore
	@QueryParameter("memswap")
	private Long memswap;

	@JsonIgnore
	@QueryParameter("memory")
	private Long memory;

	@JsonIgnore
	@QueryParameter(value = "forcerm", defaultValue = "false")
	private Boolean forcerm;

	@JsonIgnore
	@QueryParameter(value = "rm", defaultValue = "true")
	private Boolean rm;

	@JsonIgnore
	@QueryParameter("pull")
	private String pull;

	@JsonIgnore
	@QueryParameter("cachefrom")
	private String cachefrom;

	@JsonIgnore
	@QueryParameter(value = "nocache", defaultValue = "false")
	private Boolean nocache;

	@JsonIgnore
	@QueryParameter(value = "q", defaultValue = "false")
	private Boolean q;

	@JsonIgnore
	@QueryParameter("remote")
	private String remote;

	@JsonIgnore
	@QueryParameter("t")
	private String t;

	@JsonIgnore
	@QueryParameter(value = "dockerfile", defaultValue = "Dockerfile")
	private String dockerfile;

}
