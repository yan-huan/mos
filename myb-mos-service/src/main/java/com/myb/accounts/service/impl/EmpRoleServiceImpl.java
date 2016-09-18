package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.EmpRoleDao;
import com.myb.accounts.service.EmpRoleService;
import com.myb.entity.pojo.mos.EmpRole;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("empRoleService")
public class EmpRoleServiceImpl implements EmpRoleService{

    @Autowired
    private EmpRoleDao empRoleDao;

    public int insert(EmpRole empRole)
    {
        return empRoleDao.insert(empRole);
    }
    public int update(EmpRole empRole)
    {
        return empRoleDao.update(empRole);
    }

    public int delete(int id)
    {
        return empRoleDao.delete(id);
    }

    public EmpRole searchById(int id) {
        return empRoleDao.searchById(id);
    }
    public PagedList<EmpRole> searchByPage(QueryCondition queryCondition)
    {
        return empRoleDao.searchByPage(queryCondition);
    }
    public List<EmpRole> searchList(QueryParameter queryParameter)
    {
        return empRoleDao.searchList(queryParameter);
    }
}

