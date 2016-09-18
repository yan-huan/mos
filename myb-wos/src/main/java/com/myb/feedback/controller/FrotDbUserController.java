package com.myb.feedback.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.myb.feedback.service.DbDataDictionaryService;
import com.myb.feedback.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myb.commons.utils.HexUtil;
import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.entity.pojo.feedback.DbUser;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.QueryParameter;

@Controller
@RequestMapping("/wos/user")
public class FrotDbUserController {
	@Autowired
	private DbDataDictionaryService dbDataDictionaryService;
	@Autowired
	private DbUserService dbUserService;
	
	@RequestMapping("/editUI.jhtml")
	public String editUI(HttpServletRequest request, Model model) {
		QueryParameter queryParameterDd = new QueryParameter();
    	queryParameterDd.eq("type", 5);
    	List<DbDataDictionary> departments = dbDataDictionaryService.searchList(queryParameterDd);
    	model.addAttribute("departments", departments);
		return Cons.FRONT + "/user/editUI";
	}
	
	@RequestMapping("/edit.jhtml")
    public String edit(DbUser user, RedirectAttributes attr, HttpServletRequest request) {
    	DbUser du = dbUserService.searchById(user.getId());
    	Timestamp ts = new Timestamp(new Date().getTime());
    	user.setAddTime(du.getAddTime());
    	user.setPassword(du.getPassword());
    	user.setUsername(du.getUsername());
    	user.setAdministrator(du.getAdministrator());
    	user.setModifyTime(ts);
    	dbUserService.update(user);
    	
    	request.getSession().setAttribute(Cons.USER, user);
    	attr.addFlashAttribute("message", "1");
    	return "redirect:/wos/user/editUI.jhtml";
    }
	
	@RequestMapping("/modifyPasswordUI.jhtml")
	public String modifyPasswordUI() {
		return Cons.FRONT + "/user/modifyPasswordUI";
	}
	
	@RequestMapping("/modifypwd.jhtml")
	public String modifyPasswordUI(String newPassword, String oldPassword, HttpServletRequest request, RedirectAttributes attr) {
		DbUser user = (DbUser) request.getSession().getAttribute(Cons.USER);
		if(HexUtil.validPasswd(oldPassword, user.getPassword())) {
			user.setPassword(HexUtil.getEncryptedPwd(newPassword));
			Timestamp ts = new Timestamp(new Date().getTime());
			user.setModifyTime(ts);
			dbUserService.update(user);
			request.getSession().setAttribute(Cons.USER, user);
			attr.addFlashAttribute(Cons.MESSAGE, "1");
		} else {
			attr.addFlashAttribute(Cons.MESSAGE, "0");
		}
		return "redirect:/wos/user/modifyPasswordUI.jhtml";
	}
	
}
