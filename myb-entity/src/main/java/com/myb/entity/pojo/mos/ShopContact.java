package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ShopContact extends EntityBase{

    @DataMapping(ShopContactMapping.Id)
    private long id;//
    @DataMapping(ShopContactMapping.ShopId)
    private long shopId;//店id
    @DataMapping(ShopContactMapping.Name)
    private java.lang.String name;//
    @DataMapping(ShopContactMapping.Telephone)
    private java.lang.String telephone;//
    @DataMapping(ShopContactMapping.Wechat)
    private java.lang.String wechat;//微信号
    @DataMapping(ShopContactMapping.Duty)
    private int duty;//职位：老板1，店长2，店员3


    public ShopContact() { }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    public long getShopId()
    {
        return shopId;
    }

    public void setShopId(long shopId)
    {
        this.shopId = shopId;
    }
    public java.lang.String getName()
    {
        return name;
    }

    public void setName(java.lang.String name)
    {
        this.name = name;
    }
    public java.lang.String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(java.lang.String telephone)
    {
        this.telephone = telephone;
    }
    public java.lang.String getWechat()
    {
        return wechat;
    }

    public void setWechat(java.lang.String wechat)
    {
        this.wechat = wechat;
    }
    public int getDuty()
    {
        return duty;
    }

    public void setDuty(int duty)
    {
        this.duty = duty;
    }

}
