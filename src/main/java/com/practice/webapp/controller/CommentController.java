package com.practice.webapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.webapp.dao.CommentDAO;
import com.practice.webapp.entity.Comment;

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
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");
		ModelAndView model = new ModelAndView("CommentList");
		// = model.setViewName("CommentList");
		List<Comment>CommentList = commentDAO.getList();
		CommentList = commentDAO.getList();
		model.addObject("CommentList", CommentList);
		return model;
	}

	@RequestMapping(value = "/insertComment", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView insertComment(@ModelAttribute Comment comment, HttpServletRequest request,
			@RequestParam("type") String type) {
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");
		ModelAndView model = new ModelAndView();
		commentDAO.insert(comment);
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
	public ModelAndView deleteComment(@ModelAttribute Comment comment, HttpServletRequest request,
			@RequestParam("type") String type) {
		CommentDAO commentDAO = (CommentDAO) context.getBean("CommentDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("deleteComment")) {
			commentDAO.delete(comment);
		}
		model.setViewName("redirect:/CommentList");
		return model;
	}

	@RequestMapping(value = "/Comment", method = RequestMethod.GET)
	public ModelAndView getComment(String name) {
		ModelAndView model = new ModelAndView("Comment");
		model.addObject("message");
		return model;
	}

}
