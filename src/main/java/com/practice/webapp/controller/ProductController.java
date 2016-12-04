package com.practice.webapp.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.AdministratorDAO;
import com.practice.webapp.dao.MemberDAO;
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.dao.Product_categoryDAO;
import com.practice.webapp.entity.Administrator;
import com.practice.webapp.entity.Member;
import com.practice.webapp.entity.Product;
import com.practice.webapp.entity.Product_category;

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
public class ProductController {
	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	public ModelAndView getProduct(String name) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
		ModelAndView model = new ModelAndView("Product");
		// = model.setViewName("Product");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		Product_categoryDAO Product_categoryDAO = (Product_categoryDAO)context.getBean("Product_categoryDAO");
		List<Product> ProductList = new ArrayList<Product>();
		List<Product_category> Product_categoryList = new ArrayList<Product_category>();
		ProductList=Productdao.getList();
		Product_categoryList=Product_categoryDAO.getList();
		model.addObject("ProductList",ProductList);
		model.addObject("Product_categoryList",Product_categoryList);
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
	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public ModelAndView getShoppingCart(String name) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// = model.setViewName("shoppingCart");
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
	@RequestMapping(value = "/iPhone7", method = RequestMethod.GET)
	public ModelAndView getiPhone7(String name) {
		ModelAndView model = new ModelAndView("iPhone7");
		// = model.setViewName("iPhone7");
		model.addObject("message");
		return model;
	}
}
