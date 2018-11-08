
package org.sourcepit.jd.client;

import java.io.IOException;

import org.sourcepit.jd.client.error.BadParameterException;
import org.sourcepit.jd.client.error.ConflictException;
import org.sourcepit.jd.client.error.ImpossibleToAttachException;
import org.sourcepit.jd.client.error.NoSuchContainerException;
import org.sourcepit.jd.client.error.ServerErrorException;

public interface DockerClient {
	ContainerListResponse containerList(ContainerListRequest request)
			throws BadParameterException, ServerErrorException, IOException;

	ContainerCreateResponse containerCreate(ContainerCreateRequest request) throws BadParameterException,
			NoSuchContainerException, ImpossibleToAttachException, ConflictException, ServerErrorException, IOException;

	/**
	 * Return low-level information about a container
	 */
	ContainerInspectResponse containerInspect(ContainerInspectRequest request)
			throws NoSuchContainerException, ServerErrorException, IOException;

	SystemVersionResponse systemVersion() throws ServerErrorException, IOException;
}
