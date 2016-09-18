package com.myb.framework.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	public static String join(String[] strings, String separator) {
		int len = strings.length;
		int i = 0;
		StringBuffer sbBuffer = new StringBuffer();
		for (String str : strings) {
			sbBuffer.append(str);
			if (i != len - 1) {
				sbBuffer.append(separator);
			}
			i++;
		}
		return sbBuffer.toString();
	}

	public static boolean isNullOrEmpty(String str) {
		if (str == null) {
			return true;
		}
		if (str.equals("")) {
			return true;
		}
		return false;
	}

	public static String trimEnd(String str, String suffix) {
		if (str != null) {
			if (str.endsWith(suffix)) {
				str = str.substring(0, str.length() - suffix.length());
			}
		}
		return str;
	}
	
	public static String trimStart(String str, String prefix) {
		if (str != null) {
			if (str.startsWith(prefix)) {
				str = str.substring(prefix.length());
			}
		}
		return str;
	}

	public static String ToDateString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateString = sdf.format(date);
		return dateString;

	}

	public static String EncodeUTF8(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

}
