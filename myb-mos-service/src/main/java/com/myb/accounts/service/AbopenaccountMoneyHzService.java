package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AbopenaccountMoneyHz;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AbopenaccountMoneyHzService {


    public int insert(AbopenaccountMoneyHz abopenaccountMoneyHz);

    public int update(AbopenaccountMoneyHz abopenaccountMoneyHz);

    public int delete(java.lang.String xuhao);

    public AbopenaccountMoneyHz searchByXuhao(java.lang.String xuhao);

    public PagedList<AbopenaccountMoneyHz> searchByPage(QueryCondition queryCondition);

    public List<AbopenaccountMoneyHz> searchList(QueryParameter queryParameter);
}

