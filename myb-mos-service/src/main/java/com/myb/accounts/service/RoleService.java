package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Role;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface RoleService {


    public int insert(Role role);

    public int update(Role role);

    public int delete(int roleId);

    public Role searchByRoleId(int roleId);

    public PagedList<Role> searchByPage(QueryCondition queryCondition);

    public List<Role> searchList(QueryParameter queryParameter);
}

