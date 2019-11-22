package org.sourcepit.jd.client;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.sourcepit.jd.client.core.AbstractJacksonHttpClient;
import org.sourcepit.jd.client.core.HttpMethod;

public class DockerClientImpl extends AbstractJacksonHttpClient implements DockerClient {
	private static final String[] PATH_V140_CONTAINERS_JSON = { "v1.40", "containers", "json" };
	private static final String[] PATH_V140_CONTAINERS_CREATE = { "v1.40", "containers", "create" };
	private static final String[] PATH_V140_CONTAINERS_ID_JSON = { "v1.40", "containers", "{id}", "json" };
	private static final String[] PATH_V140_CONTAINERS_ID_TOP = { "v1.40", "containers", "{id}", "top" };
	private static final String[] PATH_V140_CONTAINERS_ID_LOGS = { "v1.40", "containers", "{id}", "logs" };
	private static final String[] PATH_V140_CONTAINERS_ID_CHANGES = { "v1.40", "containers", "{id}", "changes" };
	private static final String[] PATH_V140_CONTAINERS_ID_EXPORT = { "v1.40", "containers", "{id}", "export" };
	private static final String[] PATH_V140_CONTAINERS_ID_STATS = { "v1.40", "containers", "{id}", "stats" };
	private static final String[] PATH_V140_CONTAINERS_ID_RESIZE = { "v1.40", "containers", "{id}", "resize" };
	private static final String[] PATH_V140_CONTAINERS_ID_START = { "v1.40", "containers", "{id}", "start" };
	private static final String[] PATH_V140_CONTAINERS_ID_STOP = { "v1.40", "containers", "{id}", "stop" };
	private static final String[] PATH_V140_CONTAINERS_ID_RESTART = { "v1.40", "containers", "{id}", "restart" };
	private static final String[] PATH_V140_CONTAINERS_ID_KILL = { "v1.40", "containers", "{id}", "kill" };
	private static final String[] PATH_V140_CONTAINERS_ID_UPDATE = { "v1.40", "containers", "{id}", "update" };
	private static final String[] PATH_V140_CONTAINERS_ID_RENAME = { "v1.40", "containers", "{id}", "rename" };
	private static final String[] PATH_V140_CONTAINERS_ID_PAUSE = { "v1.40", "containers", "{id}", "pause" };
	private static final String[] PATH_V140_CONTAINERS_ID_UNPAUSE = { "v1.40", "containers", "{id}", "unpause" };
	private static final String[] PATH_V140_CONTAINERS_ID_ATTACH = { "v1.40", "containers", "{id}", "attach" };
	private static final String[] PATH_V140_CONTAINERS_ID_ATTACH_WS = { "v1.40", "containers", "{id}", "attach", "ws" };
	private static final String[] PATH_V140_CONTAINERS_ID_WAIT = { "v1.40", "containers", "{id}", "wait" };
	private static final String[] PATH_V140_CONTAINERS_ID = { "v1.40", "containers", "{id}" };
	private static final String[] PATH_V140_CONTAINERS_ID_ARCHIVE = { "v1.40", "containers", "{id}", "archive" };
	private static final String[] PATH_V140_CONTAINERS_PRUNE = { "v1.40", "containers", "prune" };
	private static final String[] PATH_V140_IMAGES_JSON = { "v1.40", "images", "json" };
	private static final String[] PATH_V140_BUILD = { "v1.40", "build" };
	private static final String[] PATH_V140_BUILD_PRUNE = { "v1.40", "build", "prune" };
	private static final String[] PATH_V140_IMAGES_CREATE = { "v1.40", "images", "create" };
	private static final String[] PATH_V140_IMAGES_NAME_JSON = { "v1.40", "images", "{name}", "json" };
	private static final String[] PATH_V140_IMAGES_NAME_HISTORY = { "v1.40", "images", "{name}", "history" };
	private static final String[] PATH_V140_IMAGES_NAME_PUSH = { "v1.40", "images", "{name}", "push" };
	private static final String[] PATH_V140_IMAGES_NAME_TAG = { "v1.40", "images", "{name}", "tag" };
	private static final String[] PATH_V140_IMAGES_NAME = { "v1.40", "images", "{name}" };
	private static final String[] PATH_V140_IMAGES_SEARCH = { "v1.40", "images", "search" };
	private static final String[] PATH_V140_IMAGES_PRUNE = { "v1.40", "images", "prune" };
	private static final String[] PATH_V140_AUTH = { "v1.40", "auth" };
	private static final String[] PATH_V140_INFO = { "v1.40", "info" };
	private static final String[] PATH_V140_VERSION = { "v1.40", "version" };
	private static final String[] PATH_V140__PING = { "v1.40", "_ping" };
	private static final String[] PATH_V140_COMMIT = { "v1.40", "commit" };
	private static final String[] PATH_V140_EVENTS = { "v1.40", "events" };
	private static final String[] PATH_V140_SYSTEM_DF = { "v1.40", "system", "df" };
	private static final String[] PATH_V140_IMAGES_NAME_GET = { "v1.40", "images", "{name}", "get" };
	private static final String[] PATH_V140_IMAGES_GET = { "v1.40", "images", "get" };
	private static final String[] PATH_V140_IMAGES_LOAD = { "v1.40", "images", "load" };
	private static final String[] PATH_V140_CONTAINERS_ID_EXEC = { "v1.40", "containers", "{id}", "exec" };
	private static final String[] PATH_V140_EXEC_ID_START = { "v1.40", "exec", "{id}", "start" };
	private static final String[] PATH_V140_EXEC_ID_RESIZE = { "v1.40", "exec", "{id}", "resize" };
	private static final String[] PATH_V140_EXEC_ID_JSON = { "v1.40", "exec", "{id}", "json" };
	private static final String[] PATH_V140_VOLUMES = { "v1.40", "volumes" };
	private static final String[] PATH_V140_VOLUMES_CREATE = { "v1.40", "volumes", "create" };
	private static final String[] PATH_V140_VOLUMES_NAME = { "v1.40", "volumes", "{name}" };
	private static final String[] PATH_V140_VOLUMES_PRUNE = { "v1.40", "volumes", "prune" };
	private static final String[] PATH_V140_NETWORKS = { "v1.40", "networks" };
	private static final String[] PATH_V140_NETWORKS_ID = { "v1.40", "networks", "{id}" };
	private static final String[] PATH_V140_NETWORKS_CREATE = { "v1.40", "networks", "create" };
	private static final String[] PATH_V140_NETWORKS_ID_CONNECT = { "v1.40", "networks", "{id}", "connect" };
	private static final String[] PATH_V140_NETWORKS_ID_DISCONNECT = { "v1.40", "networks", "{id}", "disconnect" };
	private static final String[] PATH_V140_NETWORKS_PRUNE = { "v1.40", "networks", "prune" };
	private static final String[] PATH_V140_PLUGINS = { "v1.40", "plugins" };
	private static final String[] PATH_V140_PLUGINS_PRIVILEGES = { "v1.40", "plugins", "privileges" };
	private static final String[] PATH_V140_PLUGINS_PULL = { "v1.40", "plugins", "pull" };
	private static final String[] PATH_V140_PLUGINS_NAME_JSON = { "v1.40", "plugins", "{name}", "json" };
	private static final String[] PATH_V140_PLUGINS_NAME = { "v1.40", "plugins", "{name}" };
	private static final String[] PATH_V140_PLUGINS_NAME_ENABLE = { "v1.40", "plugins", "{name}", "enable" };
	private static final String[] PATH_V140_PLUGINS_NAME_DISABLE = { "v1.40", "plugins", "{name}", "disable" };
	private static final String[] PATH_V140_PLUGINS_NAME_UPGRADE = { "v1.40", "plugins", "{name}", "upgrade" };
	private static final String[] PATH_V140_PLUGINS_CREATE = { "v1.40", "plugins", "create" };
	private static final String[] PATH_V140_PLUGINS_NAME_PUSH = { "v1.40", "plugins", "{name}", "push" };
	private static final String[] PATH_V140_PLUGINS_NAME_SET = { "v1.40", "plugins", "{name}", "set" };
	private static final String[] PATH_V140_NODES = { "v1.40", "nodes" };
	private static final String[] PATH_V140_NODES_ID = { "v1.40", "nodes", "{id}" };
	private static final String[] PATH_V140_NODES_ID_UPDATE = { "v1.40", "nodes", "{id}", "update" };
	private static final String[] PATH_V140_SWARM = { "v1.40", "swarm" };
	private static final String[] PATH_V140_SWARM_INIT = { "v1.40", "swarm", "init" };
	private static final String[] PATH_V140_SWARM_JOIN = { "v1.40", "swarm", "join" };
	private static final String[] PATH_V140_SWARM_LEAVE = { "v1.40", "swarm", "leave" };
	private static final String[] PATH_V140_SWARM_UPDATE = { "v1.40", "swarm", "update" };
	private static final String[] PATH_V140_SWARM_UNLOCKKEY = { "v1.40", "swarm", "unlockkey" };
	private static final String[] PATH_V140_SWARM_UNLOCK = { "v1.40", "swarm", "unlock" };
	private static final String[] PATH_V140_SERVICES = { "v1.40", "services" };
	private static final String[] PATH_V140_SERVICES_CREATE = { "v1.40", "services", "create" };
	private static final String[] PATH_V140_SERVICES_ID = { "v1.40", "services", "{id}" };
	private static final String[] PATH_V140_SERVICES_ID_UPDATE = { "v1.40", "services", "{id}", "update" };
	private static final String[] PATH_V140_SERVICES_ID_LOGS = { "v1.40", "services", "{id}", "logs" };
	private static final String[] PATH_V140_TASKS = { "v1.40", "tasks" };
	private static final String[] PATH_V140_TASKS_ID = { "v1.40", "tasks", "{id}" };
	private static final String[] PATH_V140_TASKS_ID_LOGS = { "v1.40", "tasks", "{id}", "logs" };
	private static final String[] PATH_V140_SECRETS = { "v1.40", "secrets" };
	private static final String[] PATH_V140_SECRETS_CREATE = { "v1.40", "secrets", "create" };
	private static final String[] PATH_V140_SECRETS_ID = { "v1.40", "secrets", "{id}" };
	private static final String[] PATH_V140_SECRETS_ID_UPDATE = { "v1.40", "secrets", "{id}", "update" };
	private static final String[] PATH_V140_CONFIGS = { "v1.40", "configs" };
	private static final String[] PATH_V140_CONFIGS_CREATE = { "v1.40", "configs", "create" };
	private static final String[] PATH_V140_CONFIGS_ID = { "v1.40", "configs", "{id}" };
	private static final String[] PATH_V140_CONFIGS_ID_UPDATE = { "v1.40", "configs", "{id}", "update" };
	private static final String[] PATH_V140_DISTRIBUTION_NAME_JSON = { "v1.40", "distribution", "{name}", "json" };
	private static final String[] PATH_V140_SESSION = { "v1.40", "session" };

	public DockerClientImpl(HttpClient httpClient, URI uri) {
		super(httpClient, uri);
	}

	@Override
	public ContainerListResponse containerList(ContainerListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_JSON, request);
		return new ContainerListResponse(objectMapper, response);
	}

	@Override
	public ContainerCreateResponse containerCreate(ContainerCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_CREATE, request);
		return new ContainerCreateResponse(objectMapper, response);
	}

	@Override
	public ContainerInspectResponse containerInspect(ContainerInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_JSON, request);
		return new ContainerInspectResponse(objectMapper, response);
	}

	@Override
	public ContainerTopResponse containerTop(ContainerTopRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_TOP, request);
		return new ContainerTopResponse(objectMapper, response);
	}

	@Override
	public ContainerLogsResponse containerLogs(ContainerLogsRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_LOGS, request);
		return new ContainerLogsResponse(objectMapper, response);
	}

	@Override
	public ContainerChangesResponse containerChanges(ContainerChangesRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_CHANGES, request);
		return new ContainerChangesResponse(objectMapper, response);
	}

	@Override
	public ContainerExportResponse containerExport(ContainerExportRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_EXPORT, request);
		return new ContainerExportResponse(objectMapper, response);
	}

	@Override
	public ContainerStatsResponse containerStats(ContainerStatsRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_STATS, request);
		return new ContainerStatsResponse(objectMapper, response);
	}

	@Override
	public ContainerResizeResponse containerResize(ContainerResizeRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_RESIZE, request);
		return new ContainerResizeResponse(objectMapper, response);
	}

	@Override
	public ContainerStartResponse containerStart(ContainerStartRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_START, request);
		return new ContainerStartResponse(objectMapper, response);
	}

	@Override
	public ContainerStopResponse containerStop(ContainerStopRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_STOP, request);
		return new ContainerStopResponse(objectMapper, response);
	}

	@Override
	public ContainerRestartResponse containerRestart(ContainerRestartRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_RESTART, request);
		return new ContainerRestartResponse(objectMapper, response);
	}

	@Override
	public ContainerKillResponse containerKill(ContainerKillRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_KILL, request);
		return new ContainerKillResponse(objectMapper, response);
	}

	@Override
	public ContainerUpdateResponse containerUpdate(ContainerUpdateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_UPDATE, request);
		return new ContainerUpdateResponse(objectMapper, response);
	}

	@Override
	public ContainerRenameResponse containerRename(ContainerRenameRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_RENAME, request);
		return new ContainerRenameResponse(objectMapper, response);
	}

	@Override
	public ContainerPauseResponse containerPause(ContainerPauseRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_PAUSE, request);
		return new ContainerPauseResponse(objectMapper, response);
	}

	@Override
	public ContainerUnpauseResponse containerUnpause(ContainerUnpauseRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_UNPAUSE, request);
		return new ContainerUnpauseResponse(objectMapper, response);
	}

	@Override
	public ContainerAttachResponse containerAttach(ContainerAttachRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_ATTACH, request);
		return new ContainerAttachResponse(objectMapper, response);
	}

	@Override
	public ContainerAttachWebsocketResponse containerAttachWebsocket(ContainerAttachWebsocketRequest request)
			throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_ATTACH_WS, request);
		return new ContainerAttachWebsocketResponse(objectMapper, response);
	}

	@Override
	public ContainerWaitResponse containerWait(ContainerWaitRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_WAIT, request);
		return new ContainerWaitResponse(objectMapper, response);
	}

	@Override
	public ContainerDeleteResponse containerDelete(ContainerDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_CONTAINERS_ID, request);
		return new ContainerDeleteResponse(objectMapper, response);
	}

	@Override
	public ContainerArchiveResponse containerArchive(ContainerArchiveRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONTAINERS_ID_ARCHIVE, request);
		return new ContainerArchiveResponse(objectMapper, response);
	}

	@Override
	public PutContainerArchiveResponse putContainerArchive(PutContainerArchiveRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.PUT, PATH_V140_CONTAINERS_ID_ARCHIVE, request);
		return new PutContainerArchiveResponse(objectMapper, response);
	}

	@Override
	public ContainerArchiveInfoResponse containerArchiveInfo(ContainerArchiveInfoRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.HEAD, PATH_V140_CONTAINERS_ID_ARCHIVE, request);
		return new ContainerArchiveInfoResponse(objectMapper, response);
	}

	@Override
	public ContainerPruneResponse containerPrune(ContainerPruneRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_PRUNE, request);
		return new ContainerPruneResponse(objectMapper, response);
	}

	@Override
	public ImageListResponse imageList(ImageListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_IMAGES_JSON, request);
		return new ImageListResponse(objectMapper, response);
	}

	@Override
	public ImageBuildResponse imageBuild(ImageBuildRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_BUILD, request);
		return new ImageBuildResponse(objectMapper, response);
	}

	@Override
	public BuildPruneResponse buildPrune(BuildPruneRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_BUILD_PRUNE, request);
		return new BuildPruneResponse(objectMapper, response);
	}

	@Override
	public ImageCreateResponse imageCreate(ImageCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_IMAGES_CREATE, request);
		return new ImageCreateResponse(objectMapper, response);
	}

	@Override
	public ImageInspectResponse imageInspect(ImageInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_IMAGES_NAME_JSON, request);
		return new ImageInspectResponse(objectMapper, response);
	}

	@Override
	public ImageHistoryResponse imageHistory(ImageHistoryRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_IMAGES_NAME_HISTORY, request);
		return new ImageHistoryResponse(objectMapper, response);
	}

	@Override
	public ImagePushResponse imagePush(ImagePushRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_IMAGES_NAME_PUSH, request);
		return new ImagePushResponse(objectMapper, response);
	}

	@Override
	public ImageTagResponse imageTag(ImageTagRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_IMAGES_NAME_TAG, request);
		return new ImageTagResponse(objectMapper, response);
	}

	@Override
	public ImageDeleteResponse imageDelete(ImageDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_IMAGES_NAME, request);
		return new ImageDeleteResponse(objectMapper, response);
	}

	@Override
	public ImageSearchResponse imageSearch(ImageSearchRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_IMAGES_SEARCH, request);
		return new ImageSearchResponse(objectMapper, response);
	}

	@Override
	public ImagePruneResponse imagePrune(ImagePruneRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_IMAGES_PRUNE, request);
		return new ImagePruneResponse(objectMapper, response);
	}

	@Override
	public SystemAuthResponse systemAuth(AuthConfig request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_AUTH, request);
		return new SystemAuthResponse(objectMapper, response);
	}

	@Override
	public SystemInfoResponse systemInfo() throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_INFO, null);
		return new SystemInfoResponse(objectMapper, response);
	}

	@Override
	public SystemVersionResponse systemVersion() throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_VERSION, null);
		return new SystemVersionResponse(objectMapper, response);
	}

	@Override
	public SystemPingResponse systemPing() throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140__PING, null);
		return new SystemPingResponse(objectMapper, response);
	}

	@Override
	public SystemPingHeadResponse systemPingHead() throws IOException {
		final HttpResponse response = execute(HttpMethod.HEAD, PATH_V140__PING, null);
		return new SystemPingHeadResponse(objectMapper, response);
	}

	@Override
	public ImageCommitResponse imageCommit(ImageCommitRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_COMMIT, request);
		return new ImageCommitResponse(objectMapper, response);
	}

	@Override
	public SystemEventsResponse systemEvents(SystemEventsRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_EVENTS, request);
		return new SystemEventsResponse(objectMapper, response);
	}

	@Override
	public SystemDataUsageResponse systemDataUsage() throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SYSTEM_DF, null);
		return new SystemDataUsageResponse(objectMapper, response);
	}

	@Override
	public ImageGetResponse imageGet(ImageGetRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_IMAGES_NAME_GET, request);
		return new ImageGetResponse(objectMapper, response);
	}

	@Override
	public ImageGetAllResponse imageGetAll(ImageGetAllRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_IMAGES_GET, request);
		return new ImageGetAllResponse(objectMapper, response);
	}

	@Override
	public ImageLoadResponse imageLoad(ImageLoadRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_IMAGES_LOAD, request);
		return new ImageLoadResponse(objectMapper, response);
	}

	@Override
	public ContainerExecResponse containerExec(ContainerExecRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONTAINERS_ID_EXEC, request);
		return new ContainerExecResponse(objectMapper, response);
	}

	@Override
	public ExecStartResponse execStart(ExecStartRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_EXEC_ID_START, request);
		return new ExecStartResponse(objectMapper, response);
	}

	@Override
	public ExecResizeResponse execResize(ExecResizeRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_EXEC_ID_RESIZE, request);
		return new ExecResizeResponse(objectMapper, response);
	}

	@Override
	public ExecInspectResponse execInspect(ExecInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_EXEC_ID_JSON, request);
		return new ExecInspectResponse(objectMapper, response);
	}

	@Override
	public VolumeListResponse volumeList(VolumeListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_VOLUMES, request);
		return new VolumeListResponse(objectMapper, response);
	}

	@Override
	public VolumeCreateResponse volumeCreate(VolumeCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_VOLUMES_CREATE, request);
		return new VolumeCreateResponse(objectMapper, response);
	}

	@Override
	public VolumeInspectResponse volumeInspect(VolumeInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_VOLUMES_NAME, request);
		return new VolumeInspectResponse(objectMapper, response);
	}

	@Override
	public VolumeDeleteResponse volumeDelete(VolumeDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_VOLUMES_NAME, request);
		return new VolumeDeleteResponse(objectMapper, response);
	}

	@Override
	public VolumePruneResponse volumePrune(VolumePruneRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_VOLUMES_PRUNE, request);
		return new VolumePruneResponse(objectMapper, response);
	}

	@Override
	public NetworkListResponse networkList(NetworkListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_NETWORKS, request);
		return new NetworkListResponse(objectMapper, response);
	}

	@Override
	public NetworkInspectResponse networkInspect(NetworkInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_NETWORKS_ID, request);
		return new NetworkInspectResponse(objectMapper, response);
	}

	@Override
	public NetworkDeleteResponse networkDelete(NetworkDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_NETWORKS_ID, request);
		return new NetworkDeleteResponse(objectMapper, response);
	}

	@Override
	public NetworkCreateResponse networkCreate(NetworkCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_NETWORKS_CREATE, request);
		return new NetworkCreateResponse(objectMapper, response);
	}

	@Override
	public NetworkConnectResponse networkConnect(NetworkConnectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_NETWORKS_ID_CONNECT, request);
		return new NetworkConnectResponse(objectMapper, response);
	}

	@Override
	public NetworkDisconnectResponse networkDisconnect(NetworkDisconnectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_NETWORKS_ID_DISCONNECT, request);
		return new NetworkDisconnectResponse(objectMapper, response);
	}

	@Override
	public NetworkPruneResponse networkPrune(NetworkPruneRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_NETWORKS_PRUNE, request);
		return new NetworkPruneResponse(objectMapper, response);
	}

	@Override
	public PluginListResponse pluginList(PluginListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_PLUGINS, request);
		return new PluginListResponse(objectMapper, response);
	}

	@Override
	public GetPluginPrivilegesResponse getPluginPrivileges(GetPluginPrivilegesRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_PLUGINS_PRIVILEGES, request);
		return new GetPluginPrivilegesResponse(objectMapper, response);
	}

	@Override
	public PluginPullResponse pluginPull(PluginPullRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_PLUGINS_PULL, request);
		return new PluginPullResponse(objectMapper, response);
	}

	@Override
	public PluginInspectResponse pluginInspect(PluginInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_PLUGINS_NAME_JSON, request);
		return new PluginInspectResponse(objectMapper, response);
	}

	@Override
	public PluginDeleteResponse pluginDelete(PluginDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_PLUGINS_NAME, request);
		return new PluginDeleteResponse(objectMapper, response);
	}

	@Override
	public PluginEnableResponse pluginEnable(PluginEnableRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_PLUGINS_NAME_ENABLE, request);
		return new PluginEnableResponse(objectMapper, response);
	}

	@Override
	public PluginDisableResponse pluginDisable(PluginDisableRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_PLUGINS_NAME_DISABLE, request);
		return new PluginDisableResponse(objectMapper, response);
	}

	@Override
	public PluginUpgradeResponse pluginUpgrade(PluginUpgradeRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_PLUGINS_NAME_UPGRADE, request);
		return new PluginUpgradeResponse(objectMapper, response);
	}

	@Override
	public PluginCreateResponse pluginCreate(PluginCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_PLUGINS_CREATE, request);
		return new PluginCreateResponse(objectMapper, response);
	}

	@Override
	public PluginPushResponse pluginPush(PluginPushRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_PLUGINS_NAME_PUSH, request);
		return new PluginPushResponse(objectMapper, response);
	}

	@Override
	public PluginSetResponse pluginSet(PluginSetRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_PLUGINS_NAME_SET, request);
		return new PluginSetResponse(objectMapper, response);
	}

	@Override
	public NodeListResponse nodeList(NodeListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_NODES, request);
		return new NodeListResponse(objectMapper, response);
	}

	@Override
	public NodeInspectResponse nodeInspect(NodeInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_NODES_ID, request);
		return new NodeInspectResponse(objectMapper, response);
	}

	@Override
	public NodeDeleteResponse nodeDelete(NodeDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_NODES_ID, request);
		return new NodeDeleteResponse(objectMapper, response);
	}

	@Override
	public NodeUpdateResponse nodeUpdate(NodeUpdateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_NODES_ID_UPDATE, request);
		return new NodeUpdateResponse(objectMapper, response);
	}

	@Override
	public SwarmInspectResponse swarmInspect() throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SWARM, null);
		return new SwarmInspectResponse(objectMapper, response);
	}

	@Override
	public SwarmInitResponse swarmInit(SwarmInitRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SWARM_INIT, request);
		return new SwarmInitResponse(objectMapper, response);
	}

	@Override
	public SwarmJoinResponse swarmJoin(SwarmJoinRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SWARM_JOIN, request);
		return new SwarmJoinResponse(objectMapper, response);
	}

	@Override
	public SwarmLeaveResponse swarmLeave(SwarmLeaveRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SWARM_LEAVE, request);
		return new SwarmLeaveResponse(objectMapper, response);
	}

	@Override
	public SwarmUpdateResponse swarmUpdate(SwarmUpdateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SWARM_UPDATE, request);
		return new SwarmUpdateResponse(objectMapper, response);
	}

	@Override
	public SwarmUnlockkeyResponse swarmUnlockkey() throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SWARM_UNLOCKKEY, null);
		return new SwarmUnlockkeyResponse(objectMapper, response);
	}

	@Override
	public SwarmUnlockResponse swarmUnlock(SwarmUnlockRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SWARM_UNLOCK, request);
		return new SwarmUnlockResponse(objectMapper, response);
	}

	@Override
	public ServiceListResponse serviceList(ServiceListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SERVICES, request);
		return new ServiceListResponse(objectMapper, response);
	}

	@Override
	public ServiceCreateResponse serviceCreate(ServiceCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SERVICES_CREATE, request);
		return new ServiceCreateResponse(objectMapper, response);
	}

	@Override
	public ServiceInspectResponse serviceInspect(ServiceInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SERVICES_ID, request);
		return new ServiceInspectResponse(objectMapper, response);
	}

	@Override
	public ServiceDeleteResponse serviceDelete(ServiceDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_SERVICES_ID, request);
		return new ServiceDeleteResponse(objectMapper, response);
	}

	@Override
	public ServiceUpdateResponse serviceUpdate(ServiceUpdateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SERVICES_ID_UPDATE, request);
		return new ServiceUpdateResponse(objectMapper, response);
	}

	@Override
	public ServiceLogsResponse serviceLogs(ServiceLogsRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SERVICES_ID_LOGS, request);
		return new ServiceLogsResponse(objectMapper, response);
	}

	@Override
	public TaskListResponse taskList(TaskListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_TASKS, request);
		return new TaskListResponse(objectMapper, response);
	}

	@Override
	public TaskInspectResponse taskInspect(TaskInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_TASKS_ID, request);
		return new TaskInspectResponse(objectMapper, response);
	}

	@Override
	public TaskLogsResponse taskLogs(TaskLogsRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_TASKS_ID_LOGS, request);
		return new TaskLogsResponse(objectMapper, response);
	}

	@Override
	public SecretListResponse secretList(SecretListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SECRETS, request);
		return new SecretListResponse(objectMapper, response);
	}

	@Override
	public SecretCreateResponse secretCreate(SecretCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SECRETS_CREATE, request);
		return new SecretCreateResponse(objectMapper, response);
	}

	@Override
	public SecretInspectResponse secretInspect(SecretInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_SECRETS_ID, request);
		return new SecretInspectResponse(objectMapper, response);
	}

	@Override
	public SecretDeleteResponse secretDelete(SecretDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_SECRETS_ID, request);
		return new SecretDeleteResponse(objectMapper, response);
	}

	@Override
	public SecretUpdateResponse secretUpdate(SecretUpdateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SECRETS_ID_UPDATE, request);
		return new SecretUpdateResponse(objectMapper, response);
	}

	@Override
	public ConfigListResponse configList(ConfigListRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONFIGS, request);
		return new ConfigListResponse(objectMapper, response);
	}

	@Override
	public ConfigCreateResponse configCreate(ConfigCreateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONFIGS_CREATE, request);
		return new ConfigCreateResponse(objectMapper, response);
	}

	@Override
	public ConfigInspectResponse configInspect(ConfigInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_CONFIGS_ID, request);
		return new ConfigInspectResponse(objectMapper, response);
	}

	@Override
	public ConfigDeleteResponse configDelete(ConfigDeleteRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.DELETE, PATH_V140_CONFIGS_ID, request);
		return new ConfigDeleteResponse(objectMapper, response);
	}

	@Override
	public ConfigUpdateResponse configUpdate(ConfigUpdateRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_CONFIGS_ID_UPDATE, request);
		return new ConfigUpdateResponse(objectMapper, response);
	}

	@Override
	public DistributionInspectResponse distributionInspect(DistributionInspectRequest request) throws IOException {
		final HttpResponse response = execute(HttpMethod.GET, PATH_V140_DISTRIBUTION_NAME_JSON, request);
		return new DistributionInspectResponse(objectMapper, response);
	}

	@Override
	public SessionResponse session() throws IOException {
		final HttpResponse response = execute(HttpMethod.POST, PATH_V140_SESSION, null);
		return new SessionResponse(objectMapper, response);
	}
}
