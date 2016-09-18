package com.myb.feedback.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myb.feedback.base.Cons;

@Controller
@RequestMapping("manage.jhtml")
public class AdminIndexController {
	
	@RequestMapping(value = "")
	public String goIndex(HttpServletRequest request, Model model) {
			return Cons.CONTROL + "/index";
	}
	
}
