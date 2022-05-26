package indi.likai.mrm.service.impl;

import indi.likai.mrm.constant.CommandConstant;
import indi.likai.mrm.domain.ServerStatus;
import indi.likai.mrm.domain.ServerInfo;
import indi.likai.mrm.service.IMonitorService;
import indi.likai.mrm.utils.SSHUtils;
import indi.likai.mrm.utils.TestUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorServiceImpl implements IMonitorService {

    @Override
    public List<ServerStatus> getAllServersStatus(){
        //初始化返回列表
        List<ServerStatus> serverStatusList=new ArrayList<>();
        //初始化服务器信息
        List<ServerInfo> serverInfoList = TestUtils.generateTestServerInfoList();
        //遍历服务器信息
        for (ServerInfo serverInfo:serverInfoList
             ) {
            serverStatusList.add(getServerStatus(serverInfo));
        }
        return serverStatusList;
    }

    @Override
    public ServerStatus getServerStatus(ServerInfo serverInfo){
        ServerStatus serverStatus =new ServerStatus();
        //包装基本信息
        serverStatus.setServerIp(serverInfo.getIp());
        serverStatus.setServerRemark(serverInfo.getRemark());
        //包装服务器运行信息
        setServerStatus(serverInfo, serverStatus);
        return serverStatus;
    }

    /**
     * 包装服务器运行信息
     * @param serverInfo
     * @param serverStatus
     */
    private void setServerStatus(ServerInfo serverInfo, ServerStatus serverStatus){
        //获取服务器运行信息
        String sshStr=SSHUtils.execCommand(CommandConstant.SERVER_STATUS_BASH ,serverInfo);
        String[] rstStr=sshStr.split("\n");
        BigDecimal totalMemorySize=new BigDecimal(rstStr[0]);
        BigDecimal usedMemorySize=new BigDecimal(rstStr[1]);
        BigDecimal usedCpuRate=new BigDecimal(rstStr[2]);
        BigDecimal totalDiskSize=new BigDecimal(rstStr[3]);
        BigDecimal usedDiskSize=new BigDecimal(rstStr[4]);
        String usedDiskRate=rstStr[5];
        //包装信息
        serverStatus.setUsedMemSize(usedMemorySize);
        serverStatus.setTotalMemSize(totalMemorySize);
        serverStatus.calcUsedMemRate();
        serverStatus.setUsedCpuRate(usedCpuRate);
        serverStatus.setTotalDiskSize(totalDiskSize);
        serverStatus.setUsedDiskSize(usedDiskSize);
        serverStatus.setUsedDiskRate(usedDiskRate);
    }

}
