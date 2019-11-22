package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class ImageCommitRequest extends Config {
	@JsonIgnore
	@PathParameter("changes")
	private String changes;

	@JsonIgnore
	@PathParameter(value = "pause", defaultValue = "true")
	private Boolean pause;

	@JsonIgnore
	@PathParameter("author")
	private String author;

	@JsonIgnore
	@PathParameter("comment")
	private String comment;

	@JsonIgnore
	@PathParameter("tag")
	private String tag;

	@JsonIgnore
	@PathParameter("repo")
	private String repo;

	@JsonIgnore
	@PathParameter("container")
	private String container;

}
