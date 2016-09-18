package com.myb.mos.VO;

import com.myb.framework.data.EntityBase;
/**
 * 渠道信息的VO
 * @author yanhuan
 *
 */
public class CityVO extends EntityBase{

	private String cityCode;
	private String cityName;
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
