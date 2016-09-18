package com.myb.feedback.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.myb.feedback.service.DbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myb.commons.utils.HexUtil;
import com.myb.entity.pojo.feedback.DbUser;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.QueryParameter;

@Controller
@RequestMapping("/manage/login.jhtml")
public class LoginController {
	@Resource
	private DbUserService userService;

	@RequestMapping("")
	public String login(DbUser user, HttpServletRequest request, RedirectAttributes attr) {
		try {
			attr.addFlashAttribute("userDto", user);
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq("username", user.getUsername()).and().eq("administrator", 1);
			List<DbUser> users = userService.searchList(queryParameter);
			if(users != null && users.size() > 0) {
				DbUser userTemp = users.get(0);
				if(HexUtil.validPasswd(user.getPassword(), userTemp.getPassword())) {
					request.getSession().setAttribute(Cons.USER, userTemp);
					return "redirect:/manage/control/main.jhtml";
				} else {	
					attr.addFlashAttribute(Cons.MESSAGE, "0");
					return "redirect:/manage.jhtml";
				}
			} else {
				attr.addFlashAttribute(Cons.MESSAGE, "1");
				return "redirect:/manage.jhtml";
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
}
