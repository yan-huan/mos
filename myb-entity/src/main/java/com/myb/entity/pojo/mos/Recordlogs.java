package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Recordlogs extends EntityBase{

    @DataMapping(RecordlogsMapping.LogsId)
    private int logsId;//记录日志信息
    @DataMapping(RecordlogsMapping.Mobile)
    private java.lang.String mobile;//开账号的手机号
    @DataMapping(RecordlogsMapping.Remark)
    private java.lang.String remark;//备注
    @DataMapping(RecordlogsMapping.Status)
    private int status;//
    @DataMapping(RecordlogsMapping.CreateTime)
    private java.util.Date createTime;//
    @DataMapping(RecordlogsMapping.OperationUser)
    private java.lang.String operationUser;//
    @DataMapping(RecordlogsMapping.UpdateTime)
    private java.util.Date updateTime;//
    @DataMapping(RecordlogsMapping.AddInfoUser)
    private java.lang.String addInfoUser;//开通账号的登陆用户
    @DataMapping(RecordlogsMapping.OpenShopAmount)
    private int openShopAmount;//开店数量
    @DataMapping(RecordlogsMapping.PayDate)
    private java.util.Date payDate;//付款日期
    @DataMapping(RecordlogsMapping.BeautifulYard)
    private java.lang.String beautifulYard;//美容院名称
    @DataMapping(RecordlogsMapping.ProvinceCode)
    private int provinceCode;//省份code
    @DataMapping(RecordlogsMapping.CityCode)
    private int cityCode;//城市code
    @DataMapping(RecordlogsMapping.ZongbuAddress)
    private java.lang.String zongbuAddress;//总部地址
    @DataMapping(RecordlogsMapping.ProvinceCodeShop)
    private int provinceCodeShop;//开店省份code
    @DataMapping(RecordlogsMapping.CityCodeShop)
    private int cityCodeShop;//开店城市code
    @DataMapping(RecordlogsMapping.StartDate)
    private java.util.Date startDate;//开通时间
    @DataMapping(RecordlogsMapping.EndDate)
    private java.util.Date endDate;//结束时间
    @DataMapping(RecordlogsMapping.ShopName)
    private java.lang.String shopName;//店名
    @DataMapping(RecordlogsMapping.DetailAddressShop)
    private java.lang.String detailAddressShop;//详细地址
    @DataMapping(RecordlogsMapping.Type)
    private int type;//type等于1为开账号错误，为2开店错误
    @DataMapping(RecordlogsMapping.Market)
    private java.lang.String market;//销售
    @DataMapping(RecordlogsMapping.CompanyCode)
    private java.lang.String companyCode;//账号code
    @DataMapping(RecordlogsMapping.ShopCode)
    private java.lang.String shopCode;//开店code
    @DataMapping(RecordlogsMapping.Duration)
    private int duration;//期限
    @DataMapping(RecordlogsMapping.AccountId)
    private int accountId;//关联开通账号的id
    @DataMapping(RecordlogsMapping.GiveAway)
    private int giveAway;//赠送月数


    public Recordlogs() { }

    public int getLogsId()
    {
        return logsId;
    }

    public void setLogsId(int logsId)
    {
        this.logsId = logsId;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
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
    public java.lang.String getOperationUser()
    {
        return operationUser;
    }

    public void setOperationUser(java.lang.String operationUser)
    {
        this.operationUser = operationUser;
    }
    public java.util.Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime)
    {
        this.updateTime = updateTime;
    }
    public java.lang.String getAddInfoUser()
    {
        return addInfoUser;
    }

    public void setAddInfoUser(java.lang.String addInfoUser)
    {
        this.addInfoUser = addInfoUser;
    }
    public int getOpenShopAmount()
    {
        return openShopAmount;
    }

    public void setOpenShopAmount(int openShopAmount)
    {
        this.openShopAmount = openShopAmount;
    }
    public java.util.Date getPayDate()
    {
        return payDate;
    }

    public void setPayDate(java.util.Date payDate)
    {
        this.payDate = payDate;
    }
    public java.lang.String getBeautifulYard()
    {
        return beautifulYard;
    }

    public void setBeautifulYard(java.lang.String beautifulYard)
    {
        this.beautifulYard = beautifulYard;
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
    public int getProvinceCodeShop()
    {
        return provinceCodeShop;
    }

    public void setProvinceCodeShop(int provinceCodeShop)
    {
        this.provinceCodeShop = provinceCodeShop;
    }
    public int getCityCodeShop()
    {
        return cityCodeShop;
    }

    public void setCityCodeShop(int cityCodeShop)
    {
        this.cityCodeShop = cityCodeShop;
    }
    public java.util.Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(java.util.Date startDate)
    {
        this.startDate = startDate;
    }
    public java.util.Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate)
    {
        this.endDate = endDate;
    }
    public java.lang.String getShopName()
    {
        return shopName;
    }

    public void setShopName(java.lang.String shopName)
    {
        this.shopName = shopName;
    }
    public java.lang.String getDetailAddressShop()
    {
        return detailAddressShop;
    }

    public void setDetailAddressShop(java.lang.String detailAddressShop)
    {
        this.detailAddressShop = detailAddressShop;
    }
    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }
    public java.lang.String getMarket()
    {
        return market;
    }

    public void setMarket(java.lang.String market)
    {
        this.market = market;
    }
    public java.lang.String getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(java.lang.String companyCode)
    {
        this.companyCode = companyCode;
    }
    public java.lang.String getShopCode()
    {
        return shopCode;
    }

    public void setShopCode(java.lang.String shopCode)
    {
        this.shopCode = shopCode;
    }
    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    public int getAccountId()
    {
        return accountId;
    }

    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }
    public int getGiveAway()
    {
        return giveAway;
    }

    public void setGiveAway(int giveAway)
    {
        this.giveAway = giveAway;
    }

}
