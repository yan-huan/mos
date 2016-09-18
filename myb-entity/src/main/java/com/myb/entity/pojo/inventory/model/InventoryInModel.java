package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 
 * Description : 入库参数 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午5:48:44 <br/>
 * @version 1.0
 */
public class InventoryInModel implements Serializable {
	private static final long serialVersionUID = 7678084865562218309L;
	/** 原始单号 **/
	private String originalDocument;
	/** 入库来源code **/
	private String fromCode;
	/** 商品类型：院装，客装 **/
	private String productType;
	/** 仓库code **/
	private String inventoryCode;
	/** 仓库名称 **/
	private String inventoryName;
	/** 库存类型：1父仓，2子仓 **/
	private String inventoryType;
	/** 入库类型 **/
	private String inType;
	/** 入库人code **/
	private String createUserCode;
	/** 入库人姓名 **/
	private String createUserName;
	/** 入库的商品信息 **/
	private List<InventoryInProductModel> inventoryInProductModels = Lists.newArrayList();
	
	
	public String getOriginalDocument() {
		return originalDocument;
	}
	public void setOriginalDocument(String originalDocument) {
		this.originalDocument = originalDocument;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getInType() {
		return inType;
	}
	public void setInType(String inType) {
		this.inType = inType;
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
	public List<InventoryInProductModel> getInventoryInProductModels() {
		return inventoryInProductModels;
	}
	public void setInventoryInProductModels(
			List<InventoryInProductModel> inventoryInProductModels) {
		this.inventoryInProductModels = inventoryInProductModels;
	}
	public String getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}
	public String getFromCode() {
		return fromCode;
	}
	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
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
