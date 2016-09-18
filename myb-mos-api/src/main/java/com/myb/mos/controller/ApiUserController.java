package com.myb.mos.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myb.entity.pojo.mos.City;
import com.myb.entity.pojo.mos.Employee;
import com.myb.framework.web.models.JsonModel;
import com.myb.framework.web.models.JsonModel.JsonModelStatus;
import com.myb.mos.VO.EmployeeVO;
import com.myb.mos.exception.ServiceException;
import com.myb.mos.service.CityService;
import com.myb.mos.utils.MD5Util;

/**
 * 登录
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/user")
public class ApiUserController {
	
	@Autowired
	private com.myb.mos.service.EmployeeService employeeService;
	
	@Autowired
	private CityService cityService;
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param session
	 * @param userName
	 * @param passWord
	 * @return
	 */
    @RequestMapping(value="/login" ,method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public  JsonModel login(@RequestParam Map<String,Object> data) {
    	 String userName = (String)data.get("userName");
    	 String passWord = (String)data.get("passWord");
    	 JsonModel jsonModel=new JsonModel();
    	 EmployeeVO vo = new EmployeeVO();
    	 StringBuilder stringBuilder = new StringBuilder();
    	 Employee employee = employeeService.searchByUserName(userName);
    	 if (employee != null) {
    		 stringBuilder.append(passWord);
    		 stringBuilder.append(employee.getRan());
    		 String pwdAfter = stringBuilder.toString();
    		 String jiamiPwd = MD5Util.string2MD5(pwdAfter);
    		 
    		 if (jiamiPwd.equals(employee.getPassWord())) {
    			 System.out.println("==============================================用户名是："+employee.getEmpName());
    			
    			 vo.setCityId(employee.getCityId());
    			 City city = cityService.searchByCityId(employee.getCityId());
    			 if(city==null){
    				 throw new ServiceException("根据cityId,查找城市异常。ApiUserController，70行");
    			 }
    			 vo.setCityName(city.getCityname());
    			 vo.setEmployeeId(employee.getEmpId());
    			 vo.setName(employee.getEmpName());
    		 }else{
    			 jsonModel.setCode("-1");
        		 jsonModel.setStatus(JsonModelStatus.FAIL);
        		 jsonModel.setMessage("密码不对"+userName);
        		 return jsonModel;
    		 }
    	 } else {
    		 jsonModel.setCode("-1");
    		 jsonModel.setStatus(JsonModelStatus.FAIL);
    		 jsonModel.setMessage("不存在"+userName);
    		 return jsonModel;
    	}
    	 jsonModel.setCode("100000");
		 jsonModel.setStatus(JsonModelStatus.SUCCESS);
		 jsonModel.setData(vo);
    	 return jsonModel;
    }
    @RequestMapping(value="/modifyPwd" ,method={RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public  JsonModel modifyPwd(@RequestParam Map<String,Object> data) {
    	 String userName = (String)data.get("userName");
    	 String oldPassWord = (String)data.get("oldPassWord");
    	 String newPassWord = (String)data.get("passWord");
    	 JsonModel jsonModel=new JsonModel();
    	 StringBuilder stringBuilder = new StringBuilder();
    	 Employee employee = employeeService.searchByUserName(userName);
    	 if (employee != null) {
    		 stringBuilder.append(oldPassWord);
    		 stringBuilder.append(employee.getRan());
    		 String pwdAfter = stringBuilder.toString();
    		 String jiamiPwd = MD5Util.string2MD5(pwdAfter);
    		 
    		 if (jiamiPwd.equals(employee.getPassWord())) {
    			 System.out.println("==============================================用户名是："+employee.getEmpName()+"要改密码");
    			 StringBuilder sb = new StringBuilder();
    			 sb.append(newPassWord);
    			 sb.append(employee.getRan());
        		 String md5String = MD5Util.string2MD5(sb.toString());
        		 employee.setPassWord(md5String);
        		 employeeService.update(employee);
    		 }
    	 } else {
    		 jsonModel.setCode("-1");
    		 jsonModel.setStatus(JsonModelStatus.FAIL);
    		 jsonModel.setMessage("不存在"+userName);
    		 return jsonModel;
    	}
    	 jsonModel.setCode("100000");
		 jsonModel.setStatus(JsonModelStatus.SUCCESS);
    	 return jsonModel;
    }
    
    
    
}
