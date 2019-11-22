package org.sourcepit.jd.client;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class RegistryServiceConfig {
	@JsonProperty("AllowNondistributableArtifactsCIDRs")
	private List<String> allowNondistributableArtifactsCIDRs;

	@JsonProperty("AllowNondistributableArtifactsHostnames")
	private List<String> allowNondistributableArtifactsHostnames;

	@JsonProperty("InsecureRegistryCIDRs")
	private List<String> insecureRegistryCIDRs;

	@JsonProperty("IndexConfigs")
	private Map<IndexInfo, IndexInfo> indexConfigs;

	@JsonProperty("Mirrors")
	private List<String> mirrors;

}
