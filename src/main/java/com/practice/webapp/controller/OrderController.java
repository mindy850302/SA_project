package com.practice.webapp.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.OrderDAO;
import com.practice.webapp.dao.OrderDetailDAO;
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.dao.Product_categoryDAO;
import com.practice.webapp.dao.ShoppingDetailDAO;
import com.practice.webapp.entity.Member;
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
	public ModelAndView getOrder(String name,@RequestParam("order_id") String order_id) {
		ModelAndView model = new ModelAndView("order");
		// = model.setViewName("order");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Order> orderList = new ArrayList<Order>();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); 
		List<Product> HotProductList = new ArrayList<Product>();
		HotProductList=Productdao.hotProduct();
		model.addObject("HotProductList",HotProductList);
		orderList=orderdao.getList();
		orderDetailList=orderDetaildao.getList();
		model.addObject("order_id",order_id);
		model.addObject("orderList",orderList);
		model.addObject("orderDetailList",orderDetailList);

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
	@RequestMapping(value = "/makeOrder", method = RequestMethod.POST)
	public ModelAndView insertOrder(@ModelAttribute Order order) {
		ModelAndView model = new ModelAndView();
		// = model.setViewName("OrderDetail");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Order> orderList = new ArrayList<Order>();
		List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		int id=orderdao.insert(order);
		orderList.add(0,order);
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
				orderDetail.setOrder_p_id(ShoppingDetailList.get(i).getShopping_p_id());
				orderDetail.setP_amount(ShoppingDetailList.get(i).getP_amount());
				orderDetail.setP_total(ShoppingDetailList.get(i).getProduct().getP_price()*ShoppingDetailList.get(i).getP_amount());
				orderDetail.setProduct(ShoppingDetailList.get(i).getProduct());
				orderDetaildao.insert(orderDetail);/*更新訂單明細*/
				orderDetailList.add(0, orderDetail);
				Product product=new Product();
				product.setP_id(ShoppingDetailList.get(i).getShopping_p_id());
				System.out.println("1");
				for(int j=0;j<ProductList.size();j++){
					if(ShoppingDetailList.get(i).getShopping_p_id()==ProductList.get(j).getP_id()){
						System.out.println("2");
						int inventory=ProductList.get(j).getP_inventory();
						System.out.println("3");
						System.out.println("inventory "+inventory);
						System.out.println("ShoppingDetailList.get(i).getP_amount() "+ShoppingDetailList.get(i).getP_amount());
						product.setP_inventory(inventory-ShoppingDetailList.get(i).getP_amount());
						System.out.println("原本的inventory"+ProductList.get(j).getP_inventory());
						System.out.println("消費者買的inventory"+ShoppingDetailList.get(i).getP_amount());
						System.out.println("inventory"+product.getP_inventory());
						Productdao.addInventory(product);
					}
				}
				
				
				shoppingDetaildao.delete(ShoppingDetailList.get(i));
			}
		}
		model.addObject("orderList",orderList);
		model.addObject("orderDetailList",orderDetailList);
		model.addObject("order_id",id);
		model.setViewName("redirect:/order");
		return model;
	}
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView showOrder(@ModelAttribute Order order) {
		ModelAndView model = new ModelAndView("order");
		// = model.setViewName("order");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Order> OrderList = new ArrayList<Order>();
		List<OrderDetail> OrderDetailList = new ArrayList<OrderDetail>();
	
		return model;
	}
	@RequestMapping(value = "/deleteOrderDetail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView deleteProduct(@ModelAttribute Order order, HttpServletRequest request,
			@RequestParam("type") String type) {
		OrderDAO Orderdao = (OrderDAO) context.getBean("OrderDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("deleteOrderDetail")) {
			Orderdao.delete(order);
		}
		model.setViewName("redirect:/OrderDetail");
		return model;
	}
	@RequestMapping(value = "/updateOrderDetail", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView updateProduct(@ModelAttribute Order order, HttpServletRequest request,
			@RequestParam("type") String type) {
		OrderDAO Orderdao = (OrderDAO) context.getBean("OrderDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("modifyOrderDetail")) {
			Orderdao.update(order);
		}
		model.setViewName("redirect:/OrderDetail");
		return model;
	}
	
	@RequestMapping(value = "/OrderShipping", method = RequestMethod.GET)
	public ModelAndView getOrderShipping(String name) {
		ModelAndView model = new ModelAndView("OrderShipping");
		// = model.setViewName("OrderDetail");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO"); //defined in spring-webapp.xml
		OrderDetailDAO orderDetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Order> orderList = new ArrayList<Order>();
		orderList=orderdao.getOrderShippingList();
		
		model.addObject("OrderList",orderList);
		
		model.addObject("message");
		return model;
	}
}
