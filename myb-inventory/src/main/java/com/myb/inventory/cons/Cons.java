package com.myb.inventory.cons;

/**
 * 
 * Description : 常量 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午6:40:47 <br/>
 * @version 1.0
 */
public interface Cons {
	/** 正常状态 **/
	public static final String STATUS_NORMAL = "NORMAL";
	/** 失败状态 **/
	public static final String STATUS_FAIL = "FAIL";
	/** 等待到店 **/
	public static final String STATUS_XIAFADAODIANWAIT = "XIAFADAODIANWAIT";
	/** 下发到店完成 **/
	public static final String STATUS_XIAFADAODIANSUCCESS = "XIAFADAODIANSUCCESS";
	/** 下发到店拒绝 **/
	public static final String STATUS_XIAFADAODIANREJECT = "XIAFADAODIANREJECT";
	/** 待我审批 **/
	public static final String STATUS_DAIWOSHENPI = "DAIWOSHENPI";
	
	/** 父仓 **/
	public static final String INVENTORY_PARENT = "INVENTORY_PARENT";
	/** 子仓 **/
	public static final String INVENTORY_CHILD = "INVENTORY_CHILD";
	
	/** 采购入库 **/
	public static final String CAIGOURUKU = "CAIGOURUKU";
	/** 人工出库 **/
	public static final String RENGONGCHUKU = "RENGONGCHUKU";
	/** 销售出库 **/
	public static final String XIAOSHOUCHUKU = "XIAOSHOUCHUKU";
	/** 下发到店 **/
	public static final String XIAFADAODIAN = "XIAFADAODIAN";
	/** 申请入库 **/
	public static final String SHENQINGRUKU = "SHENQINGRUKU";
	
	
	/** 已平仓 **/
	public static final String STOCK_CHECK_COVER = "STOCK_CHECK_COVER";
	/** 未平仓 **/
	public static final String  UN_STOCK_CHECK_COVER = "UN_STOCK_CHECK_COVER";
	
	/** 盘盈 **/
	public static final String PROFIT = "PROFIT";
	/** 盘亏 **/
	public static final String SHORTAGES = "SHORTAGES";
	
	/** 院装 **/
	public static final String PRODUCT_COMPANY = "PRODUCT_COMPANY";
	/** 客装 **/
	public static final String PRODUCT_CUSTOM = "PRODUCT_CUSTOM";
	
	/** 未处理 **/
	public static final String UN_PROCESS = "UN_PROCESS";
	/** 已处理 **/
	public static final String PROCESS = "PROCESS";
	
	/** 每页默认显示记录数 **/
	public static final int PAGE_SIZE = 10;
	
	/** 商品 **/
	public static final String PRODUCT = "PRODUCT";

	/** 未发送 **/
	public static final String UNSEND = "UNSEND";
	/** 已发送 **/
	public static final String SENDED = "SENDED";
	/** 存量提醒 **/
	public static final String STOCK_WARNNING = "STOCK_WARNNING";
	/** 未读 **/
	public static final String UN_READ = "UN_READ";
	/** 已读 **/
	public static final String READED = "READED";
	
	/** 已支付 **/
	public static final Object PAYED = "PAYED";

	/** 系统操作 **/
	public static final String SYSTEM = "SYSTEM";
	
}
