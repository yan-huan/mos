package com.myb.entity.pojo.accounts;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class AccountsAccount extends EntityBase{

    @DataMapping(AccountsAccountMapping.Id)
    private int id;//
    @DataMapping(AccountsAccountMapping.Code)
    private java.lang.String code;//
    @DataMapping(AccountsAccountMapping.CurrencyCode)
    private java.lang.String currencyCode;//
    @DataMapping(AccountsAccountMapping.BelongToPartyType)
    private java.lang.String belongToPartyType;//
    @DataMapping(AccountsAccountMapping.BelongToPartyCode)
    private java.lang.String belongToPartyCode;//
    @DataMapping(AccountsAccountMapping.CreateBy)
    private java.lang.String createBy;//
    @DataMapping(AccountsAccountMapping.CreatePartyType)
    private java.lang.String createPartyType;//
    @DataMapping(AccountsAccountMapping.UpdateBy)
    private java.lang.String updateBy;//
    @DataMapping(AccountsAccountMapping.UpdatePartyType)
    private java.lang.String updatePartyType;//
    @DataMapping(AccountsAccountMapping.Comments)
    private java.lang.String comments;//
    @DataMapping(AccountsAccountMapping.Status)
    private java.lang.String status;//
    @DataMapping(AccountsAccountMapping.ObjName)
    private java.lang.String objName;//
    @DataMapping(AccountsAccountMapping.ParentCode)
    private java.lang.String parentCode;//
    @DataMapping(AccountsAccountMapping.AccountType)
    private java.lang.String accountType;//
    @DataMapping(AccountsAccountMapping.Amount)
    private long amount;//
    @DataMapping(AccountsAccountMapping.ExpireDate)
    private java.sql.Timestamp expireDate;//
    @DataMapping(AccountsAccountMapping.IsDefault)
    private boolean isDefault;//
    @DataMapping(AccountsAccountMapping.AccountMetaType)
    private int accountMetaType;//
    @DataMapping(AccountsAccountMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//
    @DataMapping(AccountsAccountMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//


    public AccountsAccount() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getCode()
    {
        return code;
    }

    public void setCode(java.lang.String code)
    {
        this.code = code;
    }
    public java.lang.String getCurrencyCode()
    {
        return currencyCode;
    }

    public void setCurrencyCode(java.lang.String currencyCode)
    {
        this.currencyCode = currencyCode;
    }
    public java.lang.String getBelongToPartyType()
    {
        return belongToPartyType;
    }

    public void setBelongToPartyType(java.lang.String belongToPartyType)
    {
        this.belongToPartyType = belongToPartyType;
    }
    public java.lang.String getBelongToPartyCode()
    {
        return belongToPartyCode;
    }

    public void setBelongToPartyCode(java.lang.String belongToPartyCode)
    {
        this.belongToPartyCode = belongToPartyCode;
    }
    public java.lang.String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(java.lang.String createBy)
    {
        this.createBy = createBy;
    }
    public java.lang.String getCreatePartyType()
    {
        return createPartyType;
    }

    public void setCreatePartyType(java.lang.String createPartyType)
    {
        this.createPartyType = createPartyType;
    }
    public java.lang.String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(java.lang.String updateBy)
    {
        this.updateBy = updateBy;
    }
    public java.lang.String getUpdatePartyType()
    {
        return updatePartyType;
    }

    public void setUpdatePartyType(java.lang.String updatePartyType)
    {
        this.updatePartyType = updatePartyType;
    }
    public java.lang.String getComments()
    {
        return comments;
    }

    public void setComments(java.lang.String comments)
    {
        this.comments = comments;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public java.lang.String getObjName()
    {
        return objName;
    }

    public void setObjName(java.lang.String objName)
    {
        this.objName = objName;
    }
    public java.lang.String getParentCode()
    {
        return parentCode;
    }

    public void setParentCode(java.lang.String parentCode)
    {
        this.parentCode = parentCode;
    }
    public java.lang.String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(java.lang.String accountType)
    {
        this.accountType = accountType;
    }
    public long getAmount()
    {
        return amount;
    }

    public void setAmount(long amount)
    {
        this.amount = amount;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getExpireDate()
    {
        return expireDate;
    }

    public void setExpireDate(java.sql.Timestamp expireDate)
    {
        this.expireDate = expireDate;
    }
    public boolean getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault)
    {
        this.isDefault = isDefault;
    }
    public int getAccountMetaType()
    {
        return accountMetaType;
    }

    public void setAccountMetaType(int accountMetaType)
    {
        this.accountMetaType = accountMetaType;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt)
    {
        this.createdAt = createdAt;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}
