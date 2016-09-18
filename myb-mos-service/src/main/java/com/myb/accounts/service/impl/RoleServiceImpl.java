package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.RoleDao;
import com.myb.accounts.service.RoleService;
import com.myb.entity.pojo.mos.Role;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    public int insert(Role role)
    {
        return roleDao.insert(role);
    }
    public int update(Role role)
    {
        return roleDao.update(role);
    }

    public int delete(int roleId)
    {
        return roleDao.delete(roleId);
    }

    public Role searchByRoleId(int roleId) {
        return roleDao.searchByRoleId(roleId);
    }
    public PagedList<Role> searchByPage(QueryCondition queryCondition)
    {
        return roleDao.searchByPage(queryCondition);
    }
    public List<Role> searchList(QueryParameter queryParameter)
    {
        return roleDao.searchList(queryParameter);
    }
}

