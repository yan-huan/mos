package com.myb.mos.VO;

import java.util.List;

import com.myb.entity.pojo.mos.ShopMapping;
import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;

public class ShopVO extends EntityBase{

    private int shopId;//
    private int contractId;//
    private java.lang.String shopName;//店名
    private java.lang.String shopOwner;//店长
    private java.lang.String shopAccount;//该店账号
    private java.lang.String city;//城市
    private java.lang.String cityName;//城市名称
    private java.lang.String province;//省
    private java.lang.String provinceName;//省名字
    private java.lang.String business;//商圈
    private java.lang.String beginDate;//账号开通时间
    private java.lang.String endDate;//账号停止时间
    private int duration;//开通年限 1一年 3三年 9终身 
    private java.lang.String address;//门店地址
    private java.lang.String longitude;//经度
    private java.lang.String latitude;//纬度
    private java.lang.String giveAway;//赠送
    private int status;//状态
    private int accountId;//外键关联开通账号表 美容院
    private String  mobile; //老板手机号为存储外键
    private String type;
    private String shopcode;
    private Double currentRate;//当前的折扣率
    private Double shijiMoney;//实际费用
    private Double danjia;//单价
    private Double AllMoney;//合计金额
    private List<CityVO> cityVos;//城市集合
    private int exceptionStatus;//1代表账号加店，2代表店的续签，3代表退款,4代表修改店的信息
    private String updateTime;//更新时间
    private int ispass;//1代表通过，2未通过3未审批
    private String refuse;//1拒绝原因
    private String modifyType;//类型是修改还是延期延期为delay
    

    public String getModifyType() {
		return modifyType;
	}


	public void setModifyType(String modifyType) {
		this.modifyType = modifyType;
	}


	public ShopVO() { }


	public int getShopId() {
		return shopId;
	}


	public void setShopId(int shopId) {
		this.shopId = shopId;
	}


	public int getContractId() {
		return contractId;
	}


	public void setContractId(int contractId) {
		this.contractId = contractId;
	}


	public java.lang.String getShopName() {
		return shopName;
	}


	public void setShopName(java.lang.String shopName) {
		this.shopName = shopName;
	}


	public java.lang.String getShopOwner() {
		return shopOwner;
	}


	public void setShopOwner(java.lang.String shopOwner) {
		this.shopOwner = shopOwner;
	}


	public java.lang.String getShopAccount() {
		return shopAccount;
	}


	public void setShopAccount(java.lang.String shopAccount) {
		this.shopAccount = shopAccount;
	}


	public java.lang.String getCity() {
		return city;
	}


	public void setCity(java.lang.String city) {
		this.city = city;
	}


	public java.lang.String getProvince() {
		return province;
	}


	public void setProvince(java.lang.String province) {
		this.province = province;
	}


	public java.lang.String getBusiness() {
		return business;
	}


	public void setBusiness(java.lang.String business) {
		this.business = business;
	}





	public java.lang.String getBeginDate() {
		return beginDate;
	}


	public void setBeginDate(java.lang.String beginDate) {
		this.beginDate = beginDate;
	}


	public java.lang.String getEndDate() {
		return endDate;
	}


	public void setEndDate(java.lang.String endDate) {
		this.endDate = endDate;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public java.lang.String getAddress() {
		return address;
	}


	public void setAddress(java.lang.String address) {
		this.address = address;
	}


	public java.lang.String getLongitude() {
		return longitude;
	}


	public void setLongitude(java.lang.String longitude) {
		this.longitude = longitude;
	}


	public java.lang.String getLatitude() {
		return latitude;
	}


	public void setLatitude(java.lang.String latitude) {
		this.latitude = latitude;
	}


	public java.lang.String getGiveAway() {
		return giveAway;
	}


	public void setGiveAway(java.lang.String giveAway) {
		this.giveAway = giveAway;
	}

	public int getStatus() {
		return status;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public java.lang.String getProvinceName() {
		return provinceName;
	}


	public void setProvinceName(java.lang.String provinceName) {
		this.provinceName = provinceName;
	}


	public java.lang.String getCityName() {
		return cityName;
	}


	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getShopcode() {
		return shopcode;
	}


	public void setShopcode(String shopcode) {
		this.shopcode = shopcode;
	}


	public Double getCurrentRate() {
		return currentRate;
	}


	public void setCurrentRate(Double currentRate) {
		this.currentRate = currentRate;
	}


	public Double getShijiMoney() {
		return shijiMoney;
	}


	public void setShijiMoney(Double shijiMoney) {
		this.shijiMoney = shijiMoney;
	}


	public Double getDanjia() {
		return danjia;
	}


	public void setDanjia(Double danjia) {
		this.danjia = danjia;
	}


	public Double getAllMoney() {
		return AllMoney;
	}


	public void setAllMoney(Double allMoney) {
		AllMoney = allMoney;
	}


	public List<CityVO> getCityVos() {
		return cityVos;
	}


	public void setCityVos(List<CityVO> cityVos) {
		this.cityVos = cityVos;
	}


	public int getExceptionStatus() {
		return exceptionStatus;
	}


	public void setExceptionStatus(int exceptionStatus) {
		this.exceptionStatus = exceptionStatus;
	}


	public String getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


	public int getIspass() {
		return ispass;
	}


	public void setIspass(int ispass) {
		this.ispass = ispass;
	}


	public String getRefuse() {
		return refuse;
	}


	public void setRefuse(String refuse) {
		this.refuse = refuse;
	}
	

   

}
