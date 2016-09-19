package com.myb.mos.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myb.accounts.service.AddressAreaDefService;
import com.myb.accounts.service.EmpRoleService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.RoleChildService;
import com.myb.accounts.service.RoleService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.EmpRole;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.Role;
import com.myb.entity.pojo.mos.RoleChild;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.OpenAccountVO;
import com.myb.mos.VO.RoleVO;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * 角色的管理
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/province")
public class provinceAndCityController {
	
    @Autowired
    private AddressAreaDefService addressAreaDefService;
    
    /**
     * 登录用户显示对应的权限
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/province" ,method={RequestMethod.POST,RequestMethod.GET})
    public String role( HttpServletRequest request, HttpServletResponse response) {
    	QueryParameter queryParameter = new QueryParameter();
    	List<AddressAreaDef> addressAreaDefs = addressAreaDefService.searchList(queryParameter);
    	System.out.println(addressAreaDefs.size());
    	
		return "0";
    }

}
