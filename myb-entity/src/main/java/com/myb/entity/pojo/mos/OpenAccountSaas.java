package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class OpenAccountSaas extends EntityBase{

    @DataMapping(OpenAccountSaasMapping.Id)
    private int id;//
    @DataMapping(OpenAccountSaasMapping.AccountId)
    private java.lang.String accountId;//
    @DataMapping(OpenAccountSaasMapping.Beautifulyard)
    private java.lang.String beautifulyard;//
    @DataMapping(OpenAccountSaasMapping.OpenNumber)
    private java.lang.String openNumber;//
    @DataMapping(OpenAccountSaasMapping.ShopCount)
    private java.lang.String shopCount;//
    @DataMapping(OpenAccountSaasMapping.PayDate)
    private java.lang.String payDate;//
    @DataMapping(OpenAccountSaasMapping.Market)
    private java.lang.String market;//
    @DataMapping(OpenAccountSaasMapping.Status)
    private java.lang.String status;//
    @DataMapping(OpenAccountSaasMapping.Remark)
    private java.lang.String remark;//
    @DataMapping(OpenAccountSaasMapping.Createtime)
    private java.sql.Timestamp createtime;//
    @DataMapping(OpenAccountSaasMapping.Zongbuaddress)
    private java.lang.String zongbuaddress;//
    @DataMapping(OpenAccountSaasMapping.Kefumobile)
    private java.lang.String kefumobile;//
    @DataMapping(OpenAccountSaasMapping.Province)
    private java.lang.String province;//
    @DataMapping(OpenAccountSaasMapping.City)
    private java.lang.String city;//
    @DataMapping(OpenAccountSaasMapping.Companycode)
    private java.lang.String companycode;//
    @DataMapping(OpenAccountSaasMapping.Approvalstatus)
    private java.lang.String approvalstatus;//
    @DataMapping(OpenAccountSaasMapping.Isaddaccount)
    private java.lang.String isaddaccount;//
    @DataMapping(OpenAccountSaasMapping.Updatedate)
    private java.lang.String updatedate;//
    @DataMapping(OpenAccountSaasMapping.Refuseinfo)
    private java.lang.String refuseinfo;//
    @DataMapping(OpenAccountSaasMapping.Empid)
    private java.lang.String empid;//
    @DataMapping(OpenAccountSaasMapping.Source)
    private java.lang.String source;//


    public OpenAccountSaas() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(java.lang.String accountId)
    {
        this.accountId = accountId;
    }
    public java.lang.String getBeautifulyard()
    {
        return beautifulyard;
    }

    public void setBeautifulyard(java.lang.String beautifulyard)
    {
        this.beautifulyard = beautifulyard;
    }
    public java.lang.String getOpenNumber()
    {
        return openNumber;
    }

    public void setOpenNumber(java.lang.String openNumber)
    {
        this.openNumber = openNumber;
    }
    public java.lang.String getShopCount()
    {
        return shopCount;
    }

    public void setShopCount(java.lang.String shopCount)
    {
        this.shopCount = shopCount;
    }
    public java.lang.String getPayDate()
    {
        return payDate;
    }

    public void setPayDate(java.lang.String payDate)
    {
        this.payDate = payDate;
    }
    public java.lang.String getMarket()
    {
        return market;
    }

    public void setMarket(java.lang.String market)
    {
        this.market = market;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
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
    public java.sql.Timestamp getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.sql.Timestamp createtime)
    {
        this.createtime = createtime;
    }
    public java.lang.String getZongbuaddress()
    {
        return zongbuaddress;
    }

    public void setZongbuaddress(java.lang.String zongbuaddress)
    {
        this.zongbuaddress = zongbuaddress;
    }
    public java.lang.String getKefumobile()
    {
        return kefumobile;
    }

    public void setKefumobile(java.lang.String kefumobile)
    {
        this.kefumobile = kefumobile;
    }
    public java.lang.String getProvince()
    {
        return province;
    }

    public void setProvince(java.lang.String province)
    {
        this.province = province;
    }
    public java.lang.String getCity()
    {
        return city;
    }

    public void setCity(java.lang.String city)
    {
        this.city = city;
    }
    public java.lang.String getCompanycode()
    {
        return companycode;
    }

    public void setCompanycode(java.lang.String companycode)
    {
        this.companycode = companycode;
    }
    public java.lang.String getApprovalstatus()
    {
        return approvalstatus;
    }

    public void setApprovalstatus(java.lang.String approvalstatus)
    {
        this.approvalstatus = approvalstatus;
    }
    public java.lang.String getIsaddaccount()
    {
        return isaddaccount;
    }

    public void setIsaddaccount(java.lang.String isaddaccount)
    {
        this.isaddaccount = isaddaccount;
    }
    public java.lang.String getUpdatedate()
    {
        return updatedate;
    }

    public void setUpdatedate(java.lang.String updatedate)
    {
        this.updatedate = updatedate;
    }
    public java.lang.String getRefuseinfo()
    {
        return refuseinfo;
    }

    public void setRefuseinfo(java.lang.String refuseinfo)
    {
        this.refuseinfo = refuseinfo;
    }
    public java.lang.String getEmpid()
    {
        return empid;
    }

    public void setEmpid(java.lang.String empid)
    {
        this.empid = empid;
    }
    public java.lang.String getSource()
    {
        return source;
    }

    public void setSource(java.lang.String source)
    {
        this.source = source;
    }

}
