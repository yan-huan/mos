package com.myb.commons.exception.dto;


/**
 * Description : 自定义异常 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年4月12日 下午8:50:14 <br/>
 * @version 1.0
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 2918188416034997923L;
	
	private String code;
	
	public String getCode() {
		return code;
	}
	
	
	
	public void setCode(String code) {
		this.code = code;
	}

	public BusinessException(String code, String message, Throwable t) {
		super(message, t);
		this.code = code;
	}
	
	public BusinessException(String code, String message) {
		super(message);
		this.code = code;
	}
	
}
