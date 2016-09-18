package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Duty extends EntityBase{

    @DataMapping(DutyMapping.DutyId)
    private int dutyId;//
    @DataMapping(DutyMapping.DutyName)
    private java.lang.String dutyName;//岗位名称
    @DataMapping(DutyMapping.DutyCode)
    private java.lang.String dutyCode;//岗位代码 0为默认的 内置岗位需要特定代码 销售101 销售总监102 城市经理103 大区经理104
    @DataMapping(DutyMapping.Status)
    private int status;//


    public Duty() { }

    public int getDutyId()
    {
        return dutyId;
    }

    public void setDutyId(int dutyId)
    {
        this.dutyId = dutyId;
    }
    public java.lang.String getDutyName()
    {
        return dutyName;
    }

    public void setDutyName(java.lang.String dutyName)
    {
        this.dutyName = dutyName;
    }
    public java.lang.String getDutyCode()
    {
        return dutyCode;
    }

    public void setDutyCode(java.lang.String dutyCode)
    {
        this.dutyCode = dutyCode;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
