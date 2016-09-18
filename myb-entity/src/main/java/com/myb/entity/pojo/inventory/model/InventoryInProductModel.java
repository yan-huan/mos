package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

/**
 * 
 * Description : 入库单商品信息 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月16日 下午5:52:14 <br/>
 * @version 1.0
 */
public class InventoryInProductModel implements Serializable {
	private static final long serialVersionUID = 8384699069573541530L;
	/** 版本 **/
	private Integer version;
	/** 商品品牌code **/
	private String productBrandCode;
	/** 商品code **/
	private String productCode;
	/** 商品生产日期 **/
	private Integer productionTime;
	/** 商品有效期 **/
	private Integer productExpiredime;
	/** 商品单价 **/
	private Double singlePrice;
	/** 数量 **/
	private Integer quantity;
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getProductBrandCode() {
		return productBrandCode;
	}
	public void setProductBrandCode(String productBrandCode) {
		this.productBrandCode = productBrandCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getProductionTime() {
		return productionTime;
	}
	public void setProductionTime(Integer productionTime) {
		this.productionTime = productionTime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getProductExpiredime() {
		return productExpiredime;
	}
	public void setProductExpiredime(Integer productExpiredime) {
		this.productExpiredime = productExpiredime;
	}
	public Double getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(Double singlePrice) {
		this.singlePrice = singlePrice;
	}
}
