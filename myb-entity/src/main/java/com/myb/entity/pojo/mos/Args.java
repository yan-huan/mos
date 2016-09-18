package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Args extends EntityBase{

    @DataMapping(ArgsMapping.ArgId)
    private int argId;//
    @DataMapping(ArgsMapping.ArgName)
    private java.lang.String argName;//
    @DataMapping(ArgsMapping.ArgType)
    private java.lang.String argType;//
    @DataMapping(ArgsMapping.Status)
    private int status;//
    @DataMapping(ArgsMapping.ArgValue)
    private String argValue;//参数对应的值


    public Args() { }

    public int getArgId()
    {
        return argId;
    }

    public void setArgId(int argId)
    {
        this.argId = argId;
    }
    public java.lang.String getArgName()
    {
        return argName;
    }

    public void setArgName(java.lang.String argName)
    {
        this.argName = argName;
    }
    public java.lang.String getArgType()
    {
        return argType;
    }

    public void setArgType(java.lang.String argType)
    {
        this.argType = argType;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

	public String getArgValue() {
		return argValue;
	}

	public void setArgValue(String argValue) {
		this.argValue = argValue;
	}



}
