package org.sourcepit.jd.client.impl;

import static org.junit.Assert.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sourcepit.jd.client.ContainerListRequest;
import org.sourcepit.jd.client.ContainerListResponse;
import org.sourcepit.jd.client.DockerClient;
import org.sourcepit.jd.client.SystemVersionResponse;

public class DefaultDockerClientTest
{
	private final static URI DOCKER_HOST_URI;
	static
	{
		try
		{
			DOCKER_HOST_URI = new URI("http://192.168.56.31:2375");
		}
		catch (URISyntaxException e)
		{
			throw new IllegalStateException(e);
		}
	}

	private CloseableHttpClient httpClient;

	private DockerClient dockerClient;

	@Before
	public void setUp()
	{
		httpClient = HttpClients.createDefault();
		dockerClient = new DefaultDockerClient(httpClient, DOCKER_HOST_URI);
	}

	@After
	public void tearDown() throws Exception
	{
		httpClient.close();
	}

	@Test
	public void testContainerList() throws Exception
	{
		ContainerListRequest request = new ContainerListRequest();
		request.setAll(true);
		request.setLimit(10);

		ContainerListResponse response = dockerClient.containerList(request);
		assertNotNull(response);
	}

	@Test
	public void test() throws Exception
	{
		SystemVersionResponse response = dockerClient.systemVersion();
		assertNotNull(response);
	}

}
