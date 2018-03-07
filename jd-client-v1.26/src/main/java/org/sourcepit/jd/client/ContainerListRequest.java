package org.sourcepit.jd.client;

import org.sourcepit.jd.client.core.annotation.QueryParameter;

import lombok.Data;

@Data
public class ContainerListRequest
{
	/**
	 * Return all containers. By default, only running containers are shown
	 * 
	 * @default false
	 */
	@QueryParameter
	private Boolean all;

	/**
	 * Return this number of most recently created containers, including non-running ones.
	 */
	@QueryParameter
	private Integer limit;

	/**
	 * Return the size of container as fields <code>SizeRw</code> and <code>SizeRootFs</code>.
	 * 
	 * @default false
	 */
	@QueryParameter
	private Boolean size;

	/**
	 * Filters to process on the container list, encoded as JSON (a <code>map[string][]string</code>). For example,
	 * <code>{"status": ["paused"]}</code> will only return paused containers. Available filters:
	 * <ul>
	 * <li><code>ancestor</code>=(<code>&lt;image-name&gt;[:<tag>]</code>, <code>&lt;image id&gt;</code>, or
	 * <code>&lt;image@digest&gt;</code>)</li>
	 * <li><code>before</code>=(<code>&lt;container id&gt;</code> or <code>&lt;container name&gt;</code>)</li>
	 * <li><code>exited=&lt;int&gt;</code> containers with exit code of <code>&lt;int&gt;</code></li>
	 * <li><code>health</code>=(<code>starting</code>|<code>healthy</code>|<code>unhealthy</code>|<code>none</code>)</li>
	 * <li><code>id=&lt;ID&gt;</code> a container's ID</li>
	 * <li><code>isolation=</code>(<code>default</code>|<code>process</code>|<code>hyperv</code>) (Windows daemon
	 * only)</li>
	 * <li><code>is-task=</code>(<code>true</code>|<code>false</code>)</li>
	 * <li><code>label=key</code> or <code>label="key=value"</code> of a container label</li>
	 * <li><code>name=&lt;name&gt;</code> a container's name</li>
	 * <li><code>network</code>=(<code>&lt;network id&gt;</code> or <code>&lt;network name&gt;</code>)</li>
	 * <li><code>since</code>=(<code>&lt;container id&gt;</code> or <code>&lt;container name&gt;</code>)</li>
	 * <li><code>status=</code>(<code>created</code>|<code>restarting</code>|<code>running</code>|<code>removing</code>|<code>paused</code>|<code>exited</code>|<code>dead</code>)</li>
	 * <li><code>volume</code>=(<code>&lt;volume name&gt;</code> or <code>&lt;mount point destination&gt;</code>)</li>
	 * </ul>
	 */
	@QueryParameter
	private String filters;

}
