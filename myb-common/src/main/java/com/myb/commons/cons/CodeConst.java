package com.myb.commons.cons;

/**
 * Description : 系统使用的错误编码 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年4月13日 上午11:04:22 <br/>
 * @version 1.0
 */
public interface CodeConst {
	/** 未知错误 **/
	public static final String UNKNOW_ERROR=  "-1";
	/** 成功 **/
	public static final String SUCCESS = "1000000";
	/** 用户ID为空 **/
	public static final String USER_ID_NULL_ERROR = "1000001";
	

	/** 父仓code为空 **/
	public static final String PARENT_CODE_NULL_ERROR = "1000002";
	/** 仓库类型为空 **/
	public static final String INVENTORY_TYPE_NULL_ERROR = "1000003";
	/** 商品类型为空 **/
	public static final String PRODUCT_TYPE_NULL_ERROR = "1000004";
	/** 商品code为空 **/
	public static final String PRODUCT_CODE_NULL_ERROR = "1000005";
	/** 入库单号为空 **/
	public static final String IN_CODE_NULL_ERROR = "1000006";
	/** 页码为空 **/
	public static final String PAGE_NULL_ERROR = "1000007";
	/** 子仓code为空 **/
	public static final String CHILD_CODE_NULL_ERROR = "1000008";
	/** 库存商品code为空 **/
	public static final String SKU_CODES_NULL_ERROR = "1000009";
	/** 库存发生变化 **/
	public static final String STOCK_VERSION_ERROR = "1000010";
	/** 出库单号为空 **/
	public static final String OUT_CODE_NULL_ERROR = "1000011";
	/** 盘点code为空 **/
	public static final String STOCK_CHECK_CODE_NULL_ERROR = "1000012";
	/** 盘点明细code为空 **/
	public static final String STOCK_CHECK_ITEM_CODE_NULL_ERROR = "1000013";
	/** 商品版本号为空 **/
	public static final String VERSION_NULL_ERROR = "1000014";
	/** 差异数量为空 **/
	public static final String DIFFERENCE_QUANTITY_NULL_ERROR = "1000015";
	/** 盘盈盘亏code为空 **/
	public static final String PRODFIT_SHORTAGES_CODE_NULL_ERROR = "1000016";
	/** 库存code为空 **/
	public static final String INVENTORY_CODE_NULL_ERROR = "1000017";
	/** 申请单code为空 **/
	public static final String APPLY_CODE_NULL_ERROR = "1000018";
	/** 状态为空 **/
	public static final String STATUS_NULL_ERROR = "1000019";
	/** 用户code为空 **/
	public static final String USER_CODE_NULL_ERROR = "1000020";
	/** 用户姓名为空 **/
	public static final String USER_NAME_NULL_ERROR = "1000021";
	/** 父仓名称为空 **/
	public static final String PARENT_NAME_NULL_ERROR = "1000022";
	/** 被申请方code为空 **/
	public static final String TO_CODE_NULL_ERROR = "1000023";
	/**  被申请方名称为空 **/
	public static final String TO_NAME_NULL_ERROR = "1000024";
	/** 类型为空 **/
	public static final String TYPE_NULL_ERROR = "1000025";
	/** 数量为空 **/
	public static final String QUANTITY_NULL_ERROR = "1000026";
	/** 提醒code为空 **/
	public static final String WARNNING_CODE_NULL_ERROR = "1000027";
	
	/** 帐号已存在 **/
	public static final String CLERK_LOGIN_ACCOUNT_EXIST_ERROR = "1000028";
	/** 账号不存在 **/
	public static final String CLERK_NULL_ERROR = "1000029";
	
	/** 库存不存在 **/
	public static final String INVENTORY_NOT_EXIST_ERROR = "1000030";
	/** 商品品牌code为空 **/
	public static final String PRODUCT_BRAND_CODE_NULL_ERRO = "1000031";
	
	/** 服务器内部错误 **/
	public static final String INTERNAL_ERROR = "9999997";
	/** 访问路径不存在 **/
	public static final String NO_SUCH_METHOD_FIND_ERROR = "9999998";
	/** 系统异常 **/
	public static final String SYSTEM_ERROR = "9999999";
	
	
}
