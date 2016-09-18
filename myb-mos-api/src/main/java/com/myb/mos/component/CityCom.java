package com.myb.mos.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myb.entity.pojo.mos.City;
import com.myb.mos.exception.ServiceException;
import com.myb.mos.service.CityService;

@Component
public class CityCom {
	@Autowired
	private CityService cityService;
	
	public  Long getCityId (String cityName){
		Long cityId=null;
		City city = cityService.searchByCityName(cityName);
		if(city!=null){
			cityId=Long.parseLong(city.getCityId()+"");
		}else{
			throw  new ServiceException("该城市："+cityName+"，尚未开通");
		}
		return cityId;
		
	}
}
