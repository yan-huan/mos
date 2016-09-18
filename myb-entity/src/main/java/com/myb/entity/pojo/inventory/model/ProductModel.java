package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

/**
 * 
 * Description : 商品信息 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午1:27:29 <br/>
 * @version 1.0
 */
public class ProductModel implements Serializable {
	private static final long serialVersionUID = 1604074848116394616L;
	/** 商品code **/
	private String productCode;
	/** 商品名称 **/
	private String productName;
	/** 商品单位 **/
	private String productUnit;
	/** 现有库存 **/
	private Integer stockNumber;
	/** 实际库存数量 **/
	private Integer factStockNumber;
	/** 已平仓，未平仓 **/
	private String status;
	/** 商品总成本 **/
	private Double productCost;
	/** 版本 **/
	private Integer version;
	/** 库存商品code **/
	private String inventorySkuCode;
	/** 盘点明细code **/
	private String stockCheckItemCode;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public Double getProductCost() {
		return productCost;
	}
	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getInventorySkuCode() {
		return inventorySkuCode;
	}
	public void setInventorySkuCode(String inventorySkuCode) {
		this.inventorySkuCode = inventorySkuCode;
	}
	public Integer getFactStockNumber() {
		return factStockNumber;
	}
	public void setFactStockNumber(Integer factStockNumber) {
		this.factStockNumber = factStockNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStockCheckItemCode() {
		return stockCheckItemCode;
	}
	public void setStockCheckItemCode(String stockCheckItemCode) {
		this.stockCheckItemCode = stockCheckItemCode;
	}
}
