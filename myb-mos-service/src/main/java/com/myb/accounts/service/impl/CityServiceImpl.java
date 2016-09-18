package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.CityDao;
import com.myb.accounts.service.CityService;
import com.myb.entity.pojo.mos.City;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

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
    public PagedList<City> searchByPage(QueryCondition queryCondition)
    {
        return cityDao.searchByPage(queryCondition);
    }
    public List<City> searchList(QueryParameter queryParameter)
    {
        return cityDao.searchList(queryParameter);
    }
}

