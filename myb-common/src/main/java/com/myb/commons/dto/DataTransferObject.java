package com.myb.commons.dto;

import java.io.Serializable;

import com.myb.commons.cons.CodeConst;

/**
 * 
 * Description : 数据传输对象 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年4月13日 上午10:22:24 <br/>
 * @version 1.0
 */
public class DataTransferObject<T> implements Serializable {
	private static final long serialVersionUID = -5373248800100790519L;
	/** 返回的code码，根据该编码确定返回结果是否正确 **/
	private String code = CodeConst.SUCCESS;
	/** 如果返回的code为错误码，则需要返回错误信息 **/
	private String msg;
	/** 返回正确信息时的具体内容 **/
	private T data;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "DataTransferObject [code=" + code + ", msg=" + msg + ", data="
				+ data + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataTransferObject<T> other = (DataTransferObject<T>) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		return true;
	}
    	
}
