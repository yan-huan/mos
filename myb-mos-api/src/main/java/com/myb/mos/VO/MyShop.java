package com.myb.mos.VO;

public class MyShop {
	private Long shopId;
	private String shopName;
	private String shopAddress;
	private String shopLevel;//A,B,C,D
	public String getShopName() {
		return shopName;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
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
	
}
