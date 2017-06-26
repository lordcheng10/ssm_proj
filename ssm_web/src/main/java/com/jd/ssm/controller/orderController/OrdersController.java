package com.jd.ssm.controller.orderController;

import com.jd.ssm.service.order.OrderService;
import com.jd.ssm.model.Order;
import com.jd.ssm.util.OrderUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import org.apache.jasper.tagplugins.jstl.core.Param;

@Controller
@RequestMapping("/ordersController")
public class OrdersController {
	@Resource
	private OrderService orderService;

	@RequestMapping("/queryOrder")
	@ResponseBody
	public void queryOrder(HttpServletRequest request,HttpServletResponse response) throws Exception{
		List<Order> orders = new ArrayList<Order>();
		String order_id = request.getParameter("id");		
		System.out.println(order_id);
		int id = Integer.parseInt(order_id);
		Order od = orderService.getOrderById(id);
		orders.add(od);
		System.out.println(od.toString());
		
		JSONArray objs = new JSONArray();
		objs.add(orders);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");		
		String result = objs.toString().substring(1, objs.toString().length() - 1);
		System.out.println(result);
		response.getWriter().write(result);
	}
	
	@RequestMapping("/editOrder")
	public void editOrder(HttpServletRequest request) throws Exception{
		orderService.editOrder(OrderUtils.getOrderFrRequest(request));
	}
	
	@RequestMapping("/deleteOrder")
	public void deleteOrder(HttpServletRequest request){
		System.out.println("requestGetParam: "+ request.getParameter("id"));
		String id_str = request.getParameter("id");
		Integer id = Integer.parseInt(id_str);
		orderService.deleteOrder(id);
	}
	
	@RequestMapping("/addOrder")
	public void addOrder(HttpServletRequest request) throws Exception {
		orderService.addOrder(OrderUtils.getOrderFrRequest(request));
	}

	@RequestMapping("/getAllOrders")
	@ResponseBody
	public /* String */void getAllOrders(HttpServletResponse response, String page, String rows, String text)
			throws IOException {
		JSONObject jsonResult = new JSONObject();
		List<Order> orders = orderService.getAll();
		jsonResult.put("total", 1);

		JSONArray objs = new JSONArray();
		objs.add(orders);
		jsonResult.put("rows", objs);

		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		String result = objs.toString().substring(1, objs.toString().length() - 1);
		response.getWriter().write(result);

		// JSONObject jsonResult = new JSONObject();
		// jsonResult.put("total", 1);
		// JSONArray objs = new JSONArray();
		// Map<String, String> obj = new HashMap<String, String>();
		// obj.put("order_id", "3");
		// obj.put("user_id", "1");
		// obj.put("oder_numb", "000001");
		// obj.put("create_time", "2017-07-12 13:22:35");
		// obj.put("order_status", "�Ѿ�����");
		// objs.add(obj);
		// jsonResult.put("rows", objs);
		// response.setContentType("application/json");
		// response.setCharacterEncoding("utf-8");
		// response.getWriter().write(objs.toString());
		// return jsonResult.toString(); //���ַ�ʽ�����趨response��utf��ʽ
	}

}
