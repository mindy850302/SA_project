package com.practice.webapp.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.OrderDAO;
import com.practice.webapp.dao.OrderDetailDAO;
import com.practice.webapp.entity.Order;
import com.practice.webapp.entity.OrderDetail;

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
@SessionAttributes("loginsession")

public class OrderController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/OrderDetail", method = RequestMethod.GET)
	public ModelAndView getOrderDetail(String name) {
		ModelAndView model = new ModelAndView("OrderDetail");
		// = model.setViewName("OrderDetail");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Order> orderList = new ArrayList<Order>();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		orderList=orderdao.getList();
		orderDetailList=orderDetaildao.getList();
		Order order=new Order();
		OrderDetail orderDetail=new OrderDetail();
		for(int i = 0 ; i < orderList.size();i++){
			if (1==orderList.get(i).getOrder_id()){
				order=orderList.get(i);
			}
		}
		model.addObject("Order",order);
		model.addObject("OrderDetail",orderDetail);
		model.addObject("OrderList",orderList);
		model.addObject("OrderDetailList",orderDetailList);
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
	public ModelAndView getOrderRecord(String name, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("OrderRecord");
		// = model.setViewName("OrderDetail");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		request.getSession().getAttribute("loginsession");
		String idName=(String)request.getSession().getAttribute("loginsession");
		List<Order> orderList = new ArrayList<Order>();
		List<Order> orderList2 = new ArrayList<Order>();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		orderList=orderdao.getList();
		orderDetailList=orderDetaildao.getList();
		Order order=new Order();
		OrderDetail orderDetail=new OrderDetail();
		for(int i = 0 ; i < orderList.size();i++){
			System.out.println(orderList.get(i).getMember().getM_idName());
			if (idName.equals(orderList.get(i).getMember().getM_idName())){
				
				orderList2.add(orderList.get(i));
			}
		}
		System.out.println(orderList2.size());
		
		System.out.println(idName);
		
		model.addObject("Order",order);
		model.addObject("OrderDetail",orderDetail);
		model.addObject("OrderList",orderList);
		model.addObject("OrderList2",orderList2);
		model.addObject("OrderDetailList",orderDetailList);
		model.addObject("message");
		return model;
	}
}
