package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AbopenaccountMoneyBj;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AbopenaccountMoneyBjService {


    public int insert(AbopenaccountMoneyBj abopenaccountMoneyBj);

    public int update(AbopenaccountMoneyBj abopenaccountMoneyBj);

    public int delete(java.lang.String xuhao);

    public AbopenaccountMoneyBj searchByXuhao(java.lang.String xuhao);

    public PagedList<AbopenaccountMoneyBj> searchByPage(QueryCondition queryCondition);

    public List<AbopenaccountMoneyBj> searchList(QueryParameter queryParameter);
}

