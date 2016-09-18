package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

/**
 * 
 * Description : 根据入库单号查询入库单详情时返回的入库单明细 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月17日 下午1:34:46 <br/>
 * @version 1.0
 */
public class InventoryItemModel implements Serializable {
	private static final long serialVersionUID = -816480463663158399L;
	/** 商品品牌code **/
	private String productBrandCode;
	/** 商品品牌名称 **/
	private String productBrandName;
	/** 商品code **/
	private String productCode;
	/** 商品名称 **/
	private String productName;
	/** 库存数量 **/
	private Integer stockNumber;
	/** 入库数量 **/
	private Integer quantity;
	/** 进货价 **/
	private Double singlePrice;
	/** 生产日期 **/
	private Integer productionTime;
	
	
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
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(Double singlePrice) {
		this.singlePrice = singlePrice;
	}
	public Integer getProductionTime() {
		return productionTime;
	}
	public void setProductionTime(Integer productionTime) {
		this.productionTime = productionTime;
	}
}
