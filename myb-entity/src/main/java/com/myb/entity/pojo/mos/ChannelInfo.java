package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ChannelInfo extends EntityBase{

    @DataMapping(ChannelInfoMapping.ChannelId)
    private int channelId;//主键
    @DataMapping(ChannelInfoMapping.CompanyName)
    private java.lang.String companyName;//公司名称
    @DataMapping(ChannelInfoMapping.CompanyAddress)
    private java.lang.String companyAddress;//公司地址
    @DataMapping(ChannelInfoMapping.PersonInCharge)
    private java.lang.String personInCharge;//负责人
    @DataMapping(ChannelInfoMapping.Phone)
    private java.lang.String phone;//联系电话
    @DataMapping(ChannelInfoMapping.ReadyDepositMoney)
    private java.math.BigDecimal readyDepositMoney;//预存款
    @DataMapping(ChannelInfoMapping.MarginMoney)
    private java.math.BigDecimal marginMoney;//保证金冻结
    @DataMapping(ChannelInfoMapping.OpenTime)
    private java.util.Date openTime;//开始日期
    private String openTimeStr;//转换
    @DataMapping(ChannelInfoMapping.EndTime)
    private java.util.Date endTime;//截止日期
    private String endTimeStr;//转换
    @DataMapping(ChannelInfoMapping.Remark)
    private java.lang.String remark;//备注
    @DataMapping(ChannelInfoMapping.Status)
    private int status;//状态
    @DataMapping(ChannelInfoMapping.CreateTime)
    private java.util.Date createTime;//创建时间
    @DataMapping(ChannelInfoMapping.UpdateTime)
    private java.util.Date updateTime;//修改时间
    @DataMapping(ChannelInfoMapping.ContractMoney)
    private java.math.BigDecimal contractMoney;//合同金额
    @DataMapping(ChannelInfoMapping.EmpId)
    private int empId;//添加员工id
    @DataMapping(ChannelInfoMapping.DiscountRate)
    private Double discountRate;//折扣率
    @DataMapping(ChannelInfoMapping.SalesName)
    private String salesName;//销售人
    @DataMapping(ChannelInfoMapping.DepositPaymentMoney)
    private java.math.BigDecimal depositPaymentMoney;//预存货款


    public ChannelInfo() { }

    public int getChannelId()
    {
        return channelId;
    }

    public void setChannelId(int channelId)
    {
        this.channelId = channelId;
    }
    public java.lang.String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(java.lang.String companyName)
    {
        this.companyName = companyName;
    }
    public java.lang.String getCompanyAddress()
    {
        return companyAddress;
    }

    public void setCompanyAddress(java.lang.String companyAddress)
    {
        this.companyAddress = companyAddress;
    }
    public java.lang.String getPersonInCharge()
    {
        return personInCharge;
    }

    public void setPersonInCharge(java.lang.String personInCharge)
    {
        this.personInCharge = personInCharge;
    }
    public java.lang.String getPhone()
    {
        return phone;
    }

    public void setPhone(java.lang.String phone)
    {
        this.phone = phone;
    }
    public java.math.BigDecimal getReadyDepositMoney()
    {
        return readyDepositMoney;
    }

    public void setReadyDepositMoney(java.math.BigDecimal readyDepositMoney)
    {
        this.readyDepositMoney = readyDepositMoney;
    }
    public java.math.BigDecimal getMarginMoney()
    {
        return marginMoney;
    }

    public void setMarginMoney(java.math.BigDecimal marginMoney)
    {
        this.marginMoney = marginMoney;
    }
    public java.util.Date getOpenTime()
    {
        return openTime;
    }

    public void setOpenTime(java.util.Date openTime)
    {
        this.openTime = openTime;
    }
    public java.util.Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(java.util.Date endTime)
    {
        this.endTime = endTime;
    }
    public java.lang.String getRemark()
    {
        return remark;
    }

    public void setRemark(java.lang.String remark)
    {
        this.remark = remark;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
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
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime)
    {
        this.updateTime = updateTime;
    }
    public java.math.BigDecimal getContractMoney()
    {
        return contractMoney;
    }

    public void setContractMoney(java.math.BigDecimal contractMoney)
    {
        this.contractMoney = contractMoney;
    }
    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }

	public Double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(Double discountRate) {
		this.discountRate = discountRate;
	}

	public String getOpenTimeStr() {
		return openTimeStr;
	}

	public void setOpenTimeStr(String openTimeStr) {
		this.openTimeStr = openTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public java.math.BigDecimal getDepositPaymentMoney() {
		return depositPaymentMoney;
	}

	public void setDepositPaymentMoney(java.math.BigDecimal depositPaymentMoney) {
		this.depositPaymentMoney = depositPaymentMoney;
	}
	

}
