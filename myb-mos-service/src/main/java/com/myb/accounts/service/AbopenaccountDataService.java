package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AbopenaccountData;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AbopenaccountDataService {


    public int insert(AbopenaccountData abopenaccountData);

    public int update(AbopenaccountData abopenaccountData);

    public int delete(java.lang.String id);

    public AbopenaccountData searchById(java.lang.String id);

    public PagedList<AbopenaccountData> searchByPage(QueryCondition queryCondition);

    public List<AbopenaccountData> searchList(QueryParameter queryParameter);
}

