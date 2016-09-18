package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.ArgsDao;
import com.myb.accounts.service.ArgsService;
import com.myb.entity.pojo.mos.Args;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("argsService")
public class ArgsServiceImpl implements ArgsService{

    @Autowired
    private ArgsDao argsDao;

    public int insert(Args args)
    {
        return argsDao.insert(args);
    }
    public int update(Args args)
    {
        return argsDao.update(args);
    }

    public int delete(int argId)
    {
        return argsDao.delete(argId);
    }

    public Args searchByArgId(int argId) {
        return argsDao.searchByArgId(argId);
    }
    public PagedList<Args> searchByPage(QueryCondition queryCondition)
    {
        return argsDao.searchByPage(queryCondition);
    }
    public List<Args> searchList(QueryParameter queryParameter)
    {
        return argsDao.searchList(queryParameter);
    }
}

