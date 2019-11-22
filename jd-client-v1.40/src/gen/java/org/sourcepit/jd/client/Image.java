package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Image {
	@Data
	@JsonInclude(Include.NON_NULL)
	public static class RootFS {
		@JsonProperty("Type")
		private String type;

		@JsonProperty("Layers")
		private List<String> layers;

		@JsonProperty("BaseLayer")
		private String baseLayer;

	}

	@Data
	@JsonInclude(Include.NON_NULL)
	public static class Metadata {
		@JsonProperty("LastTagTime")
		private String lastTagTime;

	}

	@JsonProperty("Id")
	private String id;

	@JsonProperty("RepoTags")
	private List<String> repoTags;

	@JsonProperty("RepoDigests")
	private List<String> repoDigests;

	@JsonProperty("Parent")
	private String parent;

	@JsonProperty("Comment")
	private String comment;

	@JsonProperty("Created")
	private String created;

	@JsonProperty("Container")
	private String container;

	@JsonProperty("ContainerConfig")
	private ContainerConfig containerConfig;

	@JsonProperty("DockerVersion")
	private String dockerVersion;

	@JsonProperty("Author")
	private String author;

	@JsonProperty("Config")
	private ContainerConfig config;

	@JsonProperty("Architecture")
	private String architecture;

	@JsonProperty("Os")
	private String os;

	@JsonProperty("OsVersion")
	private String osVersion;

	@JsonProperty("Size")
	private Long size;

	@JsonProperty("VirtualSize")
	private Long virtualSize;

	@JsonProperty("GraphDriver")
	private GraphDriverData graphDriver;

	@JsonProperty("RootFS")
	private RootFS rootFS;

	@JsonProperty("Metadata")
	private Metadata metadata;

}
