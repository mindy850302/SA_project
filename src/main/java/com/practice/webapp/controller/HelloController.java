package com.practice.webapp.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.CommentDAO;
import com.practice.webapp.dao.MemberDAO;
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Product;

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
public class HelloController {

	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView getDashboard(String name) {
		ModelAndView model = new ModelAndView("dashboard");
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); 
		MemberDAO memberdao = (MemberDAO) context.getBean("MemberDAO");
		List<Comment>CommentList = new ArrayList<Comment>();
		List<Product> HotProductList = new ArrayList<Product>();
		List<Product> newProductList = new ArrayList<Product>();
		int count_member=memberdao.countMember();
		int count_comment=commentDAO.countComment();
		int count_product=Productdao.countProduct();
		HotProductList=Productdao.hotProduct();
		newProductList=Productdao.newProduct();
		// = model.setViewName("dashboard");
		model.addObject("count_comment",count_comment);
		model.addObject("count_product",count_product);
		model.addObject("count_member",count_member);
		model.addObject("HotProductList",HotProductList);
		model.addObject("newProductList",newProductList);
		return model;
		
	}

}
