package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Upbosslogs;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface UpbosslogsService {


    public int insert(Upbosslogs upbosslogs);

    public int update(Upbosslogs upbosslogs);

    public int delete(int upBossId);

    public Upbosslogs searchByUpBossId(int upBossId);

    public PagedList<Upbosslogs> searchByPage(QueryCondition queryCondition);

    public List<Upbosslogs> searchList(QueryParameter queryParameter);
}

