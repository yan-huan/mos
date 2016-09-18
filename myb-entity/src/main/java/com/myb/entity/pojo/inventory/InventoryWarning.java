package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryWarning extends EntityBase{

    @DataMapping(InventoryWarningMapping.Id)
    private int id;//
    @DataMapping(InventoryWarningMapping.InventoryWarnningCode)
    private java.lang.String inventoryWarnningCode;//提醒code
    @DataMapping(InventoryWarningMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryWarningMapping.InventoryCode)
    private java.lang.String inventoryCode;//仓库code
    @DataMapping(InventoryWarningMapping.IsSend)
    private java.lang.String isSend;//是否发送
    @DataMapping(InventoryWarningMapping.IsRead)
    private java.lang.String isRead;//是否已读
    @DataMapping(InventoryWarningMapping.Type)
    private java.lang.String type;//提醒类型
    @DataMapping(InventoryWarningMapping.Condition)
    private java.lang.String condition;//提醒条件
    @DataMapping(InventoryWarningMapping.CreateTime)
    private int createTime;//创建时间
    @DataMapping(InventoryWarningMapping.UpdateTime)
    private int updateTime;//更新时间


    public InventoryWarning() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getInventoryWarnningCode()
    {
        return inventoryWarnningCode;
    }

    public void setInventoryWarnningCode(java.lang.String inventoryWarnningCode)
    {
        this.inventoryWarnningCode = inventoryWarnningCode;
    }
    public java.lang.String getInventorySkuCode()
    {
        return inventorySkuCode;
    }

    public void setInventorySkuCode(java.lang.String inventorySkuCode)
    {
        this.inventorySkuCode = inventorySkuCode;
    }
    public java.lang.String getIsSend()
    {
        return isSend;
    }

    public void setIsSend(java.lang.String isSend)
    {
        this.isSend = isSend;
    }
    public java.lang.String getIsRead()
    {
        return isRead;
    }

    public void setIsRead(java.lang.String isRead)
    {
        this.isRead = isRead;
    }
    public java.lang.String getType()
    {
        return type;
    }

    public void setType(java.lang.String type)
    {
        this.type = type;
    }
    public java.lang.String getCondition()
    {
        return condition;
    }

    public void setCondition(java.lang.String condition)
    {
        this.condition = condition;
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

	public java.lang.String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(java.lang.String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

}
