package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.RoleChildDao;
import com.myb.accounts.service.RoleChildService;
import com.myb.entity.pojo.mos.RoleChild;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("roleChildService")
public class RoleChildServiceImpl implements RoleChildService{

    @Autowired
    private RoleChildDao roleChildDao;

    public int insert(RoleChild roleChild)
    {
        return roleChildDao.insert(roleChild);
    }
    public int update(RoleChild roleChild)
    {
        return roleChildDao.update(roleChild);
    }

    public int delete(int childId)
    {
        return roleChildDao.delete(childId);
    }

    public RoleChild searchByChildId(int childId) {
        return roleChildDao.searchByChildId(childId);
    }
    public PagedList<RoleChild> searchByPage(QueryCondition queryCondition)
    {
        return roleChildDao.searchByPage(queryCondition);
    }
    public List<RoleChild> searchList(QueryParameter queryParameter)
    {
        return roleChildDao.searchList(queryParameter);
    }
}

