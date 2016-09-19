package com.myb.mos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myb.accounts.service.AccountsAccountService;
import com.myb.accounts.service.EmpRoleService;
import com.myb.accounts.service.RoleChildService;
import com.myb.accounts.service.RoleService;
import com.myb.entity.pojo.mos.EmpRole;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.Role;
import com.myb.entity.pojo.mos.RoleChild;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.RoleVO;
/**
 * 公共
 */
public class BaseController {

	public BaseController(HttpServletRequest request) {
		super();
	}
 
	
    
    
}
