package com.myb.entity.pojo.feedback;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class DbProblem extends EntityBase{

    @DataMapping(DbProblemMapping.Id)
    private int id;//
    @DataMapping(DbProblemMapping.AddTime)
    private java.sql.Timestamp addTime;//
    @DataMapping(DbProblemMapping.ModifyTime)
    private java.sql.Timestamp modifyTime;//
    @DataMapping(DbProblemMapping.Account)
    private java.lang.String account;//
    @DataMapping(DbProblemMapping.Answer)
    private java.lang.String answer;//
    @DataMapping(DbProblemMapping.AppVersion)
    private java.lang.String appVersion;//
    @DataMapping(DbProblemMapping.BeforeShantui)
    private java.lang.String beforeShantui;//
    @DataMapping(DbProblemMapping.BugType)
    private java.lang.String bugType;//
    @DataMapping(DbProblemMapping.CreateBy)
    private int createBy;//
    @DataMapping(DbProblemMapping.CreateByUname)
    private java.lang.String createByUname;//
    @DataMapping(DbProblemMapping.Descripe)
    private java.lang.String descripe;//
    @DataMapping(DbProblemMapping.ImgUrl)
    private java.lang.String imgUrl;//
    @DataMapping(DbProblemMapping.IosAuth)
    private java.lang.String iosAuth;//
    @DataMapping(DbProblemMapping.MobileModel)
    private java.lang.String mobileModel;//
    @DataMapping(DbProblemMapping.Rate)
    private java.lang.String rate;//
    @DataMapping(DbProblemMapping.Role)
    private java.lang.String role;//
    @DataMapping(DbProblemMapping.ShantuiTime)
    private java.lang.String shantuiTime;//
    @DataMapping(DbProblemMapping.Status)
    private java.lang.String status;//
    @DataMapping(DbProblemMapping.Title)
    private java.lang.String title;//
    @DataMapping(DbProblemMapping.UpdateBy)
    private int updateBy;//
    @DataMapping(DbProblemMapping.UpdateByUname)
    private java.lang.String updateByUname;//
    @DataMapping(DbProblemMapping.Version)
    private java.lang.String version;//
    @DataMapping(DbProblemMapping.VideoUrl)
    private java.lang.String videoUrl;//


    public DbProblem() { }

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
    public java.lang.String getAccount()
    {
        return account;
    }

    public void setAccount(java.lang.String account)
    {
        this.account = account;
    }
    public java.lang.String getAnswer()
    {
        return answer;
    }

    public void setAnswer(java.lang.String answer)
    {
        this.answer = answer;
    }
    public java.lang.String getAppVersion()
    {
        return appVersion;
    }

    public void setAppVersion(java.lang.String appVersion)
    {
        this.appVersion = appVersion;
    }
    public java.lang.String getBeforeShantui()
    {
        return beforeShantui;
    }

    public void setBeforeShantui(java.lang.String beforeShantui)
    {
        this.beforeShantui = beforeShantui;
    }
    public java.lang.String getBugType()
    {
        return bugType;
    }

    public void setBugType(java.lang.String bugType)
    {
        this.bugType = bugType;
    }
    public int getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(int createBy)
    {
        this.createBy = createBy;
    }
    public java.lang.String getCreateByUname()
    {
        return createByUname;
    }

    public void setCreateByUname(java.lang.String createByUname)
    {
        this.createByUname = createByUname;
    }
    public java.lang.String getDescripe()
    {
        return descripe;
    }

    public void setDescripe(java.lang.String descripe)
    {
        this.descripe = descripe;
    }
    public java.lang.String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(java.lang.String imgUrl)
    {
        this.imgUrl = imgUrl;
    }
    public java.lang.String getIosAuth()
    {
        return iosAuth;
    }

    public void setIosAuth(java.lang.String iosAuth)
    {
        this.iosAuth = iosAuth;
    }
    public java.lang.String getMobileModel()
    {
        return mobileModel;
    }

    public void setMobileModel(java.lang.String mobileModel)
    {
        this.mobileModel = mobileModel;
    }
    public java.lang.String getRate()
    {
        return rate;
    }

    public void setRate(java.lang.String rate)
    {
        this.rate = rate;
    }
    public java.lang.String getRole()
    {
        return role;
    }

    public void setRole(java.lang.String role)
    {
        this.role = role;
    }
    public java.lang.String getShantuiTime()
    {
        return shantuiTime;
    }

    public void setShantuiTime(java.lang.String shantuiTime)
    {
        this.shantuiTime = shantuiTime;
    }
    public java.lang.String getStatus()
    {
        return status;
    }

    public void setStatus(java.lang.String status)
    {
        this.status = status;
    }
    public java.lang.String getTitle()
    {
        return title;
    }

    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }
    public int getUpdateBy()
    {
        return updateBy;
    }

    public void setUpdateBy(int updateBy)
    {
        this.updateBy = updateBy;
    }
    public java.lang.String getUpdateByUname()
    {
        return updateByUname;
    }

    public void setUpdateByUname(java.lang.String updateByUname)
    {
        this.updateByUname = updateByUname;
    }
    public java.lang.String getVersion()
    {
        return version;
    }

    public void setVersion(java.lang.String version)
    {
        this.version = version;
    }
    public java.lang.String getVideoUrl()
    {
        return videoUrl;
    }

    public void setVideoUrl(java.lang.String videoUrl)
    {
        this.videoUrl = videoUrl;
    }

}
