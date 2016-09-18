package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Aaemployee1;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface Aaemployee1Service {


    public int insert(Aaemployee1 aaemployee1);

    public int update(Aaemployee1 aaemployee1);

    public int delete(java.lang.String xu);

    public Aaemployee1 searchByXu(java.lang.String xu);

    public PagedList<Aaemployee1> searchByPage(QueryCondition queryCondition);

    public List<Aaemployee1> searchList(QueryParameter queryParameter);
}

