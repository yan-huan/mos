package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AaopenAccountSaasDao;
import com.myb.accounts.service.AaopenAccountSaasService;
import com.myb.entity.pojo.mos.AaopenAccountSaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("aaopenAccountSaasService")
public class AaopenAccountSaasServiceImpl implements AaopenAccountSaasService{

    @Autowired
    private AaopenAccountSaasDao aaopenAccountSaasDao;

    public int insert(AaopenAccountSaas aaopenAccountSaas)
    {
        return aaopenAccountSaasDao.insert(aaopenAccountSaas);
    }
    public int update(AaopenAccountSaas aaopenAccountSaas)
    {
        return aaopenAccountSaasDao.update(aaopenAccountSaas);
    }

    public int delete(java.lang.String id)
    {
        return aaopenAccountSaasDao.delete(id);
    }

    public AaopenAccountSaas searchById(java.lang.String id) {
        return aaopenAccountSaasDao.searchById(id);
    }
    public PagedList<AaopenAccountSaas> searchByPage(QueryCondition queryCondition)
    {
        return aaopenAccountSaasDao.searchByPage(queryCondition);
    }
    public List<AaopenAccountSaas> searchList(QueryParameter queryParameter)
    {
        return aaopenAccountSaasDao.searchList(queryParameter);
    }
}

