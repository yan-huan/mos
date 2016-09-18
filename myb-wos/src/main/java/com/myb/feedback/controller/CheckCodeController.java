package com.myb.feedback.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/check.jhtml")
public class CheckCodeController {

	@RequestMapping("")
	public void checkCode(String checkCode, HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out = null;
		try {
			String sessionCheckCode = (String) request.getSession().getAttribute("checkCode");
			out = response.getWriter();
			if(!sessionCheckCode.equalsIgnoreCase(checkCode)) {
				out.write("{\"valid\":false}");
			} else {
				out.write("{\"valid\":true}");
			}
			out.close();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
}
