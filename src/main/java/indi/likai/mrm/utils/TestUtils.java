package indi.likai.mrm.utils;
import indi.likai.mrm.domain.ServerInfo;
import indi.likai.mrm.enums.ServerTypeEnum;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发测试工具类
 */
public class TestUtils {
    /**
     * 生成包含一个ServerInfo测试对象的List
     * @return
     */
    public static synchronized List<ServerInfo> generateTestServerInfoList(){
        List<ServerInfo> list=new ArrayList<>();
        ServerInfo serverInfo=new ServerInfo();
        serverInfo.setId(1);
        serverInfo.setIp("127.0.0.1");
        serverInfo.setPort(22);
        serverInfo.setUsername("root");
        serverInfo.setPassword("root");
        serverInfo.setServertype(ServerTypeEnum.LINUX);
        serverInfo.setRemark("这是备注");
        list.add(serverInfo);
        return list;
    }


}
