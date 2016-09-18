package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AbopenaccountMoneySz;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AbopenaccountMoneySzService {


    public int insert(AbopenaccountMoneySz abopenaccountMoneySz);

    public int update(AbopenaccountMoneySz abopenaccountMoneySz);

    public int delete(java.lang.String xuhao);

    public AbopenaccountMoneySz searchByXuhao(java.lang.String xuhao);

    public PagedList<AbopenaccountMoneySz> searchByPage(QueryCondition queryCondition);

    public List<AbopenaccountMoneySz> searchList(QueryParameter queryParameter);
}

