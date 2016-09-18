package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class InventoryStockCheckModel implements Serializable {
	private static final long serialVersionUID = 5297222202083558590L;
	/** 库存code **/
	private String inventoryCode;
	/** 开始时间 **/
	private Integer startTime;
	/** 结束时间 **/
	private Integer endTime;
	/** 提交人code **/
	private String createUserCode;
	/** 提交人姓名 **/
	private String createUserName;
	/** 已处理，未处理 **/
	private String status;
	/** 异常数量 **/
	private Integer unNormalNumber;
	/** 盘点code **/
	private String stockCheckCode;
	/** 库存商品集合 **/
	private List<InventoryStockCheckItemModel> inventorySkuList = Lists.newArrayList();
	/** 盘点详情集合 **/
	private List<ProductBrandModel> stockCheckItemList = Lists.newArrayList();
	
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public String getCreateUserCode() {
		return createUserCode;
	}
	public void setCreateUserCode(String createUserCode) {
		this.createUserCode = createUserCode;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public List<InventoryStockCheckItemModel> getInventorySkuList() {
		return inventorySkuList;
	}
	public void setInventorySkuList(
			List<InventoryStockCheckItemModel> inventorySkuList) {
		this.inventorySkuList = inventorySkuList;
	}
	public List<ProductBrandModel> getStockCheckItemList() {
		return stockCheckItemList;
	}
	public void setStockCheckItemList(List<ProductBrandModel> stockCheckItemList) {
		this.stockCheckItemList = stockCheckItemList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUnNormalNumber() {
		return unNormalNumber;
	}
	public void setUnNormalNumber(Integer unNormalNumber) {
		this.unNormalNumber = unNormalNumber;
	}
	public String getStockCheckCode() {
		return stockCheckCode;
	}
	public void setStockCheckCode(String stockCheckCode) {
		this.stockCheckCode = stockCheckCode;
	}
}
