package com.myb.mos.utils;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
/**
 * Copyright 2007 GuangZhou Cotel Co. Ltd.
 * All right reserved.    
 * DES加密解密类.     
 * @version 1.0 
 * Creation date: 2007-7-31 - 上午11:59:28
 */
public class BaseProUtill {
  
//	public static String httpUrl="http://101.201.76.14:8003";//正式
//	public static String httpUrl="http://192.168.1.119:8080/myb-web";
	public static String httpUrl="http://101.201.42.115:8080/myb-web";//测试
//	public static String httpCrmUrl="http://192.168.2.108:8989/myb-mos-api";//crm的http
//	public static String httpCrmUrl="http://101.201.42.115:8989/myb-mos-api";//crm的http
	public static String httpCrmUrl="http://60.205.94.254:8989/myb-mos-api";//crm的http测试
	
}