package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.City;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface CityService {


    public int insert(City city);

    public int update(City city);

    public int delete(int cityId);

    public City searchByCityId(int cityId);

    public PagedList<City> searchByPage(QueryCondition queryCondition);

    public List<City> searchList(QueryParameter queryParameter);
}

