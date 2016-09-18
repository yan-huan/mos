package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ShopProcess extends EntityBase{

    @DataMapping(ShopProcessMapping.Id)
    private long id;//
    @DataMapping(ShopProcessMapping.ShopId)
    private long shopId;//美容院id
    @DataMapping(ShopProcessMapping.IsEscort)
    private int isEscort;//是否陪同拜访:0无，1有
    @DataMapping(ShopProcessMapping.ClientLevel)
    private java.lang.String clientLevel;//客户级别：ABCD
    @DataMapping(ShopProcessMapping.IsValide)
    private int isValide;//是否有效拜访：0无效；1有效
    @DataMapping(ShopProcessMapping.Process)
    private java.lang.String process;//拜访进度
    @DataMapping(ShopProcessMapping.Reason)
    private java.lang.String reason;//未出单原因
    @DataMapping(ShopProcessMapping.CreateTime)
    private Date createTime;//
    @DataMapping(ShopProcessMapping.Amount)
    private java.math.BigDecimal amount;//成交金额
    @DataMapping(ShopProcessMapping.FinishTime)
    private Date finishTime;//签单时间
    @DataMapping(ShopProcessMapping.EmployeeId)
    private long employeeId;//最终签单人id


    public ShopProcess() { }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    public long getShopId()
    {
        return shopId;
    }

    public void setShopId(long shopId)
    {
        this.shopId = shopId;
    }
    public int getIsEscort()
    {
        return isEscort;
    }

    public void setIsEscort(int isEscort)
    {
        this.isEscort = isEscort;
    }
    public java.lang.String getClientLevel()
    {
        return clientLevel;
    }

    public void setClientLevel(java.lang.String clientLevel)
    {
        this.clientLevel = clientLevel;
    }
    public int getIsValide()
    {
        return isValide;
    }

    public void setIsValide(int isValide)
    {
        this.isValide = isValide;
    }
    public java.lang.String getProcess()
    {
        return process;
    }

    public void setProcess(java.lang.String process)
    {
        this.process = process;
    }
    public java.lang.String getReason()
    {
        return reason;
    }

    public void setReason(java.lang.String reason)
    {
        this.reason = reason;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public java.math.BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	@JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public Date getFinishTime()
    {
        return finishTime;
    }

    public void setFinishTime(Date finishTime)
    {
        this.finishTime = finishTime;
    }
    public long getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(long employeeId)
    {
        this.employeeId = employeeId;
    }

}
