package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class RoleChild extends EntityBase{

    @DataMapping(RoleChildMapping.ChildId)
    private int childId;//
    @DataMapping(RoleChildMapping.RoleId)
    private int roleId;//
    @DataMapping(RoleChildMapping.ChildName)
    private java.lang.String childName;//
    @DataMapping(RoleChildMapping.Status)
    private int status;//
    @DataMapping(RoleChildMapping.OpenUrl)
    private java.lang.String openUrl;//


    public RoleChild() { }

    public int getChildId()
    {
        return childId;
    }

    public void setChildId(int childId)
    {
        this.childId = childId;
    }
    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }
    public java.lang.String getChildName()
    {
        return childName;
    }

    public void setChildName(java.lang.String childName)
    {
        this.childName = childName;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    public java.lang.String getOpenUrl()
    {
        return openUrl;
    }

    public void setOpenUrl(java.lang.String openUrl)
    {
        this.openUrl = openUrl;
    }

}
