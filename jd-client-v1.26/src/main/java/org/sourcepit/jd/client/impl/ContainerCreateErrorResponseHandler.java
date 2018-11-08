package org.sourcepit.jd.client.impl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.sourcepit.jd.client.error.BadParameterException;
import org.sourcepit.jd.client.error.ConflictException;
import org.sourcepit.jd.client.error.ImpossibleToAttachException;
import org.sourcepit.jd.client.error.NoSuchContainerException;
import org.sourcepit.jd.client.error.ServerErrorException;
import org.sourcepit.jd.client.impl.JdResponseHandler.ErrorResponseHandler;
import org.sourcepit.jd.client.model.ErrorResponse;

public class ContainerCreateErrorResponseHandler implements ErrorResponseHandler {
	@Override
	public void handleErrorResponse(int statusCode, ErrorResponse errorResponse)
			throws ClientProtocolException, IOException {
		switch (statusCode) {
		case 400:
			throw new BadParameterException(errorResponse);
		case 404:
			throw new NoSuchContainerException(errorResponse);
		case 406:
			throw new ImpossibleToAttachException(errorResponse);
		case 409:
			throw new ConflictException(errorResponse);
		case 500:
			throw new ServerErrorException(errorResponse);
		default:
			break;
		}
	}
}