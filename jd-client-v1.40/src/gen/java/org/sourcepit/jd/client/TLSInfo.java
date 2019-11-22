package org.sourcepit.jd.client;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class TLSInfo {
	@JsonProperty("TrustRoot")
	private String trustRoot;

	@JsonProperty("CertIssuerSubject")
	private String certIssuerSubject;

	@JsonProperty("CertIssuerPublicKey")
	private String certIssuerPublicKey;

}
