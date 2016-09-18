package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AbopenaccountMoneyBjDao;
import com.myb.accounts.service.AbopenaccountMoneyBjService;
import com.myb.entity.pojo.mos.AbopenaccountMoneyBj;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("abopenaccountMoneyBjService")
public class AbopenaccountMoneyBjServiceImpl implements AbopenaccountMoneyBjService{

    @Autowired
    private AbopenaccountMoneyBjDao abopenaccountMoneyBjDao;

    public int insert(AbopenaccountMoneyBj abopenaccountMoneyBj)
    {
        return abopenaccountMoneyBjDao.insert(abopenaccountMoneyBj);
    }
    public int update(AbopenaccountMoneyBj abopenaccountMoneyBj)
    {
        return abopenaccountMoneyBjDao.update(abopenaccountMoneyBj);
    }

    public int delete(java.lang.String xuhao)
    {
        return abopenaccountMoneyBjDao.delete(xuhao);
    }

    public AbopenaccountMoneyBj searchByXuhao(java.lang.String xuhao) {
        return abopenaccountMoneyBjDao.searchByXuhao(xuhao);
    }
    public PagedList<AbopenaccountMoneyBj> searchByPage(QueryCondition queryCondition)
    {
        return abopenaccountMoneyBjDao.searchByPage(queryCondition);
    }
    public List<AbopenaccountMoneyBj> searchList(QueryParameter queryParameter)
    {
        return abopenaccountMoneyBjDao.searchList(queryParameter);
    }
}

