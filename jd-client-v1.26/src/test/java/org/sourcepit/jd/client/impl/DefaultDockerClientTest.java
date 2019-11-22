package org.sourcepit.jd.client.impl;

import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sourcepit.jd.client.ContainerCreateCreatedResponse;
import org.sourcepit.jd.client.ContainerCreateRequest;
import org.sourcepit.jd.client.ContainerInspectRequest;
import org.sourcepit.jd.client.ContainerInspectResponse;
import org.sourcepit.jd.client.ContainerListRequest;
import org.sourcepit.jd.client.ContainerListResponse;
import org.sourcepit.jd.client.DockerClient;
import org.sourcepit.jd.client.DockerClientImpl;
import org.sourcepit.jd.client.SystemVersionOkResponse;

public class DefaultDockerClientTest {
	private final static URI DOCKER_HOST_URI;
	static {
		try {
			DOCKER_HOST_URI = new URI("http://127.0.0.1:2375");
		} catch (URISyntaxException e) {
			throw new IllegalStateException(e);
		}
	}

	private CloseableHttpClient httpClient;

	private DockerClient dockerClient;

	@Before
	public void setUp() {
		httpClient = HttpClients.createDefault();
		dockerClient = new DockerClientImpl(httpClient, DOCKER_HOST_URI);
	}

	@After
	public void tearDown() throws Exception {
		httpClient.close();
	}

	@Test
	public void testSystemVersion() throws Exception {
		SystemVersionOkResponse response = dockerClient.systemVersion().unwrap();
		assertNotNull(response.getApiVersion());
		assertNotNull(response.getVersion());
	}

	@Test
	public void testContainerList() throws Exception {
		ContainerListRequest request = new ContainerListRequest();
		request.setAll(true);
		request.setLimit(Long.valueOf(10));

		ContainerListResponse response = dockerClient.containerList(request);
		assertNotNull(response);
	}

	@Test
	public void testContainerCreate() throws Exception {
		ContainerCreateRequest request = new ContainerCreateRequest();
		request.setImage("mongo:3.6");

		ContainerCreateCreatedResponse response = dockerClient.containerCreate(request).unwrap();
		assertNotNull(response);
	}

	@Test
	public void testContainerInspect() throws Exception {
		ContainerInspectRequest request = new ContainerInspectRequest();
		request.setId("hans");
		request.setSize(true);

		ContainerInspectResponse response = dockerClient.containerInspect(request);
		assertNotNull(response);
	}
}
