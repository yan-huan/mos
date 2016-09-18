package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Sheet1;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface Sheet1Service {


    public int insert(Sheet1 sheet1);

    public int update(Sheet1 sheet1);

    public int delete(java.lang.String xuhao);

    public Sheet1 searchByXuhao(java.lang.String xuhao);

    public PagedList<Sheet1> searchByPage(QueryCondition queryCondition);

    public List<Sheet1> searchList(QueryParameter queryParameter);
}

