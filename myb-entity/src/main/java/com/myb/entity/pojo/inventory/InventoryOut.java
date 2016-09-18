package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryOut extends EntityBase{

    @DataMapping(InventoryOutMapping.Id)
    private int id;//
    @DataMapping(InventoryOutMapping.OutCode)
    private java.lang.String outCode;//出库单code
    @DataMapping(InventoryOutMapping.OutType)
    private java.lang.String outType;//出库类型：手动出库，扫码出库，下发到店，销售出库，总院回调
    @DataMapping(InventoryOutMapping.OutPattern)
    private java.lang.String outPattern;//出库方式：美容师领取，调配仓
    @DataMapping(InventoryOutMapping.ProductType)
    private java.lang.String productType;//院装，客装
    @DataMapping(InventoryOutMapping.OriginalDocument)
    private java.lang.String originalDocument;//原始单据号
    @DataMapping(InventoryOutMapping.ToCode)
    private java.lang.String toCode;//接收者
    @DataMapping(InventoryOutMapping.ToName)
    private java.lang.String toName;//接收人姓名
    @DataMapping(InventoryOutMapping.InventoryCode)
    private java.lang.String inventoryCode;//仓库code
    @DataMapping(InventoryOutMapping.Status)
    private java.lang.String status;//状态
    @DataMapping(InventoryOutMapping.JingshourenCode)
    private java.lang.String jingshourenCode;//经手人code
    @DataMapping(InventoryOutMapping.JingshourenName)
    private java.lang.String jingshourenName;//经手人姓名
    @DataMapping(InventoryOutMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人
    @DataMapping(InventoryOutMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryOutMapping.CreateTime)
    private int createTime;//创建时间


    public InventoryOut() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getOutCode()
    {
        return outCode;
    }

    public void setOutCode(java.lang.String outCode)
    {
        this.outCode = outCode;
    }
    public java.lang.String getOutType()
    {
        return outType;
    }

    public void setOutType(java.lang.String outType)
    {
        this.outType = outType;
    }
    public java.lang.String getOutPattern()
    {
        return outPattern;
    }

    public void setOutPattern(java.lang.String outPattern)
    {
        this.outPattern = outPattern;
    }
    public java.lang.String getProductType()
    {
        return productType;
    }

    public void setProductType(java.lang.String productType)
    {
        this.productType = productType;
    }
    public java.lang.String getOriginalDocument()
    {
        return originalDocument;
    }

    public void setOriginalDocument(java.lang.String originalDocument)
    {
        this.originalDocument = originalDocument;
    }
    public java.lang.String getToCode()
    {
        return toCode;
    }

    public void setToCode(java.lang.String toCode)
    {
        this.toCode = toCode;
    }
    public java.lang.String getToName()
    {
        return toName;
    }

    public void setToName(java.lang.String toName)
    {
        this.toName = toName;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public java.lang.String getJingshourenCode()
    {
        return jingshourenCode;
    }

    public void setJingshourenCode(java.lang.String jingshourenCode)
    {
        this.jingshourenCode = jingshourenCode;
    }
    public java.lang.String getJingshourenName()
    {
        return jingshourenName;
    }

    public void setJingshourenName(java.lang.String jingshourenName)
    {
        this.jingshourenName = jingshourenName;
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

	public java.lang.String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(java.lang.String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

}
