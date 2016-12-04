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
import com.practice.webapp.entity.Administrator;
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

	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/AccountList", method = RequestMethod.GET)
	public ModelAndView getAccountList(String name) {
		ModelAndView model = new ModelAndView("AccountList");
		// = model.setViewName("Accountlist");
		MemberDAO memberdao = (MemberDAO) context.getBean("MemberDAO"); // defined
																		// in
																		// spring-webapp.xml
		AdministratorDAO AdministratorDAO = (AdministratorDAO) context.getBean("AdministratorDAO");
		List<Member> memberList = new ArrayList<Member>();
		List<Administrator> administratorList = new ArrayList<Administrator>();
		memberList = memberdao.getList();
		administratorList = AdministratorDAO.getList();
		model.addObject("memberList", memberList);
		model.addObject("administratorList", administratorList);

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

	@RequestMapping(value = "/AccountList", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView add(@ModelAttribute Member member, HttpServletRequest request,
			@RequestParam("action_type") String type, @RequestParam("m_category") String m_category,
			@ModelAttribute Administrator administrator) {
		MemberDAO MemberDAO = (MemberDAO) context.getBean("MemberDAO");
		AdministratorDAO AdministratorDAO = (AdministratorDAO) context.getBean("AdministratorDAO");
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("addMember")) {
			if (m_category.equals("Member")) {
				MemberDAO.insert(member);
			} else {
				AdministratorDAO.insert(administrator);
			}

		}
		model.setViewName("redirect:/AccountList");
		return model;
	}

	@RequestMapping(value = "/updateMember", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView updateMember(@ModelAttribute Member member, HttpServletRequest request,
			@RequestParam("type") String type) {
		MemberDAO MemberDAO = (MemberDAO) context.getBean("MemberDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("modifyMember")) {
			MemberDAO.update(member);
		}
		model.setViewName("redirect:/AccountList");
		return model;
	}

	@RequestMapping(value = "/deleteMember", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView deleteMember(@ModelAttribute Member member, HttpServletRequest request,
			@RequestParam("type") String type) {
		MemberDAO MemberDAO = (MemberDAO) context.getBean("MemberDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("deleteMember")) {
			MemberDAO.delete(member);
		}
		model.setViewName("redirect:/AccountList");
		return model;
	}

}
