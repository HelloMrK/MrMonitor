package indi.likai.mrm.service;

import indi.likai.mrm.pojo.WOLClientInfo;

import java.util.List;

public interface IWANService {

    List<WOLClientInfo> getWOLClientInfoList(WOLClientInfo wolClientInfo);

    WOLClientInfo save(WOLClientInfo wolClientInfo);

}
