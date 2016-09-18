package com.myb.mos.VO;
public class ShopContactVO {
    private long id;//
    private java.lang.String name;//
    private java.lang.String telephone;//
    private java.lang.String wechat;//微信号
    private int duty;//职位：老板1，店长2，店员3
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getTelephone() {
		return telephone;
	}
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	public java.lang.String getWechat() {
		return wechat;
	}
	public void setWechat(java.lang.String wechat) {
		this.wechat = wechat;
	}
	public int getDuty() {
		return duty;
	}
	public void setDuty(int duty) {
		this.duty = duty;
	}

    
}
