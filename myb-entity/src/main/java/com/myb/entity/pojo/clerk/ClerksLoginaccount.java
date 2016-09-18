package com.myb.entity.pojo.clerk;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ClerksLoginaccount extends EntityBase{

    @DataMapping(ClerksLoginaccountMapping.Id)
    private int id;//
    @DataMapping(ClerksLoginaccountMapping.Code)
    private java.lang.String code;//
    @DataMapping(ClerksLoginaccountMapping.ClerkCode)
    private java.lang.String clerkCode;//
    @DataMapping(ClerksLoginaccountMapping.ShopCode)
    private java.lang.String shopCode;//
    @DataMapping(ClerksLoginaccountMapping.CompanyCode)
    private java.lang.String companyCode;//
    @DataMapping(ClerksLoginaccountMapping.CreateBy)
    private java.lang.String createBy;//
    @DataMapping(ClerksLoginaccountMapping.CreatePartyType)
    private java.lang.String createPartyType;//
    @DataMapping(ClerksLoginaccountMapping.UpdateBy)
    private java.lang.String updateBy;//
    @DataMapping(ClerksLoginaccountMapping.UpdatePartyType)
    private java.lang.String updatePartyType;//
    @DataMapping(ClerksLoginaccountMapping.Comments)
    private java.lang.String comments;//
    @DataMapping(ClerksLoginaccountMapping.Status)
    private java.lang.String status;//
    @DataMapping(ClerksLoginaccountMapping.Avatar)
    private java.lang.String avatar;//
    @DataMapping(ClerksLoginaccountMapping.BeauticianCode)
    private java.lang.String beauticianCode;//
    @DataMapping(ClerksLoginaccountMapping.Mobile)
    private java.lang.String mobile;//目前是以手机号登录
    @DataMapping(ClerksLoginaccountMapping.Password)
    private java.lang.String password;//
    @DataMapping(ClerksLoginaccountMapping.Token)
    private java.lang.String token;//登录token。根据token信息登陆。
    @DataMapping(ClerksLoginaccountMapping.ExpiredDate)
    private java.sql.Timestamp expiredDate;//
    @DataMapping(ClerksLoginaccountMapping.AccountType)
    private int accountType;//1普通帐号、2体验帐号、3内部测试帐号、4老板超级帐号
    @DataMapping(ClerksLoginaccountMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//
    @DataMapping(ClerksLoginaccountMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//
    @DataMapping(ClerksLoginaccountMapping.ReleaseLevel)
    private int releaseLevel;//


    public ClerksLoginaccount() { }

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
    public java.lang.String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(java.lang.String avatar)
    {
        this.avatar = avatar;
    }
    public java.lang.String getBeauticianCode()
    {
        return beauticianCode;
    }

    public void setBeauticianCode(java.lang.String beauticianCode)
    {
        this.beauticianCode = beauticianCode;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
    }
    public java.lang.String getPassword()
    {
        return password;
    }

    public void setPassword(java.lang.String password)
    {
        this.password = password;
    }
    public java.lang.String getToken()
    {
        return token;
    }

    public void setToken(java.lang.String token)
    {
        this.token = token;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getExpiredDate()
    {
        return expiredDate;
    }

    public void setExpiredDate(java.sql.Timestamp expiredDate)
    {
        this.expiredDate = expiredDate;
    }
    public int getAccountType()
    {
        return accountType;
    }

    public void setAccountType(int accountType)
    {
        this.accountType = accountType;
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
    public int getReleaseLevel()
    {
        return releaseLevel;
    }

    public void setReleaseLevel(int releaseLevel)
    {
        this.releaseLevel = releaseLevel;
    }

}
