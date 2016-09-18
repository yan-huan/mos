package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Area;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AreaService {


    public int insert(Area area);

    public int update(Area area);

    public int delete(int areaId);

    public Area searchByAreaId(int areaId);

    public PagedList<Area> searchByPage(QueryCondition queryCondition);

    public List<Area> searchList(QueryParameter queryParameter);
}

