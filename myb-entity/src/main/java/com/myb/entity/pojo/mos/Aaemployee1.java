package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Aaemployee1 extends EntityBase{

    @DataMapping(Aaemployee1Mapping.Xu)
    private java.lang.String xu;//
    @DataMapping(Aaemployee1Mapping.A)
    private java.lang.String a;//
    @DataMapping(Aaemployee1Mapping.Quyu)
    private java.lang.String quyu;//
    @DataMapping(Aaemployee1Mapping.Gonghao)
    private java.lang.String gonghao;//
    @DataMapping(Aaemployee1Mapping.Xingming)
    private java.lang.String xingming;//
    @DataMapping(Aaemployee1Mapping.Shenfenzheng)
    private java.lang.String shenfenzheng;//
    @DataMapping(Aaemployee1Mapping.Xingbie)
    private java.lang.String xingbie;//
    @DataMapping(Aaemployee1Mapping.Bian)
    private java.lang.String bian;//
    @DataMapping(Aaemployee1Mapping.Nianling)
    private java.lang.String nianling;//
    @DataMapping(Aaemployee1Mapping.Bumen)
    private java.lang.String bumen;//
    @DataMapping(Aaemployee1Mapping.Gangwei)
    private java.lang.String gangwei;//
    @DataMapping(Aaemployee1Mapping.Ruzhishijian)
    private java.sql.Timestamp ruzhishijian;//
    @DataMapping(Aaemployee1Mapping.Zhuanzhenshijian)
    private java.sql.Timestamp zhuanzhenshijian;//
    @DataMapping(Aaemployee1Mapping.Xingzhi)
    private java.lang.String xingzhi;//
    @DataMapping(Aaemployee1Mapping.Xueli)
    private java.lang.String xueli;//
    @DataMapping(Aaemployee1Mapping.Xuexiao)
    private java.lang.String xuexiao;//
    @DataMapping(Aaemployee1Mapping.Zhuanye)
    private java.lang.String zhuanye;//
    @DataMapping(Aaemployee1Mapping.Shebao)
    private java.lang.String shebao;//
    @DataMapping(Aaemployee1Mapping.Mobile)
    private java.lang.String mobile;//
    @DataMapping(Aaemployee1Mapping.F20)
    private java.lang.String f20;//
    @DataMapping(Aaemployee1Mapping.F21)
    private java.lang.String f21;//


    public Aaemployee1() { }

    public java.lang.String getXu()
    {
        return xu;
    }

    public void setXu(java.lang.String xu)
    {
        this.xu = xu;
    }
    public java.lang.String getA()
    {
        return a;
    }

    public void setA(java.lang.String a)
    {
        this.a = a;
    }
    public java.lang.String getQuyu()
    {
        return quyu;
    }

    public void setQuyu(java.lang.String quyu)
    {
        this.quyu = quyu;
    }
    public java.lang.String getGonghao()
    {
        return gonghao;
    }

    public void setGonghao(java.lang.String gonghao)
    {
        this.gonghao = gonghao;
    }
    public java.lang.String getXingming()
    {
        return xingming;
    }

    public void setXingming(java.lang.String xingming)
    {
        this.xingming = xingming;
    }
    public java.lang.String getShenfenzheng()
    {
        return shenfenzheng;
    }

    public void setShenfenzheng(java.lang.String shenfenzheng)
    {
        this.shenfenzheng = shenfenzheng;
    }
    public java.lang.String getXingbie()
    {
        return xingbie;
    }

    public void setXingbie(java.lang.String xingbie)
    {
        this.xingbie = xingbie;
    }
    public java.lang.String getBian()
    {
        return bian;
    }

    public void setBian(java.lang.String bian)
    {
        this.bian = bian;
    }
    public java.lang.String getNianling()
    {
        return nianling;
    }

    public void setNianling(java.lang.String nianling)
    {
        this.nianling = nianling;
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
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getRuzhishijian()
    {
        return ruzhishijian;
    }

    public void setRuzhishijian(java.sql.Timestamp ruzhishijian)
    {
        this.ruzhishijian = ruzhishijian;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getZhuanzhenshijian()
    {
        return zhuanzhenshijian;
    }

    public void setZhuanzhenshijian(java.sql.Timestamp zhuanzhenshijian)
    {
        this.zhuanzhenshijian = zhuanzhenshijian;
    }
    public java.lang.String getXingzhi()
    {
        return xingzhi;
    }

    public void setXingzhi(java.lang.String xingzhi)
    {
        this.xingzhi = xingzhi;
    }
    public java.lang.String getXueli()
    {
        return xueli;
    }

    public void setXueli(java.lang.String xueli)
    {
        this.xueli = xueli;
    }
    public java.lang.String getXuexiao()
    {
        return xuexiao;
    }

    public void setXuexiao(java.lang.String xuexiao)
    {
        this.xuexiao = xuexiao;
    }
    public java.lang.String getZhuanye()
    {
        return zhuanye;
    }

    public void setZhuanye(java.lang.String zhuanye)
    {
        this.zhuanye = zhuanye;
    }
    public java.lang.String getShebao()
    {
        return shebao;
    }

    public void setShebao(java.lang.String shebao)
    {
        this.shebao = shebao;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
    }
    public java.lang.String getF20()
    {
        return f20;
    }

    public void setF20(java.lang.String f20)
    {
        this.f20 = f20;
    }
    public java.lang.String getF21()
    {
        return f21;
    }

    public void setF21(java.lang.String f21)
    {
        this.f21 = f21;
    }

}
