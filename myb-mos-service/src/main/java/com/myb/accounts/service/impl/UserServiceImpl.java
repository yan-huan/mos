package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.UserDao;
import com.myb.accounts.service.UserService;
import com.myb.entity.pojo.mos.User;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public int insert(User user)
    {
        return userDao.insert(user);
    }
    public int update(User user)
    {
        return userDao.update(user);
    }

    public int delete(int userId)
    {
        return userDao.delete(userId);
    }

    public User searchByUserId(int userId) {
        return userDao.searchByUserId(userId);
    }
    public PagedList<User> searchByPage(QueryCondition queryCondition)
    {
        return userDao.searchByPage(queryCondition);
    }
    public List<User> searchList(QueryParameter queryParameter)
    {
        return userDao.searchList(queryParameter);
    }
	@Override
	public User searchByUserNameAndPassWord(String userName, String passWord) {
		return userDao.searchByUserNameAndPassWord(userName,passWord);
	}
}

