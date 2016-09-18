package com.myb.entity.pojo.clerk;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ClerksClerk extends EntityBase{

    @DataMapping(ClerksClerkMapping.Id)
    private int id;//
    @DataMapping(ClerksClerkMapping.Code)
    private java.lang.String code;//
    @DataMapping(ClerksClerkMapping.ClerkCode)
    private java.lang.String clerkCode;//
    @DataMapping(ClerksClerkMapping.ShopCode)
    private java.lang.String shopCode;//
    @DataMapping(ClerksClerkMapping.CompanyCode)
    private java.lang.String companyCode;//
    @DataMapping(ClerksClerkMapping.CreateBy)
    private java.lang.String createBy;//
    @DataMapping(ClerksClerkMapping.CreatePartyType)
    private java.lang.String createPartyType;//
    @DataMapping(ClerksClerkMapping.UpdateBy)
    private java.lang.String updateBy;//
    @DataMapping(ClerksClerkMapping.UpdatePartyType)
    private java.lang.String updatePartyType;//
    @DataMapping(ClerksClerkMapping.Comments)
    private java.lang.String comments;//
    @DataMapping(ClerksClerkMapping.Status)
    private java.lang.String status;//YOULI--游离状态，不属于任何美容院; INIT--初始化、待审批; NORMAL--正常使用中; LOCKED--锁定; UNBIND--解除绑定; DELETED--逻辑删除
    @DataMapping(ClerksClerkMapping.ObjName)
    private java.lang.String objName;//姓名
    @DataMapping(ClerksClerkMapping.BeauticianCode)
    private java.lang.String beauticianCode;//美容师code
    @DataMapping(ClerksClerkMapping.Age)
    private int age;//年龄
    @DataMapping(ClerksClerkMapping.Gender)
    private int gender;//性别
    @DataMapping(ClerksClerkMapping.Birthday)
    private java.sql.Timestamp birthday;//生日
    @DataMapping(ClerksClerkMapping.SecurityCode)
    private java.lang.String securityCode;//
    @DataMapping(ClerksClerkMapping.Address)
    private java.lang.String address;//地址
    @DataMapping(ClerksClerkMapping.Mobile)
    private java.lang.String mobile;//手机号
    @DataMapping(ClerksClerkMapping.Avatar)
    private java.lang.String avatar;//
    @DataMapping(ClerksClerkMapping.Seniority)
    private int seniority;//资历、工作年限
    @DataMapping(ClerksClerkMapping.Speciality)
    private java.lang.String speciality;//特长
    @DataMapping(ClerksClerkMapping.Title)
    private java.lang.String title;//一个职员只能有一个职位名称。但是可以有多个角色。
    @DataMapping(ClerksClerkMapping.Dreams)
    private java.lang.String dreams;//理想？梦想？
    @DataMapping(ClerksClerkMapping.Weixin)
    private java.lang.String weixin;//微信号
    @DataMapping(ClerksClerkMapping.Qq)
    private java.lang.String qq;//QQ号
    @DataMapping(ClerksClerkMapping.CompleteRange)
    private int completeRange;//完成范围？
    @DataMapping(ClerksClerkMapping.DefaultLoginAccountCode)
    private java.lang.String defaultLoginAccountCode;//默认登录帐号code
    @DataMapping(ClerksClerkMapping.ServiceTimes)
    private int serviceTimes;//服务次数，暂定 以完成的预约数目为准
    @DataMapping(ClerksClerkMapping.AverageRank)
    private double averageRank;//平均星级
    @DataMapping(ClerksClerkMapping.EvaluateTimes)
    private int evaluateTimes;//评价次数
    @DataMapping(ClerksClerkMapping.LeaveDate)
    private java.sql.Timestamp leaveDate;//
    @DataMapping(ClerksClerkMapping.CreatedAt)
    private java.sql.Timestamp createdAt;//创建日期
    @DataMapping(ClerksClerkMapping.UpdatedAt)
    private java.sql.Timestamp updatedAt;//更新日期


    public ClerksClerk() { }

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
    public java.lang.String getClerkCode()
    {
        return clerkCode;
    }

    public void setClerkCode(java.lang.String clerkCode)
    {
        this.clerkCode = clerkCode;
    }
    public java.lang.String getShopCode()
    {
        return shopCode;
    }

    public void setShopCode(java.lang.String shopCode)
    {
        this.shopCode = shopCode;
    }
    public java.lang.String getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(java.lang.String companyCode)
    {
        this.companyCode = companyCode;
    }
    public java.lang.String getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(java.lang.String createBy)
    {
        this.createBy = createBy;
    }
    public java.lang.String getCreatePartyType()
    {
        return createPartyType;
    }

    public void setCreatePartyType(java.lang.String createPartyType)
    {
        this.createPartyType = createPartyType;
    }
    public java.lang.String getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(java.lang.String updateBy)
    {
        this.updateBy = updateBy;
    }
    public java.lang.String getUpdatePartyType()
    {
        return updatePartyType;
    }

    public void setUpdatePartyType(java.lang.String updatePartyType)
    {
        this.updatePartyType = updatePartyType;
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
    public java.lang.String getObjName()
    {
        return objName;
    }

    public void setObjName(java.lang.String objName)
    {
        this.objName = objName;
    }
    public java.lang.String getBeauticianCode()
    {
        return beauticianCode;
    }

    public void setBeauticianCode(java.lang.String beauticianCode)
    {
        this.beauticianCode = beauticianCode;
    }
    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getBirthday()
    {
        return birthday;
    }

    public void setBirthday(java.sql.Timestamp birthday)
    {
        this.birthday = birthday;
    }
    public java.lang.String getSecurityCode()
    {
        return securityCode;
    }

    public void setSecurityCode(java.lang.String securityCode)
    {
        this.securityCode = securityCode;
    }
    public java.lang.String getAddress()
    {
        return address;
    }

    public void setAddress(java.lang.String address)
    {
        this.address = address;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
    }
    public java.lang.String getAvatar()
    {
        return avatar;
    }

    public void setAvatar(java.lang.String avatar)
    {
        this.avatar = avatar;
    }
    public int getSeniority()
    {
        return seniority;
    }

    public void setSeniority(int seniority)
    {
        this.seniority = seniority;
    }
    public java.lang.String getSpeciality()
    {
        return speciality;
    }

    public void setSpeciality(java.lang.String speciality)
    {
        this.speciality = speciality;
    }
    public java.lang.String getTitle()
    {
        return title;
    }

    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }
    public java.lang.String getDreams()
    {
        return dreams;
    }

    public void setDreams(java.lang.String dreams)
    {
        this.dreams = dreams;
    }
    public java.lang.String getWeixin()
    {
        return weixin;
    }

    public void setWeixin(java.lang.String weixin)
    {
        this.weixin = weixin;
    }
    public java.lang.String getQq()
    {
        return qq;
    }

    public void setQq(java.lang.String qq)
    {
        this.qq = qq;
    }
    public int getCompleteRange()
    {
        return completeRange;
    }

    public void setCompleteRange(int completeRange)
    {
        this.completeRange = completeRange;
    }
    public java.lang.String getDefaultLoginAccountCode()
    {
        return defaultLoginAccountCode;
    }

    public void setDefaultLoginAccountCode(java.lang.String defaultLoginAccountCode)
    {
        this.defaultLoginAccountCode = defaultLoginAccountCode;
    }
    public int getServiceTimes()
    {
        return serviceTimes;
    }

    public void setServiceTimes(int serviceTimes)
    {
        this.serviceTimes = serviceTimes;
    }
    public double getAverageRank()
    {
        return averageRank;
    }

    public void setAverageRank(double averageRank)
    {
        this.averageRank = averageRank;
    }
    public int getEvaluateTimes()
    {
        return evaluateTimes;
    }

    public void setEvaluateTimes(int evaluateTimes)
    {
        this.evaluateTimes = evaluateTimes;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.sql.Timestamp getLeaveDate()
    {
        return leaveDate;
    }

    public void setLeaveDate(java.sql.Timestamp leaveDate)
    {
        this.leaveDate = leaveDate;
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
