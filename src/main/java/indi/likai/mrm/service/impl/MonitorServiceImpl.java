package indi.likai.mrm.service.impl;

import indi.likai.mrm.domain.ResultInfo;
import indi.likai.mrm.domain.ServerInfo;
import indi.likai.mrm.service.IMonitorService;
import indi.likai.mrm.utils.SSHUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MonitorServiceImpl implements IMonitorService {

    @Override
    public  ResultInfo getUsedMemorySize(ServerInfo serverInfo){
        ResultInfo resultInfo=new ResultInfo();
        //获取服务器内存信息
        String command="free -m|grep Mem|awk '{print $2}' && free -m|grep Mem|awk '{print $3}'";
        String sshStr=SSHUtils.execCommand(command ,serverInfo);
        String[] rstStr=sshStr.split("\n");
        BigDecimal totalMemorySize=new BigDecimal(rstStr[0]);
        BigDecimal usedMemorySize=new BigDecimal(rstStr[1]);
        //包装返回信息
        resultInfo.setServerIp(serverInfo.getIp());
        resultInfo.setServerRemark(serverInfo.getRemark());
        resultInfo.setUsedMemSize(usedMemorySize);
        resultInfo.setTotalMemSize(totalMemorySize);
        resultInfo.calcUsedMemRate();

        return resultInfo;
    }

    /**
     * 获取内存总数
     * @param serverInfo
     * @return
     */
    private BigDecimal getTotalMemorySize(ServerInfo serverInfo){
        String totalMemSizeStr= SSHUtils.execCommand("free -m|grep Mem|awk '{print $2}'",serverInfo);
        return new BigDecimal(totalMemSizeStr);
    }

}
