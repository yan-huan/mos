package com.myb.mos.VO;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class CrmUserinfoVO extends EntityBase{

    private int id;//
    private java.lang.String quyu;//大区
    private java.lang.String xingming;//
    private java.lang.String bumen;//
    private java.lang.String gangwei;//
    private int empId;//
    private int superiorId;//上级id
    private java.lang.String mobile;//手机号
    private java.lang.String xu;//
    private java.lang.String xiaozu;//小组
    private int isValide;//1：无效


    public CrmUserinfoVO() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }
    public int getSuperiorId()
    {
        return superiorId;
    }

    public void setSuperiorId(int superiorId)
    {
        this.superiorId = superiorId;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
    }
    public java.lang.String getXu()
    {
        return xu;
    }

    public void setXu(java.lang.String xu)
    {
        this.xu = xu;
    }
    public java.lang.String getXiaozu()
    {
        return xiaozu;
    }

    public void setXiaozu(java.lang.String xiaozu)
    {
        this.xiaozu = xiaozu;
    }
    public int getIsValide()
    {
        return isValide;
    }

    public void setIsValide(int isValide)
    {
        this.isValide = isValide;
    }



}
