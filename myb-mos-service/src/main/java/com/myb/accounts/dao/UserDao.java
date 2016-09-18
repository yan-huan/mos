package com.myb.accounts.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.myb.entity.pojo.mos.User;
import com.myb.entity.pojo.mos.UserMapping;
import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

@Repository("userDao")
public class UserDao extends MySqlCommandBase
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
        return "user";
    }


    public int insert(User user)
    {
        String sql="INSERT INTO "+getTableName()+" (userId,userName,passWord,realName,createTime,status)VALUES(@{userId},@{userName},@{passWord},@{realName},@{createTime},@{status})";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserMapping.UserId, user.getUserId());
        sqlParameter.add(UserMapping.UserName, user.getUserName());
        sqlParameter.add(UserMapping.PassWord, user.getPassWord());
        sqlParameter.add(UserMapping.RealName, user.getRealName());
        sqlParameter.add(UserMapping.CreateTime, user.getCreateTime());
        sqlParameter.add(UserMapping.Status, user.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(User user)
    {
        String sql="UPDATE "+getTableName()+" set userName=@{userName},passWord=@{passWord},realName=@{realName},createTime=@{createTime},status=@{status} WHERE userId=@{userId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserMapping.UserId, user.getUserId());
        sqlParameter.add(UserMapping.UserName, user.getUserName());
        sqlParameter.add(UserMapping.PassWord, user.getPassWord());
        sqlParameter.add(UserMapping.RealName, user.getRealName());
        sqlParameter.add(UserMapping.CreateTime, user.getCreateTime());
        sqlParameter.add(UserMapping.Status, user.getStatus());
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(int userId)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE userId=@{userId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserMapping.UserId,userId);
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public User searchByUserId(int userId)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE userId=@{userId}";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserMapping.UserId,userId);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, User.class);
    }
    public PagedList<User> searchByPage(QueryCondition queryCondition) {
        PagedList<User> pagedList=this.searchByPage(queryCondition, User.class);
        return pagedList;
    }
    public List<User> searchList(QueryParameter queryParameter) {
                List<User> list=this.searchList(queryParameter, User.class);
                    return list;
    }
    
    public User searchByUserNameAndPassWord(String userName, String  passWord)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE userName=@{userName} and passWord=@{passWord}  and status=1";
        SqlParameter sqlParameter=new SqlParameter();
        sqlParameter.add(UserMapping.UserName,userName);
        sqlParameter.add(UserMapping.PassWord,passWord);
        return this.dataCommandRead.executeEntity(sql, sqlParameter, User.class);
    }
    
}
