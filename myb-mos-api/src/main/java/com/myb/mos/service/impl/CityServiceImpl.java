package com.myb.mos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.mos.City;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.dao.CityDao;
import com.myb.mos.service.CityService;
import com.myb.framework.data.QueryCondition;


@Service("cityService")
public class CityServiceImpl implements CityService{

    @Autowired
    private CityDao cityDao;

    public int insert(City city)
    {
        return cityDao.insert(city);
    }
    public int update(City city)
    {
        return cityDao.update(city);
    }

    public int delete(int cityId)
    {
        return cityDao.delete(cityId);
    }

    public City searchByCityId(int cityId) {
        return cityDao.searchByCityId(cityId);
    }
    public City searchByCityName(String cityName) {
        return cityDao.searchByCityName(cityName);
    }
    public PagedList<City> searchByPage(QueryCondition queryCondition)
    {
        return cityDao.searchByPage(queryCondition);
    }
    public List<City> searchList(QueryParameter queryParameter)
    {
        return cityDao.searchList(queryParameter);
    }
    
}

