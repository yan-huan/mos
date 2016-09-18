package com.myb.mos.VO;

import com.myb.framework.data.EntityBase;
/**
 * 渠道信息的VO
 * @author yanhuan
 *
 */
public class ChannelVO extends EntityBase{

    private java.lang.String companyName;//公司名称
    private java.lang.String companyAddress;//公司地址
    private java.lang.String personInCharge;//负责人
    private String phone;//联系电话
    private java.math.BigDecimal readyDepositMoney;//账户余额
    private java.math.BigDecimal marginMoney;//保证金冻结
    private java.sql.Date openTime;//开始日期
    private java.sql.Date endTime;//截止日期
    private java.lang.String remark;//备注
    private int status;//状态
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//修改时间
    private int channelId;//主键
    private java.math.BigDecimal contractMoney;//合同金额
    private int empId;//登录人的id
    private int discountRate;//折扣率
    private String salesName;//销售人
    private java.math.BigDecimal depositPaymentMoney;//预存货款

    public ChannelVO() { }


	public java.lang.String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}


	public java.lang.String getCompanyAddress() {
		return companyAddress;
	}


	public void setCompanyAddress(java.lang.String companyAddress) {
		this.companyAddress = companyAddress;
	}


	public java.lang.String getPersonInCharge() {
		return personInCharge;
	}


	public void setPersonInCharge(java.lang.String personInCharge) {
		this.personInCharge = personInCharge;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public java.math.BigDecimal getReadyDepositMoney() {
		return readyDepositMoney;
	}


	public void setReadyDepositMoney(java.math.BigDecimal readyDepositMoney) {
		this.readyDepositMoney = readyDepositMoney;
	}


	public java.math.BigDecimal getMarginMoney() {
		return marginMoney;
	}


	public void setMarginMoney(java.math.BigDecimal marginMoney) {
		this.marginMoney = marginMoney;
	}


	public java.sql.Date getOpenTime() {
		return openTime;
	}


	public void setOpenTime(java.sql.Date openTime) {
		this.openTime = openTime;
	}


	public java.sql.Date getEndTime() {
		return endTime;
	}


	public void setEndTime(java.sql.Date endTime) {
		this.endTime = endTime;
	}


	public java.lang.String getRemark() {
		return remark;
	}


	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public java.util.Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}


	public java.util.Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}


	public int getChannelId() {
		return channelId;
	}


	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}


	public java.math.BigDecimal getContractMoney() {
		return contractMoney;
	}


	public void setContractMoney(java.math.BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}




	public int getDiscountRate() {
		return discountRate;
	}


	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
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
