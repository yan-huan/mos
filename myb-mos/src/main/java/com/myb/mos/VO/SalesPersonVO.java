package com.myb.mos.VO;

import java.util.List;

import com.myb.framework.data.EntityBase;
/**
 * 
 * @author yanhuan
 *
 */
public class SalesPersonVO extends EntityBase{
//	城市	所属销售总监	销售人	入职时间	成交单	汇款金额	本月牌级	本月佣金	特殊备注
	private int xuhao;//序号
    private java.lang.String cityName;//城市
    private java.lang.String saleParent;//所属销售总监
    private java.lang.String salePerson;//销售人
    private String joinTime;//入职时间
    private int sucessCount;//成交单
    private Integer saleMoney;//汇款金额
    private String mobile;//手机号
    private String paiji;//牌级
    private String xiaozu;//小组
    private int allMoney;//总金额
    private int allSuccessCount;//总签单数量
    private List<Integer> shopIdByMarket; 
    
    
//    private String joinTime;//本月牌级
//    private String joinTime;//本月佣金
    private String remark;//特殊备注

    public SalesPersonVO() { }

	public java.lang.String getCityName() {
		return cityName;
	}

	public void setCityName(java.lang.String cityName) {
		this.cityName = cityName;
	}

	public java.lang.String getSaleParent() {
		return saleParent;
	}

	public void setSaleParent(java.lang.String saleParent) {
		this.saleParent = saleParent;
	}

	public java.lang.String getSalePerson() {
		return salePerson;
	}

	public void setSalePerson(java.lang.String salePerson) {
		this.salePerson = salePerson;
	}

	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	public int getSucessCount() {
		return sucessCount;
	}

	public void setSucessCount(int sucessCount) {
		this.sucessCount = sucessCount;
	}

	public Integer getSaleMoney() {
		return saleMoney;
	}

	public void setSaleMoney(Integer saleMoney) {
		this.saleMoney = saleMoney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getXuhao() {
		return xuhao;
	}

	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}

	public String getPaiji() {
		return paiji;
	}

	public void setPaiji(String paiji) {
		this.paiji = paiji;
	}

	public String getXiaozu() {
		return xiaozu;
	}

	public void setXiaozu(String xiaozu) {
		this.xiaozu = xiaozu;
	}

	public int getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(int allMoney) {
		this.allMoney = allMoney;
	}

	public int getAllSuccessCount() {
		return allSuccessCount;
	}

	public void setAllSuccessCount(int allSuccessCount) {
		this.allSuccessCount = allSuccessCount;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Integer> getShopIdByMarket() {
		return shopIdByMarket;
	}

	public void setShopIdByMarket(List<Integer> shopIdByMarket) {
		this.shopIdByMarket = shopIdByMarket;
	}

	
}
