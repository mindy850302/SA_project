package com.practice.webapp.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.AdministratorDAO;
import com.practice.webapp.dao.MemberDAO;
import com.practice.webapp.dao.OrderDAO;
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.dao.ReturnDAO;
import com.practice.webapp.dao.ReturnDetailDAO;
import com.practice.webapp.entity.Administrator;
import com.practice.webapp.entity.Member;
import com.practice.webapp.entity.Order;
import com.practice.webapp.entity.Product;
import com.practice.webapp.entity.Return;
import com.practice.webapp.entity.ReturnDetail;

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
public class ReturnController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/Return", method = RequestMethod.GET)
	public ModelAndView getReturnList(String name) {
		ModelAndView model = new ModelAndView("Return");
		// = model.setViewName("Return");
		ReturnDAO returndao = (ReturnDAO)context.getBean("ReturnDAO"); //defined in spring-webapp.xml
		OrderDAO orderDAO = (OrderDAO)context.getBean("OrderDAO");
		AdministratorDAO AdministratorDAO = (AdministratorDAO)context.getBean("AdministratorDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		MemberDAO memberdao = (MemberDAO)context.getBean("MemberDAO"); //defined in spring-webapp.xml
		List<Return> ReturnList = new ArrayList<Return>();
		List<Order> OrderList = new ArrayList<Order>();
		List<Administrator> administratorList = new ArrayList<Administrator>();
		List<Product> ProductList = new ArrayList<Product>();
		List<Member> memberList = new ArrayList<Member>();
		ReturnList=returndao.getList();
		memberList=memberdao.getList();
		OrderList=orderDAO.getList();
		administratorList=AdministratorDAO.getList();
		ProductList=Productdao.getList();
		model.addObject("ProductList",ProductList);
		model.addObject("administratorList",administratorList);
		model.addObject("memberList",memberList);
		model.addObject("ReturnList",ReturnList);
		model.addObject("OrderList",OrderList);
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/ReturnDetail", method = RequestMethod.GET)
	public ModelAndView getReturnDetailList(String name) {
		ModelAndView model = new ModelAndView("ReturnDetail");
		// = model.setViewName("ReturnDetail");
		ReturnDAO returndao = (ReturnDAO)context.getBean("ReturnDAO"); //defined in spring-webapp.xml
		ReturnDetailDAO returnDetailDAO = (ReturnDetailDAO)context.getBean("ReturnDetailDAO");
		AdministratorDAO AdministratorDAO = (AdministratorDAO)context.getBean("AdministratorDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		MemberDAO memberdao = (MemberDAO)context.getBean("MemberDAO"); //defined in spring-webapp.xml
		OrderDAO orderdao = (OrderDAO)context.getBean("OrderDAO");
		List<Return> ReturnList = new ArrayList<Return>();
		List<ReturnDetail> ReturnDetailList = new ArrayList<ReturnDetail>();
		List<Administrator> administratorList = new ArrayList<Administrator>();
		List<Product> ProductList = new ArrayList<Product>();
		List<Member> memberList = new ArrayList<Member>();
		List<Order> OrderList = new ArrayList<Order>();
		ReturnList=returndao.getList();
		memberList=memberdao.getList();
		ReturnDetailList=returnDetailDAO.getList();
		administratorList=AdministratorDAO.getList();
		ProductList=Productdao.getList();
		OrderList=orderdao.getList();
		model.addObject("ProductList",ProductList);
		model.addObject("administratorList",administratorList);
		model.addObject("memberList",memberList);
		model.addObject("ReturnList",ReturnList);
		model.addObject("ReturnDetailList",ReturnDetailList);
		model.addObject("OrderList",OrderList);
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/addReturn", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView getAddReturn(@ModelAttribute Return areturn,HttpServletRequest request,@ModelAttribute("type") String type){
		ModelAndView model = new ModelAndView();
		// = model.setViewName("ReturnDetail");
		ReturnDAO returnDAO = (ReturnDAO)context.getBean("ReturnDAO"); //defined in spring-webapp.xml
		OrderDAO orderDAO = (OrderDAO)context.getBean("OrderDAO"); 
//		ReturnDetailDAO returnDetailDAO = (ReturnDetailDAO)context.getBean("ReturnDetailDAO");
//		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO");
		List<Return> ReturnList = new ArrayList<Return>();
		List<Order> OrderList = new ArrayList<Order>();
//		List<ReturnDetail> ReturnDetailList = new ArrayList<ReturnDetail>();
//		List<Product> ProductList = new ArrayList<Product>();
		ReturnList=returnDAO.getList();
		OrderList=orderDAO.getList();
//		ReturnDetailList=returnDetailDAO.getList();
//		ProductList=Productdao.getList();
		if(type.equals("addReturn")){
			returnDAO.insert(areturn);
			for(int i=0;i<OrderList.size();i++){
				if(OrderList.get(i).getOrder_id()==areturn.getReturn_order_id()){
					OrderList.get(i).setOrder_status(1);
					orderDAO.updateOrder_status(OrderList.get(i));
					break;
				}
			}
			
		}
		
		model.addObject("ReturnList",ReturnList);
		model.addObject("OrderList",OrderList);
		//model.addObject("ReturnDetailList",ReturnDetailList);
		model.addObject("message");
		model.setViewName("redirect:/ReturnDetail");
		return model;
	}
	@RequestMapping(value = "/updateReturn", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView getUpdateReturn(@ModelAttribute Return areturn,HttpServletRequest request,@RequestParam("type") String type,@ModelAttribute ReturnDetail areturnDetail){
		ModelAndView model = new ModelAndView();
		// = model.setViewName("ReturnDetail");
		ReturnDAO returnDAOdao = (ReturnDAO)context.getBean("ReturnDAO"); //defined in spring-webapp.xml
		ReturnDetailDAO returnDetailDAO = (ReturnDetailDAO)context.getBean("ReturnDetailDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO");
		List<Return> ReturnList = new ArrayList<Return>();
		List<ReturnDetail> ReturnDetailList = new ArrayList<ReturnDetail>();
		List<Product> ProductList = new ArrayList<Product>();
		ReturnList=returnDAOdao.getList();
		ReturnDetailList=returnDetailDAO.getList();
		ProductList=Productdao.getList();
		if(type.equals("updateReturn")){
			int price =0;
			for(int i=0;i<ProductList.size();i++){
				 price=ProductList.get(i).getP_price();
			}
			int total=areturnDetail.getP_amount()*price;
			areturn.setReturn_total(total);
			returnDAOdao.update(areturn);
			returnDetailDAO.update(areturnDetail);
			
		}

		model.addObject("ReturnList",ReturnList);
		model.addObject("ReturnDetailList",ReturnDetailList);
		model.addObject("message");
		model.setViewName("redirect:/ReturnDetail");
		return model;
	}
	@RequestMapping(value = "/deleteReturn", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView getDeleteReturn(@ModelAttribute Return areturn,HttpServletRequest request,@RequestParam("type") String type,@ModelAttribute ReturnDetail areturnDetail){
		ModelAndView model = new ModelAndView();
		// = model.setViewName("ReturnDetail");
		ReturnDAO returnDAOdao = (ReturnDAO)context.getBean("ReturnDAO"); //defined in spring-webapp.xml
		ReturnDetailDAO returnDetailDAO = (ReturnDetailDAO)context.getBean("ReturnDetailDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO");
		List<Return> ReturnList = new ArrayList<Return>();
		List<ReturnDetail> ReturnDetailList = new ArrayList<ReturnDetail>();
		List<Product> ProductList = new ArrayList<Product>();
		ReturnList=returnDAOdao.getList();
		ReturnDetailList=returnDetailDAO.getList();
		ProductList=Productdao.getList();
		if(type.equals("deleteReturn")){
			returnDAOdao.delete(areturn);
		}

		model.addObject("ReturnList",ReturnList);
		model.addObject("ReturnDetailList",ReturnDetailList);
		model.addObject("message");
		model.setViewName("redirect:/ReturnDetail");
		return model;
	}

}

