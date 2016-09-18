package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryStockCheckLog extends EntityBase{

    @DataMapping(InventoryStockCheckLogMapping.Id)
    private int id;//
    @DataMapping(InventoryStockCheckLogMapping.StockCheckItemCode)
    private java.lang.String stockCheckItemCode;//盘点明细code
    @DataMapping(InventoryStockCheckLogMapping.Descripe)
    private java.lang.String descripe;//描述
    @DataMapping(InventoryStockCheckLogMapping.OperatorCode)
    private java.lang.String operatorCode;//操作人
    @DataMapping(InventoryStockCheckLogMapping.OperateTime)
    private int operateTime;//操作时间


    public InventoryStockCheckLog() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getStockCheckItemCode()
    {
        return stockCheckItemCode;
    }

    public void setStockCheckItemCode(java.lang.String stockCheckItemCode)
    {
        this.stockCheckItemCode = stockCheckItemCode;
    }
    public java.lang.String getDescripe()
    {
        return descripe;
    }

    public void setDescripe(java.lang.String descripe)
    {
        this.descripe = descripe;
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
