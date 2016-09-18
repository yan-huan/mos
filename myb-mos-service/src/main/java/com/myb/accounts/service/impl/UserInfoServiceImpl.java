package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.UserInfoDao;
import com.myb.accounts.service.UserInfoService;
import com.myb.entity.pojo.mos.UserInfo;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoDao userInfoDao;

    public int insert(UserInfo sheet0)
    {
        return userInfoDao.insert(sheet0);
    }
    public int update(UserInfo sheet0)
    {
        return userInfoDao.update(sheet0);
    }

    public int delete(java.lang.String xu)
    {
        return userInfoDao.delete(xu);
    }

    public UserInfo searchByXu(java.lang.String xu) {
        return userInfoDao.searchByXu(xu);
    }
    public PagedList<UserInfo> searchByPage(QueryCondition queryCondition)
    {
        return userInfoDao.searchByPage(queryCondition);
    }
    public List<UserInfo> searchList(QueryParameter queryParameter)
    {
        return userInfoDao.searchList(queryParameter);
    }
}

