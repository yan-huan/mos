package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class InventoryApply extends EntityBase{

    @DataMapping(InventoryApplyMapping.Id)
    private int id;//
    @DataMapping(InventoryApplyMapping.ApplyCode)
    private java.lang.String applyCode;//申请单code
    @DataMapping(InventoryApplyMapping.InventoryCode)
    private java.lang.String inventoryCode;//仓库code
    @DataMapping(InventoryApplyMapping.InventoryName)
    private java.lang.String inventoryName;//仓库名称
    @DataMapping(InventoryApplyMapping.ToCode)
    private java.lang.String toCode;//被申请方code
    @DataMapping(InventoryApplyMapping.ToName)
    private java.lang.String toName;//被申请方名称
    @DataMapping(InventoryApplyMapping.Comments)
    private java.lang.String comments;//备注
    @DataMapping(InventoryApplyMapping.OriginalDocument)
    private java.lang.String originalDocument;//原始单据号
    @DataMapping(InventoryApplyMapping.Type)
    private java.lang.String type;//总院调回，申请调货
    @DataMapping(InventoryApplyMapping.Status)
    private java.lang.String status;//状态
    @DataMapping(InventoryApplyMapping.CreateUserCode)
    private java.lang.String createUserCode;//申请人code
    @DataMapping(InventoryApplyMapping.CreateUserName)
    private java.lang.String createUserName;//申请人姓名
    @DataMapping(InventoryApplyMapping.CreateTime)
    private int createTime;//申请时间
    @DataMapping(InventoryApplyMapping.UpdateUserCode)
    private java.lang.String updateUserCode;//审批人code
    @DataMapping(InventoryApplyMapping.UpdateUserName)
    private java.lang.String updateUserName;//审批人姓名
    @DataMapping(InventoryApplyMapping.UpdateTime)
    private int updateTime;//审批时间


    public InventoryApply() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getApplyCode()
    {
        return applyCode;
    }

    public void setApplyCode(java.lang.String applyCode)
    {
        this.applyCode = applyCode;
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
    public java.lang.String getComments()
    {
        return comments;
    }

    public void setComments(java.lang.String comments)
    {
        this.comments = comments;
    }
    public java.lang.String getOriginalDocument()
    {
        return originalDocument;
    }

    public void setOriginalDocument(java.lang.String originalDocument)
    {
        this.originalDocument = originalDocument;
    }
    public java.lang.String getType()
    {
        return type;
    }

    public void setType(java.lang.String type)
    {
        this.type = type;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
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
    public java.lang.String getUpdateUserCode()
    {
        return updateUserCode;
    }

    public void setUpdateUserCode(java.lang.String updateUserCode)
    {
        this.updateUserCode = updateUserCode;
    }
    public java.lang.String getUpdateUserName()
    {
        return updateUserName;
    }

    public void setUpdateUserName(java.lang.String updateUserName)
    {
        this.updateUserName = updateUserName;
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

	public java.lang.String getInventoryName() {
		return inventoryName;
	}

	public void setInventoryName(java.lang.String inventoryName) {
		this.inventoryName = inventoryName;
	}

}
