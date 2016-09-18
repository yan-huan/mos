package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;

public class InventoryStockCheckItemResultModel implements Serializable {
	private static final long serialVersionUID = 1021922699104355999L;
	/** 盘点详情code **/
	private String stockCheckItemCode;
	/** 商品品牌名称 **/
	private String productBrandName;
	/** 商品品牌code **/
	private String productBrandCode;
	/** 商品名称 **/
	private String productName;
	/** 商品code **/
	private String productCode;
	/** 库存数量 **/
	private Integer stockQuantity;
	/** 实际库存数量 **/
	private Integer factQuantity;
	/** 差异数量 **/
	private Integer differenceuantity;
	/** 库存状态：盘盈，盘亏 **/
	private String type;
	/** 库存商品code **/
	private String inventorySkuCode;
	/** 库存版本 **/
	private Integer version;
	
	
	public String getStockCheckItemCode() {
		return stockCheckItemCode;
	}
	public void setStockCheckItemCode(String stockCheckItemCode) {
		this.stockCheckItemCode = stockCheckItemCode;
	}
	public String getProductBrandName() {
		return productBrandName;
	}
	public void setProductBrandName(String productBrandName) {
		this.productBrandName = productBrandName;
	}
	public String getProductBrandCode() {
		return productBrandCode;
	}
	public void setProductBrandCode(String productBrandCode) {
		this.productBrandCode = productBrandCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInventorySkuCode() {
		return inventorySkuCode;
	}
	public void setInventorySkuCode(String inventorySkuCode) {
		this.inventorySkuCode = inventorySkuCode;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Integer getFactQuantity() {
		return factQuantity;
	}
	public void setFactQuantity(Integer factQuantity) {
		this.factQuantity = factQuantity;
	}
	public Integer getDifferenceuantity() {
		return differenceuantity;
	}
	public void setDifferenceuantity(Integer differenceuantity) {
		this.differenceuantity = differenceuantity;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
}
