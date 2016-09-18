package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.DutyDao;
import com.myb.accounts.service.DutyService;
import com.myb.entity.pojo.mos.Duty;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("dutyService")
public class DutyServiceImpl implements DutyService{

    @Autowired
    private DutyDao dutyDao;

    public int insert(Duty duty)
    {
        return dutyDao.insert(duty);
    }
    public int update(Duty duty)
    {
        return dutyDao.update(duty);
    }

    public int delete(int dutyId)
    {
        return dutyDao.delete(dutyId);
    }

    public Duty searchByDutyId(int dutyId) {
        return dutyDao.searchByDutyId(dutyId);
    }
    public PagedList<Duty> searchByPage(QueryCondition queryCondition)
    {
        return dutyDao.searchByPage(queryCondition);
    }
    public List<Duty> searchList(QueryParameter queryParameter)
    {
        return dutyDao.searchList(queryParameter);
    }
}

