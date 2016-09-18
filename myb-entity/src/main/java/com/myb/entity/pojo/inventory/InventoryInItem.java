package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryInItem extends EntityBase{

    @DataMapping(InventoryInItemMapping.Id)
    private int id;//
    @DataMapping(InventoryInItemMapping.InItemCode)
    private java.lang.String inItemCode;//入库单编码
    @DataMapping(InventoryInItemMapping.InCode)
    private java.lang.String inCode;//入库单code
    @DataMapping(InventoryInItemMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryInItemMapping.ProductionTime)
    private int productionTime;//生产日期
    @DataMapping(InventoryInItemMapping.ProductExpiredTime)
    private int productExpiredTime;//过期时间
    @DataMapping(InventoryInItemMapping.SinglePrice)
    private double singlePrice;//单价
    @DataMapping(InventoryInItemMapping.Quantity)
    private int quantity;//数量
    @DataMapping(InventoryInItemMapping.Status)
    private java.lang.String status;//状态
    @DataMapping(InventoryInItemMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryInItemMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryInItemMapping.CreateTime)
    private int createTime;//创建时间


    public InventoryInItem() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getInItemCode()
    {
        return inItemCode;
    }

    public void setInItemCode(java.lang.String inItemCode)
    {
        this.inItemCode = inItemCode;
    }
    public java.lang.String getInCode()
    {
        return inCode;
    }

    public void setInCode(java.lang.String inCode)
    {
        this.inCode = inCode;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public int getProductionTime()
    {
        return productionTime;
    }

    public void setProductionTime(int productionTime)
    {
        this.productionTime = productionTime;
    }
    public int getProductExpiredTime()
    {
        return productExpiredTime;
    }

    public void setProductExpiredTime(int productExpiredTime)
    {
        this.productExpiredTime = productExpiredTime;
    }
    public double getSinglePrice()
    {
        return singlePrice;
    }

    public void setSinglePrice(double singlePrice)
    {
        this.singlePrice = singlePrice;
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
