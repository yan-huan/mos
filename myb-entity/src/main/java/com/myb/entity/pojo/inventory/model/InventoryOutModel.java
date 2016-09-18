package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 
 * Description : 商品出库接口需要的参数 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月17日 下午5:38:11 <br/>
 * @version 1.0
 */
public class InventoryOutModel implements Serializable {
	private static final long serialVersionUID = 2813395201654087216L;
	/** 出库类型：手动出库，扫码出库，下发到店，销售出库 **/
	private String outType;
	/** 出库方式：美容师领取，调配仓 **/
	private String outPattern;
	/** 出库仓：院装，客装 **/
	private String productType;
	/** 原始单据号 **/
	private String originalDocument;
	/** 出库人code **/
	private String createUserCode;
	/** 出库人姓名 **/
	private String createUserName;
	/** 接收方code **/
	private String toCode;
	/** 接收方姓名 **/
	private String toName;
	/** 库存code **/
	private String inventoryCode;
	/** 库存名称 **/
	private String inventoryName;
	/** 库存类型：父仓、子仓 **/
	private String inventoryType;
	/** 经手人code **/
	private String jingshourenCode;
	/** 经手人姓名 **/
	private String jingshourenName;
	/** 出库商品集合 **/
	private List<InventoryOutItemModel> inventoryOutItems = Lists.newArrayList();
	
	
	public String getOutType() {
		return outType;
	}
	public void setOutType(String outType) {
		this.outType = outType;
	}
	public String getOutPattern() {
		return outPattern;
	}
	public void setOutPattern(String outPattern) {
		this.outPattern = outPattern;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getOriginalDocument() {
		return originalDocument;
	}
	public void setOriginalDocument(String originalDocument) {
		this.originalDocument = originalDocument;
	}
	public String getCreateUserCode() {
		return createUserCode;
	}
	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getToCode() {
		return toCode;
	}
	public void setToCode(String toCode) {
		this.toCode = toCode;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getJingshourenCode() {
		return jingshourenCode;
	}
	public void setJingshourenCode(String jingshourenCode) {
		this.jingshourenCode = jingshourenCode;
	}
	public String getJingshourenName() {
		return jingshourenName;
	}
	public void setJingshourenName(String jingshourenName) {
		this.jingshourenName = jingshourenName;
	}
	public List<InventoryOutItemModel> getInventoryOutItems() {
		return inventoryOutItems;
	}
	public void setInventoryOutItems(List<InventoryOutItemModel> inventoryOutItems) {
		this.inventoryOutItems = inventoryOutItems;
	}
	public String getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
}
