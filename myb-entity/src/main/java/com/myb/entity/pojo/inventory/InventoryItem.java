package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryItem extends EntityBase{

    @DataMapping(InventoryItemMapping.Id)
    private int id;//
    @DataMapping(InventoryItemMapping.InventoryItemCode)
    private java.lang.String inventoryItemCode;//库存明细code
    @DataMapping(InventoryItemMapping.InventoryCode)
    private java.lang.String inventoryCode;//库存code
    @DataMapping(InventoryItemMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryItemMapping.AveragePrice)
    private double averagePrice;//加权平均价
    @DataMapping(InventoryItemMapping.StockNumber)
    private int stockNumber;//现有库存
    @DataMapping(InventoryItemMapping.AvailableStockNumber)
    private int availableStockNumber;//可用库存
    @DataMapping(InventoryItemMapping.OccupyStockNumber)
    private int occupyStockNumber;//占用库存
    @DataMapping(InventoryItemMapping.Status)
    private java.lang.String status;//状态：NORMAL--正常；
    @DataMapping(InventoryItemMapping.Version)
    private int version;//乐观锁版本
    @DataMapping(InventoryItemMapping.CreateTime)
    private int createTime;//创建时间
    @DataMapping(InventoryItemMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryItemMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryItemMapping.UpdateTime)
    private int updateTime;//更新时间
    @DataMapping(InventoryItemMapping.UpdateUserCode)
    private java.lang.String updateUserCode;//更新人code
    @DataMapping(InventoryItemMapping.UpdateUserName)
    private java.lang.String updateUserName;//更新人姓名


    public InventoryItem() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getInventoryItemCode()
    {
        return inventoryItemCode;
    }

    public void setInventoryItemCode(java.lang.String inventoryItemCode)
    {
        this.inventoryItemCode = inventoryItemCode;
    }
    public java.lang.String getInventoryCode()
    {
        return inventoryCode;
    }

    public void setInventoryCode(java.lang.String inventoryCode)
    {
        this.inventoryCode = inventoryCode;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public int getStockNumber()
    {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber)
    {
        this.stockNumber = stockNumber;
    }
    public int getAvailableStockNumber()
    {
        return availableStockNumber;
    }

    public void setAvailableStockNumber(int availableStockNumber)
    {
        this.availableStockNumber = availableStockNumber;
    }
    public int getOccupyStockNumber()
    {
        return occupyStockNumber;
    }

    public void setOccupyStockNumber(int occupyStockNumber)
    {
        this.occupyStockNumber = occupyStockNumber;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public int getVersion()
    {
        return version;
    }

    public void setVersion(int version)
    {
        this.version = version;
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

	public double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}

}
