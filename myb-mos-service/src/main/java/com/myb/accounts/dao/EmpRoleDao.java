package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.EmpRole;
import com.myb.entity.pojo.mos.EmpRoleMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("empRoleDao")
public class EmpRoleDao extends MySqlCommandBase
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
        return "emp_role";
    }


    public int insert(EmpRole empRole)
    {
        String sql="INSERT INTO "+getTableName()+" (id,empId,roleId,status)VALUES(@{id},@{empId},@{roleId},@{status})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmpRoleMapping.Id, empRole.getId());
        sqlParameter.add(EmpRoleMapping.EmpId, empRole.getEmpId());
        sqlParameter.add(EmpRoleMapping.RoleId, empRole.getRoleId());
        sqlParameter.add(EmpRoleMapping.Status, empRole.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(EmpRole empRole)
    {
        String sql="UPDATE "+getTableName()+" set empId=@{empId},roleId=@{roleId},status=@{status} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmpRoleMapping.Id, empRole.getId());
        sqlParameter.add(EmpRoleMapping.EmpId, empRole.getEmpId());
        sqlParameter.add(EmpRoleMapping.RoleId, empRole.getRoleId());
        sqlParameter.add(EmpRoleMapping.Status, empRole.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmpRoleMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public EmpRole searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(EmpRoleMapping.Id,id);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, EmpRole.class);
    }
    public PagedList<EmpRole> searchByPage(QueryCondition queryCondition) {
        PagedList<EmpRole> pagedList=this.searchByPage(queryCondition, EmpRole.class);
        return pagedList;
    }
    public List<EmpRole> searchList(QueryParameter queryParameter) {
                List<EmpRole> list=this.searchList(queryParameter, EmpRole.class);
                    return list;
    }
}
