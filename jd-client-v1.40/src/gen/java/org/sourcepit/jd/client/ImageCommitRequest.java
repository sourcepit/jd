package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class ImageCommitRequest extends ContainerConfig {
	@JsonIgnore
	@QueryParameter("changes")
	private String changes;

	@JsonIgnore
	@QueryParameter(value = "pause", defaultValue = "true")
	private Boolean pause;

	@JsonIgnore
	@QueryParameter("author")
	private String author;

	@JsonIgnore
	@QueryParameter("comment")
	private String comment;

	@JsonIgnore
	@QueryParameter("tag")
	private String tag;

	@JsonIgnore
	@QueryParameter("repo")
	private String repo;

	@JsonIgnore
	@QueryParameter("container")
	private String container;

}
