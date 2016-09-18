package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.Aaemployee1Dao;
import com.myb.accounts.service.Aaemployee1Service;
import com.myb.entity.pojo.mos.Aaemployee1;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("aaemployee1Service")
public class Aaemployee1ServiceImpl implements Aaemployee1Service{

    @Autowired
    private Aaemployee1Dao aaemployee1Dao;

    public int insert(Aaemployee1 aaemployee1)
    {
        return aaemployee1Dao.insert(aaemployee1);
    }
    public int update(Aaemployee1 aaemployee1)
    {
        return aaemployee1Dao.update(aaemployee1);
    }

    public int delete(java.lang.String xu)
    {
        return aaemployee1Dao.delete(xu);
    }

    public Aaemployee1 searchByXu(java.lang.String xu) {
        return aaemployee1Dao.searchByXu(xu);
    }
    public PagedList<Aaemployee1> searchByPage(QueryCondition queryCondition)
    {
        return aaemployee1Dao.searchByPage(queryCondition);
    }
    public List<Aaemployee1> searchList(QueryParameter queryParameter)
    {
        return aaemployee1Dao.searchList(queryParameter);
    }
}

