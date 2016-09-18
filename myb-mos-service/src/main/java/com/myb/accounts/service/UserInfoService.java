package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.UserInfo;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface UserInfoService {


    public int insert(UserInfo sheet0);

    public int update(UserInfo sheet0);

    public int delete(java.lang.String xu);

    public UserInfo searchByXu(java.lang.String xu);

    public PagedList<UserInfo> searchByPage(QueryCondition queryCondition);

    public List<UserInfo> searchList(QueryParameter queryParameter);
}

