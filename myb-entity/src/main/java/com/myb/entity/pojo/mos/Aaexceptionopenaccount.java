package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Aaexceptionopenaccount extends EntityBase{

    @DataMapping(AaexceptionopenaccountMapping.Id)
    private int id;//
    @DataMapping(AaexceptionopenaccountMapping.Mobile)
    private java.lang.String mobile;//


    public Aaexceptionopenaccount() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
    }

}
