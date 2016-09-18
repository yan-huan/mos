package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AashopSaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AashopSaasService {


    public int insert(AashopSaas aashopSaas);

    public int update(AashopSaas aashopSaas);

    public int delete(java.lang.String shopId);

    public AashopSaas searchByShopId(java.lang.String shopId);

    public PagedList<AashopSaas> searchByPage(QueryCondition queryCondition);

    public List<AashopSaas> searchList(QueryParameter queryParameter);
}

