package com.myb.feedback.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.feedback.DbUser;
import com.myb.entity.pojo.feedback.DbUserMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("dbUserDao")
public class DbUserDao extends MySqlCommandBase
{

    @Resource(name = "datacommand")
    private DataCommand dataCommand;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "db_user";
    }


    public int insert(DbUser dbUser)
    {
        String sql="INSERT INTO "+getTableName()+" (id,addTime,modifyTime,administrator,department,email,mobile,password,qq,uname,username,weixin)VALUES(@{id},@{addTime},@{modifyTime},@{administrator},@{department},@{email},@{mobile},@{password},@{qq},@{uname},@{username},@{weixin})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbUserMapping.Id, dbUser.getId());
        sqlParameter.add(DbUserMapping.AddTime, dbUser.getAddTime());
        sqlParameter.add(DbUserMapping.ModifyTime, dbUser.getModifyTime());
        sqlParameter.add(DbUserMapping.Administrator, dbUser.getAdministrator());
        sqlParameter.add(DbUserMapping.Department, dbUser.getDepartment());
        sqlParameter.add(DbUserMapping.Email, dbUser.getEmail());
        sqlParameter.add(DbUserMapping.Mobile, dbUser.getMobile());
        sqlParameter.add(DbUserMapping.Password, dbUser.getPassword());
        sqlParameter.add(DbUserMapping.Qq, dbUser.getQq());
        sqlParameter.add(DbUserMapping.Uname, dbUser.getUname());
        sqlParameter.add(DbUserMapping.Username, dbUser.getUsername());
        sqlParameter.add(DbUserMapping.Weixin, dbUser.getWeixin());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(DbUser dbUser)
    {
        String sql="UPDATE "+getTableName()+" set addTime=@{addTime},modifyTime=@{modifyTime},administrator=@{administrator},department=@{department},email=@{email},mobile=@{mobile},password=@{password},qq=@{qq},uname=@{uname},username=@{username},weixin=@{weixin} WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbUserMapping.Id, dbUser.getId());
        sqlParameter.add(DbUserMapping.AddTime, dbUser.getAddTime());
        sqlParameter.add(DbUserMapping.ModifyTime, dbUser.getModifyTime());
        sqlParameter.add(DbUserMapping.Administrator, dbUser.getAdministrator());
        sqlParameter.add(DbUserMapping.Department, dbUser.getDepartment());
        sqlParameter.add(DbUserMapping.Email, dbUser.getEmail());
        sqlParameter.add(DbUserMapping.Mobile, dbUser.getMobile());
        sqlParameter.add(DbUserMapping.Password, dbUser.getPassword());
        sqlParameter.add(DbUserMapping.Qq, dbUser.getQq());
        sqlParameter.add(DbUserMapping.Uname, dbUser.getUname());
        sqlParameter.add(DbUserMapping.Username, dbUser.getUsername());
        sqlParameter.add(DbUserMapping.Weixin, dbUser.getWeixin());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int id)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbUserMapping.Id,id);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public DbUser searchById(int id)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE id=@{id}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(DbUserMapping.Id,id);
        return this.dataCommand.executeEntity(sql, sqlParameter, DbUser.class);
    }
    public PagedList<DbUser> searchByPage(QueryCondition queryCondition) {
        PagedList<DbUser> pagedList=this.searchByPage(queryCondition, DbUser.class);
        return pagedList;
    }
    public List<DbUser> searchList(QueryParameter queryParameter) {
                List<DbUser> list=this.searchList(queryParameter, DbUser.class);
                    return list;
    }
}
