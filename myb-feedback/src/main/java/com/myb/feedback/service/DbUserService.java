package com.myb.feedback.service;

import java.util.List;

import com.myb.entity.pojo.feedback.DbUser;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface DbUserService {


    public int insert(DbUser dbUser);

    public int update(DbUser dbUser);

    public int delete(int id);

    public DbUser searchById(int id);

    public PagedList<DbUser> searchByPage(QueryCondition queryCondition);

    public List<DbUser> searchList(QueryParameter queryParameter);
}

