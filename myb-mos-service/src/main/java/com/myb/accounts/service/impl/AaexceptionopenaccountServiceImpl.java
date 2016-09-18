package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.AaexceptionopenaccountDao;
import com.myb.accounts.service.AaexceptionopenaccountService;
import com.myb.entity.pojo.mos.Aaexceptionopenaccount;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("aaexceptionopenaccountService")
public class AaexceptionopenaccountServiceImpl implements AaexceptionopenaccountService{

    @Autowired
    private AaexceptionopenaccountDao aaexceptionopenaccountDao;

    public int insert(Aaexceptionopenaccount aaexceptionopenaccount)
    {
        return aaexceptionopenaccountDao.insert(aaexceptionopenaccount);
    }
    public int update(Aaexceptionopenaccount aaexceptionopenaccount)
    {
        return aaexceptionopenaccountDao.update(aaexceptionopenaccount);
    }

    public int delete(int id)
    {
        return aaexceptionopenaccountDao.delete(id);
    }

    public Aaexceptionopenaccount searchById(int id) {
        return aaexceptionopenaccountDao.searchById(id);
    }
    public PagedList<Aaexceptionopenaccount> searchByPage(QueryCondition queryCondition)
    {
        return aaexceptionopenaccountDao.searchByPage(queryCondition);
    }
    public List<Aaexceptionopenaccount> searchList(QueryParameter queryParameter)
    {
        return aaexceptionopenaccountDao.searchList(queryParameter);
    }
}

