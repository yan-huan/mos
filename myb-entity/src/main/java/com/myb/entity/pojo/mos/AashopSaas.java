package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class AashopSaas extends EntityBase{

    @DataMapping(AashopSaasMapping.ShopId)
    private java.lang.String shopId;//
    @DataMapping(AashopSaasMapping.CONTRACTID)
    private java.lang.String cONTRACTID;//
    @DataMapping(AashopSaasMapping.SHOPNAME)
    private java.lang.String sHOPNAME;//
    @DataMapping(AashopSaasMapping.SHOPACCOUNT)
    private java.lang.String sHOPACCOUNT;//
    @DataMapping(AashopSaasMapping.City)
    private java.lang.String city;//
    @DataMapping(AashopSaasMapping.Province)
    private java.lang.String province;//
    @DataMapping(AashopSaasMapping.BEGINDATE)
    private java.lang.String bEGINDATE;//
    @DataMapping(AashopSaasMapping.ENDDATE)
    private java.lang.String eNDDATE;//
    @DataMapping(AashopSaasMapping.DURATION)
    private java.lang.String dURATION;//
    @DataMapping(AashopSaasMapping.Address)
    private java.lang.String address;//
    @DataMapping(AashopSaasMapping.Createtime)
    private java.lang.String createtime;//
    @DataMapping(AashopSaasMapping.Shopcode)
    private java.lang.String shopcode;//
    @DataMapping(AashopSaasMapping.Companycode)
    private java.lang.String companycode;//
    @DataMapping(AashopSaasMapping.N)
    private java.lang.String n;//
    @DataMapping(AashopSaasMapping.O)
    private java.lang.String o;//
    @DataMapping(AashopSaasMapping.ANOBEGINDATE)
    private java.util.Date aNOBEGINDATE;//
    @DataMapping(AashopSaasMapping.ANOENDDATE)
    private java.util.Date aNOENDDATE;//
    @DataMapping(AashopSaasMapping.ANOCREATETIME)
    private java.util.Date aNOCREATETIME;//


    public AashopSaas() { }

    public java.lang.String getShopId()
    {
        return shopId;
    }

    public void setShopId(java.lang.String shopId)
    {
        this.shopId = shopId;
    }
    public java.lang.String getCONTRACTID()
    {
        return cONTRACTID;
    }

    public void setCONTRACTID(java.lang.String cONTRACTID)
    {
        this.cONTRACTID = cONTRACTID;
    }
    public java.lang.String getSHOPNAME()
    {
        return sHOPNAME;
    }

    public void setSHOPNAME(java.lang.String sHOPNAME)
    {
        this.sHOPNAME = sHOPNAME;
    }
    public java.lang.String getSHOPACCOUNT()
    {
        return sHOPACCOUNT;
    }

    public void setSHOPACCOUNT(java.lang.String sHOPACCOUNT)
    {
        this.sHOPACCOUNT = sHOPACCOUNT;
    }
    public java.lang.String getCity()
    {
        return city;
    }

    public void setCity(java.lang.String city)
    {
        this.city = city;
    }
    public java.lang.String getProvince()
    {
        return province;
    }

    public void setProvince(java.lang.String province)
    {
        this.province = province;
    }
    public java.lang.String getBEGINDATE()
    {
        return bEGINDATE;
    }

    public void setBEGINDATE(java.lang.String bEGINDATE)
    {
        this.bEGINDATE = bEGINDATE;
    }
    public java.lang.String getENDDATE()
    {
        return eNDDATE;
    }

    public void setENDDATE(java.lang.String eNDDATE)
    {
        this.eNDDATE = eNDDATE;
    }
    public java.lang.String getDURATION()
    {
        return dURATION;
    }

    public void setDURATION(java.lang.String dURATION)
    {
        this.dURATION = dURATION;
    }
    public java.lang.String getAddress()
    {
        return address;
    }

    public void setAddress(java.lang.String address)
    {
        this.address = address;
    }
    public java.lang.String getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(java.lang.String createtime)
    {
        this.createtime = createtime;
    }
    public java.lang.String getShopcode()
    {
        return shopcode;
    }

    public void setShopcode(java.lang.String shopcode)
    {
        this.shopcode = shopcode;
    }
    public java.lang.String getCompanycode()
    {
        return companycode;
    }

    public void setCompanycode(java.lang.String companycode)
    {
        this.companycode = companycode;
    }
    public java.lang.String getN()
    {
        return n;
    }

    public void setN(java.lang.String n)
    {
        this.n = n;
    }
    public java.lang.String getO()
    {
        return o;
    }

    public void setO(java.lang.String o)
    {
        this.o = o;
    }

	public java.util.Date getaNOBEGINDATE() {
		return aNOBEGINDATE;
	}

	public void setaNOBEGINDATE(java.util.Date aNOBEGINDATE) {
		this.aNOBEGINDATE = aNOBEGINDATE;
	}

	public java.util.Date getaNOENDDATE() {
		return aNOENDDATE;
	}

	public void setaNOENDDATE(java.util.Date aNOENDDATE) {
		this.aNOENDDATE = aNOENDDATE;
	}

	public java.util.Date getaNOCREATETIME() {
		return aNOCREATETIME;
	}

	public void setaNOCREATETIME(java.util.Date aNOCREATETIME) {
		this.aNOCREATETIME = aNOCREATETIME;
	}
   

}
