package org.sourcepit.jd.client;

import java.io.IOException;

public interface DockerClient {
	ContainerListResponse containerList(ContainerListRequest request) throws IOException;

	ContainerCreateResponse containerCreate(ContainerCreateRequest request) throws IOException;

	ContainerInspectResponse containerInspect(ContainerInspectRequest request) throws IOException;

	ContainerTopResponse containerTop(ContainerTopRequest request) throws IOException;

	ContainerLogsResponse containerLogs(ContainerLogsRequest request) throws IOException;

	ContainerChangesResponse containerChanges(ContainerChangesRequest request) throws IOException;

	ContainerExportResponse containerExport(ContainerExportRequest request) throws IOException;

	ContainerStatsResponse containerStats(ContainerStatsRequest request) throws IOException;

	ContainerResizeResponse containerResize(ContainerResizeRequest request) throws IOException;

	ContainerStartResponse containerStart(ContainerStartRequest request) throws IOException;

	ContainerStopResponse containerStop(ContainerStopRequest request) throws IOException;

	ContainerRestartResponse containerRestart(ContainerRestartRequest request) throws IOException;

	ContainerKillResponse containerKill(ContainerKillRequest request) throws IOException;

	ContainerUpdateResponse containerUpdate(ContainerUpdateRequest request) throws IOException;

	ContainerRenameResponse containerRename(ContainerRenameRequest request) throws IOException;

	ContainerPauseResponse containerPause(ContainerPauseRequest request) throws IOException;

	ContainerUnpauseResponse containerUnpause(ContainerUnpauseRequest request) throws IOException;

	ContainerAttachResponse containerAttach(ContainerAttachRequest request) throws IOException;

	ContainerAttachWebsocketResponse containerAttachWebsocket(ContainerAttachWebsocketRequest request)
			throws IOException;

	ContainerWaitResponse containerWait(ContainerWaitRequest request) throws IOException;

	ContainerDeleteResponse containerDelete(ContainerDeleteRequest request) throws IOException;

	ContainerGetArchiveResponse containerGetArchive(ContainerGetArchiveRequest request) throws IOException;

	ContainerPutArchiveResponse containerPutArchive(ContainerPutArchiveRequest request) throws IOException;

	ContainerArchiveHeadResponse containerArchiveHead(ContainerArchiveHeadRequest request) throws IOException;

	ContainerPruneResponse containerPrune(ContainerPruneRequest request) throws IOException;

	ImageListResponse imageList(ImageListRequest request) throws IOException;

	ImageBuildResponse imageBuild(ImageBuildRequest request) throws IOException;

	ImageCreateResponse imageCreate(ImageCreateRequest request) throws IOException;

	ImageInspectResponse imageInspect(ImageInspectRequest request) throws IOException;

	ImageHistoryResponse imageHistory(ImageHistoryRequest request) throws IOException;

	ImagePushResponse imagePush(ImagePushRequest request) throws IOException;

	ImageTagResponse imageTag(ImageTagRequest request) throws IOException;

	ImageDeleteResponse imageDelete(ImageDeleteRequest request) throws IOException;

	ImageSearchResponse imageSearch(ImageSearchRequest request) throws IOException;

	ImagePruneResponse imagePrune(ImagePruneRequest request) throws IOException;

	SystemAuthResponse systemAuth(AuthConfig request) throws IOException;

	SystemInfoResponse systemInfo() throws IOException;

	SystemVersionResponse systemVersion() throws IOException;

	SystemPingResponse systemPing() throws IOException;

	ImageCommitResponse imageCommit(ImageCommitRequest request) throws IOException;

	SystemEventsResponse systemEvents(SystemEventsRequest request) throws IOException;

	SystemDataUsageResponse systemDataUsage() throws IOException;

	ImageGetResponse imageGet(ImageGetRequest request) throws IOException;

	ImageGetAllResponse imageGetAll(ImageGetAllRequest request) throws IOException;

	ImageLoadResponse imageLoad(ImageLoadRequest request) throws IOException;

	ContainerExecResponse containerExec(ContainerExecRequest request) throws IOException;

	ExecStartResponse execStart(ExecStartRequest request) throws IOException;

	ExecResizeResponse execResize(ExecResizeRequest request) throws IOException;

	ExecInspectResponse execInspect(ExecInspectRequest request) throws IOException;

	VolumeListResponse volumeList(VolumeListRequest request) throws IOException;

	VolumeCreateResponse volumeCreate(VolumeCreateRequest request) throws IOException;

	VolumeInspectResponse volumeInspect(VolumeInspectRequest request) throws IOException;

	VolumeDeleteResponse volumeDelete(VolumeDeleteRequest request) throws IOException;

	VolumePruneResponse volumePrune(VolumePruneRequest request) throws IOException;

	NetworkListResponse networkList(NetworkListRequest request) throws IOException;

	NetworkInspectResponse networkInspect(NetworkInspectRequest request) throws IOException;

	NetworkDeleteResponse networkDelete(NetworkDeleteRequest request) throws IOException;

	NetworkCreateResponse networkCreate(NetworkCreateRequest request) throws IOException;

	NetworkConnectResponse networkConnect(NetworkConnectRequest request) throws IOException;

	NetworkDisconnectResponse networkDisconnect(NetworkDisconnectRequest request) throws IOException;

	NetworkPruneResponse networkPrune(NetworkPruneRequest request) throws IOException;

	PluginListResponse pluginList() throws IOException;

	GetPluginPrivilegesResponse getPluginPrivileges(GetPluginPrivilegesRequest request) throws IOException;

	PluginPullResponse pluginPull(PluginPullRequest request) throws IOException;

	PluginInspectResponse pluginInspect(PluginInspectRequest request) throws IOException;

	PluginDeleteResponse pluginDelete(PluginDeleteRequest request) throws IOException;

	PluginEnableResponse pluginEnable(PluginEnableRequest request) throws IOException;

	PluginDisableResponse pluginDisable(PluginDisableRequest request) throws IOException;

	PluginUpgradeResponse pluginUpgrade(PluginUpgradeRequest request) throws IOException;

	PluginCreateResponse pluginCreate(PluginCreateRequest request) throws IOException;

	PluginPushResponse pluginPush(PluginPushRequest request) throws IOException;

	PluginSetResponse pluginSet(PluginSetRequest request) throws IOException;

	NodeListResponse nodeList(NodeListRequest request) throws IOException;

	NodeInspectResponse nodeInspect(NodeInspectRequest request) throws IOException;

	NodeDeleteResponse nodeDelete(NodeDeleteRequest request) throws IOException;

	NodeUpdateResponse nodeUpdate(NodeUpdateRequest request) throws IOException;

	SwarmInspectResponse swarmInspect() throws IOException;

	SwarmInitResponse swarmInit(SwarmInitRequest request) throws IOException;

	SwarmJoinResponse swarmJoin(SwarmJoinRequest request) throws IOException;

	SwarmLeaveResponse swarmLeave(SwarmLeaveRequest request) throws IOException;

	SwarmUpdateResponse swarmUpdate(SwarmUpdateRequest request) throws IOException;

	SwarmUnlockkeyResponse swarmUnlockkey() throws IOException;

	SwarmUnlockResponse swarmUnlock(SwarmUnlockRequest request) throws IOException;

	ServiceListResponse serviceList(ServiceListRequest request) throws IOException;

	ServiceCreateResponse serviceCreate(ServiceCreateRequest request) throws IOException;

	ServiceInspectResponse serviceInspect(ServiceInspectRequest request) throws IOException;

	ServiceDeleteResponse serviceDelete(ServiceDeleteRequest request) throws IOException;

	ServiceUpdateResponse serviceUpdate(ServiceUpdateRequest request) throws IOException;

	ServiceLogsResponse serviceLogs(ServiceLogsRequest request) throws IOException;

	TaskListResponse taskList(TaskListRequest request) throws IOException;

	TaskInspectResponse taskInspect(TaskInspectRequest request) throws IOException;

	SecretListResponse secretList(SecretListRequest request) throws IOException;

	SecretCreateResponse secretCreate(SecretCreateRequest request) throws IOException;

	SecretInspectResponse secretInspect(SecretInspectRequest request) throws IOException;

	SecretDeleteResponse secretDelete(SecretDeleteRequest request) throws IOException;

	SecretUpdateResponse secretUpdate(SecretUpdateRequest request) throws IOException;
}
