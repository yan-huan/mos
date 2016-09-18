package com.myb.entity.pojo.clerk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Description : 员工变为老板号使用 <br/>
 * Copyright : Copyright (c) 2015- 2016 All rights reserved. <br/>
 * Company : 美业邦
 * @author hailin.liu 2016年5月26日 下午9:10:07 <br/>
 * @version 1.0
 * 备注：
 * startDate和endDate 同时为空或者同时不为空
 */
public class ClerkToBossModel implements Serializable {
	private static final long serialVersionUID = 5479561349548918285L;
	/** 需要变为老板的手机号， 必填 **/
	private String mobile;
	/** 需要开店的数量，必填 **/
	private Integer shopNums;
	/** 购买类型 1-1年  2-3年  3-终身（99年）, 必填 **/
	private Integer type;
	/** 开始时间，选填 **/
	private Date startDate;
	/** 结束时间，选填 **/
	private Date endDate;
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getShopNums() {
		return shopNums;
	}
	public void setShopNums(Integer shopNums) {
		this.shopNums = shopNums;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
