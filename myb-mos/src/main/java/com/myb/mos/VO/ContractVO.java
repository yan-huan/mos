package com.myb.mos.VO;

public class ContractVO {
	
	private int contractId;//
	private int owner;//签约代表的员工id
	private java.lang.String ownerName;//合同所属人姓名或签约代表姓名
	private String companyName;//公司名称
	private java.lang.String ownerDepName;//签约代表所属部门
	private java.lang.String contractCode;//合同编码
	private java.lang.String contractBody;//合同主体
	private String beginDate;//签约日期或合同开始日期
	private String endDate;//合同结束日期
	private int contractType;//合同类型 1零售 2批发 3渠道
	private java.math.BigDecimal contractAmount;//
	private int discount;// 折扣 总金额除以应付总金额的百分比
	private java.lang.String bossAccount;//老板账号或老板手机号
	private java.lang.String bossName;//老板姓名
	private String payDate;//合同款支付时间
	private Double payMoney;//合同款支付金额
	private java.lang.String payAccountName;//合同款支付账户名
	private java.lang.String payNumber;//合同款付款单号
	private java.lang.String payType;//付款类型 微信支付 支付宝 刷卡
	private int shopCount;//店数
	private int status;//合同状态
	private java.lang.String remark;//备注
	private String createTime;//
	private int accountId;
	private String openNumber;//开通账号的手机号
	private String payRemark;//支付备注
	private int contractMoney;//合同金额
	private String contractAnnex;//合同附件
	public int getContractId() {
		return contractId;
	}
	public void setContractId(int contractId) {
		this.contractId = contractId;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public java.lang.String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(java.lang.String ownerName) {
		this.ownerName = ownerName;
	}
	public java.lang.String getOwnerDepName() {
		return ownerDepName;
	}
	public void setOwnerDepName(java.lang.String ownerDepName) {
		this.ownerDepName = ownerDepName;
	}
	public java.lang.String getContractCode() {
		return contractCode;
	}
	public void setContractCode(java.lang.String contractCode) {
		this.contractCode = contractCode;
	}
	public java.lang.String getContractBody() {
		return contractBody;
	}
	public void setContractBody(java.lang.String contractBody) {
		this.contractBody = contractBody;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getContractType() {
		return contractType;
	}
	public void setContractType(int contractType) {
		this.contractType = contractType;
	}
	public java.math.BigDecimal getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(java.math.BigDecimal contractAmount) {
		this.contractAmount = contractAmount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public java.lang.String getBossAccount() {
		return bossAccount;
	}
	public void setBossAccount(java.lang.String bossAccount) {
		this.bossAccount = bossAccount;
	}
	public java.lang.String getBossName() {
		return bossName;
	}
	public void setBossName(java.lang.String bossName) {
		this.bossName = bossName;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	public java.lang.String getPayAccountName() {
		return payAccountName;
	}
	public void setPayAccountName(java.lang.String payAccountName) {
		this.payAccountName = payAccountName;
	}
	public java.lang.String getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(java.lang.String payNumber) {
		this.payNumber = payNumber;
	}
	public java.lang.String getPayType() {
		return payType;
	}
	public void setPayType(java.lang.String payType) {
		this.payType = payType;
	}
	public int getShopCount() {
		return shopCount;
	}
	public void setShopCount(int shopCount) {
		this.shopCount = shopCount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public java.lang.String getRemark() {
		return remark;
	}
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getOpenNumber() {
		return openNumber;
	}
	public void setOpenNumber(String openNumber) {
		this.openNumber = openNumber;
	}
	public String getPayRemark() {
		return payRemark;
	}
	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}
	public int getContractMoney() {
		return contractMoney;
	}
	public void setContractMoney(int contractMoney) {
		this.contractMoney = contractMoney;
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

