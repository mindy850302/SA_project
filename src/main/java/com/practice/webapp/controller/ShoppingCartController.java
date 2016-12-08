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
	public ModelAndView getShoppingCart(@ModelAttribute ShoppingDetail shoppingdetail,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// = model.setViewName("shoppingCart");
		ShoppingDetailDAO shoppingDetaildao = (ShoppingDetailDAO) context.getBean("ShoppingDetailDAO");
		List<ShoppingDetail> ShoppingDetailList = new ArrayList<ShoppingDetail>();
		
		model.setViewName("redirect:ShoppingCart");
		return model;
	}
	@RequestMapping(value = "/insertShoppingCart", method = RequestMethod.GET)
	public ModelAndView insertShoppingCart(@ModelAttribute ShoppingDetail shoppingdetail,@RequestParam("p_price") int price,@RequestParam("shopping_M_id") int shopping_M_id) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// = model.setViewName("shoppingCart");
		ShoppingDetailDAO shoppingDetaildao = (ShoppingDetailDAO) context.getBean("ShoppingDetailDAO");
		List<ShoppingDetail> ShoppingDetailList = new ArrayList<ShoppingDetail>();
		int amount=shoppingdetail.getP_amount();
		shoppingdetail.setP_total(amount*price);
		System.out.println(shopping_M_id);
		shoppingdetail.setShopping_M_id(shopping_M_id);
		shoppingDetaildao.insert(shoppingdetail);
		model.addObject("message");
		model.addObject("ShoppingDetailList",ShoppingDetailList);
		model.setViewName("redirect:ShoppingCart");
		return model;
	}
	@RequestMapping(value = "/ShoppingCart", method = RequestMethod.GET)
	public ModelAndView getShoppingCartList(@ModelAttribute ShoppingDetail shoppingdetail,HttpServletRequest request) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// = model.setViewName("shoppingCart");
		ShoppingDetailDAO shoppingDetaildao = (ShoppingDetailDAO) context.getBean("ShoppingDetailDAO");
		List<ShoppingDetail> ShoppingDetailList = new ArrayList<ShoppingDetail>();
		ShoppingDetailList=shoppingDetaildao.getList();
		model.addObject("ShoppingDetailList",ShoppingDetailList);
		request.getSession().getAttribute("loginsession");
		String idName=(String) request.getSession().getAttribute("loginsession");
		int M_id=0;
		MemberDAO Memberdao = (MemberDAO) context.getBean("MemberDAO");
		List<Member> MemberList = new ArrayList<Member>();
		MemberList = Memberdao.getList();
		for(int i =0;i<MemberList.size();i++){
			if(MemberList.get(i).getM_idName().equals(idName)){
				M_id=MemberList.get(i).getM_id();
				break;
			}
		}
		System.out.print("my_id"+M_id);
		System.out.print("shopping size"+ShoppingDetailList.size());
		model.addObject("my_id",M_id);
		return model;
	}

}

