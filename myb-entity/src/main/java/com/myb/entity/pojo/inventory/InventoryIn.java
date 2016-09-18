package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryIn extends EntityBase{

    @DataMapping(InventoryInMapping.Id)
    private int id;//
    @DataMapping(InventoryInMapping.InCode)
    private java.lang.String inCode;//入库单编码
    @DataMapping(InventoryInMapping.OriginalDocument)
    private java.lang.String originalDocument;//原始单据号
    @DataMapping(InventoryInMapping.ProductType)
    private java.lang.String productType;//院装，客装
    @DataMapping(InventoryInMapping.Status)
    private java.lang.String status;//状态
    @DataMapping(InventoryInMapping.InventoryCode)
    private java.lang.String inventoryCode;//仓库code
    @DataMapping(InventoryInMapping.InType)
    private java.lang.String inType;//入库类型：采购入库，申请入库，退货
    @DataMapping(InventoryInMapping.FromCode)
    private java.lang.String fromCode;//提供者
    @DataMapping(InventoryInMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InventoryInMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名
    @DataMapping(InventoryInMapping.CreateTime)
    private int createTime;//创建时间


    public InventoryIn() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getInCode()
    {
        return inCode;
    }

    public void setInCode(java.lang.String inCode)
    {
        this.inCode = inCode;
    }
    public java.lang.String getOriginalDocument()
    {
        return originalDocument;
    }

    public void setOriginalDocument(java.lang.String originalDocument)
    {
        this.originalDocument = originalDocument;
    }
    public java.lang.String getProductType()
    {
        return productType;
    }

    public void setProductType(java.lang.String productType)
    {
        this.productType = productType;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public java.lang.String getInType()
    {
        return inType;
    }

    public void setInType(java.lang.String inType)
    {
        this.inType = inType;
    }
    public java.lang.String getFromCode()
    {
        return fromCode;
    }

    public void setFromCode(java.lang.String fromCode)
    {
        this.fromCode = fromCode;
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
