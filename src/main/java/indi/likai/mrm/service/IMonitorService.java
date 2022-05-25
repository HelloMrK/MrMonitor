package indi.likai.mrm.service;

import indi.likai.mrm.domain.ResultInfo;
import indi.likai.mrm.domain.ServerInfo;

public interface IMonitorService {
    /**
     * 读取服务器信息
     * @param serverInfo
     * @return
     */
    ResultInfo getUsedMemorySize(ServerInfo serverInfo);
}
