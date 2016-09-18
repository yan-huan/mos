package com.myb.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

	public static int getIntParameter(HttpServletRequest request, String name,
			int defaultValue) {
		int resultValue = defaultValue;
		String value = request.getParameter(name);
		if (value != null) {
			try {
				resultValue = Integer.parseInt(value);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return resultValue;
	}

	public static int getIntParameter(HttpServletRequest request, String name) {
		return getIntParameter(request, name, 0);
	}

	public static String getStringParameter(HttpServletRequest request,
			String name, String defaultValue) {
		String resultValue = defaultValue;
		String value = request.getParameter(name);
		if (!StringUtil.isNullOrEmpty(value)) {
			resultValue = value;
		}
		return resultValue;
	}

	public static String getStringParameter(HttpServletRequest request,
			String name) {
		return getStringParameter(request, name, "");
	}


    @SuppressWarnings("unused")
	public static String sendGet(String urlString, String param,String encoding) throws UnsupportedEncodingException {
    	StringBuffer contentBuffer = new StringBuffer();  
  	  
        int responseCode = -1;  
        HttpURLConnection con = null;  
    	if(!StringUtil.isNullOrEmpty(param))
    	{
    		urlString=urlString+"?"+param;
    	}
   
        try {  
        
        	URL url=new URL(urlString);
            con = (HttpURLConnection) url.openConnection();  
            con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");// IE代理进行下载  
            con.setConnectTimeout(60000);  
            con.setReadTimeout(60000);  
            // 获得网页返回信息码  
            responseCode = con.getResponseCode();  

            InputStream inStr = con.getInputStream();  
            InputStreamReader istreamReader = new InputStreamReader(inStr, encoding);  
            BufferedReader buffStr = new BufferedReader(istreamReader);  
  
            String str = null;  
            while ((str = buffStr.readLine()) != null)  
                contentBuffer.append(str);  
            inStr.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
            contentBuffer = null;  
            System.out.println("error: " + urlString);  
        } finally {  
            con.disconnect();  
        } 
        return contentBuffer.toString();
    }
    
    public static String sendGet(String urlString, String param) throws UnsupportedEncodingException {
    	return sendGet(urlString,param,"UTF-8");
    }

	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);

			URLConnection conn = realUrl.openConnection();

			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			conn.setDoOutput(true);
			conn.setDoInput(true);

			out = new PrintWriter(conn.getOutputStream());

			out.print(param);

			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("POST error" + e);
			e.printStackTrace();
		}

		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static String getUrl(HttpServletRequest request, 
			String toParaName, String paraValue)
			throws UnsupportedEncodingException {
		String url = request.getRequestURL().toString();
		Enumeration<String> enu = request.getParameterNames();
		StringBuffer sb = new StringBuffer();
		while (enu.hasMoreElements()) {
			String paraName = enu.nextElement();
			if (!paraName.equals(toParaName)) {
				String val = request.getParameter(paraName);
				if(request.getMethod().equalsIgnoreCase("POST")) {
					val = new String(val.getBytes(request.getCharacterEncoding()), "UTF-8");
				} else {
					val = new String(val.getBytes("ISO8859-1"), "UTF-8");
				}
				sb.append(paraName
						+ "="
						+ URLEncoder.encode(val,
								"UTF-8"));
				sb.append("&");
			}
		}
		sb.append(toParaName + "=" + String.valueOf(paraValue));
		url = url + "?" + sb.toString();

		return url;
	}

	public static String getIPAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)
				|| ip == "0:0:0:0:0:0:0:1") {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	public static boolean isAjax(HttpServletRequest request)
	{
		String requestType = request.getHeader("X-Requested-With");
		if(requestType!=null&&requestType.equals("XMLHttpRequest"))
		{
			return true;
		}
		return false;
	}

}
