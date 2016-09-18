package com.myb.entity.pojo.inventory.model;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class InventoryApplyModel implements Serializable {
	private static final long serialVersionUID = 2097390766655120398L;
	/** 申请商品类型：院装，客装 **/
	private String applyProductType;
	/** 库存code **/
	private String inventoryCode;
	/** 库存名称 **/
	private String inventoryName;
	/** 被申请方code **/
	private String toCode;
	/** 被申请方名称 **/
	private String toName;
	/** 总院调回，申请调货 **/
	private String type;
	/** 备注 **/
	private String comments;
	/** 原始单据 **/
	private String originalDocument;
	/** 申请人code **/
	private String createUserCode;
	/** 申请人姓名 **/
	private String createUserName;
	/** 状态 **/
	private String status;
	/** 申请明细 **/
	private List<InventoryApplyItemModel> inventoryApplyItemModels = Lists.newArrayList();
	
	
	public String getApplyProductType() {
		return applyProductType;
	}
	public void setApplyProductType(String applyProductType) {
		this.applyProductType = applyProductType;
	}
	public String getToCode() {
		return toCode;
	}
	public void setToCode(String toCode) {
		this.toCode = toCode;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getOriginalDocument() {
		return originalDocument;
	}
	public void setOriginalDocument(String originalDocument) {
		this.originalDocument = originalDocument;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<InventoryApplyItemModel> getInventoryApplyItemModels() {
		return inventoryApplyItemModels;
	}
	public void setInventoryApplyItemModels(
			List<InventoryApplyItemModel> inventoryApplyItemModels) {
		this.inventoryApplyItemModels = inventoryApplyItemModels;
	}
	public String getInventoryCode() {
		return inventoryCode;
	}
	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}
	public String getInventoryName() {
		return inventoryName;
	}
	public void setInventoryName(String inventoryName) {
		this.inventoryName = inventoryName;
	}
}
