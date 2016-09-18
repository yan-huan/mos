package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Area extends EntityBase{

    @DataMapping(AreaMapping.AreaId)
    private int areaId;//
    @DataMapping(AreaMapping.CityId)
    private int cityId;//
    @DataMapping(AreaMapping.AreaName)
    private java.lang.String areaName;//


    public Area() { }

    public int getAreaId()
    {
        return areaId;
    }

    public void setAreaId(int areaId)
    {
        this.areaId = areaId;
    }
    public int getCityId()
    {
        return cityId;
    }

    public void setCityId(int cityId)
    {
        this.cityId = cityId;
    }
    public java.lang.String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(java.lang.String areaName)
    {
        this.areaName = areaName;
    }

}
