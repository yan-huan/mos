package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AbopenaccountMoneySh;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AbopenaccountMoneyShService {


    public int insert(AbopenaccountMoneySh abopenaccountMoneySh);

    public int update(AbopenaccountMoneySh abopenaccountMoneySh);

    public int delete(java.lang.String xuhao);

    public AbopenaccountMoneySh searchByXuhao(java.lang.String xuhao);

    public PagedList<AbopenaccountMoneySh> searchByPage(QueryCondition queryCondition);

    public List<AbopenaccountMoneySh> searchList(QueryParameter queryParameter);
}

