package org.sourcepit.jd.client;

import java.io.IOException;

import org.sourcepit.jd.client.error.BadParameterException;
import org.sourcepit.jd.client.error.ServerErrorException;

public interface DockerClient
{
	ContainerListResponse containerList(ContainerListRequest request)
			throws BadParameterException, ServerErrorException, IOException;

	SystemVersionResponse systemVersion() throws ServerErrorException, IOException;
}
