package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class EmpRole extends EntityBase{

    @DataMapping(EmpRoleMapping.Id)
    private int id;//
    @DataMapping(EmpRoleMapping.EmpId)
    private int empId;//
    @DataMapping(EmpRoleMapping.RoleId)
    private int roleId;//
    @DataMapping(EmpRoleMapping.Status)
    private int status;//


    public EmpRole() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }
    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
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
