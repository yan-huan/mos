package com.myb.feedback.service.impl;

import java.util.List;

import com.myb.feedback.dao.DbProblemDao;
import com.myb.feedback.service.DbProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.feedback.DbProblem;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("dbProblemService")
public class DbProblemServiceImpl implements DbProblemService{

    @Autowired
    private DbProblemDao dbProblemDao;

    public int insert(DbProblem dbProblem)
    {
        return dbProblemDao.insert(dbProblem);
    }
    public int update(DbProblem dbProblem)
    {
        return dbProblemDao.update(dbProblem);
    }

    public int delete(int id)
    {
        return dbProblemDao.delete(id);
    }

    public DbProblem searchById(int id) {
        return dbProblemDao.searchById(id);
    }
    public PagedList<DbProblem> searchByPage(QueryCondition queryCondition)
    {
        return dbProblemDao.searchByPage(queryCondition);
    }
    public List<DbProblem> searchList(QueryParameter queryParameter)
    {
        return dbProblemDao.searchList(queryParameter);
    }
}

