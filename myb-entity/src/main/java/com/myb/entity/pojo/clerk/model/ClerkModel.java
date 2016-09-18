package com.myb.entity.pojo.clerk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Description : 注册账号使用 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月25日 下午3:06:31 <br/>
 * @version 1.0 
 */
public class ClerkModel implements Serializable {
	private static final long serialVersionUID = 951587547867007673L;
	/** 员工名称，必填 **/
	private String objName;
	/** 年龄，必填 **/
	private Integer age;
	/** 性别，必填 **/
	private Integer gender;
	/** 生日，必填 **/
	private Date birthday;
	/** 身份证号，必填 **/
	private String securityCode;
	/** 地址，选填 **/
	private String address;
	/** 手机号码，必填 **/
	private String mobile;
	/** 密码，必填 **/
	private String password;
	/** 指头像路径，选填 **/
	private String avatar;
	/** 工作年龄，必填 **/
	private Integer seniority;
	/** 专长，必填 **/
	private String speciality;
	/** 职位，必填 **/
	private String title;
	/** 档案，选填 **/
	private String dreams;
	/** 微信号，选填 **/
	private String weixin;
	/** QQ号，选填 **/
	private String qq;
	/** 过期时间，必填 **/
	private String expiredDate;
	/** 状态，必填 **/
	private String status;
	/** 登陆帐户类型，必填 **/
	private Integer accountType;
	
	public String getObjName() {
		return objName;
	}
	public void setObjName(String objName) {
		this.objName = objName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getSeniority() {
		return seniority;
	}
	public void setSeniority(Integer seniority) {
		this.seniority = seniority;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDreams() {
		return dreams;
	}
	public void setDreams(String dreams) {
		this.dreams = dreams;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
}
