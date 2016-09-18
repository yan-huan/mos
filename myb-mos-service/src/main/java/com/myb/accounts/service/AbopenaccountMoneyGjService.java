package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AbopenaccountMoneyGj;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AbopenaccountMoneyGjService {


    public int insert(AbopenaccountMoneyGj abopenaccountMoneyGj);

    public int update(AbopenaccountMoneyGj abopenaccountMoneyGj);

    public int delete(java.lang.String xuhao);

    public AbopenaccountMoneyGj searchByXuhao(java.lang.String xuhao);

    public PagedList<AbopenaccountMoneyGj> searchByPage(QueryCondition queryCondition);

    public List<AbopenaccountMoneyGj> searchList(QueryParameter queryParameter);
}

