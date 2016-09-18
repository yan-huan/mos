package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

public class InventoryOutItemModel implements Serializable {
	/**
	 * @author hailin.liu 2016年5月17日 下午5:57:28 <br/>
	 */
	private static final long serialVersionUID = -1001605607139998302L;
	/** 库存商品code **/
	private String inventorySkuCode;
	/** 库存版本 **/
	private Integer version;
	/** 出库数量 **/
	private Integer quantity;
	
	
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
