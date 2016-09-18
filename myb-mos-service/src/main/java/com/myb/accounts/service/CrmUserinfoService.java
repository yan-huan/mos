package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.CrmUserinfo;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface CrmUserinfoService {


    public int insert(CrmUserinfo crmUserinfo);

    public int update(CrmUserinfo crmUserinfo);

    public int delete(int id);

    public CrmUserinfo searchById(int id);

    public PagedList<CrmUserinfo> searchByPage(QueryCondition queryCondition);

    public List<CrmUserinfo> searchList(QueryParameter queryParameter);
}

