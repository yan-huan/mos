package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AashopSaasDao;
import com.myb.accounts.service.AashopSaasService;
import com.myb.entity.pojo.mos.AashopSaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("aashopSaasService")
public class AashopSaasServiceImpl implements AashopSaasService{

    @Autowired
    private AashopSaasDao aashopSaasDao;

    public int insert(AashopSaas aashopSaas)
    {
        return aashopSaasDao.insert(aashopSaas);
    }
    public int update(AashopSaas aashopSaas)
    {
        return aashopSaasDao.update(aashopSaas);
    }

    public int delete(java.lang.String shopId)
    {
        return aashopSaasDao.delete(shopId);
    }

    public AashopSaas searchByShopId(java.lang.String shopId) {
        return aashopSaasDao.searchByShopId(shopId);
    }
    public PagedList<AashopSaas> searchByPage(QueryCondition queryCondition)
    {
        return aashopSaasDao.searchByPage(queryCondition);
    }
    public List<AashopSaas> searchList(QueryParameter queryParameter)
    {
        return aashopSaasDao.searchList(queryParameter);
    }
}

