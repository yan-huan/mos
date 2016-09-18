package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

public class InventoryOutItemResultModel implements Serializable {
	private static final long serialVersionUID = -4726753821750221423L;
	/** 商品品牌名称 **/
	private String productBrandName;
	/** 商品名称 **/
	private String productName;
	/** 出库数量 **/
	private Integer quantity;
	/** 剩余库存 **/
	private Integer stockNumber;
	
	
	public String getProductBrandName() {
		return productBrandName;
	}
	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	
}