package com.jd.ssm.service.user.impl;

import com.jd.ssm.dao.user.UserDao;
import com.jd.ssm.model.User;
import com.jd.ssm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImp implements UserService {

	private UserDao userMapper;

	public UserDao getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserDao userDao) {
		this.userMapper = userDao;
	}

	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
