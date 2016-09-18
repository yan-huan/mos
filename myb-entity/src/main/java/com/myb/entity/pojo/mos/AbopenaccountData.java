package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class AbopenaccountData extends EntityBase{

    @DataMapping(AbopenaccountDataMapping.Id)
    private java.lang.String id;//
    @DataMapping(AbopenaccountDataMapping.COMPANYCODE)
    private java.lang.String cOMPANYCODE;//
    @DataMapping(AbopenaccountDataMapping.BEAUTIFULYARD)
    private java.lang.String bEAUTIFULYARD;//
    @DataMapping(AbopenaccountDataMapping.OPENNUMBER)
    private java.lang.String oPENNUMBER;//
    @DataMapping(AbopenaccountDataMapping.SHOPCOUNT)
    private java.lang.String sHOPCOUNT;//
    @DataMapping(AbopenaccountDataMapping.PAYDATE)
    private java.lang.String pAYDATE;//
    @DataMapping(AbopenaccountDataMapping.CREATETIME)
    private java.util.Date cREATETIME;//
    @DataMapping(AbopenaccountDataMapping.ENDTIME)
    private java.util.Date eNDTIME;//
    @DataMapping(AbopenaccountDataMapping.ZONGBUADDRESS)
    private java.lang.String zONGBUADDRESS;//
    @DataMapping(AbopenaccountDataMapping.PROVINCE)
    private java.lang.String pROVINCE;//
    @DataMapping(AbopenaccountDataMapping.CITY)
    private java.lang.String cITY;//


    public AbopenaccountData() { }


	public java.lang.String getId() {
		return id;
	}


	public void setId(java.lang.String id) {
		this.id = id;
	}


	public java.lang.String getcOMPANYCODE() {
		return cOMPANYCODE;
	}


	public void setcOMPANYCODE(java.lang.String cOMPANYCODE) {
		this.cOMPANYCODE = cOMPANYCODE;
	}


	public java.lang.String getbEAUTIFULYARD() {
		return bEAUTIFULYARD;
	}


	public void setbEAUTIFULYARD(java.lang.String bEAUTIFULYARD) {
		this.bEAUTIFULYARD = bEAUTIFULYARD;
	}


	public java.lang.String getoPENNUMBER() {
		return oPENNUMBER;
	}


	public void setoPENNUMBER(java.lang.String oPENNUMBER) {
		this.oPENNUMBER = oPENNUMBER;
	}


	public java.lang.String getsHOPCOUNT() {
		return sHOPCOUNT;
	}


	public void setsHOPCOUNT(java.lang.String sHOPCOUNT) {
		this.sHOPCOUNT = sHOPCOUNT;
	}


	public java.lang.String getpAYDATE() {
		return pAYDATE;
	}


	public void setpAYDATE(java.lang.String pAYDATE) {
		this.pAYDATE = pAYDATE;
	}


	public java.util.Date getcREATETIME() {
		return cREATETIME;
	}


	public void setcREATETIME(java.util.Date cREATETIME) {
		this.cREATETIME = cREATETIME;
	}


	public java.util.Date geteNDTIME() {
		return eNDTIME;
	}


	public void seteNDTIME(java.util.Date eNDTIME) {
		this.eNDTIME = eNDTIME;
	}


	public java.lang.String getzONGBUADDRESS() {
		return zONGBUADDRESS;
	}


	public void setzONGBUADDRESS(java.lang.String zONGBUADDRESS) {
		this.zONGBUADDRESS = zONGBUADDRESS;
	}


	public java.lang.String getpROVINCE() {
		return pROVINCE;
	}


	public void setpROVINCE(java.lang.String pROVINCE) {
		this.pROVINCE = pROVINCE;
	}


	public java.lang.String getcITY() {
		return cITY;
	}


	public void setcITY(java.lang.String cITY) {
		this.cITY = cITY;
	}

    
}
