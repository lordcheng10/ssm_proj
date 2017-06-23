package com.jd.ssm.util;

import com.jd.ssm.model.Order;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class OrderUtils {
	public static Order getOrderFrRequest(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("UTF-8");
		Order newO = new Order();
		String id = request.getParameter("id");
		System.out.println("orderId: " + id);
		newO.setId(Integer.parseInt(id));

		String userId = request.getParameter("userId");
		System.out.println("userId: " + userId);
		newO.setUserId(Integer.parseInt(userId));

		String orderNumb = request.getParameter("number");
		System.out.println("orderNumb: " + orderNumb);
		newO.setNumber(orderNumb);

		String createTime = request.getParameter("createtime");
		System.out.println("createTime: " + createTime);
		Date date = DateUtils.strToDate(createTime);
		newO.setCreatetime(date);

		String status = request.getParameter("note");
		System.out.println("status: " + status);
		newO.setNote(status);

		return newO;
	}
}
