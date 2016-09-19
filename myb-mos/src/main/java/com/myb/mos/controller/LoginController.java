package com.myb.mos.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myb.accounts.service.UserService;
import com.myb.entity.pojo.mos.Employee;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.EmployeeVO;
import com.myb.mos.utils.MD5Util;

/**
 * 登录
 * 
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private com.myb.accounts.service.EmployeeService employeeService;

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param userName
	 * @param passWord
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,
			@RequestParam("userName") String userName,
			@RequestParam("passWord") String passWord) {
		request.getSession().removeAttribute("roleVOs");
		StringBuilder stringBuilder = new StringBuilder();
		Employee employee = employeeService.searchByUserName(userName);
		if (employee != null) {
			stringBuilder.append(passWord);
			stringBuilder.append(employee.getRan());
			String pwdAfter = stringBuilder.toString();
			String jiamiPwd = MD5Util.string2MD5(pwdAfter);

			if (jiamiPwd.equals(employee.getPassWord())) {
				request.getSession().setAttribute("loginUser", employee);
				StartupController.employee = employee;
				return "1";
			} else {
				return "2";
			}
		} else {
			return "3";
		}
	}

	/**
	 * 重定向login页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/loginPage")
	public ModelAndView loginPage(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().removeAttribute("roleVOs");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		
		return mav;
	}

	/**
	 * 注册用户存入的表是员工表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/registerUser", method = {RequestMethod.POST,RequestMethod.GET})
	public String registerUser(@ModelAttribute("employeeVO") EmployeeVO employeeVO,
			HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Employee employee = new Employee();
		org.springframework.beans.BeanUtils.copyProperties(employeeVO, employee);
		if (null != employeeVO.getEntryTime()) {
			try {
				employee.setEntryTime(format.parse(employeeVO.getEntryTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		}
		if (null != employeeVO.getQuitTime()) {
			try {
				employee.setQuitTime(format.parse(employeeVO.getQuitTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}	
		}
		if (employee.getUserName() != null) {
			Employee employee2 = employeeService.searchByUserName(employee
					.getUserName());
			if (employee2 != null) {
				return "3";
			}
		}
		employee.setIsUsed(1);
		employee.setEmpCode("1252");
		employee.setEmpName(employee.getEmpName());
		employee.setStatus(1);
		employee.setCreateTime(new Date());

		Random random = new Random();
		int rd = random.nextInt(10);
		String ran = String.valueOf(rd);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(employee.getPassWord());
		stringBuilder.append(ran);
		String newPWD = stringBuilder.toString();
		employee.setPassWord(MD5Util.string2MD5(newPWD));
		employee.setRan(rd);
		employee.setCreateTime(new Date());
		int ep = employeeService.insert(employee);

		if (ep == 1) {
			return "1";
		} else {
			return "0";
		}

	}
	/**
	 * 修改密码
	 * @param employee
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value = "/modifyUser", method = {RequestMethod.POST,RequestMethod.GET})
	public String modifyUser(@ModelAttribute("employee") Employee employee,
			HttpServletRequest request, HttpServletResponse response) {
		
		Employee employee2 = employeeService.searchByEmpId(employee.getEmpId());
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(employee.getPreferPwd());
		stringBuilder.append(employee2.getRan());
		String newPWD = stringBuilder.toString();
		if (employee2 != null && ! employee2.getPassWord().equals(MD5Util.string2MD5(newPWD))) {
			
			return "preferPwdErr";
		} 
		if (employee2 == null) {
			return "noUserName";
		} 

		Random random = new Random();
		int rd = random.nextInt(10);
		String ran = String.valueOf(rd);
		StringBuilder stringBuilder1 = new StringBuilder();
		stringBuilder1.append(employee.getPassWord());
		stringBuilder1.append(ran);
		org.springframework.beans.BeanUtils.copyProperties(employee2, employee);
		String newPWD1 = stringBuilder1.toString();
		employee.setPassWord(MD5Util.string2MD5(newPWD1));
		employee.setRan(rd);
		int ep = employeeService.update(employee);

		if (ep == 1) {
			return "1";
		} else {
			return "0";
		}

	}
	/**
	 * 退出登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/exit")
	public ModelAndView loginPage2(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().removeAttribute("loginUser");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		Cookie[] cookies = request.getCookies();
		try {
			for (int i = 0; i < cookies.length; i++) {
				// System.out.println(cookies[i].getName() + ":" +
				// cookies[i].getValue());
				Cookie cookie = new Cookie(cookies[i].getName(), null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		} catch (Exception ex) {
			System.out.println("清空Cookies发生异常！");
		}
		return mav;
	}
	
	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public String random(@ModelAttribute("employee") Employee employee,
			HttpServletRequest request, HttpServletResponse response) {

		
		List<Employee> employees = employeeService.searchList(new QueryParameter());
		
		for (Employee e:employees){
			
			Random random = new Random();
			int rd = random.nextInt(10);
			String ran = String.valueOf(rd);
			e.setRan(rd);
			
			int n=6;
			String b=e.getUserName().substring(e.getUserName().length()-n,e.getUserName().length());
			MD5Util.string2MD5(b+ran);
			e.setPassWord(MD5Util.string2MD5(b+ran));
			employeeService.update(e);
			
		}
		
		if (employee.getUserName() != null) {
			Employee employee2 = employeeService.searchByUserName(employee
					.getUserName());
			if (employee2 != null) {
				return "3";
			}
		}
		employee.setIsUsed(1);
		employee.setEmpCode("1252");
		employee.setEmpName(employee.getEmpName());
		employee.setStatus(1);
		employee.setCreateTime(new Date());

		Random random = new Random();
		int rd = random.nextInt(10);
		String ran = String.valueOf(rd);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(employee.getPassWord());
		stringBuilder.append(ran);
		String newPWD = stringBuilder.toString();
		employee.setPassWord(MD5Util.string2MD5(newPWD));
		employee.setRan(rd);
		employee.setCreateTime(new Date());
		int ep = employeeService.insert(employee);

		if (ep == 1) {
			return "1";
		} else {
			return "0";
		}

	}
	
	public static void main(String[] args) {
		
			File file =new File("C:\\Users\\yanhuan\\Desktop\\a1.jpg");
			try {
				@SuppressWarnings({ "unused", "resource" })
				FileInputStream inputStream = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String mobile = "10000000000";
		mobile.subSequence(mobile.length()-6, mobile.length());
		System.out.println(mobile.subSequence(mobile.length()-6, mobile.length()));
	}

}
