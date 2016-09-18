/**
 * @FileName: DataConvert.java
 * @Package com.sfbest.crontab.service
 * 
 * @author bushujie
 * @created 2013-4-10 下午2:07:52
 * 
 * Copyright 2011-2015 顺丰优选 版权所有
 */
package com.myb.commons.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Description : 时间转换工具 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月21日 下午5:39:41 <br/>
 * @version 1.0
 */
public class DateConvert {

	public static SimpleDateFormat sFormat2 = new SimpleDateFormat("yyyy-MM-dd");

	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	/**
	 * 月份加减
	 * @author hailin.liu 2016年5月21日 下午5:40:03 <br/>
	 * @param date
	 * @param month
	 * @return
	 */
	public static Integer getFrontMonth(Date date, int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, month);
		return (int) (c.getTime().getTime() / 1000);
	}

	/**
	 * 当日指定时间
	 * @author hailin.liu 2016年5月21日 下午5:40:23 <br/>
	 * @param date
	 * @param timeStr
	 * @return
	 */
	public static Date getWeeHours(Date date, String timeStr) {
		String dateStr = sFormat2.format(date);
		try {
			return df.parse(dateStr + timeStr);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 日期加减天数
	 * @author hailin.liu 2016年5月21日 下午5:40:55 <br/>
	 * @param day
	 * @param date
	 * @return
	 */
	public static Date getDateToDay(int day, Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}
	
	/**
	 * 获得N年前的日期
	 * @author hailin.liu 2016年5月21日 下午5:41:05 <br/>
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getDateNYearsAgo(Date date, Integer n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, -n);
		return c.getTime();
	}
	
	/**
	 * n个月前的日期
	 * @author hailin.liu 2016年5月21日 下午5:41:30 <br/>
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getDateNMonthsAgo(Date date, Integer n) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -n);
		return c.getTime();
	} 
	
	
	/**
	 * 测试
	 * @author hailin.liu 2016年5月21日 下午5:43:15 <br/>
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getDateToDay(-1, new Date()));
	}

}
