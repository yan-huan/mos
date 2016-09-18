package com.myb.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Description : code生成工具 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午6:59:18 <br/>
 * @version 1.0
 */
public class CodeUtil {
	
	private static int id = 1;
	
	public static String genCode(String businessModelName) {
		StringBuilder sb = new StringBuilder();
		sb.append(businessModelName).append("-").append(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		return sb.toString().toUpperCase();
	}
	
	public static String generateCode(String codeType) {
		String typeStr = codeType.substring(codeType.lastIndexOf(".") + 1).toUpperCase();
        String dateString = "";
        String code = typeStr + UUID.randomUUID().toString() + "UUID";
        if("FEED".equals(typeStr)) {
            return code;
        } else {
            try {
                SimpleDateFormat e = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
                dateString = e.format(new Date());
                code = typeStr + dateString + getSeq();
                return code;
            } catch (Exception var11) {
                return code;
            } finally {
                ;
            }
        }
	}
	
	private static synchronized int getSeq() {
        return id > 99999?(id = 1):++id;
    }
	
}
