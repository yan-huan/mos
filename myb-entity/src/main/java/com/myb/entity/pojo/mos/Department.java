package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Department extends EntityBase{

    @DataMapping(DepartmentMapping.DepId)
    private int depId;//
    @DataMapping(DepartmentMapping.DepCode)
    private java.lang.String depCode;//部门编码
    @DataMapping(DepartmentMapping.DepName)
    private java.lang.String depName;//
    @DataMapping(DepartmentMapping.ParentId)
    private int parentId;//上级部门id
    @DataMapping(DepartmentMapping.IsUsed)
    private int isUsed;//


    public Department() { }

    public int getDepId()
    {
        return depId;
    }

    public void setDepId(int depId)
    {
        this.depId = depId;
    }
    public java.lang.String getDepCode()
    {
        return depCode;
    }

    public void setDepCode(java.lang.String depCode)
    {
        this.depCode = depCode;
    }
    public java.lang.String getDepName()
    {
        return depName;
    }

    public void setDepName(java.lang.String depName)
    {
        this.depName = depName;
    }
    public int getParentId()
    {
        return parentId;
    }

    public void setParentId(int parentId)
    {
        this.parentId = parentId;
    }
    public int getIsUsed()
    {
        return isUsed;
    }

    public void setIsUsed(int isUsed)
    {
        this.isUsed = isUsed;
    }

}
