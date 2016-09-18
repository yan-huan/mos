package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class CrmVisitrecord extends EntityBase{

    @DataMapping(CrmVisitrecordMapping.Id)
    private long id;//
    @DataMapping(CrmVisitrecordMapping.ShopId)
    private long shopId;//
    @DataMapping(CrmVisitrecordMapping.ClientName)
    private java.lang.String clientName;//拜访的客户名
    @DataMapping(CrmVisitrecordMapping.PicUrl)
    private java.lang.String picUrl;//
    @DataMapping(CrmVisitrecordMapping.VisitTime)
    private java.lang.String visitTime;//拜访日期
    @DataMapping(CrmVisitrecordMapping.ClientLevel)
    private java.lang.String clientLevel;//客户状态（ABCD）
    @DataMapping(CrmVisitrecordMapping.Longitude)
    private java.lang.String longitude;//
    @DataMapping(CrmVisitrecordMapping.Latitude)
    private java.lang.String latitude;//
    @DataMapping(CrmVisitrecordMapping.ContractId)
    private long contractId;//联系人id
    @DataMapping(CrmVisitrecordMapping.IsEscort)
    private int isEscort;//是否陪访（0：no,1:yes）
    @DataMapping(CrmVisitrecordMapping.IsValide)
    private int isValide;//是否有效
    @DataMapping(CrmVisitrecordMapping.EmployeeId)
    private long employeeId;//
    @DataMapping(CrmVisitrecordMapping.Remark)
    private java.lang.String remark;//
    @DataMapping(CrmVisitrecordMapping.CreateTime)
    private java.sql.Timestamp createTime;//
    @DataMapping(CrmVisitrecordMapping.Isdel)
    private int isdel;//记录是否有效
    @DataMapping(CrmVisitrecordMapping.Address)
    private java.lang.String address;//
    @DataMapping(CrmVisitrecordMapping.EmpName)
    private java.lang.String empName;//
    @DataMapping(CrmVisitrecordMapping.IsBoss)
    private int isBoss;//0:见过老板


    public CrmVisitrecord() { }

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
    public java.lang.String getClientName()
    {
        return clientName;
    }

    public void setClientName(java.lang.String clientName)
    {
        this.clientName = clientName;
    }
    public java.lang.String getPicUrl()
    {
        return picUrl;
    }

    public void setPicUrl(java.lang.String picUrl)
    {
        this.picUrl = picUrl;
    }
    public java.lang.String getVisitTime()
    {
        return visitTime;
    }

    public void setVisitTime(java.lang.String visitTime)
    {
        this.visitTime = visitTime;
    }
    public java.lang.String getClientLevel()
    {
        return clientLevel;
    }

    public void setClientLevel(java.lang.String clientLevel)
    {
        this.clientLevel = clientLevel;
    }
    public java.lang.String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(java.lang.String longitude)
    {
        this.longitude = longitude;
    }
    public java.lang.String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(java.lang.String latitude)
    {
        this.latitude = latitude;
    }
    public long getContractId()
    {
        return contractId;
    }

    public void setContractId(long contractId)
    {
        this.contractId = contractId;
    }
    public int getIsEscort()
    {
        return isEscort;
    }

    public void setIsEscort(int isEscort)
    {
        this.isEscort = isEscort;
    }
    public int getIsValide()
    {
        return isValide;
    }

    public void setIsValide(int isValide)
    {
        this.isValide = isValide;
    }
    public long getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(long employeeId)
    {
        this.employeeId = employeeId;
    }
    public java.lang.String getRemark()
    {
        return remark;
    }

    public void setRemark(java.lang.String remark)
    {
        this.remark = remark;
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
    public int getIsdel()
    {
        return isdel;
    }

    public void setIsdel(int isdel)
    {
        this.isdel = isdel;
    }
    public java.lang.String getAddress()
    {
        return address;
    }

    public void setAddress(java.lang.String address)
    {
        this.address = address;
    }
    public java.lang.String getEmpName()
    {
        return empName;
    }

    public void setEmpName(java.lang.String empName)
    {
        this.empName = empName;
    }
    public int getIsBoss()
    {
        return isBoss;
    }

    public void setIsBoss(int isBoss)
    {
        this.isBoss = isBoss;
    }

}
