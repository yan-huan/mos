package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Shopsaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface ShopsaasService {


    public int insert(Shopsaas shopsaas);

    public int update(Shopsaas shopsaas);

    public int delete(java.lang.String sHOPID);

    public Shopsaas searchBySHOPID(java.lang.String sHOPID);

    public PagedList<Shopsaas> searchByPage(QueryCondition queryCondition);

    public List<Shopsaas> searchList(QueryParameter queryParameter);
}

