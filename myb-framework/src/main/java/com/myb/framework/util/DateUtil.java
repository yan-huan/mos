package com.myb.framework.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Date addDays(Date date,int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);
		return calendar.getTime();
	}
	
	public static Date addHours(Date date,int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hours);
		return calendar.getTime();
	}
	
	public static Date addMinute(Date date,int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minutes);
		return calendar.getTime();
	}
	
	public static Date addSecond(Date date,int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) + seconds);
		return calendar.getTime();
	}
	
	public static Date convertToDate(String dataString,String format) throws java.text.ParseException {
		   SimpleDateFormat formatDate = new SimpleDateFormat(format);
		    Date date = formatDate.parse(dataString);
	        return date;
	}
	
	public static String simpleDate(java.sql.Timestamp date){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(date.getTime()));
	}

}
