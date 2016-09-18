package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Aaquit;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AaquitService {


    public int insert(Aaquit aaquit);

    public int update(Aaquit aaquit);

    public int delete(java.lang.String aa);

    public Aaquit searchByAa(java.lang.String aa);

    public PagedList<Aaquit> searchByPage(QueryCondition queryCondition);

    public List<Aaquit> searchList(QueryParameter queryParameter);
}

