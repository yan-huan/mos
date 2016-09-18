package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.AaopenAccountSaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AaopenAccountSaasService {


    public int insert(AaopenAccountSaas aaopenAccountSaas);

    public int update(AaopenAccountSaas aaopenAccountSaas);

    public int delete(java.lang.String id);

    public AaopenAccountSaas searchById(java.lang.String id);

    public PagedList<AaopenAccountSaas> searchByPage(QueryCondition queryCondition);

    public List<AaopenAccountSaas> searchList(QueryParameter queryParameter);
}

