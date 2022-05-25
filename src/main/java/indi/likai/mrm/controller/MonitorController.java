package indi.likai.mrm.controller;

import indi.likai.mrm.domain.ResultInfo;
import indi.likai.mrm.domain.ServerInfo;
import indi.likai.mrm.service.IMonitorService;
import indi.likai.mrm.utils.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/monitor")
@RestController
public class MonitorController {


    @Autowired
    IMonitorService monitorService;

    /**
     * 获取服务器状态信息
     *
     * @return
     */
    @RequestMapping("/getResultInfoList")
    public List<ResultInfo> getResultInfoList() {
        List<ServerInfo> list = TestUtils.generateTestServerInfoList();
        List<ResultInfo> rstList = new ArrayList<>();
        for (ServerInfo serverInfo : list
        ) {
            rstList.add(monitorService.getUsedMemorySize(serverInfo));
        }
        return rstList;
    }
}
