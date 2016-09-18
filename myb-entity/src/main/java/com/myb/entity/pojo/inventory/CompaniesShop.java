package com.myb.entity.pojo.inventory;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class CompaniesShop extends EntityBase{

    @DataMapping(CompaniesShopMapping.Id)
    private int id;//
    @DataMapping(CompaniesShopMapping.BelongToPartyType)
    private java.lang.String belongToPartyType;//
    @DataMapping(CompaniesShopMapping.BelongToPartyCode)
    private java.lang.String belongToPartyCode;//
    @DataMapping(CompaniesShopMapping.Code)
    private java.lang.String code;//
    @DataMapping(CompaniesShopMapping.CreateBy)
    private java.lang.String createBy;//创建人
    @DataMapping(CompaniesShopMapping.CreatePartyType)
    private java.lang.String createPartyType;//
    @DataMapping(CompaniesShopMapping.UpdateBy)
    private java.lang.String updateBy;//更新人
    @DataMapping(CompaniesShopMapping.Cover)
    private java.lang.String cover;//封面
    @DataMapping(CompaniesShopMapping.UpdatePartyType)
    private java.lang.String updatePartyType;//
    @DataMapping(CompaniesShopMapping.Comments)
    private java.lang.String comments;//备注
    @DataMapping(CompaniesShopMapping.Status)
    private java.lang.String status;//
    @DataMapping(CompaniesShopMapping.ObjName)
    private java.lang.String objName;//中文名
    @DataMapping(CompaniesShopMapping.Address)
    private java.lang.String address;//地址信息
    @DataMapping(CompaniesShopMapping.Description)
    private java.lang.String description;//描述
    @DataMapping(CompaniesShopMapping.ServicePhone)
    private java.lang.String servicePhone;//服务电话
    @DataMapping(CompaniesShopMapping.BedCount)
    private int bedCount;//
    @DataMapping(CompaniesShopMapping.RoomCount)
    private int roomCount;//
    @DataMapping(CompaniesShopMapping.AreaCount)
    private double areaCount;//
    @DataMapping(CompaniesShopMapping.CompanyCode)
    private java.lang.String companyCode;//
    @DataMapping(CompaniesShopMapping.StartOperatingTime)
    private java.sql.Timestamp startOperatingTime;//
    @DataMapping(CompaniesShopMapping.EndOperatingTime)
    private java.sql.Timestamp endOperatingTime;//
    @DataMapping(CompaniesShopMapping.ServiceType)
    private int serviceType;//服务类型  1 到店服务  2 上门服务
    @DataMapping(CompaniesShopMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//创建日期
    @DataMapping(CompaniesShopMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//更新日期


    public CompaniesShop() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
    public java.lang.String getCode()
    {
        return code;
    }

    public void setCode(java.lang.String code)
    {
        this.code = code;
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
    public java.lang.String getCover()
    {
        return cover;
    }

    public void setCover(java.lang.String cover)
    {
        this.cover = cover;
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
    public java.lang.String getAddress()
    {
        return address;
    }

    public void setAddress(java.lang.String address)
    {
        this.address = address;
    }
    public java.lang.String getDescription()
    {
        return description;
    }

    public void setDescription(java.lang.String description)
    {
        this.description = description;
    }
    public java.lang.String getServicePhone()
    {
        return servicePhone;
    }

    public void setServicePhone(java.lang.String servicePhone)
    {
        this.servicePhone = servicePhone;
    }
    public int getBedCount()
    {
        return bedCount;
    }

    public void setBedCount(int bedCount)
    {
        this.bedCount = bedCount;
    }
    public int getRoomCount()
    {
        return roomCount;
    }

    public void setRoomCount(int roomCount)
    {
        this.roomCount = roomCount;
    }
    public double getAreaCount()
    {
        return areaCount;
    }

    public void setAreaCount(double areaCount)
    {
        this.areaCount = areaCount;
    }
    public java.lang.String getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(java.lang.String companyCode)
    {
        this.companyCode = companyCode;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getStartOperatingTime()
    {
        return startOperatingTime;
    }

    public void setStartOperatingTime(java.sql.Timestamp startOperatingTime)
    {
        this.startOperatingTime = startOperatingTime;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getEndOperatingTime()
    {
        return endOperatingTime;
    }

    public void setEndOperatingTime(java.sql.Timestamp endOperatingTime)
    {
        this.endOperatingTime = endOperatingTime;
    }
    public int getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(int serviceType)
    {
        this.serviceType = serviceType;
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
