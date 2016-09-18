package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class AaopenAccountSaas extends EntityBase{

    @DataMapping(AaopenAccountSaasMapping.Id)
    private java.lang.String id;//
    @DataMapping(AaopenAccountSaasMapping.COMPANYCODE)
    private java.lang.String cOMPANYCODE;//
    @DataMapping(AaopenAccountSaasMapping.BEAUTIFULYARD)
    private java.lang.String bEAUTIFULYARD;//
    @DataMapping(AaopenAccountSaasMapping.OPENNUMBER)
    private java.lang.String oPENNUMBER;//
    @DataMapping(AaopenAccountSaasMapping.SHOPCOUNT)
    private java.lang.String sHOPCOUNT;//
    @DataMapping(AaopenAccountSaasMapping.PAYDATE)
    private java.lang.String pAYDATE;//
    @DataMapping(AaopenAccountSaasMapping.CREATETIME)
    private java.lang.String cREATETIME;//
    @DataMapping(AaopenAccountSaasMapping.ENDTIME)
    private java.lang.String eNDTIME;//
    @DataMapping(AaopenAccountSaasMapping.ZONGBUADDRESS)
    private java.lang.String zONGBUADDRESS;//
    @DataMapping(AaopenAccountSaasMapping.PROVINCE)
    private java.lang.String pROVINCE;//
    @DataMapping(AaopenAccountSaasMapping.CITY)
    private java.lang.String cITY;//
    @DataMapping(AaopenAccountSaasMapping.ANOCREATETIME)
    private java.util.Date aNOCREATETIME;//
    @DataMapping(AaopenAccountSaasMapping.ANOENDTIME)
    private java.util.Date aNOENDTIME;//


    public AaopenAccountSaas() { }

    public java.lang.String getId()
    {
        return id;
    }

    public void setId(java.lang.String id)
    {
        this.id = id;
    }
    public java.lang.String getCOMPANYCODE()
    {
        return cOMPANYCODE;
    }

    public void setCOMPANYCODE(java.lang.String cOMPANYCODE)
    {
        this.cOMPANYCODE = cOMPANYCODE;
    }
    public java.lang.String getBEAUTIFULYARD()
    {
        return bEAUTIFULYARD;
    }

    public void setBEAUTIFULYARD(java.lang.String bEAUTIFULYARD)
    {
        this.bEAUTIFULYARD = bEAUTIFULYARD;
    }
    public java.lang.String getOPENNUMBER()
    {
        return oPENNUMBER;
    }

    public void setOPENNUMBER(java.lang.String oPENNUMBER)
    {
        this.oPENNUMBER = oPENNUMBER;
    }
    public java.lang.String getSHOPCOUNT()
    {
        return sHOPCOUNT;
    }

    public void setSHOPCOUNT(java.lang.String sHOPCOUNT)
    {
        this.sHOPCOUNT = sHOPCOUNT;
    }
    public java.lang.String getPAYDATE()
    {
        return pAYDATE;
    }

    public void setPAYDATE(java.lang.String pAYDATE)
    {
        this.pAYDATE = pAYDATE;
    }
    public java.lang.String getCREATETIME()
    {
        return cREATETIME;
    }

    public void setCREATETIME(java.lang.String cREATETIME)
    {
        this.cREATETIME = cREATETIME;
    }
    public java.lang.String getENDTIME()
    {
        return eNDTIME;
    }

    public void setENDTIME(java.lang.String eNDTIME)
    {
        this.eNDTIME = eNDTIME;
    }
    public java.lang.String getZONGBUADDRESS()
    {
        return zONGBUADDRESS;
    }

    public void setZONGBUADDRESS(java.lang.String zONGBUADDRESS)
    {
        this.zONGBUADDRESS = zONGBUADDRESS;
    }
    public java.lang.String getPROVINCE()
    {
        return pROVINCE;
    }

    public void setPROVINCE(java.lang.String pROVINCE)
    {
        this.pROVINCE = pROVINCE;
    }
    public java.lang.String getCITY()
    {
        return cITY;
    }

    public void setCITY(java.lang.String cITY)
    {
        this.cITY = cITY;
    }

	public java.util.Date getaNOCREATETIME() {
		return aNOCREATETIME;
	}

	public void setaNOCREATETIME(java.util.Date aNOCREATETIME) {
		this.aNOCREATETIME = aNOCREATETIME;
	}

	public java.util.Date getaNOENDTIME() {
		return aNOENDTIME;
	}

	public void setaNOENDTIME(java.util.Date aNOENDTIME) {
		this.aNOENDTIME = aNOENDTIME;
	}

}
