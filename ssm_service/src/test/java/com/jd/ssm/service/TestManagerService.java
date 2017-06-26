package com.jd.ssm.service;

import com.jd.ssm.model.Manager;
import com.jd.ssm.service.manager.ManagerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestManagerService {
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
		System.out.println("*********************************");
		ManagerService managerService = (ManagerService)ac.getBean("managerService");
		Manager manager = managerService.getManagerByName("chenlin");
		System.out.println(manager.getPwd());
	}
}
