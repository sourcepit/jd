package org.sourcepit.jd.client;

import java.util.ArrayList;

import org.sourcepit.jd.client.core.annotation.HeaderParameter;
import org.sourcepit.jd.client.core.annotation.QueryParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class PluginPullRequest extends ArrayList<PluginPullRequestItem> {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@HeaderParameter("X-Registry-Auth")
	private String xRegistryAuth;

	@JsonIgnore
	@QueryParameter("name")
	private String name;

	@JsonIgnore
	@QueryParameter("remote")
	private String remote;

}
