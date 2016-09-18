package com.myb.accounts.service;

import java.util.List;

import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.User;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;

public interface EmployeeService {


    public int insert(Employee employee);

    public int update(Employee employee);

    public int delete(int empId);

    public Employee searchByEmpId(int empId);
    
    public Employee searchByUserName(String userName);

    public PagedList<Employee> searchByPage(QueryCondition queryCondition);

    public List<Employee> searchList(QueryParameter queryParameter);
    
    //登陆
    public Employee searchByUserNameAndPassWord(String userName, String passWord);

}

