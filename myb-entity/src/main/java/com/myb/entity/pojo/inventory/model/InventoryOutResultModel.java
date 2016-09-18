package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class InventoryOutResultModel implements Serializable {
	private static final long serialVersionUID = 4101674027830911586L;
	/** 出库单编码 **/
	private String outCode;
	/** 原始单据号 **/
	private String originalDocument;
	/** 出库仓：院装，客装 **/
	private String productType;
	/** 出库类型：手动出库，扫码出库，下发到店，销售出库 **/
	private String outType;
	/** 操作人 **/
	private String createUserName;
	/** 出库时间 **/
	private Integer createTime; 
	/** 出库单明细 **/
	private List<InventoryOutItemResultModel> outItemList = Lists.newArrayList();
	
	
	public String getOutCode() {
		return outCode;
	}
	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}
	public String getOriginalDocument() {
		return originalDocument;
	}
	public void setOriginalDocument(String originalDocument) {
		this.originalDocument = originalDocument;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getOutType() {
		return outType;
	}
	public void setOutType(String outType) {
		this.outType = outType;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public List<InventoryOutItemResultModel> getOutItemList() {
		return outItemList;
	}
	public void setOutItemList(List<InventoryOutItemResultModel> outItemList) {
		this.outItemList = outItemList;
	}
}
