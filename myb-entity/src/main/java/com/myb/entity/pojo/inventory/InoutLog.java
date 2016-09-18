package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InoutLog extends EntityBase{

    @DataMapping(InoutLogMapping.Id)
    private int id;//
    @DataMapping(InoutLogMapping.InoutCode)
    private java.lang.String inoutCode;//出库入库单code
    @DataMapping(InoutLogMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InoutLogMapping.InventoryCode)
    private java.lang.String inventoryCode;//库存code
    @DataMapping(InoutLogMapping.InventoryItemCode)
    private java.lang.String inventoryItemCode;//库存明细code
    @DataMapping(InoutLogMapping.Type)
    private java.lang.String type;//出入库记录中的类型
    @DataMapping(InoutLogMapping.Reason)
    private java.lang.String reason;//原因
    @DataMapping(InoutLogMapping.OldStockNumber)
    private int oldStockNumber;//原始现有库存
    @DataMapping(InoutLogMapping.OldAvailableStockNumber)
    private int oldAvailableStockNumber;//原始可用库存
    @DataMapping(InoutLogMapping.OldOccupyStockNumber)
    private int oldOccupyStockNumber;//原始占用库存
    @DataMapping(InoutLogMapping.ChangeStockNumber)
    private int changeStockNumber;//库存变化值
    @DataMapping(InoutLogMapping.NewStockNumber)
    private int newStockNumber;//变化后现有库存s
    @DataMapping(InoutLogMapping.NewAvailableStockNumber)
    private int newAvailableStockNumber;//变化后可用库存
    @DataMapping(InoutLogMapping.NewOccupyStockNumber)
    private int newOccupyStockNumber;//新的占用库存
    @DataMapping(InoutLogMapping.CreateTime)
    private int createTime;//创建时间
    @DataMapping(InoutLogMapping.CreateUserCode)
    private java.lang.String createUserCode;//创建人code
    @DataMapping(InoutLogMapping.CreateUserName)
    private java.lang.String createUserName;//创建人姓名


    public InoutLog() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getInoutCode()
    {
        return inoutCode;
    }

    public void setInoutCode(java.lang.String inoutCode)
    {
        this.inoutCode = inoutCode;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public java.lang.String getType()
    {
        return type;
    }

    public void setType(java.lang.String type)
    {
        this.type = type;
    }
    public java.lang.String getReason()
    {
        return reason;
    }

    public void setReason(java.lang.String reason)
    {
        this.reason = reason;
    }
    public int getOldStockNumber()
    {
        return oldStockNumber;
    }

    public void setOldStockNumber(int oldStockNumber)
    {
        this.oldStockNumber = oldStockNumber;
    }
    public int getOldAvailableStockNumber()
    {
        return oldAvailableStockNumber;
    }

    public void setOldAvailableStockNumber(int oldAvailableStockNumber)
    {
        this.oldAvailableStockNumber = oldAvailableStockNumber;
    }
    public int getOldOccupyStockNumber()
    {
        return oldOccupyStockNumber;
    }

    public void setOldOccupyStockNumber(int oldOccupyStockNumber)
    {
        this.oldOccupyStockNumber = oldOccupyStockNumber;
    }
    public int getChangeStockNumber()
    {
        return changeStockNumber;
    }

    public void setChangeStockNumber(int changeStockNumber)
    {
        this.changeStockNumber = changeStockNumber;
    }
    public int getNewStockNumber()
    {
        return newStockNumber;
    }

    public void setNewStockNumber(int newStockNumber)
    {
        this.newStockNumber = newStockNumber;
    }
    public int getNewAvailableStockNumber()
    {
        return newAvailableStockNumber;
    }

    public void setNewAvailableStockNumber(int newAvailableStockNumber)
    {
        this.newAvailableStockNumber = newAvailableStockNumber;
    }
    public int getNewOccupyStockNumber()
    {
        return newOccupyStockNumber;
    }

    public void setNewOccupyStockNumber(int newOccupyStockNumber)
    {
        this.newOccupyStockNumber = newOccupyStockNumber;
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

	public java.lang.String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(java.lang.String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public java.lang.String getInventoryItemCode() {
		return inventoryItemCode;
	}

	public void setInventoryItemCode(java.lang.String inventoryItemCode) {
		this.inventoryItemCode = inventoryItemCode;
	}

}
