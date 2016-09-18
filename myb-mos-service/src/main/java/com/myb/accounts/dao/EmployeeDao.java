package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Employee;
import com.myb.entity.pojo.mos.EmployeeMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("employeeDao")
public class EmployeeDao extends MySqlCommandBase
{

    @Resource(name = "datacommand_write")
    private DataCommand dataCommandWrite;
    
    @Resource(name = "datacommand_read")
    private DataCommand dataCommandRead;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommandWrite);
    }
    @Override
    public String getTableName()
    {
        return "employee";
    }


    public int insert(Employee employee)
    {
        String sql="INSERT INTO "+getTableName()+" (empId,parentId,empName,account,empCode,dutyId,parentName,depName,cityPermission,isUsed,userName,passWord,status,ran,entryTime,cityId,quitTime,createTime)VALUES("
        		+ "@{empId},@{parentId},@{empName},@{account},@{empCode},@{dutyId},@{parentName},@{depName},@{cityPermission},@{isUsed},@{userName},@{passWord},@{status},@{ran},@{entryTime},@{cityId},@{quitTime},@{createTime})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmployeeMapping.EmpId, employee.getEmpId());
        sqlParameter.add(EmployeeMapping.ParentId, employee.getParentId());
        sqlParameter.add(EmployeeMapping.EmpName, employee.getEmpName());
        sqlParameter.add(EmployeeMapping.Account, employee.getAccount());
        sqlParameter.add(EmployeeMapping.EmpCode, employee.getEmpCode());
        sqlParameter.add(EmployeeMapping.DutyId, employee.getDutyId());
        sqlParameter.add(EmployeeMapping.ParentName, employee.getParentName());
        sqlParameter.add(EmployeeMapping.DepName, employee.getDepName());
        sqlParameter.add(EmployeeMapping.CityPermission, employee.getCityPermission());
        sqlParameter.add(EmployeeMapping.IsUsed, employee.getIsUsed());
        sqlParameter.add(EmployeeMapping.UserName, employee.getUserName());
        sqlParameter.add(EmployeeMapping.PassWord, employee.getPassWord());
        sqlParameter.add(EmployeeMapping.Status, employee.getStatus());
        sqlParameter.add(EmployeeMapping.IsUsed,employee.getIsUsed());
        sqlParameter.add(EmployeeMapping.Ran,employee.getRan());
        sqlParameter.add(EmployeeMapping.EntryTime,employee.getEntryTime());
        sqlParameter.add(EmployeeMapping.QuitTime,employee.getQuitTime());
        sqlParameter.add(EmployeeMapping.CreateTime,employee.getCreateTime());
        sqlParameter.add(EmployeeMapping.CityId,employee.getCityId());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Employee employee)
    {
        String sql="UPDATE "+getTableName()+" set parentId=@{parentId},empName=@{empName},account=@{account},empCode=@{empCode},dutyId=@{dutyId},parentName=@{parentName},depName=@{depName},cityPermission=@{cityPermission},isUsed=@{isUsed},userName=@{userName},passWord=@{passWord},ran=@{ran},entryTime=@{entryTime},cityId=@{cityId},quitTime=@{quitTime},createTime=@{createTime} WHERE empId=@{empId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmployeeMapping.EmpId, employee.getEmpId());
        sqlParameter.add(EmployeeMapping.ParentId, employee.getParentId());
        sqlParameter.add(EmployeeMapping.EmpName, employee.getEmpName());
        sqlParameter.add(EmployeeMapping.Account, employee.getAccount());
        sqlParameter.add(EmployeeMapping.EmpCode, employee.getEmpCode());
        sqlParameter.add(EmployeeMapping.DutyId, employee.getDutyId());
        sqlParameter.add(EmployeeMapping.ParentName, employee.getParentName());
        sqlParameter.add(EmployeeMapping.DepName, employee.getDepName());
        sqlParameter.add(EmployeeMapping.CityPermission, employee.getCityPermission());
        sqlParameter.add(EmployeeMapping.IsUsed, employee.getIsUsed());
        sqlParameter.add(EmployeeMapping.UserName, employee.getUserName());
        sqlParameter.add(EmployeeMapping.PassWord, employee.getPassWord());
        sqlParameter.add(EmployeeMapping.Ran, employee.getRan());
        sqlParameter.add(EmployeeMapping.Ran, employee.getRan());
        sqlParameter.add(EmployeeMapping.EntryTime,employee.getEntryTime());
        sqlParameter.add(EmployeeMapping.CityId,employee.getCityId());
        sqlParameter.add(EmployeeMapping.QuitTime,employee.getQuitTime());
        sqlParameter.add(EmployeeMapping.CreateTime,employee.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int empId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE empId=@{empId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmployeeMapping.EmpId,empId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Employee searchByEmpId(int empId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE empId=@{empId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmployeeMapping.EmpId,empId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Employee.class);
    }
    
    public Employee searchByUserName(String userName)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE userName=@{userName}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmployeeMapping.UserName,userName);
        return this.dataCommandWrite.executeEntity(sql, sqlParameter, Employee.class);
    }
    
    public Employee searchByUserNameAndPassWord(String userName, String  passWord)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE userName=@{userName} and passWord=@{passWord}  and status = 1 and isUsed = 1";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmployeeMapping.UserName,userName);
        sqlParameter.add(EmployeeMapping.PassWord,passWord);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Employee.class);
    }
    
    public PagedList<Employee> searchByPage(QueryCondition queryCondition) {
        PagedList<Employee> pagedList=this.searchByPage(queryCondition, Employee.class);
        return pagedList;
    }
    public List<Employee> searchList(QueryParameter queryParameter) {
                List<Employee> list=this.searchList(queryParameter, Employee.class);
                    return list;
    }
}
