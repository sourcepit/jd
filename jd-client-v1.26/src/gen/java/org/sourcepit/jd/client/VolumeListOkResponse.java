package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class VolumeListOkResponse {
	@JsonProperty("Volumes")
	private List<Volume> volumes;

	@JsonProperty("Warnings")
	private List<String> warnings;

}
