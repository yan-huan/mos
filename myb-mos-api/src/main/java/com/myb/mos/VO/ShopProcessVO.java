package com.myb.mos.VO;

public class ShopProcessVO {
	private int isEscort;
	private String clientLevel;
	private int isValide;
	private int visitTimes;
	private String process;
	private String reason;
	public int getIsEscort() {
		return isEscort;
	}
	public void setIsEscort(int isEscort) {
		this.isEscort = isEscort;
	}
	public String getClientLevel() {
		return clientLevel;
	}
	public void setClientLevel(String clientLevel) {
		this.clientLevel = clientLevel;
	}
	public int getIsValide() {
		return isValide;
	}
	public void setIsValide(int isValide) {
		this.isValide = isValide;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
