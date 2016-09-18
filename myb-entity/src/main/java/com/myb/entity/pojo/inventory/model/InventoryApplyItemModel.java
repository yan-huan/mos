package com.myb.entity.pojo.inventory.model;

public class InventoryApplyItemModel {
	/** 库存商品code **/
	private String inventorySkuCode;
	/** 数量 **/
	private Integer quantity;
	/** 库存版本 **/
	private Integer version;
	
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
