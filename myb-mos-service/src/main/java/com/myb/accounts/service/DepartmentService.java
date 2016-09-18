package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Department;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface DepartmentService {


    public int insert(Department department);

    public int update(Department department);

    public int delete(int depId);

    public Department searchByDepId(int depId);

    public PagedList<Department> searchByPage(QueryCondition queryCondition);

    public List<Department> searchList(QueryParameter queryParameter);
}

