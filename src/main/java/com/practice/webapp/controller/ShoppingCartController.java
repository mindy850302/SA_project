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
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.dao.ReturnDAO;
import com.practice.webapp.dao.ReturnDetailDAO;
import com.practice.webapp.dao.ShoppingDetailDAO;
import com.practice.webapp.entity.Administrator;
import com.practice.webapp.entity.Member;
import com.practice.webapp.entity.Product;
import com.practice.webapp.entity.Return;
import com.practice.webapp.entity.ReturnDetail;
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
public class ShoppingCartController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/insertShoppingCart", method = RequestMethod.POST)
	public ModelAndView getShoppingCart(@ModelAttribute ShoppingDetail shoppingdetail,HttpServletRequest request,@RequestParam("type") String type,@ModelAttribute ReturnDetail areturnDetail) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// = model.setViewName("shoppingCart");
		model.addObject("message");
		
		return model;
	}
	@RequestMapping(value = "/ShoppingCart", method = RequestMethod.GET)
	public ModelAndView getShoppingCartList(@ModelAttribute ShoppingDetail shoppingdetail,HttpServletRequest request,@RequestParam("type") String type,@ModelAttribute ReturnDetail areturnDetail) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// = model.setViewName("shoppingCart");
		ShoppingDetailDAO shoppingDetaildao = (ShoppingDetailDAO) context.getBean("ShoppingDetailDAO");
		List<ShoppingDetail> ShoppingDetailList = new ArrayList<ShoppingDetail>();
		model.addObject("message");
		
		return model;
	}

}

