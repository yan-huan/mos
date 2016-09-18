package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AbcaiwuallDao;
import com.myb.accounts.service.AbcaiwuallService;
import com.myb.entity.pojo.mos.Abcaiwuall;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("abcaiwuallService")
public class AbcaiwuallServiceImpl implements AbcaiwuallService{

    @Autowired
    private AbcaiwuallDao abcaiwuallDao;

    public int insert(Abcaiwuall abcaiwuall)
    {
        return abcaiwuallDao.insert(abcaiwuall);
    }
    public int update(Abcaiwuall abcaiwuall)
    {
        return abcaiwuallDao.update(abcaiwuall);
    }

    public int delete(java.lang.String f1)
    {
        return abcaiwuallDao.delete(f1);
    }

    public Abcaiwuall searchByF1(java.lang.String f1) {
        return abcaiwuallDao.searchByF1(f1);
    }
    public PagedList<Abcaiwuall> searchByPage(QueryCondition queryCondition)
    {
        return abcaiwuallDao.searchByPage(queryCondition);
    }
    public List<Abcaiwuall> searchList(QueryParameter queryParameter)
    {
        return abcaiwuallDao.searchList(queryParameter);
    }
}

