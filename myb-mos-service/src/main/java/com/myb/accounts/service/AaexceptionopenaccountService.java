package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Aaexceptionopenaccount;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AaexceptionopenaccountService {


    public int insert(Aaexceptionopenaccount aaexceptionopenaccount);

    public int update(Aaexceptionopenaccount aaexceptionopenaccount);

    public int delete(int id);

    public Aaexceptionopenaccount searchById(int id);

    public PagedList<Aaexceptionopenaccount> searchByPage(QueryCondition queryCondition);

    public List<Aaexceptionopenaccount> searchList(QueryParameter queryParameter);
}

