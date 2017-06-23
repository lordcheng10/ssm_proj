package com.jd.ssm.managerController;

import jd.model.Manager;
import jd.serviceI.ManagerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/managerController")
public class ManagerController {	
	@Autowired
	private ManagerServiceI managerService;
	
	@RequestMapping("/checkLogin")
	public ModelAndView checkLogin(HttpServletRequest request) {	
		String str_name = (String) request.getParameter("name");
		String str_pwd = (String) request.getParameter("password");
		Manager manager = managerService.getManagerByName(str_name);
		ModelAndView modelAndView = new ModelAndView();
		if(null != manager && manager.getPwd().equals(str_pwd)){
			modelAndView.addObject("manager",manager);
			modelAndView.setViewName("/WEB-INF/views/orderHandles/orderHandle.jsp");
		}else
			modelAndView.setViewName("/WEB-INF/views/login/loginErro.jsp");
		return modelAndView;	
	}
}

