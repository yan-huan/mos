package com.myb.feedback.service.impl;

import java.util.List;

import com.myb.feedback.dao.DbUserDao;
import com.myb.feedback.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.entity.pojo.feedback.DbUser;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("dbUserService")
public class DbUserServiceImpl implements DbUserService {

    @Autowired
    private DbUserDao dbUserDao;

    public int insert(DbUser dbUser)
    {
        return dbUserDao.insert(dbUser);
    }
    public int update(DbUser dbUser)
    {
        return dbUserDao.update(dbUser);
    }

    public int delete(int id)
    {
        return dbUserDao.delete(id);
    }

    public DbUser searchById(int id) {
        return dbUserDao.searchById(id);
    }
    public PagedList<DbUser> searchByPage(QueryCondition queryCondition)
    {
        return dbUserDao.searchByPage(queryCondition);
    }
    public List<DbUser> searchList(QueryParameter queryParameter)
    {
        return dbUserDao.searchList(queryParameter);
    }
}

