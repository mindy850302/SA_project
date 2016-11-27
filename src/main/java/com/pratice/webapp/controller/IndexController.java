package com.pratice.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
public class IndexController {
	//ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndex(String name) {
		ModelAndView model = new ModelAndView("index");
		// = model.setViewName("index");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/About", method = RequestMethod.GET)
	public ModelAndView getAbout(String name) {
		ModelAndView model = new ModelAndView("About");
		// = model.setViewName("About");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/FAQ", method = RequestMethod.GET)
	public ModelAndView getFAQ(String name) {
		ModelAndView model = new ModelAndView("FAQ");
		// = model.setViewName("FAQ");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/FAQ/iPad", method = RequestMethod.GET)
	public ModelAndView getFAQiPad(String name) {
		ModelAndView model = new ModelAndView("FAQiPad");
		// = model.setViewName("FAQiPad");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/FAQ/iPhone", method = RequestMethod.GET)
	public ModelAndView getFAQiPhone(String name) {
		ModelAndView model = new ModelAndView("FAQiPhone");
		// = model.setViewName("FAQiPhone");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/FAQ/Mac", method = RequestMethod.GET)
	public ModelAndView getFAQMac(String name) {
		ModelAndView model = new ModelAndView("FAQMac");
		// = model.setViewName("FAQMac");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	public ModelAndView getProduct(String name) {
		ModelAndView model = new ModelAndView("Product");
		// = model.setViewName("Product");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(String name) {
		ModelAndView model = new ModelAndView("login");
		// = model.setViewName("login");
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
	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public ModelAndView getShoppingCart(String name) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// = model.setViewName("shoppingCart");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView getSignup(String name) {
		ModelAndView model = new ModelAndView("signup");
		// = model.setViewName("signup");
		model.addObject("message");
		return model;
	}


}
