package com.myb.framework.web;

import java.util.HashMap;
import java.util.Map;

import com.myb.framework.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

public class WebUrl {
	
	public static Map<String, Object> getParamterMap(String param) {  
	    Map<String, Object> map = new HashMap<String, Object>(0);  
	    if (StringUtil.isNullOrEmpty(param)) {
	        return map;  
	    }  
	    String[] params = param.split("&");  
	    for (int i = 0; i < params.length; i++) {  
	        String[] p = params[i].split("=");  
	        if (p.length == 2) {  
	            map.put(p[0], p[1]);  
	        }  
	    }  
	    return map;  
	}  
	  
	public static String getQueryStringByMap(Map<String, Object> map) {  
	    if (map == null) {  
	        return "";  
	    }  
	    StringBuffer sb = new StringBuffer();  
	    for (Map.Entry<String, Object> entry : map.entrySet()) {  
	        sb.append(entry.getKey() + "=" + entry.getValue());  
	        sb.append("&");  
	    }  
	    String s = sb.toString();  
	    if (s.endsWith("&")) {  
	        s = StringUtils.substringBeforeLast(s, "&");  
	    }  
	    return s;  
	}  

}
