package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Role extends EntityBase{

    @DataMapping(RoleMapping.RoleId)
    private int roleId;//
    @DataMapping(RoleMapping.RoleName)
    private java.lang.String roleName;//
    @DataMapping(RoleMapping.Status)
    private int status;//
    @DataMapping(RoleMapping.CreateTime)
    private java.sql.Timestamp createTime;//

    public Role() { }

    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }
    public java.lang.String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(java.lang.String roleName)
    {
        this.roleName = roleName;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
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

}
