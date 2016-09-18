package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class City extends EntityBase{

    @DataMapping(CityMapping.CityId)
    private int cityId;//
    @DataMapping(CityMapping.Cityshort)
    private java.lang.String cityshort;//城市简称 如 bj
    @DataMapping(CityMapping.Cityname)
    private java.lang.String cityname;//城市全称 如 北京


    public City() { }

    public int getCityId()
    {
        return cityId;
    }

    public void setCityId(int cityId)
    {
        this.cityId = cityId;
    }
    public java.lang.String getCityshort()
    {
        return cityshort;
    }

    public void setCityshort(java.lang.String cityshort)
    {
        this.cityshort = cityshort;
    }
    public java.lang.String getCityname()
    {
        return cityname;
    }

    public void setCityname(java.lang.String cityname)
    {
        this.cityname = cityname;
    }

}
