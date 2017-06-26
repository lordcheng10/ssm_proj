package com.jd.ssm.service;

import com.jd.ssm.model.Manager;
import com.jd.ssm.model.Order;
import com.jd.ssm.service.manager.ManagerService;
import com.jd.ssm.service.order.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class TestOrderService {
	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
	OrderService orderService = (OrderService) ac.getBean("orderService");

	@Test
	public void test(){
		List<Order> result;
		result = orderService.getAll();
		for(Order o : result){
			System.out.println(o.toString());
		}
	}
	
	@Test
	public void test2(){
		Order oo = new Order();
		oo.setId(83);
		oo.setCreatetime(new Date(1496));
		//oo.setNote("出库");
		oo.setUserId(1);
		oo.setNumber("88588");
		orderService.addOrder(oo);
		
	}
	@Test
	public void test3(){
		orderService.deleteOrder(4);
	}
	@Test
	public void test4(){
		Order oo = new Order();
		oo.setId(1);
		oo.setCreatetime(new Date(1496));
		oo.setNote("出库");
		oo.setUserId(1);
		oo.setNumber("88588");
		orderService.editOrder(oo);
	}
	
	@Test
	public void test5(){
		Order o2 = orderService.selectOrderById(5);
		System.out.println(o2.toString());
	}
}
