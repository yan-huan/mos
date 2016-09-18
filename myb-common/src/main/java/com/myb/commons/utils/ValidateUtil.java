package com.myb.commons.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.myb.commons.cons.CodeConst;
import com.myb.commons.dto.DataTransferObject;

/**
 * 
 * Description : 校验工具类：用户参数校验，获取code码对应的信息等 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * 
 * @author hailin.liu 2016年4月13日 上午10:49:38 <br/>
 * @version 1.0
 */
public class ValidateUtil<T> {

	/**
	 * 获取错误信息
	 * @author hailin.liu 2016年4月13日 上午10:56:59 <br/>
	 * @param codeConst
	 * @return
	 * @throws IOException 
	 */
	public static String get(String code) {
		try {
			Properties prop = new Properties();
			prop.load(ValidateUtil.class.getClassLoader().getResourceAsStream("config/errorCode.ini"));
			String message = prop.getProperty(code);
			String msg = new String(message.getBytes("ISO-8859-1"), "UTF-8");
			return msg;
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**
	 * 校验值是否为空
	 * 
	 * @author hailin.liu 2016年4月13日 上午11:23:12 <br/>
	 * @param value
	 *            要校验的值
	 * @param errorCode
	 *            错误码
	 * @param dto
	 *            返回DataTransferObject对象，如果校验未通过，则封装校验结果信息
	 */
	public static <T> void validateNullProperty(String value, String code,
			DataTransferObject<T> dto) {
		if (CodeConst.SUCCESS.equals(dto.getCode())
				&& StringUtils.isEmpty(value)) {
			dto.setCode(code);
			dto.setMsg(get(code));
		}
	}
	
	/**
	 * 数值型验证
	 * @author hailin.liu 2016年5月16日 上午11:36:04 <br/>
	 * @param value
	 * @param code
	 * @param dto
	 */
	public static<T> void validateNullPropertyNumber(Number value, String code, DataTransferObject<T> dto) {
		if (CodeConst.SUCCESS.equals(dto.getCode())
				&& value == null) {
			dto.setCode(code);
			dto.setMsg(get(code));
		}
	}

}
