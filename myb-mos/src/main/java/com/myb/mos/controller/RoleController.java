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

import com.myb.accounts.service.EmpRoleService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.RoleChildService;
import com.myb.accounts.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
	
    @Autowired
    private RoleChildService childService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private EmpRoleService empRoleService;
    
    @Autowired
    private EmployeeService employeeService;
    
    
    /**
     * 登录用户显示对应的权限
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/roleList" ,method=RequestMethod.POST)
    public String role( HttpServletRequest request, HttpServletResponse response) {
    	
    	Employee employee = (Employee)request.getSession().getAttribute("loginUser");
    	List<Role> roleList = new ArrayList<>();
    	List<RoleChild> roleChilds = new ArrayList<>();
    	List<RoleVO> roleVOs = new ArrayList<>();
    	if (employee != null) {
    		
    		QueryParameter queryParameter = new QueryParameter();
    		queryParameter.eq("empId", employee.getEmpId());
    		List<EmpRole>  empRolesList = empRoleService.searchList(queryParameter);
    	    
    		for(EmpRole er : empRolesList) {
    			Role role = roleService.searchByRoleId(er.getRoleId());	
    			RoleVO roleVO = new RoleVO();
    			if (role != null) {
    				BeanUtils.copyProperties(role, roleVO);
    			}
    			roleVOs.add(roleVO);
    		}
    		
    		//遍历VO父角色
    		for (RoleVO rv : roleVOs) {
    			//子标签
    			QueryParameter queryParameter1 = new QueryParameter();
    			queryParameter1.eq("roleId",rv.getRoleId());
    			List<RoleChild> roleChildList =	childService.searchList(queryParameter1);
    			rv.setRoleChild(roleChildList);
    			
    		}
    		
    		JSONArray jsonArray = new JSONArray();
    		jsonArray.addAll(roleVOs);
    		return jsonArray.toString();
    	}
		return "0";
    }
    
    
    /**
     * 权限列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/roleAddMenuPage")
    public ModelAndView roleAddMenuPage(HttpServletRequest request, HttpServletResponse response){
    	
    	ModelAndView mav = new ModelAndView();
    	QueryParameter queryParameter = new QueryParameter();
    	queryParameter.eq("status","1");
    	List<Role> rolesList = roleService.searchList(queryParameter);
    	mav.addObject("roleList", rolesList);
    	mav.addObject("employee", (Employee)request.getSession().getAttribute("loginUser") );
    	mav.setViewName("autocomplete/AuthorManger");
    	
    	return mav;
    }
    /**
     * 显示所有的员工手机号为所选手机号添加权限
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/roleAddMenu")
    public String roleAddMenu(){
    	 QueryParameter queryParameter1 = new QueryParameter();
     	 queryParameter1.eq("status","1");
     	 List<Employee> employeesList = employeeService.searchList(queryParameter1);
    	 List<String> mobileList = new ArrayList<String>();
    	 if (employeesList != null && employeesList.size() > 0) {
    		for (Employee e : employeesList) {
    			mobileList.add(e.getEmpName()+"("+e.getUserName()+")");	
    		}
    	 }
    	return com.alibaba.fastjson.JSONArray.toJSONString(mobileList);
    }
    
    
    /**
     * 给用户添加权限
     * @param request
     * @param response
     * @param roleListId
     * @param mobile
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/addMenuByEmp")
    public String addMenuByEmp(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("roleListId[]") List<Integer> roleListId,@RequestParam("mobile") String mobile ){
    	Employee employee = employeeService.searchByUserName(mobile);
    	if (employee != null) {
    		int empId = employee.getEmpId();
    		
    		QueryParameter queryParameter = new QueryParameter();
    		queryParameter.eq("empId",empId);
    		queryParameter.and();
    		queryParameter.eq("status","1");
    		List<EmpRole>  empRoles = empRoleService.searchList(queryParameter);
    		
    		//获取当前库里所有的list
    		for (int s=0; s < empRoles.size(); s++) {
    			//获取页面选中的list
    			for(int i=0; i < roleListId.size(); i++) {
    				if (!roleListId.contains(empRoles.get(s).getRoleId())) {
    					System.out.println(empRoles.get(s).getRoleId()+"sssssssssss");
    					QueryParameter queryParameter1 = new QueryParameter();
    		    		queryParameter1.eq("empId", empId);
    					queryParameter1.and();
    					queryParameter1.eq("roleId", empRoles.get(s).getRoleId());
    					List<EmpRole> roles = empRoleService.searchList(queryParameter1);
    					if (roles != null && roles.size() > 0) {
    						empRoleService.delete(roles.get(0).getId());
    					}
    				} 
    			}
    		}
    		for (int s=0; s < empRoles.size(); s++) {
    			//获取页面选中的list
    			for(int i=0; i < roleListId.size(); i++) {
    				
    				if (roleListId.get(i).equals(empRoles.get(s).getRoleId())) {
    					roleListId.remove(roleListId.get(i));
    				}
    			}
    		}
    		
    		System.out.println();
    		for (int i=0; i < roleListId.size(); i++) {
    			EmpRole empRole = new EmpRole();
    			empRole.setEmpId(empId);
    			empRole.setStatus(1);
    			empRole.setRoleId(roleListId.get(i));
    			empRoleService.insert(empRole);
    		}
    		
    		return "1";
    	} else {
    		return "0";
    	}
    	
    }
    
    
    /**
     * autoComplete.js搜索  查询用户所属权限
     * @param request
     * @param response
     * @param roleListId
     * @param mobile
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/searchUserByPermission")
    public String searchUserByPermission(HttpServletRequest request, HttpServletResponse response,
    		@RequestParam("mobile") String mobile ){
    	
    	Employee employee = employeeService.searchByUserName(mobile);
    	if (employee != null) {
    		int empId = employee.getEmpId();
    		
    		QueryParameter queryParameter = new QueryParameter();
    		queryParameter.eq("empId",empId);
    		queryParameter.and();
    		queryParameter.eq("status","1");
    		List<EmpRole>  empRoles = empRoleService.searchList(queryParameter);
    		
    		List<Integer> roleList = new ArrayList<Integer>();
    		for (int s=0; s< empRoles.size(); s++) {
    			
    			EmpRole empRole = empRoles.get(s);
    			if (empRole != null) {
    				roleList.add(empRole.getRoleId());
    			}
    		}
    		
    		return roleList.toString();
    	} else {
    		return "0";
    	}
    	
    }
}
