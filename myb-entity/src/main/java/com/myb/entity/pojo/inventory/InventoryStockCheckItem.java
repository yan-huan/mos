package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryStockCheckItem extends EntityBase{

    @DataMapping(InventoryStockCheckItemMapping.Id)
    private int id;//
    @DataMapping(InventoryStockCheckItemMapping.StockCheckItemCode)
    private java.lang.String stockCheckItemCode;//盘点明细code
    @DataMapping(InventoryStockCheckItemMapping.StockCheckCode)
    private java.lang.String stockCheckCode;//盘点code
    @DataMapping(InventoryStockCheckItemMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryStockCheckItemMapping.StockQuantity)
    private int stockQuantity;//库存数量
    @DataMapping(InventoryStockCheckItemMapping.FactQuantity)
    private int factQuantity;//实际数量
    @DataMapping(InventoryStockCheckItemMapping.DifferenceQuantity)
    private int differenceQuantity;//差异数量
    @DataMapping(InventoryStockCheckItemMapping.Status)
    private java.lang.String status;//状态:已平仓，未平仓
    @DataMapping(InventoryStockCheckItemMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryStockCheckItemMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryStockCheckItemMapping.CreateTime)
    private int createTime;//创建时间
    @DataMapping(InventoryStockCheckItemMapping.UpdateUserCode)
    private java.lang.String updateUserCode;//更新人code
    @DataMapping(InventoryStockCheckItemMapping.UpdateUserName)
    private java.lang.String updateUserName;//更新人姓名
    @DataMapping(InventoryStockCheckItemMapping.UpdateTime)
    private int updateTime;//更新时间


    public InventoryStockCheckItem() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getStockCheckItemCode()
    {
        return stockCheckItemCode;
    }

    public void setStockCheckItemCode(java.lang.String stockCheckItemCode)
    {
        this.stockCheckItemCode = stockCheckItemCode;
    }
    public java.lang.String getStockCheckCode()
    {
        return stockCheckCode;
    }

    public void setStockCheckCode(java.lang.String stockCheckCode)
    {
        this.stockCheckCode = stockCheckCode;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public int getStockQuantity()
    {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity)
    {
        this.stockQuantity = stockQuantity;
    }
    public int getFactQuantity()
    {
        return factQuantity;
    }

    public void setFactQuantity(int factQuantity)
    {
        this.factQuantity = factQuantity;
    }
    public int getDifferenceQuantity()
    {
        return differenceQuantity;
    }

    public void setDifferenceQuantity(int differenceQuantity)
    {
        this.differenceQuantity = differenceQuantity;
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
    public int getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(int updateTime)
    {
        this.updateTime = updateTime;
    }

}
