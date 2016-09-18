package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryStockCheckProfitShortages extends EntityBase{

    @DataMapping(InventoryStockCheckProfitShortagesMapping.Id)
    private int id;//
    @DataMapping(InventoryStockCheckProfitShortagesMapping.ProfitShortagesCode)
    private java.lang.String profitShortagesCode;//盘盈盘亏code
    @DataMapping(InventoryStockCheckProfitShortagesMapping.StockCheckItemCode)
    private java.lang.String stockCheckItemCode;//盘点明细code
    @DataMapping(InventoryStockCheckProfitShortagesMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryStockCheckProfitShortagesMapping.Comment)
    private java.lang.String comment;//备注信息
    @DataMapping(InventoryStockCheckProfitShortagesMapping.OriginalDocument)
    private java.lang.String originalDocument;//原始单据号
    @DataMapping(InventoryStockCheckProfitShortagesMapping.WarehouseCode)
    private java.lang.String warehouseCode;//补货仓code
    @DataMapping(InventoryStockCheckProfitShortagesMapping.WarehouseName)
    private java.lang.String warehouseName;//补货仓名称
    @DataMapping(InventoryStockCheckProfitShortagesMapping.Type)
    private java.lang.String type;//盘盈,盘亏
    @DataMapping(InventoryStockCheckProfitShortagesMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryStockCheckProfitShortagesMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryStockCheckProfitShortagesMapping.CreateTime)
    private int createTime;//创建时间


    public InventoryStockCheckProfitShortages() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getProfitShortagesCode()
    {
        return profitShortagesCode;
    }

    public void setProfitShortagesCode(java.lang.String profitShortagesCode)
    {
        this.profitShortagesCode = profitShortagesCode;
    }
    public java.lang.String getStockCheckItemCode()
    {
        return stockCheckItemCode;
    }

    public void setStockCheckItemCode(java.lang.String stockCheckItemCode)
    {
        this.stockCheckItemCode = stockCheckItemCode;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public java.lang.String getComment()
    {
        return comment;
    }

    public void setComment(java.lang.String comment)
    {
        this.comment = comment;
    }
    public java.lang.String getOriginalDocument()
    {
        return originalDocument;
    }

    public void setOriginalDocument(java.lang.String originalDocument)
    {
        this.originalDocument = originalDocument;
    }
    public java.lang.String getWarehouseCode()
    {
        return warehouseCode;
    }

    public void setWarehouseCode(java.lang.String warehouseCode)
    {
        this.warehouseCode = warehouseCode;
    }
    public java.lang.String getWarehouseName()
    {
        return warehouseName;
    }

    public void setWarehouseName(java.lang.String warehouseName)
    {
        this.warehouseName = warehouseName;
    }
    public java.lang.String getType()
    {
        return type;
    }

    public void setType(java.lang.String type)
    {
        this.type = type;
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
