package com.practice.webapp.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.OrderDAO;
import com.practice.webapp.entity.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class OrderController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/OrderDetail", method = RequestMethod.GET)
	public ModelAndView getOrderDetail(String name) {
		ModelAndView model = new ModelAndView("OrderDetail");
		// = model.setViewName("OrderDetail");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView getOrder(String name) {
		ModelAndView model = new ModelAndView("order");
		// = model.setViewName("order");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/OrderRecord", method = RequestMethod.GET)
	public ModelAndView getOrderRecord(String name) {
		ModelAndView model = new ModelAndView("OrderRecord");
		// = model.setViewName("OrderDetail");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		List<Order> orderList = new ArrayList<Order>();
		orderList=orderdao.getList();
		Order order=new Order();
		for(int i = 0 ; i < orderList.size();i++){
			if (1==orderList.get(i).getOrder_id()){
				order=orderList.get(i);
			}
		}
		model.addObject("Order",order);
		model.addObject("OrderList",orderList);
		model.addObject("message");
		return model;
	}
}
