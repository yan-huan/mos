package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.Role;
import com.myb.entity.pojo.mos.RoleMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("roleDao")
public class RoleDao extends MySqlCommandBase
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
        return "role";
    }


    public int insert(Role role)
    {
        String sql="INSERT INTO "+getTableName()+" (roleId,roleName,status,createTime)VALUES(@{roleId},@{roleName},@{status},@{createTime})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleMapping.RoleId, role.getRoleId());
        sqlParameter.add(RoleMapping.RoleName, role.getRoleName());
        sqlParameter.add(RoleMapping.Status, role.getStatus());
        sqlParameter.add(RoleMapping.CreateTime, role.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(Role role)
    {
        String sql="UPDATE "+getTableName()+" set roleName=@{roleName},status=@{status},createTime=@{createTime} WHERE roleId=@{roleId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleMapping.RoleId, role.getRoleId());
        sqlParameter.add(RoleMapping.RoleName, role.getRoleName());
        sqlParameter.add(RoleMapping.Status, role.getStatus());
        sqlParameter.add(RoleMapping.CreateTime, role.getCreateTime());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int roleId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE roleId=@{roleId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleMapping.RoleId,roleId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public Role searchByRoleId(int roleId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE roleId=@{roleId} and status =1";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleMapping.RoleId,roleId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, Role.class);
    }
    public PagedList<Role> searchByPage(QueryCondition queryCondition) {
        PagedList<Role> pagedList=this.searchByPage(queryCondition, Role.class);
        return pagedList;
    }
    public List<Role> searchList(QueryParameter queryParameter) {
                List<Role> list=this.searchList(queryParameter, Role.class);
                    return list;
    }
}
