package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.ShopsaasDao;
import com.myb.accounts.service.ShopsaasService;
import com.myb.entity.pojo.mos.Shopsaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("shopsaasService")
public class ShopsaasServiceImpl implements ShopsaasService{

    @Autowired
    private ShopsaasDao shopsaasDao;

    public int insert(Shopsaas shopsaas)
    {
        return shopsaasDao.insert(shopsaas);
    }
    public int update(Shopsaas shopsaas)
    {
        return shopsaasDao.update(shopsaas);
    }

    public int delete(java.lang.String sHOPID)
    {
        return shopsaasDao.delete(sHOPID);
    }

    public Shopsaas searchBySHOPID(java.lang.String sHOPID) {
        return shopsaasDao.searchBySHOPID(sHOPID);
    }
    public PagedList<Shopsaas> searchByPage(QueryCondition queryCondition)
    {
        return shopsaasDao.searchByPage(queryCondition);
    }
    public List<Shopsaas> searchList(QueryParameter queryParameter)
    {
        return shopsaasDao.searchList(queryParameter);
    }
}

