package com.pratice.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	//ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView getHello(String name) {
		ModelAndView model = new ModelAndView("hello");
		// = model.setViewName("hello");
		String message = "Hello!"+name;
		model.addObject("message", message);
		return model;
	}
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView getDashboard(String name) {
		ModelAndView model = new ModelAndView("dashboard");
		// = model.setViewName("dashboard");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/Accountlist", method = RequestMethod.GET)
	public ModelAndView getAccountlist(String name) {
		ModelAndView model = new ModelAndView("Accountlist");
		// = model.setViewName("Accountlist");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/CommentList", method = RequestMethod.GET)
	public ModelAndView getCommentList(String name) {
		ModelAndView model = new ModelAndView("CommentList");
		// = model.setViewName("CommentList");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/Inventory", method = RequestMethod.GET)
	public ModelAndView getInventory(String name) {
		ModelAndView model = new ModelAndView("Inventory");
		// = model.setViewName("Inventory");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/OrderDetail", method = RequestMethod.GET)
	public ModelAndView getOrderDetail(String name) {
		ModelAndView model = new ModelAndView("OrderDetail");
		// = model.setViewName("OrderDetail");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/ProductInfro", method = RequestMethod.GET)
	public ModelAndView getProductInfro(String name) {
		ModelAndView model = new ModelAndView("ProductInfro");
		// = model.setViewName("ProductInfro");
		model.addObject("message");
		return model;
	}

}
