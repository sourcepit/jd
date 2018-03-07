package org.sourcepit.jd.client.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.sourcepit.jd.client.DockerClient;
import org.sourcepit.jd.client.SystemVersionResponse;
import org.sourcepit.jd.client.error.ServerErrorException;
import org.sourcepit.jd.client.impl.JdResponseHandler.ErrorResponseHandler;
import org.sourcepit.jd.client.model.ErrorResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultDockerClient implements DockerClient
{
	private static final String API_VERSION = "v1.26";

	private static final String[] PATH_SYSTEM_VERSION = { "version" };

	private final HttpClient httpClient;

	private final URI dockerHostUri;

	private final ObjectMapper objectMapper;

	public DefaultDockerClient(HttpClient httpClient, URI dockerHostUri)
	{
		this.httpClient = httpClient;

		this.dockerHostUri = dockerHostUri;

		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.objectMapper = objectMapper;
	}

	@Override
	public SystemVersionResponse systemVersion() throws ServerErrorException, IOException
	{
		final HttpGet request = new HttpGet(genUri(PATH_SYSTEM_VERSION));
		final Class<SystemVersionResponse> responseType = SystemVersionResponse.class;
		final ErrorResponseHandler errorHandler = new ErrorResponseHandler()
		{
			@Override
			public void handleErrorResponse(int statusCode, ErrorResponse errorResponse)
					throws ClientProtocolException, IOException
			{
				if (statusCode == 500)
				{
					throw new ServerErrorException(errorResponse);
				}
			}
		};
		return httpClient.execute(request, new JdResponseHandler<>(objectMapper, responseType, errorHandler));
	}

	private URI genUri(String[] segments)
	{
		final URIBuilder uriBuilder = new URIBuilder(dockerHostUri);
		uriBuilder.setPath(genPath(segments));
		try
		{
			return uriBuilder.build();
		}
		catch (URISyntaxException e)
		{
			throw new IllegalStateException(e);
		}
	}

	private static String genPath(String[] segments)
	{
		final StringBuilder pathBuilder = new StringBuilder();
		pathBuilder.append('/');
		pathBuilder.append(API_VERSION);

		for (String segment : segments)
		{
			pathBuilder.append('/');
			pathBuilder.append(segment);
		}

		return pathBuilder.toString();
	}

}
