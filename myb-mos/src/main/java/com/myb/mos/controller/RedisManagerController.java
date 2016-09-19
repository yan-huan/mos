package com.myb.mos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myb.accounts.service.AccountsAccountService;
import com.myb.accounts.service.ContractService;
import com.myb.accounts.service.EmployeeService;
import com.myb.accounts.service.OpenAccountService;
import com.myb.entity.pojo.mos.AddressAreaDef;
import com.myb.entity.pojo.mos.Contract;
import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.VO.RoleVO;
import com.myb.mos.utils.RedisUtil;
/**
 * 缓存管理
 * @author yanhuan
 *
 */
@Controller
@RequestMapping("/redis")
public class RedisManagerController {
    
    /**
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
	@RequestMapping(value="/getRedisContent",method = {RequestMethod.POST , RequestMethod.GET})
	public String getRedisContent(HttpServletRequest request, HttpServletResponse response) {
    	String redisKey = request.getParameter("redisKey");
    	String redisContent = RedisUtil.getJedis().get(redisKey);
    	if (StringUtils.isNotBlank(redisContent)) {
    		
    		return JSONObject.toJSONString(redisContent);
    	} else {
    		return "0";
    	}
	}
    
    /**
     * 进入redis的查询页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/redisPage")
    public ModelAndView redisPage(HttpServletRequest request, HttpServletResponse response) {
    	
    	ModelAndView mav = new ModelAndView("/redis/searchRedis");
    	
    	return mav;
    }
    
    /**
     * 清楚key的内容
     */
    @ResponseBody
   	@RequestMapping(value="/clearRedisKey",method = {RequestMethod.POST , RequestMethod.GET})
   	public String clearRedisKey(HttpServletRequest request, HttpServletResponse response) {
    	
       	String redisKey = request.getParameter("redisKey");
       	RedisUtil.getJedis().set(redisKey, "");
       	String clearAfterKey = RedisUtil.getJedis().get(redisKey);
       	if (clearAfterKey.equals("")) {
       		
       		return "1";
       	} else {
       		return "0";
       	}
   	}
    
}
