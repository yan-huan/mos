package com.myb.mos.VO;

import com.myb.framework.data.EntityBase;

public class OpenAccountVO extends EntityBase{

    private int accountId;//
    private java.lang.String beautifulyard;//
    private String openNumber;//
    private int shopCount;//店数*
    private String payDate;//付款时间*
    private java.lang.String market;//销售人员*
    private int status;//
    private java.lang.String remark;//备注*
    private java.util.Date createTime;//
    private String kefumobile;//客服电话
    private String zongbuAddress;//总部地址*
    private String province;//省市区
    private String city;//省市区
    private String provinceName;//省市区*
    private String cityName;//省市区*
    private String diff;
    private int approvalStatus;//财务审核状态
    private int isAddAccount;//是否添加了合同
    private int finance;//财务的权限审核账号
    private int isOpenStatus;//是否开通状态
    private String isChannel;//是否是渠道
    private int isShowQudaoList;//1为显示渠道开号列表0为不显示渠道开号列表
    private String refuseInfo;//拒绝原因
    private String consumerId;//客户id的crm
    private String updateDate;
    private int ispass;//店的延期赋值给美容院
    private int isOperationException;//异常操作过
    private String operationReason;//异常操作的原因
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public java.lang.String getBeautifulyard() {
		return beautifulyard;
	}
	public void setBeautifulyard(java.lang.String beautifulyard) {
		this.beautifulyard = beautifulyard;
	}
	public String getOpenNumber() {
		return openNumber;
	}
	public void setOpenNumber(String openNumber) {
		this.openNumber = openNumber;
	}
	public int getShopCount() {
		return shopCount;
	}
	public void setShopCount(int shopCount) {
		this.shopCount = shopCount;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public java.lang.String getMarket() {
		return market;
	}
	public void setMarket(java.lang.String market) {
		this.market = market;
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
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public String getKefumobile() {
		return kefumobile;
	}
	public void setKefumobile(String kefumobile) {
		this.kefumobile = kefumobile;
	}
	public String getZongbuAddress() {
		return zongbuAddress;
	}
	public void setZongbuAddress(String zongbuAddress) {
		this.zongbuAddress = zongbuAddress;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getDiff() {
		return diff;
	}
	public void setDiff(String diff) {
		this.diff = diff;
	}
	public int getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(int approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public int getIsAddAccount() {
		return isAddAccount;
	}
	public void setIsAddAccount(int isAddAccount) {
		this.isAddAccount = isAddAccount;
	}
	public int getFinance() {
		return finance;
	}
	public void setFinance(int finance) {
		this.finance = finance;
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
	public String getRefuseInfo() {
		return refuseInfo;
	}
	public void setRefuseInfo(String refuseInfo) {
		this.refuseInfo = refuseInfo;
	}
	
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public int getIspass() {
		return ispass;
	}
	public void setIspass(int ispass) {
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
	
}
