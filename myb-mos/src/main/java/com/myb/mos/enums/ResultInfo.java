package com.myb.mos.enums;

import java.io.Serializable;


/**
 *@Description:通用返回对象
 *@Author:IBM
 *@Since:2015年2月27日
 */
public class ResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8092903303385153617L;

	private boolean success;

	private int code;

	private Object data;

	private String message;

	public ResultInfo(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public ResultInfo() {
		
		this.success = true;
		this.code = 0;
		this.message = "";
	}
	
	public ResultInfo(Integer resultCode){
		this.code = resultCode;
	}
	
	

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "ResultInfo{" +
				"code=" + code +
				", success=" + success +
				", data=" + data +
				", message='" + message + '\'' +
				'}';
	}
}
