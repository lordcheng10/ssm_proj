package com.jd.ssm.service.manager.impl;

import com.jd.ssm.dao.manager.ManagerDao;
import com.jd.ssm.model.Manager;
import com.jd.ssm.service.manager.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerServiceImp implements ManagerService {
	@Autowired
	private ManagerDao managerMapper;

	@Override
	public Manager getManagerByName(String name) {
		return managerMapper.selectByPrimaryKey(name);
	}
}
