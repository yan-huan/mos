package com.myb.accounts.service;

import java.util.List;

import com.myb.accounts.vo.DistinctVO;
import com.myb.entity.pojo.mos.OpenAccount;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface OpenAccountService {


    public int insert(OpenAccount openAccount);

    public int update(OpenAccount openAccount);

    public int delete(int accountId);

    public OpenAccount searchByAccountId(int accountId);

    public PagedList<OpenAccount> searchByPage(QueryCondition queryCondition);
   
    public List<OpenAccount> searchDistinct(QueryCondition queryCondition, String column);

    public List<OpenAccount> searchList(QueryParameter queryParameter);
    
    public OpenAccount searchByMobile(String mobile);
}

