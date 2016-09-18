package com.myb.mos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.myb.entity.pojo.mos.Employee;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.mos.dao.EmployeeDao;
import com.myb.mos.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    public int insert(Employee employee)
    {
        return employeeDao.insert(employee);
    }
    public int update(Employee employee)
    {
        return employeeDao.update(employee);
    }

    public int delete(int empId)
    {
        return employeeDao.delete(empId);
    }

    public Employee searchByEmpId(int empId) {
        return employeeDao.searchByEmpId(empId);
    }
    public PagedList<Employee> searchByPage(QueryCondition queryCondition)
    {
        return employeeDao.searchByPage(queryCondition);
    }
    public List<Employee> searchList(QueryParameter queryParameter)
    {
        return employeeDao.searchList(queryParameter);
    }
	@Override
	public Employee searchByUserNameAndPassWord(String userName, String passWord) {
		
		Employee employee = employeeDao.searchByUserNameAndPassWord(userName, passWord);
		return employee;
	}
	@Override
	public Employee searchByUserName(String userName) {
		Employee  employee = employeeDao.searchByUserName(userName);
		return employee;
	}
	
}

