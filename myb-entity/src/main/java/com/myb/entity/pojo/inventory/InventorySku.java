package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventorySku extends EntityBase{

    @DataMapping(InventorySkuMapping.Id)
    private int id;//
    @DataMapping(InventorySkuMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventorySkuMapping.ParentCode)
    private java.lang.String parentCode;//美容院code
    @DataMapping(InventorySkuMapping.ProductBrandCode)
    private java.lang.String productBrandCode;//商品品牌code
    @DataMapping(InventorySkuMapping.ProductBrandName)
    private java.lang.String productBrandName;//商品品牌名称
    @DataMapping(InventorySkuMapping.ProductUnit)
    private java.lang.String productUnit;//商品单位
    @DataMapping(InventorySkuMapping.ProductCode)
    private java.lang.String productCode;//商品code
    @DataMapping(InventorySkuMapping.ProductName)
    private java.lang.String productName;//商品名称
    @DataMapping(InventorySkuMapping.ProductType)
    private java.lang.String productType;//院装，客装
    @DataMapping(InventorySkuMapping.MarketPrice)
    private double marketPrice;//市场价
    @DataMapping(InventorySkuMapping.DiscountPrice)
    private double discountPrice;//优惠价
    @DataMapping(InventorySkuMapping.Status)
    private String status;//状态
    @DataMapping(InventorySkuMapping.CreateTime)
    private int createTime;//创建时间
    @DataMapping(InventorySkuMapping.UpdateTime)
    private int updateTime;//更新时间


    public InventorySku() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public java.lang.String getProductBrandCode()
    {
        return productBrandCode;
    }

    public void setProductBrandCode(java.lang.String productBrandCode)
    {
        this.productBrandCode = productBrandCode;
    }
    public java.lang.String getProductBrandName()
    {
        return productBrandName;
    }

    public void setProductBrandName(java.lang.String productBrandName)
    {
        this.productBrandName = productBrandName;
    }
    public java.lang.String getProductUnit()
    {
        return productUnit;
    }

    public void setProductUnit(java.lang.String productUnit)
    {
        this.productUnit = productUnit;
    }
    public java.lang.String getProductCode()
    {
        return productCode;
    }

    public void setProductCode(java.lang.String productCode)
    {
        this.productCode = productCode;
    }
    public java.lang.String getProductName()
    {
        return productName;
    }

    public void setProductName(java.lang.String productName)
    {
        this.productName = productName;
    }
    public java.lang.String getProductType()
    {
        return productType;
    }

    public void setProductType(java.lang.String productType)
    {
        this.productType = productType;
    }
    public double getMarketPrice()
    {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice)
    {
        this.marketPrice = marketPrice;
    }
    public double getDiscountPrice()
    {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice)
    {
        this.discountPrice = discountPrice;
    }
    public int getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(int createTime)
    {
        this.createTime = createTime;
    }
    public int getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(int updateTime)
    {
        this.updateTime = updateTime;
    }

    public java.lang.String getParentCode() {
		return parentCode;
	}

	public void setParentCode(java.lang.String parentCode) {
		this.parentCode = parentCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
