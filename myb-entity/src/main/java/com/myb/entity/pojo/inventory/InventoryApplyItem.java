package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryApplyItem extends EntityBase{

    @DataMapping(InventoryApplyItemMapping.Id)
    private int id;//
    @DataMapping(InventoryApplyItemMapping.ApplyItemCode)
    private java.lang.String applyItemCode;//申请单明细code
    @DataMapping(InventoryApplyItemMapping.ApplyCode)
    private java.lang.String applyCode;//申请单code
    @DataMapping(InventoryApplyItemMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryApplyItemMapping.Quantity)
    private int quantity;//数量
    @DataMapping(InventoryApplyItemMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryApplyItemMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryApplyItemMapping.CreateTime)
    private int createTime;//创建时间


    public InventoryApplyItem() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getApplyItemCode()
    {
        return applyItemCode;
    }

    public void setApplyItemCode(java.lang.String applyItemCode)
    {
        this.applyItemCode = applyItemCode;
    }
    public java.lang.String getApplyCode()
    {
        return applyCode;
    }

    public void setApplyCode(java.lang.String applyCode)
    {
        this.applyCode = applyCode;
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
