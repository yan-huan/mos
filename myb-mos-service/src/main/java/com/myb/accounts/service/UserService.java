package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.User;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface UserService {


    public int insert(User user);

    public int update(User user);

    public int delete(int userId);

    public User searchByUserId(int userId);

    public PagedList<User> searchByPage(QueryCondition queryCondition);

    public List<User> searchList(QueryParameter queryParameter);
    
    //登陆
    public User searchByUserNameAndPassWord(String userName, String passWord);
}

