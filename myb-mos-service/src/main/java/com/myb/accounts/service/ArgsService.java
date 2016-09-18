package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Args;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface ArgsService {


    public int insert(Args args);

    public int update(Args args);

    public int delete(int argId);

    public Args searchByArgId(int argId);

    public PagedList<Args> searchByPage(QueryCondition queryCondition);

    public List<Args> searchList(QueryParameter queryParameter);
}

