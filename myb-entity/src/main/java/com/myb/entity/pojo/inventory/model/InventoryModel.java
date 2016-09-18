package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

/**
 * Description :库存 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午5:02:02 <br/>
 * @version 1.0
 */
public class InventoryModel implements Serializable {
	private static final long serialVersionUID = 3452504924675682272L;
	/** 库存名称 **/
	private String inventoryName;
	/** 某一种商品的库存总量 **/
	private Integer stockNumber;
	/** 商品成本 **/
	private Double inventoryProductCost;
	/** 库存版本 **/
	private Integer version;
	
	
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public Double getInventoryProductCost() {
		return inventoryProductCost;
	}
	public void setInventoryProductCost(Double inventoryProductCost) {
		this.inventoryProductCost = inventoryProductCost;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
