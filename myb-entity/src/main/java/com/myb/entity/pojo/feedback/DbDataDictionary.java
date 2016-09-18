package com.myb.entity.pojo.feedback;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class DbDataDictionary extends EntityBase{

    @DataMapping(DbDataDictionaryMapping.Id)
    private int id;//
    @DataMapping(DbDataDictionaryMapping.AddTime)
    private java.sql.Timestamp addTime;//
    @DataMapping(DbDataDictionaryMapping.ModifyTime)
    private java.sql.Timestamp modifyTime;//
    @DataMapping(DbDataDictionaryMapping.Code)
    private java.lang.String code;//
    @DataMapping(DbDataDictionaryMapping.Name)
    private java.lang.String name;//
    @DataMapping(DbDataDictionaryMapping.Type)
    private int type;//


    public DbDataDictionary() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getAddTime()
    {
        return addTime;
    }

    public void setAddTime(java.sql.Timestamp addTime)
    {
        this.addTime = addTime;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getModifyTime()
    {
        return modifyTime;
    }

    public void setModifyTime(java.sql.Timestamp modifyTime)
    {
        this.modifyTime = modifyTime;
    }
    public java.lang.String getCode()
    {
        return code;
    }

    public void setCode(java.lang.String code)
    {
        this.code = code;
    }
    public java.lang.String getName()
    {
        return name;
    }

    public void setName(java.lang.String name)
    {
        this.name = name;
    }
    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

}
