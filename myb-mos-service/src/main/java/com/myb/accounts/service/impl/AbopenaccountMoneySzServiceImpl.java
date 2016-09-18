package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AbopenaccountMoneySzDao;
import com.myb.accounts.service.AbopenaccountMoneySzService;
import com.myb.entity.pojo.mos.AbopenaccountMoneySz;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("abopenaccountMoneySzService")
public class AbopenaccountMoneySzServiceImpl implements AbopenaccountMoneySzService{

    @Autowired
    private AbopenaccountMoneySzDao abopenaccountMoneySzDao;

    public int insert(AbopenaccountMoneySz abopenaccountMoneySz)
    {
        return abopenaccountMoneySzDao.insert(abopenaccountMoneySz);
    }
    public int update(AbopenaccountMoneySz abopenaccountMoneySz)
    {
        return abopenaccountMoneySzDao.update(abopenaccountMoneySz);
    }

    public int delete(java.lang.String xuhao)
    {
        return abopenaccountMoneySzDao.delete(xuhao);
    }

    public AbopenaccountMoneySz searchByXuhao(java.lang.String xuhao) {
        return abopenaccountMoneySzDao.searchByXuhao(xuhao);
    }
    public PagedList<AbopenaccountMoneySz> searchByPage(QueryCondition queryCondition)
    {
        return abopenaccountMoneySzDao.searchByPage(queryCondition);
    }
    public List<AbopenaccountMoneySz> searchList(QueryParameter queryParameter)
    {
        return abopenaccountMoneySzDao.searchList(queryParameter);
    }
}

