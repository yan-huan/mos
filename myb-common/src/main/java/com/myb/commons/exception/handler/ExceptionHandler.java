package com.myb.commons.exception.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.Ordered;

import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.DataTransferObject;
import com.myb.commons.exception.dto.BusinessException;
import com.myb.commons.utils.ValidateUtil;

/**
 * 
 * Description : 异常拦截器，由该拦截器统一处理Service层抛出的程序中没有处理到的异常 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * 
 * @author hailin.liu 2016年4月13日 上午9:34:15 <br/>
 * @version 1.0
 */
public class ExceptionHandler implements Ordered {


	@SuppressWarnings("rawtypes")
	public Object afterThrowing(ProceedingJoinPoint pjp) {
		DataTransferObject returnVal = null;
		try {
			returnVal = (DataTransferObject) pjp.proceed();
		} catch (BusinessException e) {
			returnVal = new DataTransferObject();
			returnVal.setCode(e.getCode());
			returnVal.setMsg(e.getMessage());
		} catch(Throwable e) {
			returnVal = new DataTransferObject();
			returnVal.setCode(CodeConst.UNKNOW_ERROR);
			returnVal.setMsg(ValidateUtil.get(CodeConst.UNKNOW_ERROR));
			e.printStackTrace();
		}
		return returnVal;
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
