package com.myb.mos.VO;

import java.util.Date;

public class VisitInfoVO {
	private String clientLevel;
	private String shopName;
	private String shopAddress;
	private String  visitTime;
	private String remark;
	private int isValide;
	private String picUrl;
	
	public String getClientLevel() {
		return clientLevel;
	}
	public void setClientLevel(String clientLevel) {
		this.clientLevel = clientLevel;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIsValide() {
		return isValide;
	}
	public void setIsValide(int isValide) {
		this.isValide = isValide;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
}
