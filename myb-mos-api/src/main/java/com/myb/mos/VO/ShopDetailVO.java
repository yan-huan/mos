package com.myb.mos.VO;

public class ShopDetailVO {
	private String shopName;
	private String shopAddress;
	private String shopLevel;
	private int isFinish;
	//private String priMan;负责人
	private String latitude;
	private String longitude;
	private int visitTimes;//访问次数
	private String process;//客户进度
	private int contactNum;
	private int duty;
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

	public String getShopLevel() {
		return shopLevel;
	}
	public void setShopLevel(String shopLevel) {
		this.shopLevel = shopLevel;
	}
	public int getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public int getContactNum() {
		return contactNum;
	}
	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}
	public int getDuty() {
		return duty;
	}
	public void setDuty(int duty) {
		this.duty = duty;
	}

	
	
}
