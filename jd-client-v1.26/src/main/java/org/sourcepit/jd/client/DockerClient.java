package org.sourcepit.jd.client;

import java.io.IOException;

import org.sourcepit.jd.client.error.ServerErrorException;

public interface DockerClient
{
	SystemVersionResponse systemVersion() throws ServerErrorException, IOException;
}
