package com.myb.framework.web;

import javax.servlet.http.HttpServletRequest;


import com.myb.framework.util.StringUtil;

public class UrlManager {
	public static String buildResource(String filePath, String host,String version){
		if(StringUtil.isNullOrEmpty(version))
		{
			return host + filePath;
		}
		if(filePath.indexOf("?")>0)
		{
			return host + filePath+"&v="+version;
		}
		return host + filePath+"?v="+version;
		
	}

	/*
	public static String BuildUrl(String filePath, String host)
			throws IOException {
		return host + filePath;
	}

	public static String BuildUrl(String filePath, HttpServletRequest request)
			throws IOException {
		return BuildUrl(filePath, BuilrHost(request));
	}*/

	public static String BuilrHost(HttpServletRequest request) {

		String portString= request.getServerPort()==80?"":":"+request.getServerPort();
		
		return request.getScheme() + "://" + request.getServerName() + portString + request.getContextPath();
	}

}
