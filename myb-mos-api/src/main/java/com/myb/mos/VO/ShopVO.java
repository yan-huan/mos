package com.myb.mos.VO;


import com.myb.framework.data.EntityBase;

public class ShopVO extends EntityBase{

    private long id;//
    private java.lang.String name;//
    private long cityId;//
    private java.lang.String businessArea;//商圈
    private int isLink;//是否连锁：0非连锁；1连锁
    private int isArea;//是否区域内：0在区域内，1非区域
    private java.lang.String address;//
    private int linkNum;//连锁数量
    private java.lang.String telephone;//座机电话
    private java.lang.String source;//来源：自己/介绍
    private int isPublic;//是否公海1/私海0
    private long employeeId;//业务员id
    private int visitTimes;//拜访次数
    private int isFinish;//0未签单，1签单
    private java.lang.String process;//当前进度（播种；收割，肥田）
    private java.sql.Timestamp createTime;//
    private java.lang.String lantitude;
    private java.lang.String longitude;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public java.lang.String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(java.lang.String businessArea) {
		this.businessArea = businessArea;
	}
	public int getIsLink() {
		return isLink;
	}
	public void setIsLink(int isLink) {
		this.isLink = isLink;
	}
	public int getIsArea() {
		return isArea;
	}
	public void setIsArea(int isArea) {
		this.isArea = isArea;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public int getLinkNum() {
		return linkNum;
	}
	public void setLinkNum(int linkNum) {
		this.linkNum = linkNum;
	}
	public java.lang.String getTelephone() {
		return telephone;
	}
	public void setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
	}
	public java.lang.String getSource() {
		return source;
	}
	public void setSource(java.lang.String source) {
		this.source = source;
	}
	public int getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public int getVisitTimes() {
		return visitTimes;
	}
	public void setVisitTimes(int visitTimes) {
		this.visitTimes = visitTimes;
	}
	public int getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(int isFinish) {
		this.isFinish = isFinish;
	}
	public java.lang.String getProcess() {
		return process;
	}
	public void setProcess(java.lang.String process) {
		this.process = process;
	}
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}
	public java.lang.String getLantitude() {
		return lantitude;
	}
	public void setLantitude(java.lang.String lantitude) {
		this.lantitude = lantitude;
	}
	public java.lang.String getLongitude() {
		return longitude;
	}
	public void setLongitude(java.lang.String longitude) {
		this.longitude = longitude;
	}
    
  
    

	
   

}
