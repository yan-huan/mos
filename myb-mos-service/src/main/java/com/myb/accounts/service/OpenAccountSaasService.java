package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.OpenAccountSaas;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface OpenAccountSaasService {

    public int insert(OpenAccountSaas openAccountSaas);
    
    public int update(OpenAccountSaas openAccountSaas);
    
    public int delete(int id);
    
    public OpenAccountSaas searchById(int id); 
    
    public PagedList<OpenAccountSaas> searchByPage(QueryCondition queryCondition);
    
    public List<OpenAccountSaas> searchList(QueryParameter queryParameter);
}

