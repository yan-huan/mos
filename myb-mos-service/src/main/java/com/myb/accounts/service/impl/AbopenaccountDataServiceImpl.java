package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AbopenaccountDataDao;
import com.myb.accounts.service.AbopenaccountDataService;
import com.myb.entity.pojo.mos.AbopenaccountData;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("abopenaccountDataService")
public class AbopenaccountDataServiceImpl implements AbopenaccountDataService{

    @Autowired
    private AbopenaccountDataDao abopenaccountDataDao;

    public int insert(AbopenaccountData abopenaccountData)
    {
        return abopenaccountDataDao.insert(abopenaccountData);
    }
    public int update(AbopenaccountData abopenaccountData)
    {
        return abopenaccountDataDao.update(abopenaccountData);
    }

    public int delete(java.lang.String id)
    {
        return abopenaccountDataDao.delete(id);
    }

    public AbopenaccountData searchById(java.lang.String id) {
        return abopenaccountDataDao.searchById(id);
    }
    public PagedList<AbopenaccountData> searchByPage(QueryCondition queryCondition)
    {
        return abopenaccountDataDao.searchByPage(queryCondition);
    }
    public List<AbopenaccountData> searchList(QueryParameter queryParameter)
    {
        return abopenaccountDataDao.searchList(queryParameter);
    }
}

