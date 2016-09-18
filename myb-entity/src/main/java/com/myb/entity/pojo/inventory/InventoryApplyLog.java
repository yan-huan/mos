package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryApplyLog extends EntityBase{

    @DataMapping(InventoryApplyLogMapping.Id)
    private int id;//
    @DataMapping(InventoryApplyLogMapping.ApplyLogCode)
    private java.lang.String applyLogCode;//申请单日志code
    @DataMapping(InventoryApplyLogMapping.ApplyCode)
    private java.lang.String applyCode;//申请单code
    @DataMapping(InventoryApplyLogMapping.NewStatus)
    private java.lang.String newStatus;//最新状态
    @DataMapping(InventoryApplyLogMapping.Description)
    private java.lang.String description;//描述
    @DataMapping(InventoryApplyLogMapping.OperatorCode)
    private java.lang.String operatorCode;//操作人
    @DataMapping(InventoryApplyLogMapping.OperateTime)
    private int operateTime;//创建时间


    public InventoryApplyLog() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getApplyLogCode()
    {
        return applyLogCode;
    }

    public void setApplyLogCode(java.lang.String applyLogCode)
    {
        this.applyLogCode = applyLogCode;
    }
    public java.lang.String getApplyCode()
    {
        return applyCode;
    }

    public void setApplyCode(java.lang.String applyCode)
    {
        this.applyCode = applyCode;
    }
    public java.lang.String getNewStatus()
    {
        return newStatus;
    }

    public void setNewStatus(java.lang.String newStatus)
    {
        this.newStatus = newStatus;
    }
    public java.lang.String getDescription()
    {
        return description;
    }

    public void setDescription(java.lang.String description)
    {
        this.description = description;
    }
    public java.lang.String getOperatorCode()
    {
        return operatorCode;
    }

    public void setOperatorCode(java.lang.String operatorCode)
    {
        this.operatorCode = operatorCode;
    }
    public int getOperateTime()
    {
        return operateTime;
    }

    public void setOperateTime(int operateTime)
    {
        this.operateTime = operateTime;
    }

}
