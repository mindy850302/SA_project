package com.practice.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.practice.webapp.dao.DiscountDAO;
import com.practice.webapp.dao.DiscountDetailDAO;

import com.practice.webapp.entity.Discount;
import com.practice.webapp.entity.DiscountDetail;

public class DiscountController {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

	@RequestMapping(value = "/insertDiscount", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView insertDiscount(@ModelAttribute Discount discount, HttpServletRequest request,
			@RequestParam("type") String type) {
		DiscountDAO DiscountDAO = (DiscountDAO) context.getBean("DiscountDAO");
		ModelAndView model = new ModelAndView();
		DiscountDAO.insert(discount);
		model.setViewName("redirect:/DiscountList");
		return model;

	}

	@RequestMapping(value = "/updateDiscount", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView updateDiscount(@ModelAttribute Discount discount, HttpServletRequest request,
			@RequestParam("type") String type) {
		DiscountDAO DiscountDAO = (DiscountDAO) context.getBean("DiscountDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("modifyDiscount")) {
			DiscountDAO.update(discount);
		}
		model.setViewName("redirect:/DiscountList");
		return model;
	}

	@RequestMapping(value = "/deleteDiscount", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public ModelAndView deleteDiscount(@ModelAttribute Discount discount, HttpServletRequest request,
			@RequestParam("type") String type) {
		DiscountDAO DiscountDAO = (DiscountDAO) context.getBean("DiscountDAO");

		ModelAndView model = new ModelAndView();
		System.out.println(request.getCharacterEncoding());
		System.out.println(type);

		if (type.equals("deleteDiscount")) {
			DiscountDAO.delete(discount);
		}
		model.setViewName("redirect:/DiscountList");
		return model;
	}

	@RequestMapping(value = "/DiscountList", method = RequestMethod.GET)
	public ModelAndView getDiscountList(String name) {
		ModelAndView model = new ModelAndView("DiscountList");
		DiscountDAO Discountdao = (DiscountDAO) context.getBean("DiscountDAO"); // defined
																				// in
																				// spring-webapp.xml
		DiscountDetailDAO DiscountDetailDAO = (DiscountDetailDAO) context.getBean("DiscountDetailDAO");
		List<Discount> DiscountList = new ArrayList<Discount>();
		List<DiscountDetail> DiscountDetailList = new ArrayList<DiscountDetail>();
		DiscountList = Discountdao.getList();
		DiscountDetailList = DiscountDetailDAO.getList();
		model.addObject("DiscountList", DiscountList);
		model.addObject("DiscountDetailList", DiscountDetailList);

		return model;
	}

	@RequestMapping(value = "/DiscountDetail", method = RequestMethod.GET)
	public ModelAndView getDiscountDetail(String name) {
		ModelAndView model = new ModelAndView("DiscountDetail");
		model.addObject("message");
		return model;
	}

	@RequestMapping(value = "/Discount", method = RequestMethod.GET)
	public ModelAndView getDiscount(String name) {
		ModelAndView model = new ModelAndView("Discount");
		model.addObject("message");
		return model;
	}

}
