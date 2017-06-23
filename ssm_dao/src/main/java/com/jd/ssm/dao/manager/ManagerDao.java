package com.jd.ssm.dao.manager;

import com.jd.ssm.model.Manager;

public interface ManagerDao {
    int deleteByPrimaryKey(String name);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}