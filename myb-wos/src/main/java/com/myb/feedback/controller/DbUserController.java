package com.myb.feedback.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import com.myb.feedback.service.DbDataDictionaryService;
import com.myb.feedback.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Maps;
import com.myb.commons.utils.HexUtil;
import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.entity.pojo.feedback.DbUser;
import com.myb.feedback.base.Cons;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SortParameter;
import com.myb.framework.data.SqlOrder;
import com.myb.framework.util.RequestUtil;

@Controller
@RequestMapping("/manage/control/user")
public class DbUserController {
    @Autowired
    private DbUserService dbUserService;
    @Autowired
    private DbDataDictionaryService dbDataDictionaryService;
    
    @RequestMapping("/list.jhtml")
    public String searchResult(HttpServletRequest request, Model model, @RequestParam(required = false)String un) {
    	QueryParameter queryParameterDd = new QueryParameter();
    	queryParameterDd.eq("type", 5);
    	List<DbDataDictionary> dbDataDictionarys = dbDataDictionaryService.searchList(queryParameterDd);
    	if(dbDataDictionarys != null && dbDataDictionarys.size() > 0) {
    		Map<Integer, String> departMap = Maps.newHashMap();
    		for (DbDataDictionary dbDataDictionary : dbDataDictionarys) {
    			departMap.put(dbDataDictionary.getId(), dbDataDictionary.getName());
			}
    		model.addAttribute("departMap", departMap);
    	}
    	
    	
    	 QueryCondition queryCondition=new QueryCondition();
         queryCondition.setPageSize(Cons.PAGE_SIZE);
         queryCondition.setPageIndex(RequestUtil.getIntParameter(request,"page",1));
         
         if(StringUtils.isNotEmpty(un)) {
        	 String encodeChar = request.getCharacterEncoding();
        	 if(request.getMethod().equalsIgnoreCase("GET")) {
        		 encodeChar = "ISO8859-1";
        	 }
        	 try {
				un = new String(un.getBytes(encodeChar), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
        	 QueryParameter queryParameter = new QueryParameter();
             queryParameter.co("uname", un);
             queryCondition.setQueryParameter(queryParameter);
             model.addAttribute("un", un);
         }
         
         SortParameter sortParameter = new SortParameter();
         sortParameter.add("id", SqlOrder.DESC);
         queryCondition.setSortParameter(sortParameter);
         
         PagedList<DbUser> pagedList=dbUserService.searchByPage(queryCondition);
         model.addAttribute("pagedList", pagedList);
         
         try {
         	String firstPage = RequestUtil.getUrl(request, "page", "1");
 			String prePage = RequestUtil.getUrl(request, "page", String.valueOf(RequestUtil.getIntParameter(request,"page",1) -1));
 			String nextPage = RequestUtil.getUrl(request, "page", String.valueOf(RequestUtil.getIntParameter(request,"page",1) +1));
 			String lastPage = RequestUtil.getUrl(request, "page", String.valueOf(pagedList.getTotalPage()));
 			model.addAttribute("firstPage", firstPage);
 			model.addAttribute("prePage", prePage);
 			model.addAttribute("nextPage", nextPage);
 			model.addAttribute("lastPage", lastPage);
 		} catch (UnsupportedEncodingException e) {
 			throw new RuntimeException(e.getMessage(), e);
 		}
         return Cons.CONTROL + "/user/list";
    }
    
    @RequestMapping("/addUI.jhtml")
    public String addUI(Model model) {
    	QueryParameter queryParameterDd = new QueryParameter();
    	queryParameterDd.eq("type", 5);
    	List<DbDataDictionary> departments = dbDataDictionaryService.searchList(queryParameterDd);
    	model.addAttribute("departments", departments);
    	return Cons.CONTROL + "/user/addUI";
    }
    
    @RequestMapping("/add.jhtml")
    public String add(DbUser user) {
    	Timestamp ts = new Timestamp(new Date().getTime());
    	user.setPassword(HexUtil.getEncryptedPwd(user.getPassword()));
    	user.setAddTime(ts);
    	user.setModifyTime(ts);
    	dbUserService.insert(user);
    	return "redirect:/manage/control/user/list.jhtml";
    }
    
    @RequestMapping("/editUI.jhtml")
    public String editUI(Integer id, Model model) {
    	DbUser user = dbUserService.searchById(id);
    	model.addAttribute("entity", user);
    	
    	QueryParameter queryParameterDd = new QueryParameter();
    	queryParameterDd.eq("type", 5);
    	List<DbDataDictionary> departments = dbDataDictionaryService.searchList(queryParameterDd);
    	model.addAttribute("departments", departments);
    	return Cons.CONTROL + "/user/editUI";
    }
    
    @RequestMapping("/edit.jhtml")
    public String edit(DbUser user) {
    	DbUser du = dbUserService.searchById(user.getId());
    	Timestamp ts = new Timestamp(new Date().getTime());
    	user.setAddTime(du.getAddTime());
    	user.setPassword(du.getPassword());
    	user.setUsername(du.getUsername());
    	
    	user.setModifyTime(ts);
    	dbUserService.update(user);
    	return "redirect:/manage/control/user/list.jhtml";
    }
    
    @RequestMapping("/delete.jhtml")
    public String delete(Integer id) {
    	DbUser user = dbUserService.searchById(id);
    	if(!"hailinlover".equals(user.getUsername())) {
    		dbUserService.delete(id);
    	}
    	return "redirect:/manage/control/user/list.jhtml";
    }
    
    @RequestMapping("/batchDelete.jhtml")
    public String batchDelete(Integer[] ids) {
    	if(ids != null && ids.length > 0) {
    		for (Integer id : ids) {
    			DbUser user = dbUserService.searchById(id);
    	    	if(!"hailinlover".equals(user.getUsername())) {
    	    		dbUserService.delete(id);
    	    	}
			}
    	}
    	return "redirect:/manage/control/user/list.jhtml";
    }
    
    @RequestMapping("/admin.jhtml")
    public String admin(Integer id, RedirectAttributes model, Integer flag) {
    	DbUser user = dbUserService.searchById(id);
    	user.setAdministrator(flag);
    	dbUserService.update(user);
    	model.addFlashAttribute("message", flag);
    	return "redirect:/manage/control/user/list.jhtml";
    }
    
    
    @RequestMapping("/checkUsername.jhtml")
    public void checkUsername(HttpServletResponse response, String username) {
    	PrintWriter out = null;
		try {
			out = response.getWriter();
			QueryParameter queryParameter = new QueryParameter();
			queryParameter.eq("username", username);
			List<DbUser> users = dbUserService.searchList(queryParameter);
			if(users != null && users.size() > 0) {
				out.write("{\"valid\":false, \"message\":\"该用户已存在\"}");
			} else {
				out.write("{\"valid\":true}");
			}
			out.close();
		} catch (Exception e) {
			out.write("{\"valid\":false, \"message\":\"服务器异常\"}");
		} finally {
			if(out != null) {
				out.close();
			}
		}
    }
    
    @RequestMapping("/logout.jhtml")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
    	request.getSession().removeAttribute(Cons.USER);
    	try {
			response.getWriter().write("<script>parent.window.location.href='" +  request.getContextPath() + "/manage.jhtml'</script>");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
    }
    
    @RequestMapping("/modifyPasswordUI.jhtml")
	public String modifyPasswordUI() {
		return Cons.CONTROL + "/user/modifyPasswordUI";
	}
    
    @RequestMapping("/modifypwd.jhtml")
	public String modifyPasswordUI(String newPassword, String oldPassword, HttpServletRequest request, RedirectAttributes attr) {
		DbUser user = (DbUser) request.getSession().getAttribute(Cons.USER);
		if(HexUtil.validPasswd(oldPassword, user.getPassword())) {
			user.setPassword(HexUtil.getEncryptedPwd(newPassword));
			Timestamp ts = new Timestamp(new Date().getTime());
			user.setModifyTime(ts);
			dbUserService.update(user);
			attr.addFlashAttribute(Cons.MESSAGE, "1");
		} else {
			attr.addFlashAttribute(Cons.MESSAGE, "0");
		}
		return "redirect:/manage/control/user/modifyPasswordUI.jhtml";
	}
    
}
