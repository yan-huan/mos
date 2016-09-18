package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class FreshShop extends EntityBase{

    @DataMapping(FreshShopMapping.Id)
    private long id;//
    @DataMapping(FreshShopMapping.Name)
    private java.lang.String name;//
    @DataMapping(FreshShopMapping.CityId)
    private long cityId;//
    @DataMapping(FreshShopMapping.BusinessArea)
    private java.lang.String businessArea;//商圈
    @DataMapping(FreshShopMapping.IsLink)
    private int isLink;//是否连锁：0非连锁；1连锁
    @DataMapping(FreshShopMapping.IsArea)
    private int isArea;//是否区域内：0在区域内，1非区域
    @DataMapping(FreshShopMapping.Address)
    private java.lang.String address;//
    @DataMapping(FreshShopMapping.LinkNum)
    private int linkNum;//连锁数量
    @DataMapping(FreshShopMapping.Telephone)
    private java.lang.String telephone;//座机电话
    @DataMapping(FreshShopMapping.Source)
    private java.lang.String source;//来源：自己/介绍
    @DataMapping(FreshShopMapping.IsPublic)
    private int isPublic;//是否公海1/私海0
    @DataMapping(FreshShopMapping.EmployeeId)
    private long employeeId;//业务员id
    @DataMapping(FreshShopMapping.VisitTimes)
    private int visitTimes;//拜访次数
    @DataMapping(FreshShopMapping.IsFinish)
    private int isFinish;//0未签单，1签单
    @DataMapping(FreshShopMapping.Process)
    private java.lang.String process;//当前进度（播种；收割，肥田）
    @DataMapping(FreshShopMapping.CreateTime)
    private java.util.Date createTime;//;
    @DataMapping(FreshShopMapping.Latitude)
    private java.lang.String latitude;//纬度
    @DataMapping(FreshShopMapping.Longitude)
    private java.lang.String longitude;//


    public FreshShop() { }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    public java.lang.String getName()
    {
        return name;
    }

    public void setName(java.lang.String name)
    {
        this.name = name;
    }
    public long getCityId()
    {
        return cityId;
    }

    public void setCityId(long cityId)
    {
        this.cityId = cityId;
    }
    public java.lang.String getBusinessArea()
    {
        return businessArea;
    }

    public void setBusinessArea(java.lang.String businessArea)
    {
        this.businessArea = businessArea;
    }
    public int getIsLink()
    {
        return isLink;
    }

    public void setIsLink(int isLink)
    {
        this.isLink = isLink;
    }
    public int getIsArea()
    {
        return isArea;
    }

    public void setIsArea(int isArea)
    {
        this.isArea = isArea;
    }
    public java.lang.String getAddress()
    {
        return address;
    }

    public void setAddress(java.lang.String address)
    {
        this.address = address;
    }
    public int getLinkNum()
    {
        return linkNum;
    }

    public void setLinkNum(int linkNum)
    {
        this.linkNum = linkNum;
    }
    public java.lang.String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(java.lang.String telephone)
    {
        this.telephone = telephone;
    }
    public java.lang.String getSource()
    {
        return source;
    }

    public void setSource(java.lang.String source)
    {
        this.source = source;
    }
    public int getIsPublic()
    {
        return isPublic;
    }

    public void setIsPublic(int isPublic)
    {
        this.isPublic = isPublic;
    }
    public long getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(long employeeId)
    {
        this.employeeId = employeeId;
    }
    public int getVisitTimes()
    {
        return visitTimes;
    }

    public void setVisitTimes(int visitTimes)
    {
        this.visitTimes = visitTimes;
    }
    public int getIsFinish()
    {
        return isFinish;
    }

    public void setIsFinish(int isFinish)
    {
        this.isFinish = isFinish;
    }
    public java.lang.String getProcess()
    {
        return process;
    }

    public void setProcess(java.lang.String process)
    {
        this.process = process;
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
    public java.lang.String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(java.lang.String latitude)
    {
        this.latitude = latitude;
    }
    public java.lang.String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(java.lang.String longitude)
    {
        this.longitude = longitude;
    }

}