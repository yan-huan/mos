package com.myb.mos.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	public static String  getDutyName(String key){
		Map<Integer,String> duty = new HashMap<Integer,String>();
		duty.put(1, "老板");
		duty.put(2,"店长");
		duty.put(3, "前台");
		duty.put(4,"服务员");
		duty.put(5,"其他");
		return duty.get(key);
	}
	public static int  getClientLevelNum(String key){
		Map<String,Integer> duty = new HashMap<String,Integer>();
		duty.put("A", 4);
		duty.put("B", 3);
		duty.put("C", 2);
		duty.put("D", 1);
		return duty.get(key);
	}
}
