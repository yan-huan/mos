package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class UserInfo extends EntityBase{

    @DataMapping(UserInfoMapping.Xu)
    private java.lang.String xu;//
    @DataMapping(UserInfoMapping.Quyu)
    private java.lang.String quyu;//
    @DataMapping(UserInfoMapping.Xingming)
    private java.lang.String xingming;//
    @DataMapping(UserInfoMapping.Bumen)
    private java.lang.String bumen;//
    @DataMapping(UserInfoMapping.Gangwei)
    private java.lang.String gangwei;//
    @DataMapping(UserInfoMapping.Id)
    private int id;//
    @DataMapping(UserInfoMapping.EmpId)
    private int empId;//
    @DataMapping(UserInfoMapping.Mobile)
    private String mobile;//
    @DataMapping(UserInfoMapping.Xiaozu)
    private String xiaozu;//



    public java.lang.String getXu()
    {
        return xu;
    }

    public void setXu(java.lang.String xu)
    {
        this.xu = xu;
    }
    public java.lang.String getQuyu()
    {
        return quyu;
    }

    public void setQuyu(java.lang.String quyu)
    {
        this.quyu = quyu;
    }
    public java.lang.String getXingming()
    {
        return xingming;
    }

    public void setXingming(java.lang.String xingming)
    {
        this.xingming = xingming;
    }
    public java.lang.String getBumen()
    {
        return bumen;
    }

    public void setBumen(java.lang.String bumen)
    {
        this.bumen = bumen;
    }
    public java.lang.String getGangwei()
    {
        return gangwei;
    }

    public void setGangwei(java.lang.String gangwei)
    {
        this.gangwei = gangwei;
    }
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getXiaozu() {
		return xiaozu;
	}

	public void setXiaozu(String xiaozu) {
		this.xiaozu = xiaozu;
	}


}
