package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Shop extends EntityBase{

    @DataMapping(ShopMapping.ShopId)
    private int shopId;//
    @DataMapping(ShopMapping.ContractId)
    private int contractId;//
    @DataMapping(ShopMapping.ShopName)
    private java.lang.String shopName;//店名
    @DataMapping(ShopMapping.ShopOwner)
    private java.lang.String shopOwner;//店长
    @DataMapping(ShopMapping.ShopAccount)
    private java.lang.String shopAccount;//该店账号
    @DataMapping(ShopMapping.City)
    private java.lang.String city;//
    @DataMapping(ShopMapping.Province)
    private java.lang.String province;//商圈
    @DataMapping(ShopMapping.BeginDate)
    private java.util.Date beginDate;//账号开通时间
    @DataMapping(ShopMapping.EndDate)
    private java.util.Date endDate;//账号停止时间
    @DataMapping(ShopMapping.Duration)
    private int duration;//开通年限 1一年 3三年 9终身 
    @DataMapping(ShopMapping.Address)
    private java.lang.String address;//门店地址
    @DataMapping(ShopMapping.Longitude)
    private java.lang.String longitude;//经度
    @DataMapping(ShopMapping.Latitude)
    private java.lang.String latitude;//纬度
    @DataMapping(ShopMapping.GiveAway)
    private java.lang.String giveAway;//
    @DataMapping(ShopMapping.CreateTime)
    private java.util.Date createTime;//
    @DataMapping(ShopMapping.Business)
    private java.lang.String business;//
    @DataMapping(ShopMapping.AccountId)
    private int accountId;//
    @DataMapping(ShopMapping.Shopcode)
    private java.lang.String shopcode;//
    @DataMapping(ShopMapping.IsChannel)
    private java.lang.String isChannel;//是否是渠道
    @DataMapping(ShopMapping.CurrentRate)
    private Double currentRate;//当前利率
    @DataMapping(ShopMapping.Danjia)
    private Double danjia;//店的单价
    @DataMapping(ShopMapping.ExceptionStatus)
    private int exceptionStatus;//1代表账号加店，2代表店的续签，3代表退款，4代表修改店的信息
    @DataMapping(ShopMapping.UpdateTime)
    private java.util.Date updateTime;//更新时间
    @DataMapping(ShopMapping.Ispass)
    private int ispass;//是否通过1为通过，2为未通过，修改信息的时候，3为未审核
    @DataMapping(ShopMapping.Refuse)
    private java.lang.String refuse;//修改店的拒绝的原因
    
    private String beLongCity;//所属城市的业绩

    public Shop() { }

    public int getShopId()
    {
        return shopId;
    }

    public void setShopId(int shopId)
    {
        this.shopId = shopId;
    }
    public int getContractId()
    {
        return contractId;
    }

    public void setContractId(int contractId)
    {
        this.contractId = contractId;
    }
    public java.lang.String getShopName()
    {
        return shopName;
    }

    public void setShopName(java.lang.String shopName)
    {
        this.shopName = shopName;
    }
    public java.lang.String getShopOwner()
    {
        return shopOwner;
    }

    public void setShopOwner(java.lang.String shopOwner)
    {
        this.shopOwner = shopOwner;
    }
    public java.lang.String getShopAccount()
    {
        return shopAccount;
    }

    public void setShopAccount(java.lang.String shopAccount)
    {
        this.shopAccount = shopAccount;
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
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getBeginDate()
    {
        return beginDate;
    }

    public void setBeginDate(java.util.Date beginDate)
    {
        this.beginDate = beginDate;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate)
    {
        this.endDate = endDate;
    }
    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    public java.lang.String getAddress()
    {
        return address;
    }

    public void setAddress(java.lang.String address)
    {
        this.address = address;
    }
    public java.lang.String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(java.lang.String longitude)
    {
        this.longitude = longitude;
    }
    public java.lang.String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(java.lang.String latitude)
    {
        this.latitude = latitude;
    }
    public java.lang.String getGiveAway()
    {
        return giveAway;
    }

    public void setGiveAway(java.lang.String giveAway)
    {
        this.giveAway = giveAway;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime)
    {
        this.createTime = createTime;
    }
    public java.lang.String getBusiness()
    {
        return business;
    }

    public void setBusiness(java.lang.String business)
    {
        this.business = business;
    }
    public int getAccountId()
    {
        return accountId;
    }

    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }
    public java.lang.String getShopcode()
    {
        return shopcode;
    }

    public void setShopcode(java.lang.String shopcode)
    {
        this.shopcode = shopcode;
    }
    public java.lang.String getIsChannel()
    {
        return isChannel;
    }

    public void setIsChannel(java.lang.String isChannel)
    {
        this.isChannel = isChannel;
    }
    
    public Double getCurrentRate() {
		return currentRate;
	}

	public void setCurrentRate(Double currentRate) {
		this.currentRate = currentRate;
	}

	public Double getDanjia() {
		return danjia;
	}

	public void setDanjia(Double danjia) {
		this.danjia = danjia;
	}

	public int getExceptionStatus()
    {
        return exceptionStatus;
    }

    public void setExceptionStatus(int exceptionStatus)
    {
        this.exceptionStatus = exceptionStatus;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime)
    {
        this.updateTime = updateTime;
    }
    public int getIspass()
    {
        return ispass;
    }

    public void setIspass(int ispass)
    {
        this.ispass = ispass;
    }
    public java.lang.String getRefuse()
    {
        return refuse;
    }

    public void setRefuse(java.lang.String refuse)
    {
        this.refuse = refuse;
    }

	public String getBeLongCity() {
		return beLongCity;
	}

	public void setBeLongCity(String beLongCity) {
		this.beLongCity = beLongCity;
	}

    
}
