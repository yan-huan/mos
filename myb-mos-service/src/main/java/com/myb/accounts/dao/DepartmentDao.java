package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Department;
import com.myb.entity.pojo.mos.DepartmentMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("departmentDao")
public class DepartmentDao extends MySqlCommandBase
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
        return "department";
    }


    public int insert(Department department)
    {
        String sql="INSERT INTO "+getTableName()+" (depId,depCode,depName,parentId,isUsed)VALUES(@{depId},@{depCode},@{depName},@{parentId},@{isUsed})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DepartmentMapping.DepId, department.getDepId());
        sqlParameter.add(DepartmentMapping.DepCode, department.getDepCode());
        sqlParameter.add(DepartmentMapping.DepName, department.getDepName());
        sqlParameter.add(DepartmentMapping.ParentId, department.getParentId());
        sqlParameter.add(DepartmentMapping.IsUsed, department.getIsUsed());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Department department)
    {
        String sql="UPDATE "+getTableName()+" set depCode=@{depCode},depName=@{depName},parentId=@{parentId},isUsed=@{isUsed} WHERE depId=@{depId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DepartmentMapping.DepId, department.getDepId());
        sqlParameter.add(DepartmentMapping.DepCode, department.getDepCode());
        sqlParameter.add(DepartmentMapping.DepName, department.getDepName());
        sqlParameter.add(DepartmentMapping.ParentId, department.getParentId());
        sqlParameter.add(DepartmentMapping.IsUsed, department.getIsUsed());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int depId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE depId=@{depId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DepartmentMapping.DepId,depId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Department searchByDepId(int depId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE depId=@{depId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DepartmentMapping.DepId,depId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Department.class);
    }
    public PagedList<Department> searchByPage(QueryCondition queryCondition) {
        PagedList<Department> pagedList=this.searchByPage(queryCondition, Department.class);
        return pagedList;
    }
    public List<Department> searchList(QueryParameter queryParameter) {
                List<Department> list=this.searchList(queryParameter, Department.class);
                    return list;
    }
}
