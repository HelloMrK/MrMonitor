package indi.likai.mrm.utils;
import indi.likai.mrm.dto.ServerInfo;
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

        list.add(new ServerInfo("127.0.0.1",22,"test","test",ServerTypeEnum.LINUX,"testLinux"));
        list.add(new ServerInfo("127.0.0.1",62223,ServerTypeEnum.WIN,"testWin","C:\\"));

        return list;
    }


}
