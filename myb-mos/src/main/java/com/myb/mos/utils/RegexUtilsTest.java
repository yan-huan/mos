package com.myb.mos.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * 正则表达式工具类测试
 */ 
public class RegexUtilsTest { 
//     
//    /**
//     * 验证邮箱
//     */ 
    @Test 
    public void testCheckEmail() { 
//        boolean result = RegexUtils.checkMobile("15822112888"); 
    	String s = "15822112888";
    	s.substring(s.length()-6, s.length());
    	System.out.println(s.substring(s.length()-6, s.length()));
        boolean result =  RegexUtils.checkDigit("-8");
//        System.out.println(result);
//        Assert.assertTrue(result); 
    } 
    
    @Test 
    public void testCheckEmail1() { 
        boolean result = RegexUtils.checkMobileOrPhone("10225687894"); 
        boolean result1 = RegexUtils.checkMobileOrPhone("15225687894"); 
        boolean result2 = RegexUtils.checkMobileOrPhone("010-69485555"); 
        boolean result3 = RegexUtils.checkMobileOrPhone("69485555"); 
//        System.out.println(result);
//        System.out.println(result1);
//        System.out.println(result2);
//        System.out.println(result3);
    } 
//     
//    /**
//     * 验证身份证号码
//     */ 
//    @Test 
//    public void testCheckIdCard() { 
//        boolean result = RegexUtils.checkIdCard("432403193902273273"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证手机号码
//     */ 
//    @Test 
//    public void testCheckMobile() { 
//        boolean result = RegexUtils.checkMobile("+8613620285733"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证电话号码
//     */ 
//    @Test 
//    public void testCheckPhone() { 
//        boolean result = RegexUtils.checkPhone("+860738-4630706"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证整数（正整数和负整数）
//     */ 
//    @Test 
//    public void testCheckDigit() { 
//        boolean result = RegexUtils.checkDigit("123132"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证小数和整数（正负整数和正负小数）
//     */ 
//    @Test 
//    public void testCheckDecimals() { 
//        boolean result = RegexUtils.checkDecimals("-33.2"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证空白字符
//     */ 
//    @Test 
//    public void testCheckBlankSpace() { 
//        boolean result = RegexUtils.checkBlankSpace("           "); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 匹配中文
//     */ 
//    @Test 
//    public void testCheckChinese() { 
//        boolean result = RegexUtils.checkChinese("中文"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证日期
//     */ 
//    @Test 
//    public void testCheckBirthday() { 
//        boolean result = RegexUtils.checkBirthday("1992/09/03"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证中国邮政编码
//     */ 
//    @Test 
//    public void testCheckPostcode() { 
//        boolean result = RegexUtils.checkPostcode("417100"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证URL地址
//     */ 
//    @Test 
//    public  void testCheckURL() { 
//        boolean result = RegexUtils.checkURL("http://blog.csdn.com:80/xyang81/article/details?name=&abc=中文"); 
//        Assert.assertTrue(result); 
//    } 
//     
//    /**
//     * 验证IP地址
//     */ 
//    @Test 
//    public void testCheckIpAddress() { 
//        boolean result = RegexUtils.checkIpAddress("192.1.22.255"); 
//        Assert.assertTrue(result); 
//    } 
} 