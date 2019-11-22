package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;
import org.sourcepit.jd.client.core.annotation.PathParameter;

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
	@PathParameter("networkmode")
	private String networkmode;

	@JsonIgnore
	@PathParameter("labels")
	private String labels;

	@JsonIgnore
	@PathParameter("squash")
	private Boolean squash;

	@JsonIgnore
	@PathParameter("shmsize")
	private Long shmsize;

	@JsonIgnore
	@PathParameter("buildargs")
	private Long buildargs;

	@JsonIgnore
	@PathParameter("cpuquota")
	private Long cpuquota;

	@JsonIgnore
	@PathParameter("cpuperiod")
	private Long cpuperiod;

	@JsonIgnore
	@PathParameter("cpusetcpus")
	private String cpusetcpus;

	@JsonIgnore
	@PathParameter("cpushares")
	private Long cpushares;

	@JsonIgnore
	@PathParameter("memswap")
	private Long memswap;

	@JsonIgnore
	@PathParameter("memory")
	private Long memory;

	@JsonIgnore
	@PathParameter(value = "forcerm", defaultValue = "false")
	private Boolean forcerm;

	@JsonIgnore
	@PathParameter(value = "rm", defaultValue = "true")
	private Boolean rm;

	@JsonIgnore
	@PathParameter("pull")
	private String pull;

	@JsonIgnore
	@PathParameter("cachefrom")
	private String cachefrom;

	@JsonIgnore
	@PathParameter(value = "nocache", defaultValue = "false")
	private Boolean nocache;

	@JsonIgnore
	@PathParameter(value = "q", defaultValue = "false")
	private Boolean q;

	@JsonIgnore
	@PathParameter("remote")
	private String remote;

	@JsonIgnore
	@PathParameter("t")
	private String t;

	@JsonIgnore
	@PathParameter(value = "dockerfile", defaultValue = "Dockerfile")
	private String dockerfile;

}
