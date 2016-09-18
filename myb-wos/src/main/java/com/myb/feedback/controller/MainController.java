package com.myb.feedback.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myb.feedback.base.Cons;

@Controller
@RequestMapping("/manage/control")
public class MainController {
	
	@RequestMapping("/main.jhtml")
	public String main(HttpServletRequest request, Model model) {
		return Cons.CONTROL + "/main";
	}
	
	@RequestMapping("/top.jhtml")
	public String top() {
		return Cons.CONTROL + "/top";
	}
	
	@RequestMapping("/left.jhtml")
	public String left() {
		return Cons.CONTROL + "/left";
	}
	
	@RequestMapping("/right.jhtml")
	public String right() {
		return Cons.CONTROL + "/right";
	}
}
