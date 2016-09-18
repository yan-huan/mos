package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class InventoryStockCheckResultModel implements Serializable {
	private static final long serialVersionUID = 4716757687875543131L;
	/** 开始时间 **/
	private Integer startTime;
	/** 结束时间 **/
	private Integer endTime;
	/** 盘点详情集合 **/
	private List<ProductBrandModel> stockCheckItemList = Lists.newArrayList();
	
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
	public List<ProductBrandModel> getStockCheckItemList() {
		return stockCheckItemList;
	}
	public void setStockCheckItemList(
			List<ProductBrandModel> stockCheckItemList) {
		this.stockCheckItemList = stockCheckItemList;
	}
}
