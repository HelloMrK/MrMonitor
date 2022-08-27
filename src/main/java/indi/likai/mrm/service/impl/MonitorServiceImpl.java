package indi.likai.mrm.service.impl;

import com.alibaba.fastjson.JSONObject;
import indi.likai.mrm.constant.CommandConstant;
import indi.likai.mrm.dto.ServerStatus;
import indi.likai.mrm.dto.ServerInfo;
import indi.likai.mrm.enums.ServerTypeEnum;
import indi.likai.mrm.service.IMonitorService;
import indi.likai.mrm.utils.SSHUtils;
import indi.likai.mrm.utils.TestUtils;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorServiceImpl implements IMonitorService {

    @Override
    public List<ServerStatus> getAllServersStatus() {
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
        serverStatus.setServerType(serverInfo.getServertype());
        //包装服务器运行信息
        try{
            setServerStatus(serverInfo, serverStatus);
        }catch (Exception e){
            System.out.println("出错:"+serverStatus.getServerIp());
        }
        return serverStatus;
    }

    /**
     * 包装服务器运行信息
     * @param serverInfo
     * @param serverStatus
     */
    private void setServerStatus(ServerInfo serverInfo, ServerStatus serverStatus){
        //LINUX 用jsch的方式
        if (serverInfo.getServertype().equals(ServerTypeEnum.LINUX)){
            setServerStatusLINUX(serverInfo,serverStatus);
        }
        //WIN 用远程接口调用的方式
        if (serverInfo.getServertype().equals(ServerTypeEnum.WIN)){
            try{
                setServerStatusWIN(serverInfo,serverStatus);
            }catch (IOException e){
                System.out.println("okhttp错误:"+e);
            }
        }
    }

    /**
     * 使用jsch方式获取linux服务器信息
     * @param serverInfo
     * @param serverStatus
     */
    private void setServerStatusLINUX(ServerInfo serverInfo, ServerStatus serverStatus){
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

    /**
     * 配合MrMonitorMini获取win端的信息
     * @param serverInfo
     * @param serverStatus
     */
    private void setServerStatusWIN(ServerInfo serverInfo,ServerStatus serverStatus) throws IOException {
        String url="http://"+serverInfo.getIp()+":"+serverInfo.getPort()+"/mini/getServerStatus";
        //请求远程接口
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("path",serverInfo.getDiskpath())
                .build();        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)

                .build();
        Response response = client.newCall(request).execute();
        String resultStr=response.body().string();
        ServerStatus resultStatus= JSONObject.parseObject(resultStr,ServerStatus.class);

        //包装信息
        serverStatus.setUsedMemSize(resultStatus.getUsedMemSize());
        serverStatus.setTotalMemSize(resultStatus.getTotalMemSize());
        serverStatus.calcUsedMemRate();
        serverStatus.setUsedCpuRate(resultStatus.getUsedCpuRate());
        serverStatus.setTotalDiskSize(resultStatus.getTotalDiskSize());
        serverStatus.setUsedDiskSize(resultStatus.getUsedDiskSize());
        serverStatus.setUsedDiskRate(resultStatus.getUsedDiskRate());

    }

}
