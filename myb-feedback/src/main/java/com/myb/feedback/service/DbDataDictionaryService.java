package com.myb.feedback.service;

import java.util.List;

import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface DbDataDictionaryService {


    public int insert(DbDataDictionary dbDataDictionary);

    public int update(DbDataDictionary dbDataDictionary);

    public int delete(int id);

    public DbDataDictionary searchById(int id);

    public PagedList<DbDataDictionary> searchByPage(QueryCondition queryCondition);

    public List<DbDataDictionary> searchList(QueryParameter queryParameter);
}

