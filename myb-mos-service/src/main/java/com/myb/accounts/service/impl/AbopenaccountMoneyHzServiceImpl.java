package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AbopenaccountMoneyHzDao;
import com.myb.accounts.service.AbopenaccountMoneyHzService;
import com.myb.entity.pojo.mos.AbopenaccountMoneyHz;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("abopenaccountMoneyHzService")
public class AbopenaccountMoneyHzServiceImpl implements AbopenaccountMoneyHzService{

    @Autowired
    private AbopenaccountMoneyHzDao abopenaccountMoneyHzDao;

    public int insert(AbopenaccountMoneyHz abopenaccountMoneyHz)
    {
        return abopenaccountMoneyHzDao.insert(abopenaccountMoneyHz);
    }
    public int update(AbopenaccountMoneyHz abopenaccountMoneyHz)
    {
        return abopenaccountMoneyHzDao.update(abopenaccountMoneyHz);
    }

    public int delete(java.lang.String xuhao)
    {
        return abopenaccountMoneyHzDao.delete(xuhao);
    }

    public AbopenaccountMoneyHz searchByXuhao(java.lang.String xuhao) {
        return abopenaccountMoneyHzDao.searchByXuhao(xuhao);
    }
    public PagedList<AbopenaccountMoneyHz> searchByPage(QueryCondition queryCondition)
    {
        return abopenaccountMoneyHzDao.searchByPage(queryCondition);
    }
    public List<AbopenaccountMoneyHz> searchList(QueryParameter queryParameter)
    {
        return abopenaccountMoneyHzDao.searchList(queryParameter);
    }
}

