package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AaquitDao;
import com.myb.accounts.service.AaquitService;
import com.myb.entity.pojo.mos.Aaquit;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("aaquitService")
public class AaquitServiceImpl implements AaquitService{

    @Autowired
    private AaquitDao aaquitDao;

    public int insert(Aaquit aaquit)
    {
        return aaquitDao.insert(aaquit);
    }
    public int update(Aaquit aaquit)
    {
        return aaquitDao.update(aaquit);
    }

    public int delete(java.lang.String aa)
    {
        return aaquitDao.delete(aa);
    }

    public Aaquit searchByAa(java.lang.String aa) {
        return aaquitDao.searchByAa(aa);
    }
    public PagedList<Aaquit> searchByPage(QueryCondition queryCondition)
    {
        return aaquitDao.searchByPage(queryCondition);
    }
    public List<Aaquit> searchList(QueryParameter queryParameter)
    {
        return aaquitDao.searchList(queryParameter);
    }
}

