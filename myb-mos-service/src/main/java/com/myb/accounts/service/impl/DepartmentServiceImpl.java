package com.myb.accounts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.accounts.dao.DepartmentDao;
import com.myb.accounts.service.DepartmentService;
import com.myb.entity.pojo.mos.Department;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentDao departmentDao;

    public int insert(Department department)
    {
        return departmentDao.insert(department);
    }
    public int update(Department department)
    {
        return departmentDao.update(department);
    }

    public int delete(int depId)
    {
        return departmentDao.delete(depId);
    }

    public Department searchByDepId(int depId) {
        return departmentDao.searchByDepId(depId);
    }
    public PagedList<Department> searchByPage(QueryCondition queryCondition)
    {
        return departmentDao.searchByPage(queryCondition);
    }
    public List<Department> searchList(QueryParameter queryParameter)
    {
        return departmentDao.searchList(queryParameter);
    }
}

