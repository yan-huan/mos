package com.myb.inventory.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.ResultDto;
import com.myb.commons.utils.ValidateUtil;

@Controller
@RequestMapping("/base")
public class BaseController {
	
	@ExceptionHandler(Exception.class)
    public @ResponseBody String exceptionHandler(Exception e) {
    	e.printStackTrace();
    	ResultDto rd = new ResultDto();
    	Map<String,Object> head = Maps.newHashMap();
    	Map<String,Object> body = Maps.newHashMap();
    	head.put("errCode", CodeConst.UNKNOW_ERROR);
    	rd.setHead(head);
    	body.put("errMsg", ValidateUtil.get(CodeConst.UNKNOW_ERROR));
    	rd.setBody(body);
    	return JSONObject.toJSONString(rd);
    }
	
	/**
	 * 404错误处理
	 */
	@RequestMapping("/404.jhtml")
	public @ResponseBody String NoSuchMethodFindException() {
		ResultDto rd = new ResultDto();
    	Map<String,Object> head = Maps.newHashMap();
    	Map<String,Object> body = Maps.newHashMap();
    	head.put("errCode", CodeConst.NO_SUCH_METHOD_FIND_ERROR);
    	rd.setHead(head);
    	body.put("errMsg", ValidateUtil.get(CodeConst.NO_SUCH_METHOD_FIND_ERROR));
    	rd.setBody(body);
    	return JSONObject.toJSONString(rd);
	}
	

}
