package com.practice.webapp.controller;

import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.dao.Product_categoryDAO;

import com.practice.webapp.entity.Product;
import com.practice.webapp.entity.Product_category;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

//import org.springframework.ui.Model;
@Controller
public class ProductController {

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	

	@RequestMapping(value = "/Product/iPhone", method = RequestMethod.GET)
	public ModelAndView getProductiPhone(String name) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
		ModelAndView model = new ModelAndView("Product_iPhone");
		// = model.setViewName("Product_iPhone");
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
	@RequestMapping(value = "/Product/iPad", method = RequestMethod.GET)
	public ModelAndView getProductiPad(String name) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
		ModelAndView model = new ModelAndView("Product_iPad");
		// = model.setViewName("Product_iPad");
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
	@RequestMapping(value = "/Product/Macbook", method = RequestMethod.GET)
	public ModelAndView getProductMacbook(String name) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
		ModelAndView model = new ModelAndView("Product_Macbook");
		// = model.setViewName("Product_Macbook");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		Product_categoryDAO Product_categoryDAO = (Product_categoryDAO)context.getBean("Product_categoryDAO");
		List<Product> ProductList = new ArrayList<Product>();
		List<Product_category> Product_categoryList = new ArrayList<Product_category>();
		ProductList = Productdao.getList();
		Product_categoryList = Product_categoryDAO.getList();
		model.addObject("ProductList", ProductList);
		model.addObject("Product_categoryList", Product_categoryList);
		return model;
	}
	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	public ModelAndView getiPhone7(@ModelAttribute("id") int id) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
		ModelAndView model = new ModelAndView("Product");
		// = model.setViewName("Product");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		Product_categoryDAO Product_categoryDAO = (Product_categoryDAO)context.getBean("Product_categoryDAO");
		List<Product> ProductList = new ArrayList<Product>();
		List<Product_category> Product_categoryList = new ArrayList<Product_category>();
		ProductList=Productdao.getList();
		Product product=new Product();
		for(int i = 0 ; i < ProductList.size();i++){
			if (id==ProductList.get(i).getP_id()){
				product=ProductList.get(i);
			}
		}
		Product_categoryList=Product_categoryDAO.getList();
		model.addObject("Product",product);
		int click=Productdao.updateClick(product);
		System.out.println(id);
		System.out.println(click);

		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/ProductInfro", method = RequestMethod.GET)
	public ModelAndView getProduct(String name) {

		ModelAndView model = new ModelAndView("ProductInfro");
		ProductDAO Productdao = (ProductDAO) context.getBean("ProductDAO"); // define								
		Product_categoryDAO Product_categoryDAO = (Product_categoryDAO) context.getBean("Product_categoryDAO");
		List<Product> ProductList = new ArrayList<Product>();
		List<Product_category> Product_categoryList = new ArrayList<Product_category>();
		ProductList = Productdao.getList();
		Product_categoryList = Product_categoryDAO.getList();
		model.addObject("ProductList", ProductList);
		model.addObject("Product_categoryList", Product_categoryList);

		return model;
	}

	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView insertProduct(@ModelAttribute Product product, HttpServletRequest request,
			@RequestParam("type") String type) {
		ProductDAO Productdao = (ProductDAO) context.getBean("ProductDAO");
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);
		if (type.equals("insertProduct")) {

			Productdao.insert(product);
		}

		model.setViewName("redirect:/ProductInfro");
		return model;

	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView updateProduct(@ModelAttribute Product product, HttpServletRequest request,
			@RequestParam("type") String type) {
		ProductDAO Productdao = (ProductDAO) context.getBean("ProductDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("modifyProduct")) {
			Productdao.update(product);
		}
		model.setViewName("redirect:/ProductInfro");
		return model;
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView deleteProduct(@ModelAttribute Product product, HttpServletRequest request,
			@RequestParam("type") String type) {
		ProductDAO Productdao = (ProductDAO) context.getBean("ProductDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("deleteProduct")) {
			Productdao.delete(product);
		}
		model.setViewName("redirect:/ProductInfro");
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
