package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryOutItem extends EntityBase{

    @DataMapping(InventoryOutItemMapping.Id)
    private int id;//
    @DataMapping(InventoryOutItemMapping.OutItemCode)
    private java.lang.String outItemCode;//出库单详情code
    @DataMapping(InventoryOutItemMapping.OutCode)
    private java.lang.String outCode;//出库单code
    @DataMapping(InventoryOutItemMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryOutItemMapping.Quantity)
    private int quantity;//数量
    @DataMapping(InventoryOutItemMapping.Status)
    private java.lang.String status;//状态
    @DataMapping(InventoryOutItemMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人
    @DataMapping(InventoryOutItemMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryOutItemMapping.CreateTime)
    private int createTime;//创建时间


    public InventoryOutItem() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getOutItemCode()
    {
        return outItemCode;
    }

    public void setOutItemCode(java.lang.String outItemCode)
    {
        this.outItemCode = outItemCode;
    }
    public java.lang.String getOutCode()
    {
        return outCode;
    }

    public void setOutCode(java.lang.String outCode)
    {
        this.outCode = outCode;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
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
    public int getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(int createTime)
    {
        this.createTime = createTime;
    }

}
