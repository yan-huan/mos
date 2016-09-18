package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryWarnningSetting extends EntityBase{

    @DataMapping(InventoryWarnningSettingMapping.Id)
    private int id;//
    @DataMapping(InventoryWarnningSettingMapping.InventoryCode)
    private java.lang.String inventoryCode;//仓库code
    @DataMapping(InventoryWarnningSettingMapping.InventorySkuCode)
    private java.lang.String inventorySkuCode;//库存商品code
    @DataMapping(InventoryWarnningSettingMapping.IsSend)
    private java.lang.String isSend;//SENDED--已发送；UNSEND--未发送
    @DataMapping(InventoryWarnningSettingMapping.Type)
    private java.lang.String type;//提醒类型：STOCK_WARNNING-存量提醒；
    @DataMapping(InventoryWarnningSettingMapping.Condition)
    private java.lang.String condition;//提醒条件
    @DataMapping(InventoryWarnningSettingMapping.CreateTime)
    private int createTime;//创建时间
    @DataMapping(InventoryWarnningSettingMapping.UpdateTime)
    private int updateTime;//更新时间


    public InventoryWarnningSetting() { }

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
    public java.lang.String getIsSend()
    {
        return isSend;
    }

    public void setIsSend(java.lang.String isSend)
    {
        this.isSend = isSend;
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
