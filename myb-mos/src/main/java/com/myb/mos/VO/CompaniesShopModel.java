package com.myb.mos.VO;

import java.io.Serializable;

/**
 * 美容店模型
 * 
 * @author songhaiqiang
 *
 */
public class CompaniesShopModel implements Serializable {

	private static final long serialVersionUID = 8193935701961646820L;
	/** 美容店code */
	private String shopCode;
	/** 美容院名称 */
	private String objName;
	/** 省标示 */
	private String provinceId;
	/** 省名称 */
	private String provinceName;
	/** 城市名称 */
	private String cityName;
	/** 城市标示 */
	private String cityId;
	/** 区域标示 */
	private String areaId;
	/** 区域名称 */
	private String areaName;
	/** 开始日期 */
	private String startDate;
	/** 截止日期 */
	private String endDate;
	/** 详细地址 */
	private String address;
	/** 说明 */
	private String comments;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
