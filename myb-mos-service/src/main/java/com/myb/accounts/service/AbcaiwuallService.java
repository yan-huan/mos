package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Abcaiwuall;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface AbcaiwuallService {


    public int insert(Abcaiwuall abcaiwuall);

    public int update(Abcaiwuall abcaiwuall);

    public int delete(java.lang.String f1);

    public Abcaiwuall searchByF1(java.lang.String f1);

    public PagedList<Abcaiwuall> searchByPage(QueryCondition queryCondition);

    public List<Abcaiwuall> searchList(QueryParameter queryParameter);
}

