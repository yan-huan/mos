package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.Sheet1Dao;
import com.myb.accounts.service.Sheet1Service;
import com.myb.entity.pojo.mos.Sheet1;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("sheet1Service")
public class Sheet1ServiceImpl implements Sheet1Service{

    @Autowired
    private Sheet1Dao sheet1Dao;

    public int insert(Sheet1 sheet1)
    {
        return sheet1Dao.insert(sheet1);
    }
    public int update(Sheet1 sheet1)
    {
        return sheet1Dao.update(sheet1);
    }

    public int delete(java.lang.String xuhao)
    {
        return sheet1Dao.delete(xuhao);
    }

    public Sheet1 searchByXuhao(java.lang.String xuhao) {
        return sheet1Dao.searchByXuhao(xuhao);
    }
    public PagedList<Sheet1> searchByPage(QueryCondition queryCondition)
    {
        return sheet1Dao.searchByPage(queryCondition);
    }
    public List<Sheet1> searchList(QueryParameter queryParameter)
    {
        return sheet1Dao.searchList(queryParameter);
    }
}

