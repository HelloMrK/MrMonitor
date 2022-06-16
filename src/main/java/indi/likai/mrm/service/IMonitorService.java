package indi.likai.mrm.service;

import indi.likai.mrm.domain.ServerStatus;
import indi.likai.mrm.domain.ServerInfo;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public interface IMonitorService {
    /**
     * 获取所有服务器运行信息
     * @return
     */
    List<ServerStatus> getAllServersStatus() throws BrokenBarrierException, InterruptedException;

    /**
     * 获取服务器运行信息
     * @param serverInfo
     * @return
     */
    ServerStatus getServerStatus(ServerInfo serverInfo);
}
