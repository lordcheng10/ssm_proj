package com.jd.ssm.service.order.impl;

import com.jd.ssm.dao.order.OrderDao;
import com.jd.ssm.model.Order;
import com.jd.ssm.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImp implements OrderService {
	private  OrderDao orderDao;

	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Order getOrderById(Integer id) {
		return orderDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Order> getAll() {
		return orderDao.selectAllOrder();
	}

	@Override
	public void addOrder(Order newOrder) {
		orderDao.insertSelective(newOrder);
	}

	@Override
	public void deleteOrder(Integer id) {
		orderDao.deleteByPrimaryKey(id);
	}

	@Override
	public void editOrder(Order newOrder) {
		orderDao.updateByPrimaryKey(newOrder);
	}

	@Override
	public Order selectOrderById(Integer id) {
		return orderDao.selectByPrimaryKey(id);
	}
}
