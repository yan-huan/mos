package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.OpenAccountSaasDao;
import com.myb.accounts.service.OpenAccountSaasService;
import com.myb.entity.pojo.mos.OpenAccountSaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("openAccountSaasService")
public class OpenAccountSaasServiceImpl implements OpenAccountSaasService{

    @Autowired
    private OpenAccountSaasDao openAccountSaasDao;

    public int insert(OpenAccountSaas openAccountSaas)
    {
        return openAccountSaasDao.insert(openAccountSaas);
    }
    public int update(OpenAccountSaas openAccountSaas)
    {
        return openAccountSaasDao.update(openAccountSaas);
    }

    public int delete(int id)
    {
        return openAccountSaasDao.delete(id);
    }

    public OpenAccountSaas searchById(int id) {
        return openAccountSaasDao.searchById(id);
    }
    public PagedList<OpenAccountSaas> searchByPage(QueryCondition queryCondition)
    {
        return openAccountSaasDao.searchByPage(queryCondition);
    }
    public List<OpenAccountSaas> searchList(QueryParameter queryParameter)
    {
        return openAccountSaasDao.searchList(queryParameter);
    }
}

