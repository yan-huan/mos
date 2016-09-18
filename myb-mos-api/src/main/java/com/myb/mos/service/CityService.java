package com.myb.mos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.City;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;


public interface CityService {


    public int insert(City city);

    public int update(City city);

    public int delete(int cityId);

    public City searchByCityId(int cityId);
    
    public City searchByCityName(String cityName);

    public PagedList<City> searchByPage(QueryCondition queryCondition);

    public List<City> searchList(QueryParameter queryParameter);
}

