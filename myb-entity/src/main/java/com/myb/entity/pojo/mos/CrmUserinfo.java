package com.myb.entity.pojo.mos;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class CrmUserinfo extends EntityBase{

    @DataMapping(CrmUserinfoMapping.Id)
    private int id;//
    @DataMapping(CrmUserinfoMapping.Quyu)
    private java.lang.String quyu;//
    @DataMapping(CrmUserinfoMapping.Xingming)
    private java.lang.String xingming;//
    @DataMapping(CrmUserinfoMapping.Bumen)
    private java.lang.String bumen;//
    @DataMapping(CrmUserinfoMapping.Gangwei)
    private java.lang.String gangwei;//
    @DataMapping(CrmUserinfoMapping.EmpId)
    private int empId;//
    @DataMapping(CrmUserinfoMapping.SuperiorId)
    private int superiorId;//上级id
    @DataMapping(CrmUserinfoMapping.Mobile)
    private java.lang.String mobile;//手机号
    @DataMapping(CrmUserinfoMapping.Xu)
    private java.lang.String xu;//
    @DataMapping(CrmUserinfoMapping.Xiaozu)
    private java.lang.String xiaozu;//
    @DataMapping(CrmUserinfoMapping.IsValide)
    private int isValide;//1：无效
    @DataMapping(CrmUserinfoMapping.ShopId)
    private int shopId;//1：店
    private int shopAllCount;//拜访店数
    private int shopValideCount;//有效店数
    public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	private int allCount;//总拜访
    private int isValideCount;//有效


    public CrmUserinfo() { }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public java.lang.String getQuyu()
    {
        return quyu;
    }

    public void setQuyu(java.lang.String quyu)
    {
        this.quyu = quyu;
    }
    public java.lang.String getXingming()
    {
        return xingming;
    }

    public void setXingming(java.lang.String xingming)
    {
        this.xingming = xingming;
    }
    public java.lang.String getBumen()
    {
        return bumen;
    }

    public void setBumen(java.lang.String bumen)
    {
        this.bumen = bumen;
    }
    public java.lang.String getGangwei()
    {
        return gangwei;
    }

    public void setGangwei(java.lang.String gangwei)
    {
        this.gangwei = gangwei;
    }
    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }
    public int getSuperiorId()
    {
        return superiorId;
    }

    public void setSuperiorId(int superiorId)
    {
        this.superiorId = superiorId;
    }
    public java.lang.String getMobile()
    {
        return mobile;
    }

    public void setMobile(java.lang.String mobile)
    {
        this.mobile = mobile;
    }
    public java.lang.String getXu()
    {
        return xu;
    }

    public void setXu(java.lang.String xu)
    {
        this.xu = xu;
    }
    public java.lang.String getXiaozu()
    {
        return xiaozu;
    }

    public void setXiaozu(java.lang.String xiaozu)
    {
        this.xiaozu = xiaozu;
    }
    public int getIsValide()
    {
        return isValide;
    }

    public void setIsValide(int isValide)
    {
        this.isValide = isValide;
    }

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getIsValideCount() {
		return isValideCount;
	}

	public void setIsValideCount(int isValideCount) {
		this.isValideCount = isValideCount;
	}

	public int getShopAllCount() {
		return shopAllCount;
	}

	public void setShopAllCount(int shopAllCount) {
		this.shopAllCount = shopAllCount;
	}

	public int getShopValideCount() {
		return shopValideCount;
	}

	public void setShopValideCount(int shopValideCount) {
		this.shopValideCount = shopValideCount;
	}




}
