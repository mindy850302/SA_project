package com.practice.webapp.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.practice.webapp.dao.MemberDAO;

import com.practice.webapp.entity.Member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class MemberController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/AccountList", method = RequestMethod.GET)
	public ModelAndView getAccountList(String name) {
		ModelAndView model = new ModelAndView("AccountList");
		// = model.setViewName("Accountlist");
		MemberDAO memberdao = (MemberDAO)context.getBean("MemberDAO"); //defined in spring-webapp.xml
		List<Member> memberList = new ArrayList<Member>();
		memberList=memberdao.getList();
		model.addObject("memberList",memberList);
		
		return model;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView getSignup(String name) {
		ModelAndView model = new ModelAndView("signup");
		// = model.setViewName("signup");
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
	@RequestMapping(value = "/updateGraduate", method = RequestMethod.GET)
	public ModelAndView updateGraduate(@ModelAttribute Member member,HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		MemberDAO memberDAO = (MemberDAO) context.getBean("MemberDAO");
		model.setViewName("redirect:/AccountList");
		return model; 
	}
	
	@RequestMapping(value = "/AccountList", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView updateMember(@ModelAttribute Member member){		
		MemberDAO MemberDAO = (MemberDAO)context.getBean("MemberDAO");
		ModelAndView model = new ModelAndView();
		MemberDAO.update(member);
		model.setViewName("redirect:/AccountList");
		return model; 
	}
}
