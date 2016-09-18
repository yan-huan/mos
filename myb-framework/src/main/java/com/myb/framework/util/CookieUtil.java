package com.myb.framework.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CookieUtil {
	public static String get(HttpServletRequest request,String cookieName)
	{
		String cookieValue="";
		try {
			cookieValue = URLEncoder.encode(cookieValue, "utf-8");
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(cookieName)) {
						cookieValue = cookie.getValue();
						break;
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return cookieValue;
	}
	
	public static void set(HttpServletResponse response,String cookieName,String cookieValue,String domain)
	{
		Cookie cookie;
		try {
			
			cookieValue = URLEncoder.encode(cookieValue, "utf-8");
			cookie = new Cookie(cookieName, cookieValue);
			cookie.setPath("/");
			if(!StringUtil.isNullOrEmpty(domain))
			{
				cookie.setDomain(domain);
			}
			response.addCookie(cookie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
