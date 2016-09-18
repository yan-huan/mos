package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.RoleChild;
import com.myb.entity.pojo.mos.RoleChildMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("roleChildDao")
public class RoleChildDao extends MySqlCommandBase
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
        return "role_child";
    }


    public int insert(RoleChild roleChild)
    {
        String sql="INSERT INTO "+getTableName()+" (childId,roleId,childName,status)VALUES(@{childId},@{roleId},@{childName},@{status})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleChildMapping.ChildId, roleChild.getChildId());
        sqlParameter.add(RoleChildMapping.RoleId, roleChild.getRoleId());
        sqlParameter.add(RoleChildMapping.ChildName, roleChild.getChildName());
        sqlParameter.add(RoleChildMapping.Status, roleChild.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(RoleChild roleChild)
    {
        String sql="UPDATE "+getTableName()+" set roleId=@{roleId},childName=@{childName},status=@{status} WHERE childId=@{childId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleChildMapping.ChildId, roleChild.getChildId());
        sqlParameter.add(RoleChildMapping.RoleId, roleChild.getRoleId());
        sqlParameter.add(RoleChildMapping.ChildName, roleChild.getChildName());
        sqlParameter.add(RoleChildMapping.Status, roleChild.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int childId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE childId=@{childId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleChildMapping.ChildId,childId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public RoleChild searchByChildId(int childId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE childId=@{childId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(RoleChildMapping.ChildId,childId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, RoleChild.class);
    }
    public PagedList<RoleChild> searchByPage(QueryCondition queryCondition) {
        PagedList<RoleChild> pagedList=this.searchByPage(queryCondition, RoleChild.class);
        return pagedList;
    }
    public List<RoleChild> searchList(QueryParameter queryParameter) {
                List<RoleChild> list=this.searchList(queryParameter, RoleChild.class);
                    return list;
    }
}
