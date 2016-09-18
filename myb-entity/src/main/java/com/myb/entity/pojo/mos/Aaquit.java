package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Aaquit extends EntityBase{

    @DataMapping(AaquitMapping.Aa)
    private java.lang.String aa;//


    public Aaquit() { }

    public java.lang.String getAa()
    {
        return aa;
    }

    public void setAa(java.lang.String aa)
    {
        this.aa = aa;
    }

}
