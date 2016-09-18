package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class AddressAreaDef extends EntityBase{

    @DataMapping(AddressAreaDefMapping.Id)
    private int id;//
    @DataMapping(AddressAreaDefMapping.Code)
    private java.lang.String code;//地址code
    @DataMapping(AddressAreaDefMapping.ParentCode)
    private java.lang.String parentCode;//父地址code
    @DataMapping(AddressAreaDefMapping.ObjName)
    private java.lang.String objName;//中文名称
    @DataMapping(AddressAreaDefMapping.PlNo)
    private java.lang.String plNo;//
    @DataMapping(AddressAreaDefMapping.Status)
    private java.lang.String status;//状态：INIT--初始化；NORMAL--正常使用；LOCKED--锁定；DELETED--逻辑删除。


    public AddressAreaDef() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getCode()
    {
        return code;
    }

    public void setCode(java.lang.String code)
    {
        this.code = code;
    }
    public java.lang.String getParentCode()
    {
        return parentCode;
    }

    public void setParentCode(java.lang.String parentCode)
    {
        this.parentCode = parentCode;
    }
    public java.lang.String getObjName()
    {
        return objName;
    }

    public void setObjName(java.lang.String objName)
    {
        this.objName = objName;
    }
    public java.lang.String getPlNo()
    {
        return plNo;
    }

    public void setPlNo(java.lang.String plNo)
    {
        this.plNo = plNo;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }

}
