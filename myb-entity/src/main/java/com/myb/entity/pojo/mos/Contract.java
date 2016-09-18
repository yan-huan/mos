package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Contract extends EntityBase{

    @DataMapping(ContractMapping.ContractId)
    private int contractId;//
    @DataMapping(ContractMapping.Owner)
    private int owner;//签约代表的员工id
    @DataMapping(ContractMapping.CompanyName)
    private String companyName;//公司名称
    @DataMapping(ContractMapping.OwnerName)
    private java.lang.String ownerName;//合同所属人姓名或签约代表姓名
    @DataMapping(ContractMapping.OwnerDepName)
    private java.lang.String ownerDepName;//签约代表所属部门
    @DataMapping(ContractMapping.ContractCode)
    private java.lang.String contractCode;//合同编码
    @DataMapping(ContractMapping.ContractBody)
    private java.lang.String contractBody;//合同主体
    @DataMapping(ContractMapping.BeginDate)
    private java.util.Date beginDate;//签约日期或合同开始日期
    @DataMapping(ContractMapping.EndDate)
    private java.util.Date endDate;//合同结束日期
    @DataMapping(ContractMapping.ContractType)
    private int contractType;//合同类型 1零售 2批发 3渠道
    @DataMapping(ContractMapping.ContractAmount)
    private java.math.BigDecimal contractAmount;//
    @DataMapping(ContractMapping.Discount)
    private int discount;// 折扣 总金额除以应付总金额的百分比
    @DataMapping(ContractMapping.BossAccount)
    private java.lang.String bossAccount;//老板账号或老板手机号
    @DataMapping(ContractMapping.BossName)
    private java.lang.String bossName;//老板姓名
    @DataMapping(ContractMapping.PayDate)
    private java.util.Date payDate;//合同款支付时间
    @DataMapping(ContractMapping.PayMoney)
    private java.lang.Double payMoney;//合同款支付金额
    @DataMapping(ContractMapping.PayAccountName)
    private java.lang.String payAccountName;//合同款支付账户名
    @DataMapping(ContractMapping.PayNumber)
    private java.lang.String payNumber;//合同款付款单号
    @DataMapping(ContractMapping.PayType)
    private java.lang.String payType;//付款类型 微信支付 支付宝 刷卡
    @DataMapping(ContractMapping.ShopCount)
    private int shopCount;//店数
    @DataMapping(ContractMapping.Status)
    private int status;//合同状态
    @DataMapping(ContractMapping.Remark)
    private java.lang.String remark;//备注
    @DataMapping(ContractMapping.CreateTime)
    private java.util.Date createTime;//
    @DataMapping(ContractMapping.UpdateDate)
    private java.util.Date updateDate;//更新的时间
    @DataMapping(ContractMapping.AccountId)
    private int accountId;//创建美容院的关联id
    @DataMapping(ContractMapping.OpenNumber)
    private java.lang.String openNumber;//开通账号的手机号
    @DataMapping(ContractMapping.PayRemark)
    private java.lang.String payRemark;//支付备注
    @DataMapping(ContractMapping.ContractMoney)
    private int contractMoney;//合同金额
    @DataMapping(ContractMapping.Creater)
    private String creater;//保存创建合同的人
    @DataMapping(ContractMapping.ContractAnnex)
    private String contractAnnex;//合同附件
    
    
    public Contract() { }

    public int getContractId()
    {
        return contractId;
    }

    public void setContractId(int contractId)
    {
        this.contractId = contractId;
    }
    public int getOwner()
    {
        return owner;
    }

    public void setOwner(int owner)
    {
        this.owner = owner;
    }
    public java.lang.String getOwnerName()
    {
        return ownerName;
    }

    public void setOwnerName(java.lang.String ownerName)
    {
        this.ownerName = ownerName;
    }
    public java.lang.String getOwnerDepName()
    {
        return ownerDepName;
    }

    public void setOwnerDepName(java.lang.String ownerDepName)
    {
        this.ownerDepName = ownerDepName;
    }
    public java.lang.String getContractCode()
    {
        return contractCode;
    }

    public void setContractCode(java.lang.String contractCode)
    {
        this.contractCode = contractCode;
    }
    public java.lang.String getContractBody()
    {
        return contractBody;
    }

    public void setContractBody(java.lang.String contractBody)
    {
        this.contractBody = contractBody;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getBeginDate()
    {
        return beginDate;
    }

    public void setBeginDate(java.util.Date beginDate)
    {
        this.beginDate = beginDate;
    }
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
    public java.util.Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(java.util.Date endDate)
    {
        this.endDate = endDate;
    }
    public int getContractType()
    {
        return contractType;
    }

    public void setContractType(int contractType)
    {
        this.contractType = contractType;
    }
    public java.math.BigDecimal getContractAmount()
    {
        return contractAmount;
    }

    public void setContractAmount(java.math.BigDecimal contractAmount)
    {
        this.contractAmount = contractAmount;
    }
    public int getDiscount()
    {
        return discount;
    }

    public void setDiscount(int discount)
    {
        this.discount = discount;
    }
    public java.lang.String getBossAccount()
    {
        return bossAccount;
    }

    public void setBossAccount(java.lang.String bossAccount)
    {
        this.bossAccount = bossAccount;
    }
    public java.lang.String getBossName()
    {
        return bossName;
    }

    public void setBossName(java.lang.String bossName)
    {
        this.bossName = bossName;
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
    

	public java.lang.Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(java.lang.Double payMoney) {
		this.payMoney = payMoney;
	}

	public java.lang.String getPayAccountName()
    {
        return payAccountName;
    }

    public void setPayAccountName(java.lang.String payAccountName)
    {
        this.payAccountName = payAccountName;
    }
    public java.lang.String getPayNumber()
    {
        return payNumber;
    }

    public void setPayNumber(java.lang.String payNumber)
    {
        this.payNumber = payNumber;
    }
    public java.lang.String getPayType()
    {
        return payType;
    }

    public void setPayType(java.lang.String payType)
    {
        this.payType = payType;
    }
    public int getShopCount()
    {
        return shopCount;
    }

    public void setShopCount(int shopCount)
    {
        this.shopCount = shopCount;
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
    public int getAccountId()
    {
        return accountId;
    }

    public void setAccountId(int accountId)
    {
        this.accountId = accountId;
    }
    public java.lang.String getOpenNumber()
    {
        return openNumber;
    }

    public void setOpenNumber(java.lang.String openNumber)
    {
        this.openNumber = openNumber;
    }

	public java.lang.String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(java.lang.String payRemark) {
		this.payRemark = payRemark;
	}

	public int getContractMoney() {
		return contractMoney;
	}

	public void setContractMoney(int contractMoney) {
		this.contractMoney = contractMoney;
	}

	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getContractAnnex() {
		return contractAnnex;
	}

	public void setContractAnnex(String contractAnnex) {
		this.contractAnnex = contractAnnex;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
    
}
