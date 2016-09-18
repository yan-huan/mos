package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

import com.myb.framework.data.EntityBase;

/**
 * 
 * Description : 院装或客装库存详情 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午12:29:25 <br/>
 * @version 1.0
 */
public class InventorySkuModel extends EntityBase implements Serializable  {
	private static final long serialVersionUID = 1683412821052192669L;
	
	/** 商品品牌code **/
	private String productBrandCode;
	/** 商品品牌名称 **/
	private String productBrandName;
	/** 商品code **/
	private String productCode;
	/** 商品名称 **/
	private String productName;
	/** 商品单位 **/
	private String productUnit;
	/** 现有库存 **/
	private Integer stockNumber;
	/** 商品单价 **/
	private Double marketPrice;
	/** 库存版本号 **/
	private Integer version;
	/** 库存类型：院装，客装 **/
	private String productType;
	
	public String getProductBrandCode() {
		return productBrandCode;
	}
	public void setProductBrandCode(String productBrandCode) {
		this.productBrandCode = productBrandCode;
	}
	public String getProductBrandName() {
		return productBrandName;
	}
	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}
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
	public Double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
}
