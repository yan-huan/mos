package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryStockCheck extends EntityBase{

    @DataMapping(InventoryStockCheckMapping.Id)
    private int id;//
    @DataMapping(InventoryStockCheckMapping.StockCheckCode)
    private java.lang.String stockCheckCode;//盘点code
    @DataMapping(InventoryStockCheckMapping.InventoryCode)
    private java.lang.String inventoryCode;//库存code
    @DataMapping(InventoryStockCheckMapping.Status)
    private java.lang.String status;//状态
    @DataMapping(InventoryStockCheckMapping.StartTime)
    private int startTime;//开始时间
    @DataMapping(InventoryStockCheckMapping.EndTime)
    private int endTime;//结束时间
    @DataMapping(InventoryStockCheckMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryStockCheckMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryStockCheckMapping.CreateTime)
    private int createTime;//创建时间


    public InventoryStockCheck() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getStockCheckCode()
    {
        return stockCheckCode;
    }

    public void setStockCheckCode(java.lang.String stockCheckCode)
    {
        this.stockCheckCode = stockCheckCode;
    }
    public java.lang.String getInventoryCode()
    {
        return inventoryCode;
    }

    public void setInventoryCode(java.lang.String inventoryCode)
    {
        this.inventoryCode = inventoryCode;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public int getStartTime()
    {
        return startTime;
    }

    public void setStartTime(int startTime)
    {
        this.startTime = startTime;
    }
    public int getEndTime()
    {
        return endTime;
    }

    public void setEndTime(int endTime)
    {
        this.endTime = endTime;
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
