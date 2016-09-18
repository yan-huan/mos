package com.myb.mos.VO;

import java.math.BigDecimal;
import java.util.Date;

public class FinishShopVO {
	private String shopName;
	private Date finishTime;
	private String shopAddress;
	private BigDecimal amount;
	private int monthFinishNum;
	
	public int getMonthFinishNum() {
		return monthFinishNum;
	}
	public void setMonthFinishNum(int monthFinishNum) {
		this.monthFinishNum = monthFinishNum;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
}
