package com.practice.webapp.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
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
		ModelAndView model = new ModelAndView("Product");
		// = model.setViewName("Product");
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
}
