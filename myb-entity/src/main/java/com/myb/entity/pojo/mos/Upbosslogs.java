package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Upbosslogs extends EntityBase{

    @DataMapping(UpbosslogsMapping.UpBossId)
    private int upBossId;//
    @DataMapping(UpbosslogsMapping.BeautifulYard)
    private java.lang.String beautifulYard;//美容院名称
    @DataMapping(UpbosslogsMapping.OpenNumber)
    private java.lang.String openNumber;//开通账号手机号
    @DataMapping(UpbosslogsMapping.PayDate)
    private java.util.Date payDate;//付款日期
    @DataMapping(UpbosslogsMapping.Marker)
    private java.lang.String marker;//销售人员
    @DataMapping(UpbosslogsMapping.ProvinceCode)
    private int provinceCode;//省份code
    @DataMapping(UpbosslogsMapping.CityCode)
    private int cityCode;//城市code
    @DataMapping(UpbosslogsMapping.ZongbuAddress)
    private java.lang.String zongbuAddress;//总部地址
    @DataMapping(UpbosslogsMapping.Remark)
    private java.lang.String remark;//备注
    @DataMapping(UpbosslogsMapping.Status)
    private int status;//状态
    @DataMapping(UpbosslogsMapping.CreateTime)
    private java.util.Date createTime;//创建时间
    @DataMapping(UpbosslogsMapping.CompanyCode)
    private java.lang.String companyCode;//公司code
    @DataMapping(UpbosslogsMapping.ShopCount)//开店数量
    private int shopCount;//
    private String provinceName;
    private String cityName;


    public Upbosslogs() { }

    public int getUpBossId()
    {
        return upBossId;
    }

    public void setUpBossId(int upBossId)
    {
        this.upBossId = upBossId;
    }
    public java.lang.String getBeautifulYard()
    {
        return beautifulYard;
    }

    public void setBeautifulYard(java.lang.String beautifulYard)
    {
        this.beautifulYard = beautifulYard;
    }
    public java.lang.String getOpenNumber()
    {
        return openNumber;
    }

    public void setOpenNumber(java.lang.String openNumber)
    {
        this.openNumber = openNumber;
    }
    public java.util.Date getPayDate()
    {
        return payDate;
    }

    public void setPayDate(java.util.Date payDate)
    {
        this.payDate = payDate;
    }
    public java.lang.String getMarker()
    {
        return marker;
    }

    public void setMarker(java.lang.String marker)
    {
        this.marker = marker;
    }
    public int getProvinceCode()
    {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode)
    {
        this.provinceCode = provinceCode;
    }
    public int getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(int cityCode)
    {
        this.cityCode = cityCode;
    }
    public java.lang.String getZongbuAddress()
    {
        return zongbuAddress;
    }

    public void setZongbuAddress(java.lang.String zongbuAddress)
    {
        this.zongbuAddress = zongbuAddress;
    }
    public java.lang.String getRemark()
    {
        return remark;
    }

    public void setRemark(java.lang.String remark)
    {
        this.remark = remark;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    public java.util.Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime)
    {
        this.createTime = createTime;
    }
    public java.lang.String getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(java.lang.String companyCode)
    {
        this.companyCode = companyCode;
    }
    public int getShopCount()
    {
        return shopCount;
    }

    public void setShopCount(int shopCount)
    {
        this.shopCount = shopCount;
    }

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
