package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.CommentDAO;
import com.practice.webapp.dao.MemberDAO;
import com.practice.webapp.dao.ProductDAO;
import com.practice.webapp.entity.Comment;
import com.practice.webapp.entity.Member;
import com.practice.webapp.entity.Product;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommentController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/CommentList", method = RequestMethod.GET)
	public ModelAndView getCommentList(String name) {
		ModelAndView model = new ModelAndView("CommentList");
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");
		ProductDAO Productdao = (ProductDAO)context.getBean("ProductDAO"); //defined in spring-webapp.xml
		MemberDAO memberdao = (MemberDAO)context.getBean("MemberDAO");
		List<Comment>CommentList = new ArrayList<Comment>();
		List<Product> ProductList = new ArrayList<Product>();
		List<Member> memberList = new ArrayList<Member>();
		CommentList = commentDAO.getList();
		memberList=memberdao.getList();
		ProductList=Productdao.getList();
		model.addObject("CommentList", CommentList);
		model.addObject("ProductList",ProductList);
		model.addObject("memberList",memberList);
		model.addObject("message");
		return model;
	}

	@RequestMapping(value = "/insertComment", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView insertComment(@ModelAttribute Comment comment, HttpServletRequest request,
			@RequestParam("type") String type) {
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");
		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);
		if (type.equals("insertComment")) {
		commentDAO.insert(comment);
		}
		model.setViewName("redirect:/CommentList");
		return model;

	}

	@RequestMapping(value = "/updateComment", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView updateComment(@ModelAttribute Comment comment, HttpServletRequest request,
			@RequestParam("type") String type) {
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("modifyComment")) {
			commentDAO.update(comment);
		}
		model.setViewName("redirect:/CommentList");
		return model;
	}

	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView deleteComment(@ModelAttribute Comment comment, HttpServletRequest request) {
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		
			commentDAO.delete(comment);
		
		model.setViewName("redirect:/CommentList");
		return model;
	}

	@RequestMapping(value = "/Comment", method = RequestMethod.GET)
	public ModelAndView getComment(String name) {
		ModelAndView model = new ModelAndView("Comment");
		model.addObject("message");
		return model;
	}
	@RequestMapping(value = "/csearch", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute Comment comment, HttpServletRequest request,
		@RequestParam("ckeyword") String ckeyword) {
		CommentDAO Commentdao = (CommentDAO) context.getBean("CommentDAO");
		MemberDAO Memberdao = (MemberDAO) context.getBean("MemberDAO");
		ProductDAO Productdao = (ProductDAO) context.getBean("ProductDAO");
		ModelAndView model = new ModelAndView("searchcomment");
		
		List<Member> MemberList = new ArrayList<Member>();
		List<Product> ProductList = new ArrayList<Product>();
		List<Comment> CommentList = new ArrayList<Comment>();

		MemberList= Memberdao.search(ckeyword);
		ProductList= Productdao.search(ckeyword);
		CommentList= Commentdao.search(ckeyword);
		
		model.addObject("MemberList",MemberList);
		model.addObject("ProductList",ProductList);
		model.addObject("CommentList",CommentList);
		return model;
		
	}
	@RequestMapping(value = "/searchcomment", method = RequestMethod.GET)
	public ModelAndView searchcomment(@ModelAttribute Comment comment, HttpServletRequest request) {
		CommentDAO Commentdao = (CommentDAO) context.getBean("CommentDAO");
		List<Comment> CommentList = new ArrayList<Comment>();
		ModelAndView model = new ModelAndView("searchcomment");
		
		return model;
	}

}
