package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.practice.webapp.dao.AdministratorDAO;
import com.practice.webapp.dao.DiscountDAO;
import com.practice.webapp.dao.DiscountDetailDAO;
import com.practice.webapp.dao.MemberDAO;
import com.practice.webapp.dao.OrderDAO;
import com.practice.webapp.dao.OrderDetailDAO;
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.dao.ReturnDAO;
import com.practice.webapp.dao.ReturnDetailDAO;
import com.practice.webapp.entity.Administrator;
import com.practice.webapp.entity.Discount;
import com.practice.webapp.entity.DiscountDetail;
import com.practice.webapp.entity.Member;
import com.practice.webapp.entity.Order;
import com.practice.webapp.entity.OrderDetail;
import com.practice.webapp.entity.Product;
import com.practice.webapp.entity.Return;
import com.practice.webapp.entity.ReturnDetail;
@Controller
public class DiscountController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	

	@RequestMapping(value = "/updateDiscount", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView updateDiscount(@ModelAttribute Discount discount,@ModelAttribute DiscountDetail discountDetail, HttpServletRequest request,
			@RequestParam("type") String type) {
		ModelAndView model = new ModelAndView();

		//DiscountDetailDAO DiscountDetailDAO = (DiscountDetailDAO) context.getBean("DiscountDetailDAO");
		DiscountDAO discountDAO = (DiscountDAO) context.getBean("DiscountDAO");
		DiscountDetailDAO discountDetailDAO = (DiscountDetailDAO)context.getBean("DiscountDetailDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO");
		List<Discount> DiscountList = new ArrayList<Discount>();
		List<DiscountDetail> DiscountDetailList = new ArrayList<DiscountDetail>();
		List<Product> ProductList = new ArrayList<Product>();
		DiscountList=discountDAO.getList();
		DiscountDetailList=discountDetailDAO.getList();
		ProductList=Productdao.getList();
		

		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("modifyDiscount")) {
			discountDAO.update(discount);
			discountDetailDAO.update(discountDetail);

			
		}
		model.addObject("DiscountList",DiscountList);
		model.addObject("DiscountDetailList",DiscountDetailList);
		model.addObject("message");
		model.setViewName("redirect:/DiscountOrder");
		return model;
	}

	@RequestMapping(value = "/deleteDiscount", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView deleteDiscount(@ModelAttribute Discount discount, HttpServletRequest request,
			@RequestParam("type") String type) {
		ModelAndView model = new ModelAndView();
		DiscountDAO discountDAO = (DiscountDAO) context.getBean("DiscountDAO");
		DiscountDetailDAO discountDetailDAO = (DiscountDetailDAO)context.getBean("DiscountDetailDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO");
		List<Discount> DiscountList = new ArrayList<Discount>();
		List<DiscountDetail> DiscountDetailList = new ArrayList<DiscountDetail>();
		List<Product> ProductList = new ArrayList<Product>();
		DiscountList=discountDAO.getList();
		DiscountDetailList=discountDetailDAO.getList();
		ProductList=Productdao.getList();
		
		
		
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("deleteDiscount")) {
			discountDAO.delete(discount);
		}
		model.addObject("DiscountList",DiscountList);
		model.addObject("DiscountDetailList",DiscountDetailList);
		model.addObject("message");
		model.setViewName("redirect:/DiscountOrder");
		return model;
	}

	@RequestMapping(value = "/DiscountOrder", method = RequestMethod.GET)
	public ModelAndView getDiscountDetail() {
		ModelAndView model = new ModelAndView("DiscountOrder");
		DiscountDAO Discountdao = (DiscountDAO) context.getBean("DiscountDAO"); // defined
		// in
		// spring-webapp.xml
		DiscountDetailDAO DiscountDetailDAO = (DiscountDetailDAO) context.getBean("DiscountDetailDAO");
		List<Discount> DiscountList = new ArrayList<Discount>();
		List<DiscountDetail> DiscountDetailList = new ArrayList<DiscountDetail>();		
		AdministratorDAO AdministratorDAO = (AdministratorDAO)context.getBean("AdministratorDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		MemberDAO memberdao = (MemberDAO)context.getBean("MemberDAO"); //defined in spring-webapp.xml
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO");
		OrderDetailDAO orderdetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Administrator> administratorList = new ArrayList<Administrator>();
		List<Product> ProductList = new ArrayList<Product>();
		List<Member> memberList = new ArrayList<Member>();
		List<Order> orderList = new ArrayList<Order>();
		List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();
		memberList=memberdao.getList();
		orderList=orderdao.getList();
		orderdetailList=orderdetaildao.getList();
		DiscountList = Discountdao.getList();
		DiscountDetailList = DiscountDetailDAO.getList();
		administratorList=AdministratorDAO.getList();
		ProductList=Productdao.getList();
		model.addObject("ProductList",ProductList);
		model.addObject("administratorList",administratorList);
		model.addObject("memberList",memberList);
		model.addObject("DiscountList",DiscountList);
		model.addObject("DiscountDetailList",DiscountDetailList);
		model.addObject("orderList",orderList);
		model.addObject("orderdetailList",orderdetailList);
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/addDiscount", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView getAddDiscount(@ModelAttribute Discount adiscount,HttpServletRequest request,@RequestParam("type") String type,@ModelAttribute DiscountDetail adiscountDetail,@RequestParam("member") String member){
		ModelAndView model = new ModelAndView();
		// = model.setViewName("DiscountDetail");
		DiscountDAO discountDAOdao = (DiscountDAO)context.getBean("DiscountDAO"); //defined in spring-webapp.xml
		DiscountDetailDAO discountDetailDAO = (DiscountDetailDAO)context.getBean("DiscountDetailDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO");
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO");
		OrderDetailDAO orderdetaildao = (OrderDetailDAO)context.getBean("OrderDetailDAO");
		List<Discount> DiscountList = new ArrayList<Discount>();
		List<DiscountDetail> DiscountDetailList = new ArrayList<DiscountDetail>();
		List<Product> ProductList = new ArrayList<Product>();
		List<Order> orderList = new ArrayList<Order>();
		List<OrderDetail> orderdetailList = new ArrayList<OrderDetail>();
		DiscountList=discountDAOdao.getList();
		DiscountDetailList=discountDetailDAO.getList();
		ProductList=Productdao.getList();
		orderList=orderdao.getList();
		orderdetailList=orderdetaildao.getList();
		
		if(type.equals("addDiscount")){
			
			int id=discountDAOdao.insert(adiscount);
			adiscountDetail.setDiscount_id(id);
			discountDetailDAO.insert(adiscountDetail);
		}

		model.addObject("DiscountList",DiscountList);
		model.addObject("DiscountDetailList",DiscountDetailList);
		model.addObject("message");
		model.setViewName("redirect:/DiscountOrder");
		return model;
	}

	
}
