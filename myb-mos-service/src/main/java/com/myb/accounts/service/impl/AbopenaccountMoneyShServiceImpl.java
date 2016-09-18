package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AbopenaccountMoneyShDao;
import com.myb.accounts.service.AbopenaccountMoneyShService;
import com.myb.entity.pojo.mos.AbopenaccountMoneySh;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("abopenaccountMoneyShService")
public class AbopenaccountMoneyShServiceImpl implements AbopenaccountMoneyShService{

    @Autowired
    private AbopenaccountMoneyShDao abopenaccountMoneyShDao;

    public int insert(AbopenaccountMoneySh abopenaccountMoneySh)
    {
        return abopenaccountMoneyShDao.insert(abopenaccountMoneySh);
    }
    public int update(AbopenaccountMoneySh abopenaccountMoneySh)
    {
        return abopenaccountMoneyShDao.update(abopenaccountMoneySh);
    }

    public int delete(java.lang.String xuhao)
    {
        return abopenaccountMoneyShDao.delete(xuhao);
    }

    public AbopenaccountMoneySh searchByXuhao(java.lang.String xuhao) {
        return abopenaccountMoneyShDao.searchByXuhao(xuhao);
    }
    public PagedList<AbopenaccountMoneySh> searchByPage(QueryCondition queryCondition)
    {
        return abopenaccountMoneyShDao.searchByPage(queryCondition);
    }
    public List<AbopenaccountMoneySh> searchList(QueryParameter queryParameter)
    {
        return abopenaccountMoneyShDao.searchList(queryParameter);
    }
}

