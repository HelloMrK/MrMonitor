package indi.likai.mrm.controller;

import indi.likai.mrm.domain.AjaxResult;
import indi.likai.mrm.domain.ServerStatus;
import indi.likai.mrm.service.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    @RequestMapping("/getAllServerStatus")
    public AjaxResult getResultInfoList() {
        List<ServerStatus> rstList = monitorService.getAllServersStatus();
        return AjaxResult.success(rstList);
    }
}
