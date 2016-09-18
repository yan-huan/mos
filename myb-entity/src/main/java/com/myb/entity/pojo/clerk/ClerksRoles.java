package com.myb.entity.pojo.clerk;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ClerksRoles extends EntityBase{

    @DataMapping(ClerksRolesMapping.Id)
    private int id;//
    @DataMapping(ClerksRolesMapping.Code)
    private java.lang.String code;//
    @DataMapping(ClerksRolesMapping.ClerkCode)
    private java.lang.String clerkCode;//
    @DataMapping(ClerksRolesMapping.ShopCode)
    private java.lang.String shopCode;//
    @DataMapping(ClerksRolesMapping.CompanyCode)
    private java.lang.String companyCode;//
    @DataMapping(ClerksRolesMapping.CreateBy)
    private java.lang.String createBy;//
    @DataMapping(ClerksRolesMapping.CreatePartyType)
    private java.lang.String createPartyType;//
    @DataMapping(ClerksRolesMapping.UpdateBy)
    private java.lang.String updateBy;//
    @DataMapping(ClerksRolesMapping.UpdatePartyType)
    private java.lang.String updatePartyType;//
    @DataMapping(ClerksRolesMapping.Comments)
    private java.lang.String comments;//
    @DataMapping(ClerksRolesMapping.Status)
    private java.lang.String status;//
    @DataMapping(ClerksRolesMapping.ObjName)
    private java.lang.String objName;//角色名称
    @DataMapping(ClerksRolesMapping.LoginAccountCode)
    private java.lang.String loginAccountCode;//登录账户code
    @DataMapping(ClerksRolesMapping.RoleCode)
    private java.lang.String roleCode;//角色code
    @DataMapping(ClerksRolesMapping.StartDate)
    private java.sql.Timestamp startDate;//开始日期
    @DataMapping(ClerksRolesMapping.EndDate)
    private java.sql.Timestamp endDate;//结束日期
    @DataMapping(ClerksRolesMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//创建日期
    @DataMapping(ClerksRolesMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//更新日期


    public ClerksRoles() { }

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
    public java.lang.String getClerkCode()
    {
        return clerkCode;
    }

    public void setClerkCode(java.lang.String clerkCode)
    {
        this.clerkCode = clerkCode;
    }
    public java.lang.String getShopCode()
    {
        return shopCode;
    }

    public void setShopCode(java.lang.String shopCode)
    {
        this.shopCode = shopCode;
    }
    public java.lang.String getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(java.lang.String companyCode)
    {
        this.companyCode = companyCode;
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
    public java.lang.String getLoginAccountCode()
    {
        return loginAccountCode;
    }

    public void setLoginAccountCode(java.lang.String loginAccountCode)
    {
        this.loginAccountCode = loginAccountCode;
    }
    public java.lang.String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(java.lang.String roleCode)
    {
        this.roleCode = roleCode;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getStartDate()
    {
        return startDate;
    }

    public void setStartDate(java.sql.Timestamp startDate)
    {
        this.startDate = startDate;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getEndDate()
    {
        return endDate;
    }

    public void setEndDate(java.sql.Timestamp endDate)
    {
        this.endDate = endDate;
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
