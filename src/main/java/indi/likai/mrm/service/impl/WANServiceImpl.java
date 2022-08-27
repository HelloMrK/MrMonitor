package indi.likai.mrm.service.impl;

import indi.likai.mrm.dao.WOLDao;
import indi.likai.mrm.pojo.WOLClientInfo;
import indi.likai.mrm.service.IWANService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WANServiceImpl implements IWANService {

    @Autowired
    WOLDao wolDao;
    @Override
    public List<WOLClientInfo> getWOLClientInfoList(WOLClientInfo wolClientInfo) {

        return wolDao.findAll();
    }

    @Override
    public WOLClientInfo save(WOLClientInfo wolClientInfo) {
        return wolDao.save(wolClientInfo);
    }
}
