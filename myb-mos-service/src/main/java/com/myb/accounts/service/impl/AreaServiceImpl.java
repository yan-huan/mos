package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AreaDao;
import com.myb.accounts.service.AreaService;
import com.myb.entity.pojo.mos.Area;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("areaService")
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaDao;

    public int insert(Area area)
    {
        return areaDao.insert(area);
    }
    public int update(Area area)
    {
        return areaDao.update(area);
    }

    public int delete(int areaId)
    {
        return areaDao.delete(areaId);
    }

    public Area searchByAreaId(int areaId) {
        return areaDao.searchByAreaId(areaId);
    }
    public PagedList<Area> searchByPage(QueryCondition queryCondition)
    {
        return areaDao.searchByPage(queryCondition);
    }
    public List<Area> searchList(QueryParameter queryParameter)
    {
        return areaDao.searchList(queryParameter);
    }
}

