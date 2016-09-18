package com.myb.mos.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间工具类
 * 
 * @author cjw
 * 
 */
public final class DateUtil {
	public static final String FORMATE_STYLE_DATA_SHORT = "yyyy-MM-dd";
	public static final String FORMATE_STYLE_DATA_COMMON = "yyyyMMdd";
	public static final String FORMATE_STYLE_DATA_STAMP = "yyyyMMddHHmmssSSS";
	public static final String FORMATE_STYLE_DATESTAMP = "yyyyMMddHHmmss";
	
	public static final String FORMATE_STYLE_DATA_LONG = "yyyy-MM-dd HH:mm:ss";
	public static final String no_miao = "yyyy-MM-dd HH:mm";

	private static DateUtil instance = null;

	public static DateUtil getInstance() {
		if (instance == null) {
			instance = new DateUtil();
		}
		return instance;
	}

	private DateUtil() {
	}

	/**
	 * 当前时间
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * convert string to date, with default pattern,throws ParseException
	 * 
	 * @param strDate
	 *            the str date
	 * @return date
	 */
	public static Date strToDate(String strDate) {
		return strToDate(strDate, no_miao);
	}

	public static Date toSimpleDateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATE_STYLE_DATA_LONG);
		return strToDate(sdf.format(date), FORMATE_STYLE_DATA_LONG);
	}

	/**
	 * convert string to date ,with custom pattern,throws
	 * IllegalArgumentException
	 * 
	 * @param strDate
	 * @param format
	 *            format style such as yyyy-MM-dd
	 * @return the date.
	 */
	public static Date strToDate(String strDate, String format) {
		if (strDate == null || "".equals(strDate)) {
			return null;
		}
		Date result = null;
		try {
			SimpleDateFormat formater = new SimpleDateFormat(format);
			result = formater.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException("String To Date Convert Error", e);
		}
		return result;
	}

	/**
	 * Date to String format as CEMConstants.FORMATE_STYLE_DATA("yyyy-MM-dd").
	 * 
	 * @param date
	 * @return the string value format as
	 *         CEMConstants.FORMATE_STYLE_DATA("yyyy-MM-dd").
	 */
	public static String dateToShortStr(Date date) {
		return dateToStr(date, FORMATE_STYLE_DATA_SHORT);
	}

	public static String dateToLongStrNomiao(Date date) {
		return dateToStr(date, no_miao);
	}
	
	public static String dateToComStr(Date date) {
		return dateToStr(date, FORMATE_STYLE_DATA_COMMON);
	}

	public static String dateToLongStr(Date date) {
		return dateToStr(date, FORMATE_STYLE_DATA_LONG);
	}

	public static String dateToTimestampStr(Date date) {
		return dateToStr(date, FORMATE_STYLE_DATESTAMP);
	}
	 
	public static String dateToLongStr(Date date, Integer hour, Integer minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hour == null ? 0 : hour);
		cal.set(Calendar.MINUTE, minute == null ? 0 : minute);
		cal.set(Calendar.SECOND, 0);

		return dateToLongStr(cal.getTime());
	}

	/**
	 * Date to String accroding to the format.
	 * 
	 * @param date
	 *            date
	 * @param format
	 *            format
	 * @return the string format of the data value.
	 */
	public static String dateToStr(Date date, String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(date);
	}

	/**
	 * 获得给定时间的00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dealwithDateNull(date));
		

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startTime = calendar.getTime();
		return startTime;
	}

	/**
	 * 获得当天的开始时间00:00:00
	 * 
	 * @return
	 */
	public static Date getTodayStart() {
		return getStartTime(now());
	}

	/**
	 * 获得当天的结束时间23:59:59
	 * 
	 * @return
	 */
	public static Date getTodayEnd() {
		return getEndTime(now());
	}

	/**
	 * 获得给定时间的23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dealwithDateNull(date));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date startTime = calendar.getTime();
		return startTime;
	}

	/**
	 * Deal with the date -- if the date is null then return the current time
	 * otherwise return itself.
	 * 
	 * @param date
	 *            date
	 * @return date
	 */
	public static Date dealwithDateNull(Date date) {
		if (date == null) {
			return new Date();
		}
		return date;
	}

	/**
	 * 获得当前年份，例如2012
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		SimpleDateFormat yearFm = new SimpleDateFormat("yyyy");
		return Integer.parseInt(yearFm.format(date));
	}

	/**
	 * 获得当前月份，例如08
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date) {
		SimpleDateFormat monthFm = new SimpleDateFormat("MM");
		return monthFm.format(date);
	}

	/**
	 * 获得当前日期（不包括年月），例如17
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(Date date) {
		SimpleDateFormat dayFm = new SimpleDateFormat("DD");
		return Integer.parseInt(dayFm.format(date));
	}
	/**
	 * 获取月—日
	 * @param date
	 * @return
	 */
     public static String getMonthDay(Date date){
    	 SimpleDateFormat dayFm = new SimpleDateFormat("MM-dd");
    	 return dayFm.format(date).toString();
     }
     public static String getHHmm(Date date){
    	 SimpleDateFormat dayFm = new SimpleDateFormat("HH:mm");
    	 return dayFm.format(date).toString();
     }
     /**
      * 获得小时数字
      * @param date
      * @return
      */
     public static int getHour(Date date){
    	 SimpleDateFormat dayFm = new SimpleDateFormat("HH");
    	 return Integer.parseInt(dayFm.format(date));
     }
	/**
	 * 传进数字返回**小时**分钟
	 * 
	 */
	public static String getHHMM(Integer ss) {
		String str = "";
		if (ss != null) {
			int HH = ss / (60 * 60);
			int MM = (ss - HH * 60 * 60) / 60;
			str = HH + "小时" + MM + "分钟";
		} else {
			str = "0小时0分钟";
		}
		return str;
	}

	// java获取当前时间的前后N天
	public static Date getDay(Date date, Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();
		return date;
	}

	// java获取当前时间的前后N月
	public static Date getDayByMonth(Date date, Integer month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		date = calendar.getTime();
		return date;
	}

	/**
	 * 比较两个时间
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 * DATE1<DATE2 -1;DATE1>DATE2 1;DATE1=DATE 0
	 */
	public static int compare_date(Date DATE1, Date DATE2) {
		try {
			if (DATE1.getTime() > DATE2.getTime()) {
				return 1;
			} else if (DATE1.getTime() < DATE2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 比较两个时间
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 * DATE1<DATE2 -1;DATE1>DATE 1;DATE1=DATE 0
	 */
	public static int compare_date(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat(FORMATE_STYLE_DATA_LONG);
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	public static int compare_date_day(String DATE1, String DATE2) {

		DateFormat df = new SimpleDateFormat(FORMATE_STYLE_DATA_SHORT);
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	/**
	 * 比较两个时间
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 * DATE1<DATE2 -1;DATE1>DATE 1;DATE1=DATE 0
	 */
	public static int compare_date_short(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat(FORMATE_STYLE_DATA_SHORT);
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 在时间节点上增加天数,并比较时间
	 * @param sourceDate
	 * @param day
	 * @return -1传入时间小于当前系统时间, 0等 于, 1大于
	 */
	public static int plusDayToCompare(Date sourceDate, int day) {
		Calendar sysDate = Calendar.getInstance();
		Calendar plusDate = Calendar.getInstance();
		plusDate.setTime(sourceDate);
		plusDate.add(Calendar.DATE, day);
		return plusDate.compareTo(sysDate);
	}
	
	/**
	 * 在时间节点上增加天数,返回增加后的时间
	 * @param sourceDate
	 * @param day
	 * @return
	 * @throws ParseException 
	 */
	public static Date getPlusDay(Date sourceDate, int day) throws ParseException {
		Calendar plusDate = Calendar.getInstance();
		plusDate.setTime(sourceDate);
		plusDate.add(Calendar.DATE, day);
		Date date = plusDate.getTime();
		String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf);
	}
	
	/**
	 * 日期筛选条件数据减日期值，返回减去的时间
	 * @param type 筛选时间  0:最近一周   1:一月   2:一年
	 * @return
	 */
	public static String getSubDate(int type) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		if (type == 0) 
			calendar.add(Calendar.DATE, -7);
		else if (type == 1)
			calendar.add(Calendar.MONTH, -1);
		else if (type == 2)
			calendar.add(Calendar.YEAR, -1);
		return sdf.format(calendar.getTime());
	}

	  public static Date getScheduleStartTime(){
		  Date date = new Date();
		  
		  return date;
	  }
	  public static Date strCTSToDate(String CTS){
		  SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
		  Date date=null;
		try {
			date = (Date) sdf.parse(CTS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return date;
	  }
	  /**
	   * 根据参数日期判断是今天、明天、后天分别0,1,2代表。3代表都不是
	   * @param date
	   * @return
	   */
	  public static String isTodayOrTom(Date date){
		  Date today=now();
		  Date tommorow=getDay(today, 1);//明天
		  Date tat= getDay(today, 2);//后天
		  String nowMonthDay =getMonthDay(today);
		  String compMonthDay = getMonthDay(date);
		  if(nowMonthDay.equals(compMonthDay)){
			  return "今天";
		  }else if(getMonthDay(tommorow).equals(compMonthDay)){
			  return "明天";
		  }else if(getMonthDay(tat).equals(compMonthDay)){
			  return "后天";
		  }else{
			  return "";
		  }
	  } 
	  public static boolean isStartToday(){
		  Date startDate = DateUtil.now();
			Date endTime =null;
			startDate = DateUtil.toSimpleDateFormat(startDate);
			//判断startTime是今天还是第二天开始算起
			boolean flag =true;
			if(DateUtil.getHour(startDate)>17){//从第二天以后开始算5天
				flag=true;
			 };
			 return flag;
	  }
	  public static int getWeekDay(String day){
		  Calendar c = Calendar.getInstance();
			 Date week =strCTSToDate(day);
			 c.setTime(DateUtil.getDay(week, -1));
			int weekDay = c.get(Calendar.DAY_OF_WEEK);//拿到是周几
		  return weekDay;
	  }
	  public static String getMonthFirstDay(int monthStep){
		  Calendar c = Calendar.getInstance();    
			SimpleDateFormat sdf = new SimpleDateFormat(FORMATE_STYLE_DATA_SHORT);
	        c.add(Calendar.MONTH, 1);
	        c.set(Calendar.DAY_OF_MONTH,monthStep);//设置为几，则为几月后第一天，0为本月第一天，1，为一个月第一天
	        String first = sdf.format(c.getTime());
	        return first;
	  }
	public static void main(String args[]) throws ParseException {
		 Calendar c = Calendar.getInstance();    
			SimpleDateFormat sdf = new SimpleDateFormat(FORMATE_STYLE_DATA_SHORT);
	        c.add(Calendar.MONTH, 1);
	        c.set(Calendar.DAY_OF_MONTH,0);//设置为0号,当前日期既为本月第一天 
	        String first = sdf.format(c.getTime());
	        System.out.println("===============first:"+first);
	}

}
