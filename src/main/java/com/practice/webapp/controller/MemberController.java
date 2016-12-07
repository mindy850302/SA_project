package com.practice.webapp.controller;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.A_categoryDAO;
import com.practice.webapp.dao.AdministratorDAO;
import com.practice.webapp.dao.MemberDAO;
import com.practice.webapp.entity.A_category;
import com.practice.webapp.entity.Administrator;
import com.practice.webapp.entity.Member;
import com.practice.webapp.entity.Product;

import javax.servlet.ServletRequest;
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
@SessionAttributes("loginsession")

public class MemberController {
	
	ApplicationContext context =  new ClassPathXmlApplicationContext("spring-module.xml");
	@RequestMapping(value = "/AccountList", method = RequestMethod.GET)
	public ModelAndView getAccountList(String name) {
		ModelAndView model = new ModelAndView("AccountList");
		// = model.setViewName("Accountlist");
		MemberDAO memberdao = (MemberDAO)context.getBean("MemberDAO"); //defined in spring-webapp.xml
		AdministratorDAO AdministratorDAO = (AdministratorDAO)context.getBean("AdministratorDAO");
		A_categoryDAO A_categoryDAO = (A_categoryDAO)context.getBean("A_categoryDAO");
		List<Member> memberList = new ArrayList<Member>();
		List<Administrator> administratorList = new ArrayList<Administrator>();
		List<A_category> A_categoryList = new ArrayList<A_category>();
		memberList=memberdao.getList();
		administratorList=AdministratorDAO.getList();
		A_categoryList=A_categoryDAO.getList();
		model.addObject("memberList",memberList);
		model.addObject("administratorList",administratorList);
		model.addObject("A_categoryList",A_categoryList);
		
		return model;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView getSignup(String name) {
		ModelAndView model = new ModelAndView("signup");
		// = model.setViewName("signup");
		model.addObject("message");
		return model;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(String name) {
		ModelAndView model = new ModelAndView("index");
		
		/*
		 * ServletRequest session = null;
		if(session.getAttribute("login")!=null){
			session.removeAttribute("login");
		}
		*/
		// = model.setViewName("login");
		model.addObject("loginsession","ben");
		return model;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin(String name) {
		ModelAndView model = new ModelAndView("login");
		
		/*
		 * ServletRequest session = null;
		if(session.getAttribute("login")!=null){
			session.removeAttribute("login");
		}
		*/
		// = model.setViewName("login");
		model.addObject("message");
		return model;
	}

	
	@RequestMapping(value = "/AccountList", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView add(@ModelAttribute Member member,HttpServletRequest request,@RequestParam("action_type") String type,@RequestParam("m_category") String m_category,@ModelAttribute Administrator administrator){		
		MemberDAO MemberDAO = (MemberDAO)context.getBean("MemberDAO");
		AdministratorDAO AdministratorDAO = (AdministratorDAO)context.getBean("AdministratorDAO");
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if(type.equals("addMember")){
			if(m_category.equals("Member")){
				MemberDAO.insert(member);
			}else{
				AdministratorDAO.insert(administrator);
			}
			
		}
		model.setViewName("redirect:/AccountList");
		return model; 
	}
	@RequestMapping(value = "/updateMember", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView updateMember(@ModelAttribute Member member,HttpServletRequest request,@RequestParam("type") String type){		
		MemberDAO MemberDAO = (MemberDAO)context.getBean("MemberDAO");
		
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if(type.equals("modifyMember")){
			MemberDAO.update(member);
		}
		model.setViewName("redirect:/AccountList");
		return model; 
	}
	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView deleteMember(@ModelAttribute Member member,HttpServletRequest request,@RequestParam("type") String type){		
		MemberDAO MemberDAO = (MemberDAO)context.getBean("MemberDAO");
		
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if(type.equals("deleteMember")){
			MemberDAO.delete(member);
		}
		model.setViewName("redirect:/AccountList");
		return model; 
	}
	@RequestMapping(value = "/updateAdministrator", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView updateAdministrator(@ModelAttribute Administrator admin,HttpServletRequest request,@RequestParam("type") String type){		
		AdministratorDAO AdministratorDAO = (AdministratorDAO)context.getBean("AdministratorDAO");
		
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if(type.equals("modifyAdministrator")){
			AdministratorDAO.update(admin);
		}
		model.setViewName("redirect:/AccountList");
		return model; 
	}
	@RequestMapping(value = "/deleteAdministrator", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView deleteAdministrator(@ModelAttribute Administrator admin,HttpServletRequest request,@RequestParam("type") String type){		
		AdministratorDAO AdministratorDAO = (AdministratorDAO)context.getBean("AdministratorDAO");
		
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if(type.equals("deleteAdministrator")){
			AdministratorDAO.delete(admin);
		}
		model.setViewName("redirect:/AccountList");
		return model; 
	}
	@RequestMapping(value = "/MemberData", method = RequestMethod.GET)
	public ModelAndView getMemberData(String name) {
		ModelAndView model = new ModelAndView("MemberData");
		// = model.setViewName("MemberData");
		MemberDAO memberdao = (MemberDAO)context.getBean("MemberDAO"); //defined in spring-webapp.xml
		List<Member> memberList = new ArrayList<Member>();
		memberList=memberdao.getList();
		Member member=new Member();
		for(int i = 0 ; i < memberList.size();i++){
			if (1==memberList.get(i).getM_id()){
				member=memberList.get(i);
			}
		}
		model.addObject("Member",member);
		model.addObject("memberList",memberList);
		
		return model;
	}
	@RequestMapping(value = "/updateMemberData", method = RequestMethod.POST,produces="text/html;charset=UTF-8")
	public ModelAndView updateMemberData(@ModelAttribute Member member,HttpServletRequest request,@RequestParam("type") String type){		
		MemberDAO MemberDAO = (MemberDAO)context.getBean("MemberDAO");
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);
		if(type.equals("modifyMemberData")){
			MemberDAO.update(member);
		}
		model.setViewName("redirect:/MemberData");
		return model; 
	}
}
