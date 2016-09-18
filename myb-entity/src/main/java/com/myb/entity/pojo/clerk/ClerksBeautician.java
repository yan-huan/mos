package com.myb.entity.pojo.clerk;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ClerksBeautician extends EntityBase{

    @DataMapping(ClerksBeauticianMapping.Id)
    private int id;//
    @DataMapping(ClerksBeauticianMapping.Code)
    private java.lang.String code;//code
    @DataMapping(ClerksBeauticianMapping.ObjName)
    private java.lang.String objName;//姓名
    @DataMapping(ClerksBeauticianMapping.Age)
    private int age;//年龄
    @DataMapping(ClerksBeauticianMapping.Sex)
    private int sex;//性别
    @DataMapping(ClerksBeauticianMapping.UnionId)
    private java.lang.String unionId;//
    @DataMapping(ClerksBeauticianMapping.CardType)
    private java.lang.String cardType;//证件类型：SHENFENZHENG--身份证
    @DataMapping(ClerksBeauticianMapping.CardCode)
    private java.lang.String cardCode;//证件号
    @DataMapping(ClerksBeauticianMapping.UpdateBy)
    private java.lang.String updateBy;//更新人
    @DataMapping(ClerksBeauticianMapping.Comments)
    private java.lang.String comments;//备注
    @DataMapping(ClerksBeauticianMapping.Status)
    private java.lang.String status;//INIT--初始化； NORMAL--可以使用； LOCKED--被锁定； DELETED--逻辑删除
    @DataMapping(ClerksBeauticianMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//创建日期
    @DataMapping(ClerksBeauticianMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//更新日期


    public ClerksBeautician() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getCode()
    {
        return code;
    }

    public void setCode(java.lang.String code)
    {
        this.code = code;
    }
    public java.lang.String getObjName()
    {
        return objName;
    }

    public void setObjName(java.lang.String objName)
    {
        this.objName = objName;
    }
    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    public int getSex()
    {
        return sex;
    }

    public void setSex(int sex)
    {
        this.sex = sex;
    }
    public java.lang.String getUnionId()
    {
        return unionId;
    }

    public void setUnionId(java.lang.String unionId)
    {
        this.unionId = unionId;
    }
    public java.lang.String getCardType()
    {
        return cardType;
    }

    public void setCardType(java.lang.String cardType)
    {
        this.cardType = cardType;
    }
    public java.lang.String getCardCode()
    {
        return cardCode;
    }

    public void setCardCode(java.lang.String cardCode)
    {
        this.cardCode = cardCode;
    }
    public java.lang.String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(java.lang.String updateBy)
    {
        this.updateBy = updateBy;
    }
    public java.lang.String getComments()
    {
        return comments;
    }

    public void setComments(java.lang.String comments)
    {
        this.comments = comments;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt)
    {
        this.createdAt = createdAt;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt)
    {
        this.updatedAt = updatedAt;
    }

}
