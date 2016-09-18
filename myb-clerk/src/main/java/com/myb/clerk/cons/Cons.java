package com.myb.clerk.cons;

public interface Cons {
	public static String STATUS_INIT = "INIT";//初始化
    public static String STATUS_NORMAL = "NORMAL";//正常使用中
    public static String STATUS_LOCKED = "LOCKED";//锁定
    public static String STATUS_DELETED = "DELETED";//逻辑删除
    public static String STATUS_YOULI = "YOULI";
    
    public static final Short GENDER_WEIZHI = 0;//未知
    public static final Short GENDER_NAN = 1;//男性
    public static final Short GENDER_NV = 2;//女性
    public static final Short GENDER_BAOMI = 3;//保密
    public static final Short GENDER_QUANBU  = 4;//全部，红包适用范围
    
  //证件类型
    public static final String CARD_TYPE_SHENGFENZHENG = "SHENFENZHENG";//身份证
    
    public static String CLERK_TITLE_MEIRONGSHI = "MEIRONGSHI";	//美容师
}
