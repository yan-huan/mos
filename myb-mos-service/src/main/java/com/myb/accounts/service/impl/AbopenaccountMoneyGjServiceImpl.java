package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AbopenaccountMoneyGjDao;
import com.myb.accounts.service.AbopenaccountMoneyGjService;
import com.myb.entity.pojo.mos.AbopenaccountMoneyGj;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("abopenaccountMoneyGjService")
public class AbopenaccountMoneyGjServiceImpl implements AbopenaccountMoneyGjService{

    @Autowired
    private AbopenaccountMoneyGjDao abopenaccountMoneyGjDao;

    public int insert(AbopenaccountMoneyGj abopenaccountMoneyGj)
    {
        return abopenaccountMoneyGjDao.insert(abopenaccountMoneyGj);
    }
    public int update(AbopenaccountMoneyGj abopenaccountMoneyGj)
    {
        return abopenaccountMoneyGjDao.update(abopenaccountMoneyGj);
    }

    public int delete(java.lang.String xuhao)
    {
        return abopenaccountMoneyGjDao.delete(xuhao);
    }

    public AbopenaccountMoneyGj searchByXuhao(java.lang.String xuhao) {
        return abopenaccountMoneyGjDao.searchByXuhao(xuhao);
    }
    public PagedList<AbopenaccountMoneyGj> searchByPage(QueryCondition queryCondition)
    {
        return abopenaccountMoneyGjDao.searchByPage(queryCondition);
    }
    public List<AbopenaccountMoneyGj> searchList(QueryParameter queryParameter)
    {
        return abopenaccountMoneyGjDao.searchList(queryParameter);
    }
}

