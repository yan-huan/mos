package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Shopsaas extends EntityBase{

    @DataMapping(ShopsaasMapping.SHOPID)
    private java.lang.String sHOPID;//
    @DataMapping(ShopsaasMapping.CONTRACTID)
    private java.lang.String cONTRACTID;//
    @DataMapping(ShopsaasMapping.SHOPNAME)
    private java.lang.String sHOPNAME;//
    @DataMapping(ShopsaasMapping.SHOPACCOUNT)
    private java.lang.String sHOPACCOUNT;//
    @DataMapping(ShopsaasMapping.CITY)
    private java.lang.String cITY;//
    @DataMapping(ShopsaasMapping.PROVINCE)
    private java.lang.String pROVINCE;//
    @DataMapping(ShopsaasMapping.BEGINDATE)
    private java.util.Date bEGINDATE;//
    @DataMapping(ShopsaasMapping.ENDDATE)
    private java.util.Date eNDDATE;//
    @DataMapping(ShopsaasMapping.DURATION)
    private java.lang.String dURATION;//
    @DataMapping(ShopsaasMapping.ADDRESS)
    private java.lang.String aDDRESS;//
    @DataMapping(ShopsaasMapping.NULL)
    private java.lang.String nULL;//
    @DataMapping(ShopsaasMapping.NULL1)
    private java.lang.String nULL1;//
    @DataMapping(ShopsaasMapping.NULL2)
    private java.lang.String nULL2;//
    @DataMapping(ShopsaasMapping.CREATETIME)
    private java.util.Date cREATETIME;//
    @DataMapping(ShopsaasMapping.NULL3)
    private java.lang.String nULL3;//
    @DataMapping(ShopsaasMapping.NULL4)
    private java.lang.String nULL4;//
    @DataMapping(ShopsaasMapping.SHOPCODE)
    private java.lang.String sHOPCODE;//
    @DataMapping(ShopsaasMapping.NULL5)
    private java.lang.String nULL5;//
    @DataMapping(ShopsaasMapping.NULL6)
    private java.lang.String nULL6;//
    @DataMapping(ShopsaasMapping.NULL7)
    private java.lang.String nULL7;//
    @DataMapping(ShopsaasMapping.NULL8)
    private java.lang.String nULL8;//
    @DataMapping(ShopsaasMapping.NULL9)
    private java.lang.String nULL9;//
    @DataMapping(ShopsaasMapping.NULL10)
    private java.lang.String nULL10;//
    @DataMapping(ShopsaasMapping.NULL11)
    private java.lang.String nULL11;//
    @DataMapping(ShopsaasMapping.NULL12)
    private java.lang.String nULL12;//
    @DataMapping(ShopsaasMapping.Id)
    private int id;//


    public Shopsaas() { }

    public java.lang.String getSHOPID()
    {
        return sHOPID;
    }

    public void setSHOPID(java.lang.String sHOPID)
    {
        this.sHOPID = sHOPID;
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
    public java.lang.String getCITY()
    {
        return cITY;
    }

    public void setCITY(java.lang.String cITY)
    {
        this.cITY = cITY;
    }
    public java.lang.String getPROVINCE()
    {
        return pROVINCE;
    }

    public void setPROVINCE(java.lang.String pROVINCE)
    {
        this.pROVINCE = pROVINCE;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getBEGINDATE()
    {
        return bEGINDATE;
    }

    public void setBEGINDATE(java.util.Date bEGINDATE)
    {
        this.bEGINDATE = bEGINDATE;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getENDDATE()
    {
        return eNDDATE;
    }

    public void setENDDATE(java.util.Date eNDDATE)
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
    public java.lang.String getADDRESS()
    {
        return aDDRESS;
    }

    public void setADDRESS(java.lang.String aDDRESS)
    {
        this.aDDRESS = aDDRESS;
    }
    public java.lang.String getNULL()
    {
        return nULL;
    }

    public void setNULL(java.lang.String nULL)
    {
        this.nULL = nULL;
    }
    public java.lang.String getNULL1()
    {
        return nULL1;
    }

    public void setNULL1(java.lang.String nULL1)
    {
        this.nULL1 = nULL1;
    }
    public java.lang.String getNULL2()
    {
        return nULL2;
    }

    public void setNULL2(java.lang.String nULL2)
    {
        this.nULL2 = nULL2;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getCREATETIME()
    {
        return cREATETIME;
    }

    public void setCREATETIME(java.util.Date cREATETIME)
    {
        this.cREATETIME = cREATETIME;
    }
    public java.lang.String getNULL3()
    {
        return nULL3;
    }

    public void setNULL3(java.lang.String nULL3)
    {
        this.nULL3 = nULL3;
    }
    public java.lang.String getNULL4()
    {
        return nULL4;
    }

    public void setNULL4(java.lang.String nULL4)
    {
        this.nULL4 = nULL4;
    }
    public java.lang.String getSHOPCODE()
    {
        return sHOPCODE;
    }

    public void setSHOPCODE(java.lang.String sHOPCODE)
    {
        this.sHOPCODE = sHOPCODE;
    }
    public java.lang.String getNULL5()
    {
        return nULL5;
    }

    public void setNULL5(java.lang.String nULL5)
    {
        this.nULL5 = nULL5;
    }
    public java.lang.String getNULL6()
    {
        return nULL6;
    }

    public void setNULL6(java.lang.String nULL6)
    {
        this.nULL6 = nULL6;
    }
    public java.lang.String getNULL7()
    {
        return nULL7;
    }

    public void setNULL7(java.lang.String nULL7)
    {
        this.nULL7 = nULL7;
    }
    public java.lang.String getNULL8()
    {
        return nULL8;
    }

    public void setNULL8(java.lang.String nULL8)
    {
        this.nULL8 = nULL8;
    }
    public java.lang.String getNULL9()
    {
        return nULL9;
    }

    public void setNULL9(java.lang.String nULL9)
    {
        this.nULL9 = nULL9;
    }
    public java.lang.String getNULL10()
    {
        return nULL10;
    }

    public void setNULL10(java.lang.String nULL10)
    {
        this.nULL10 = nULL10;
    }
    public java.lang.String getNULL11()
    {
        return nULL11;
    }

    public void setNULL11(java.lang.String nULL11)
    {
        this.nULL11 = nULL11;
    }
    public java.lang.String getNULL12()
    {
        return nULL12;
    }

    public void setNULL12(java.lang.String nULL12)
    {
        this.nULL12 = nULL12;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
