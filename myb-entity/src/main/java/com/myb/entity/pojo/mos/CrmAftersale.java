package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class CrmAftersale extends EntityBase{

    @DataMapping(CrmAftersaleMapping.Id)
    private long id;//
    @DataMapping(CrmAftersaleMapping.ShopId)
    private long shopId;//
    @DataMapping(CrmAftersaleMapping.IsDistribute)
    private int isDistribute;//0:未分配，1：分配
    @DataMapping(CrmAftersaleMapping.CreateTime)
    private java.sql.Timestamp createTime;//
    @DataMapping(CrmAftersaleMapping.DistributedId)
    private long distributedId;//被分配人员id
    @DataMapping(CrmAftersaleMapping.IsFinish)
    private int isFinish;//0:没完成；1：完成
    @DataMapping(CrmAftersaleMapping.VisitTimes)
    private int visitTimes;//回访次数记录
    @DataMapping(CrmAftersaleMapping.IsCheck)
    private int isCheck;//0:没check；1：通过审查
    @DataMapping(CrmAftersaleMapping.Quyu)
    private int quyu;//哪个大区


    public CrmAftersale() { }

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
    public int getIsDistribute()
    {
        return isDistribute;
    }

    public void setIsDistribute(int isDistribute)
    {
        this.isDistribute = isDistribute;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime)
    {
        this.createTime = createTime;
    }
    public long getDistributedId()
    {
        return distributedId;
    }

    public void setDistributedId(long distributedId)
    {
        this.distributedId = distributedId;
    }
    public int getIsFinish()
    {
        return isFinish;
    }

    public void setIsFinish(int isFinish)
    {
        this.isFinish = isFinish;
    }
    public int getVisitTimes()
    {
        return visitTimes;
    }

    public void setVisitTimes(int visitTimes)
    {
        this.visitTimes = visitTimes;
    }
    public int getIsCheck()
    {
        return isCheck;
    }

    public void setIsCheck(int isCheck)
    {
        this.isCheck = isCheck;
    }
    public int getQuyu()
    {
        return quyu;
    }

    public void setQuyu(int quyu)
    {
        this.quyu = quyu;
    }

}
