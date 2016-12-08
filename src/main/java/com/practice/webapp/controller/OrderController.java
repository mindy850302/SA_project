package com.practice.webapp.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.OrderDAO;
import com.practice.webapp.dao.OrderDetailDAO;
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.dao.Product_categoryDAO;
import com.practice.webapp.dao.ShoppingDetailDAO;
import com.practice.webapp.entity.Order;
import com.practice.webapp.entity.OrderDetail;
import com.practice.webapp.entity.Product;
import com.practice.webapp.entity.Product_category;
import com.practice.webapp.entity.ShoppingDetail;

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
	public ModelAndView getOrderRecord(String name) {
		ModelAndView model = new ModelAndView("OrderRecord");
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
	@RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
	public ModelAndView insertOrder(@ModelAttribute Order order) {
		ModelAndView model = new ModelAndView();
		// = model.setViewName("OrderDetail");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Order> orderList = new ArrayList<Order>();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		int id=orderdao.insert(order);
		System.out.println("order id="+id);
		OrderDetail orderDetail =new OrderDetail();
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		List<Product> ProductList = new ArrayList<Product>();
		ProductList=Productdao.getList();
		
		ShoppingDetailDAO shoppingDetaildao = (ShoppingDetailDAO) context.getBean("ShoppingDetailDAO");
		List<ShoppingDetail> ShoppingDetailList = new ArrayList<ShoppingDetail>();
		ShoppingDetailList=shoppingDetaildao.getList();
		
		for(int i=0;i<ShoppingDetailList.size();i++){
			if(ShoppingDetailList.get(i).getShopping_M_id()==order.getOrder_M_id()){
				orderDetail.setOrderDetail_id(id);
				orderDetail.setOrder(order);
				orderDetail.setOrder_p_id(ShoppingDetailList.get(i).getShopping_p_id());
				orderDetail.setP_amount(ShoppingDetailList.get(i).getP_amount());
				orderDetail.setP_total(ShoppingDetailList.get(i).getProduct().getP_price()*ShoppingDetailList.get(i).getP_amount());
				orderDetail.setProduct(ShoppingDetailList.get(i).getProduct());
				orderDetaildao.insert(orderDetail);/*更新訂單明細*/
				Product product=new Product();
				product.setP_id(ShoppingDetailList.get(i).getShopping_p_id());
				for(int j=0;j<ProductList.size();j++){
					if(ShoppingDetailList.get(i).getShopping_p_id()==ProductList.get(i).getP_id()){
						int inventory=ProductList.get(i).getP_inventory();
						System.out.println("inventory "+inventory);
						System.out.println("ShoppingDetailList.get(i).getP_amount() "+ShoppingDetailList.get(i).getP_amount());
						product.setP_inventory(inventory-ShoppingDetailList.get(i).getP_amount());
						Productdao.addInventory(product);
					}
				}
				
				
				shoppingDetaildao.delete(ShoppingDetailList.get(i));
			}
		}
		model.setViewName("redirect:/order");
		return model;
	}
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView showOrder(@ModelAttribute Order order) {
		ModelAndView model = new ModelAndView("order");
		// = model.setViewName("order");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Order> orderList = new ArrayList<Order>();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
	
		return model;
	}
}
