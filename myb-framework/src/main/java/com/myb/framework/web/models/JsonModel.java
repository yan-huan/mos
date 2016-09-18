package com.myb.framework.web.models;


public class JsonModel<T> {
	
	private JsonModelStatus status;
	
	private String code;
	
	private T data;
	
	private String message;

	public JsonModelStatus getStatus() {
		return status;
	}

	public void setStatus(JsonModelStatus status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public enum JsonModelStatus
	{
		SUCCESS,
		FAIL
	}
	public JsonModel()
	{
		
	}

	public JsonModel(JsonModelStatus status,String message)
	{
		this(status,message,null);
	}
	
	public JsonModel(JsonModelStatus status,String message,T data)
	{
		this.status=status;
//		this.message=message;
		this.data=data;
	}
}

