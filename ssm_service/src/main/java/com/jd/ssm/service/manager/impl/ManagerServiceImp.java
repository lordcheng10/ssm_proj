package com.jd.ssm.service.manager.impl;

import com.jd.ssm.dao.manager.ManagerDao;
import com.jd.ssm.model.Manager;
import com.jd.ssm.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("managerService")
public class ManagerServiceImp implements ManagerService {
    private ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public Manager getManagerByName(String name) {
        return managerDao.selectByPrimaryKey(name);
    }
}
