package org.sourcepit.jd.client;

import java.util.ArrayList;

import org.sourcepit.jd.client.core.annotation.PathParameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(Include.NON_NULL)
public class PluginSetRequest extends ArrayList<String> {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@PathParameter("name")
	private String name;

}
