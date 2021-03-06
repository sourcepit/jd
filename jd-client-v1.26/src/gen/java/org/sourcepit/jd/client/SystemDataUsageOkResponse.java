package org.sourcepit.jd.client;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SystemDataUsageOkResponse {
	@JsonProperty("LayersSize")
	private Long layersSize;

	@JsonProperty("Images")
	private List<ImageSummary> images;

	@JsonProperty("Containers")
	private List<List<ContainerSummary>> containers;

	@JsonProperty("Volumes")
	private List<Volume> volumes;

}
