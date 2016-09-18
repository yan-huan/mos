package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

public class InventoryStockCheckItemModel implements Serializable {
	private static final long serialVersionUID = -4074999900735770851L;
	/** 库存商品code **/
	private String inventorySkuCode;
	/** 实际库存数量 **/
	private Integer quantity;
	/** 现有库存 **/
	private Integer stockNumber;
	/** 差异数量 **/
	private Integer differenceQuantity;
	
	public String getInventorySkuCode() {
		return inventorySkuCode;
	}
	public void setInventorySkuCode(String inventorySkuCode) {
		this.inventorySkuCode = inventorySkuCode;
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
	public Integer getDifferenceQuantity() {
		return differenceQuantity;
	}
	public void setDifferenceQuantity(Integer differenceQuantity) {
		this.differenceQuantity = differenceQuantity;
	}
}
