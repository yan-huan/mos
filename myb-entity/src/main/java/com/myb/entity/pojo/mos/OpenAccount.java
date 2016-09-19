package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

import java.util.Date;

public class OpenAccount extends EntityBase{

    @DataMapping(OpenAccountMapping.AccountId)
    private int accountId;//
    @DataMapping(OpenAccountMapping.Beautifulyard)
    private java.lang.String beautifulyard;//
    @DataMapping(OpenAccountMapping.OpenNumber)
    private java.lang.String openNumber;//
    @DataMapping(OpenAccountMapping.ShopCount)
    private int shopCount;//
    @DataMapping(OpenAccountMapping.PayDate)
    private java.util.Date payDate;//
    @DataMapping(OpenAccountMapping.Market)
    private java.lang.String market;//
    @DataMapping(OpenAccountMapping.Status)
    private int status;//
    @DataMapping(OpenAccountMapping.Remark)
    private java.lang.String remark;//
    @DataMapping(OpenAccountMapping.CreateTime)
    private java.util.Date createTime;//
    @DataMapping(OpenAccountMapping.UpdateDate)
    private java.util.Date updateDate;//
    @DataMapping(OpenAccountMapping.ZongbuAddress)
    private java.lang.String zongbuAddress;//
    @DataMapping(OpenAccountMapping.Kefumobile)
    private java.lang.String kefumobile;//
    @DataMapping(OpenAccountMapping.Province)
    private java.lang.String province;//
    @DataMapping(OpenAccountMapping.City)
    private java.lang.String city;//
    @DataMapping(OpenAccountMapping.CompanyCode)
    private java.lang.String companyCode;//
    @DataMapping(OpenAccountMapping.ApprovalStatus)
    private int approvalStatus;//审批状态，1未审批，2审批通过，3审批未通过
    @DataMapping(OpenAccountMapping.IsAddAccount)
    private int isAddAccount;//1已添加合同，2未添加合同
    @DataMapping(OpenAccountMapping.RefuseInfo)
    private String refuseInfo;//拒绝原因
    @DataMapping(OpenAccountMapping.EmpId)
    private int empId;//统计销售人员录入的id
    @DataMapping(OpenAccountMapping.IsOpenStatus)
    private int isOpenStatus;//账号是否saas开通
    @DataMapping(OpenAccountMapping.IsChannel)
    private String isChannel;//是否是渠道
    @DataMapping(OpenAccountMapping.IsShowQudaoList)
    private int isShowQudaoList;//1为显示渠道开号列表0为不显示渠道开号列表
    @DataMapping(OpenAccountMapping.ConsumerId)
    private int consumerId;//客户id的crm
    @DataMapping(OpenAccountMapping.IsOperationException)
    private int isOperationException;//是否异常操作过 
    @DataMapping(OpenAccountMapping.OperationReason)
    private String operationReason;//异常操作账号的原因
    public String cityName;
    public String provinceName;
    public int isException;//异常处理操作过
    public String ispass;//异常处理操作过
    @DataMapping(OpenAccountMapping.FilePath)
    public String filePath;//上传免费版的门店照片
    @DataMapping(OpenAccountMapping.TouchMobile)
    public String touchMobile;//关联免费版的手机号



    @DataMapping(OpenAccountMapping.FinanceSuccessDate)
    private java.util.Date financeSuccessDate;//财务通过时间


    public OpenAccount() { }

    public int getAccountId()
    {
        return accountId;
    }

    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }
    public java.lang.String getBeautifulyard()
    {
        return beautifulyard;
    }

    public void setBeautifulyard(java.lang.String beautifulyard)
    {
        this.beautifulyard = beautifulyard;
    }
    public java.lang.String getOpenNumber()
    {
        return openNumber;
    }

    public void setOpenNumber(java.lang.String openNumber)
    {
        this.openNumber = openNumber;
    }
    public int getShopCount()
    {
        return shopCount;
    }

    public void setShopCount(int shopCount)
    {
        this.shopCount = shopCount;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getPayDate()
    {
        return payDate;
    }

    public void setPayDate(java.util.Date payDate)
    {
        this.payDate = payDate;
    }
    public java.lang.String getMarket()
    {
        return market;
    }

    public void setMarket(java.lang.String market)
    {
        this.market = market;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    public java.lang.String getRemark()
    {
        return remark;
    }

    public void setRemark(java.lang.String remark)
    {
        this.remark = remark;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime)
    {
        this.createTime = createTime;
    }
    public java.lang.String getZongbuAddress()
    {
        return zongbuAddress;
    }

    public void setZongbuAddress(java.lang.String zongbuAddress)
    {
        this.zongbuAddress = zongbuAddress;
    }
    public java.lang.String getKefumobile()
    {
        return kefumobile;
    }

    public void setKefumobile(java.lang.String kefumobile)
    {
        this.kefumobile = kefumobile;
    }
    public java.lang.String getProvince()
    {
        return province;
    }

    public void setProvince(java.lang.String province)
    {
        this.province = province;
    }
    public java.lang.String getCity()
    {
        return city;
    }

    public void setCity(java.lang.String city)
    {
        this.city = city;
    }
    public java.lang.String getCompanyCode()
    {
        return companyCode;
    }

    public void setCompanyCode(java.lang.String companyCode)
    {
        this.companyCode = companyCode;
    }
    public int getApprovalStatus()
    {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus)
    {
        this.approvalStatus = approvalStatus;
    }

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public int getIsAddAccount() {
		return isAddAccount;
	}

	public void setIsAddAccount(int isAddAccount) {
		this.isAddAccount = isAddAccount;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRefuseInfo() {
		return refuseInfo;
	}

	public void setRefuseInfo(String refuseInfo) {
		this.refuseInfo = refuseInfo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getIsOpenStatus() {
		return isOpenStatus;
	}

	public void setIsOpenStatus(int isOpenStatus) {
		this.isOpenStatus = isOpenStatus;
	}

	public String getIsChannel() {
		return isChannel;
	}

	public void setIsChannel(String isChannel) {
		this.isChannel = isChannel;
	}

	public int getIsShowQudaoList() {
		return isShowQudaoList;
	}

	public void setIsShowQudaoList(int isShowQudaoList) {
		this.isShowQudaoList = isShowQudaoList;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getIsException() {
		return isException;
	}

	public void setIsException(int isException) {
		this.isException = isException;
	}

	public String getIspass() {
		return ispass;
	}

	public void setIspass(String ispass) {
		this.ispass = ispass;
	}

	public int getIsOperationException() {
		return isOperationException;
	}

	public void setIsOperationException(int isOperationException) {
		this.isOperationException = isOperationException;
	}

	public String getOperationReason() {
		return operationReason;
	}

	public void setOperationReason(String operationReason) {
		this.operationReason = operationReason;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getTouchMobile() {
		return touchMobile;
	}

	public void setTouchMobile(String touchMobile) {
		this.touchMobile = touchMobile;
	}

    public Date getFinanceSuccessDate() {
        return financeSuccessDate;
    }

    public void setFinanceSuccessDate(Date financeSuccessDate) {
        this.financeSuccessDate = financeSuccessDate;
    }


}
