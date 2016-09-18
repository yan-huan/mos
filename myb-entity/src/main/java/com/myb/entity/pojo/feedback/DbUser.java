package com.myb.entity.pojo.feedback;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class DbUser extends EntityBase{

    @DataMapping(DbUserMapping.Id)
    private int id;//
    @DataMapping(DbUserMapping.AddTime)
    private java.sql.Timestamp addTime;//
    @DataMapping(DbUserMapping.ModifyTime)
    private java.sql.Timestamp modifyTime;//
    @DataMapping(DbUserMapping.Administrator)
    private int administrator;//
    @DataMapping(DbUserMapping.Department)
    private int department;//
    @DataMapping(DbUserMapping.Email)
    private java.lang.String email;//
    @DataMapping(DbUserMapping.Mobile)
    private java.lang.String mobile;//
    @DataMapping(DbUserMapping.Password)
    private java.lang.String password;//
    @DataMapping(DbUserMapping.Qq)
    private java.lang.String qq;//
    @DataMapping(DbUserMapping.Uname)
    private java.lang.String uname;//
    @DataMapping(DbUserMapping.Username)
    private java.lang.String username;//
    @DataMapping(DbUserMapping.Weixin)
    private java.lang.String weixin;//


    public DbUser() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getAddTime()
    {
        return addTime;
    }

    public void setAddTime(java.sql.Timestamp addTime)
    {
        this.addTime = addTime;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getModifyTime()
    {
        return modifyTime;
    }

    public void setModifyTime(java.sql.Timestamp modifyTime)
    {
        this.modifyTime = modifyTime;
    }
    public int getAdministrator()
    {
        return administrator;
    }

    public void setAdministrator(int administrator)
    {
        this.administrator = administrator;
    }
    public int getDepartment()
    {
        return department;
    }

    public void setDepartment(int department)
    {
        this.department = department;
    }
    public java.lang.String getEmail()
    {
        return email;
    }

    public void setEmail(java.lang.String email)
    {
        this.email = email;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
    }
    public java.lang.String getPassword()
    {
        return password;
    }

    public void setPassword(java.lang.String password)
    {
        this.password = password;
    }
    public java.lang.String getQq()
    {
        return qq;
    }

    public void setQq(java.lang.String qq)
    {
        this.qq = qq;
    }
    public java.lang.String getUname()
    {
        return uname;
    }

    public void setUname(java.lang.String uname)
    {
        this.uname = uname;
    }
    public java.lang.String getUsername()
    {
        return username;
    }

    public void setUsername(java.lang.String username)
    {
        this.username = username;
    }
    public java.lang.String getWeixin()
    {
        return weixin;
    }

    public void setWeixin(java.lang.String weixin)
    {
        this.weixin = weixin;
    }

}
