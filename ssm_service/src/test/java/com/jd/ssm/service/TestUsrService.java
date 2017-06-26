package com.jd.ssm.service;

import com.jd.ssm.model.User;
import com.jd.ssm.service.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUsrService {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
		System.out.println("*********************************");
		UserService userServiceI = (UserService)ac.getBean("userService");
		User us = userServiceI.getUserById(1);
		System.out.println(us.getUsername());
	}
}
