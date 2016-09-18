package com.myb.feedback.service;

import java.util.List;

import com.myb.entity.pojo.feedback.DbProblem;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface DbProblemService {


    public int insert(DbProblem dbProblem);

    public int update(DbProblem dbProblem);

    public int delete(int id);

    public DbProblem searchById(int id);

    public PagedList<DbProblem> searchByPage(QueryCondition queryCondition);

    public List<DbProblem> searchList(QueryParameter queryParameter);
}

