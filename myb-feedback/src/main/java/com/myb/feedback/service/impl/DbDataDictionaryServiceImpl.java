package com.myb.feedback.service.impl;

import java.util.List;

import com.myb.feedback.dao.DbDataDictionaryDao;
import com.myb.feedback.service.DbDataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.feedback.DbDataDictionary;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("dbDataDictionaryService")
public class DbDataDictionaryServiceImpl implements DbDataDictionaryService {

    @Autowired
    private DbDataDictionaryDao dbDataDictionaryDao;

    public int insert(DbDataDictionary dbDataDictionary)
    {
        return dbDataDictionaryDao.insert(dbDataDictionary);
    }
    public int update(DbDataDictionary dbDataDictionary)
    {
        return dbDataDictionaryDao.update(dbDataDictionary);
    }

    public int delete(int id)
    {
        return dbDataDictionaryDao.delete(id);
    }

    public DbDataDictionary searchById(int id) {
        return dbDataDictionaryDao.searchById(id);
    }
    public PagedList<DbDataDictionary> searchByPage(QueryCondition queryCondition)
    {
        return dbDataDictionaryDao.searchByPage(queryCondition);
    }
    public List<DbDataDictionary> searchList(QueryParameter queryParameter)
    {
        return dbDataDictionaryDao.searchList(queryParameter);
    }
}

