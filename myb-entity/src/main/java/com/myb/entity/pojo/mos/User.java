package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class User extends EntityBase{

    @DataMapping(UserMapping.UserId)
    private int userId;//
    @DataMapping(UserMapping.UserName)
    private java.lang.String userName;//
    @DataMapping(UserMapping.PassWord)
    private java.lang.String passWord;//
    @DataMapping(UserMapping.RealName)
    private java.lang.String realName;//
    @DataMapping(UserMapping.CreateTime)
    private java.sql.Timestamp createTime;//
    @DataMapping(UserMapping.Status)
    private int status;//


    public User() { }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public java.lang.String getUserName()
    {
        return userName;
    }

    public void setUserName(java.lang.String userName)
    {
        this.userName = userName;
    }
    public java.lang.String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(java.lang.String passWord)
    {
        this.passWord = passWord;
    }
    public java.lang.String getRealName()
    {
        return realName;
    }

    public void setRealName(java.lang.String realName)
    {
        this.realName = realName;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime)
    {
        this.createTime = createTime;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

}
