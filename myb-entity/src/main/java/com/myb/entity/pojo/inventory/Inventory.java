package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class Inventory extends EntityBase{

    @DataMapping(InventoryMapping.Id)
    private int id;//
    @DataMapping(InventoryMapping.InventoryCode)
    private java.lang.String inventoryCode;//库存code
    @DataMapping(InventoryMapping.InventoryName)
    private java.lang.String inventoryName;//仓库名称
    @DataMapping(InventoryMapping.ParentCode)
    private java.lang.String parentCode;//父仓code
    @DataMapping(InventoryMapping.ChildCode)
    private java.lang.String childCode;//子仓code
    @DataMapping(InventoryMapping.InventoryType)
    private java.lang.String inventoryType;//父仓，子仓
    @DataMapping(InventoryMapping.Status)
    private java.lang.String status;//状态:NORMAL--正常;
    @DataMapping(InventoryMapping.CreateTime)
    private int createTime;//创建时间
    @DataMapping(InventoryMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryMapping.UpdateTime)
    private int updateTime;//更新时间
    @DataMapping(InventoryMapping.UpdateUserCode)
    private java.lang.String updateUserCode;//更新人code
    @DataMapping(InventoryMapping.UpdateUserName)
    private java.lang.String updateUserName;//更新人姓名


    public Inventory() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getInventoryCode()
    {
        return inventoryCode;
    }

    public void setInventoryCode(java.lang.String inventoryCode)
    {
        this.inventoryCode = inventoryCode;
    }
    public java.lang.String getInventoryName()
    {
        return inventoryName;
    }

    public void setInventoryName(java.lang.String inventoryName)
    {
        this.inventoryName = inventoryName;
    }
    public java.lang.String getParentCode()
    {
        return parentCode;
    }

    public void setParentCode(java.lang.String parentCode)
    {
        this.parentCode = parentCode;
    }
    public java.lang.String getChildCode()
    {
        return childCode;
    }

    public void setChildCode(java.lang.String childCode)
    {
        this.childCode = childCode;
    }
    public java.lang.String getInventoryType()
    {
        return inventoryType;
    }

    public void setInventoryType(java.lang.String inventoryType)
    {
        this.inventoryType = inventoryType;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public int getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(int createTime)
    {
        this.createTime = createTime;
    }
    public java.lang.String getCreateUserCode()
    {
        return createUserCode;
    }

    public void setCreateUserCode(java.lang.String createUserCode)
    {
        this.createUserCode = createUserCode;
    }
    public java.lang.String getCreateUserName()
    {
        return createUserName;
    }

    public void setCreateUserName(java.lang.String createUserName)
    {
        this.createUserName = createUserName;
    }
    public int getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(int updateTime)
    {
        this.updateTime = updateTime;
    }
    public java.lang.String getUpdateUserCode()
    {
        return updateUserCode;
    }

    public void setUpdateUserCode(java.lang.String updateUserCode)
    {
        this.updateUserCode = updateUserCode;
    }
    public java.lang.String getUpdateUserName()
    {
        return updateUserName;
    }

    public void setUpdateUserName(java.lang.String updateUserName)
    {
        this.updateUserName = updateUserName;
    }

}
