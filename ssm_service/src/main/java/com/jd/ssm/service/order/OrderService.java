package com.jd.ssm.service.order;

import com.jd.ssm.model.Order;

import java.util.List;

public interface OrderService {
	public Order getOrderById(Integer id);
	public List<Order> getAll();
	public void addOrder(Order newOrder);
	public void deleteOrder(Integer id);
	public void editOrder(Order newOrder);
	public Order selectOrderById(Integer id);
}
