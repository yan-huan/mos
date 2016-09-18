package com.myb.entity.pojo.mos;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class Employee extends EntityBase{

    @DataMapping(EmployeeMapping.EmpId)
    private int empId;//
    @DataMapping(EmployeeMapping.ParentId)
    private int parentId;//直属上级Id
    @DataMapping(EmployeeMapping.EmpName)
    private java.lang.String empName;//
    @DataMapping(EmployeeMapping.Account)
    private java.lang.String account;//登录账号
    @DataMapping(EmployeeMapping.EmpCode)
    private java.lang.String empCode;//员工编号
    @DataMapping(EmployeeMapping.DutyId)
    private java.lang.Integer dutyId;//岗位Id
    @DataMapping(EmployeeMapping.ParentName)
    private java.lang.String parentName;//冗余直属上级姓名
    @DataMapping(EmployeeMapping.DepName)
    private java.lang.String depName;//冗余部门名称
    @DataMapping(EmployeeMapping.CityPermission)
    private java.lang.String cityPermission;//城市权限 可以设置多个城市以空格间隔
    @DataMapping(EmployeeMapping.IsUsed)
    private int isUsed;//
    @DataMapping(EmployeeMapping.CityId)
    private int cityId;//
    @DataMapping(EmployeeMapping.CreateTime)
    private java.util.Date createTime;//
    @DataMapping(EmployeeMapping.UserName)
    private java.lang.String userName;//
    @DataMapping(EmployeeMapping.PassWord)
    private java.lang.String passWord;//
    @DataMapping(EmployeeMapping.Status)
    private int status;//
    @DataMapping(EmployeeMapping.Ran)
    private int ran;//
    @DataMapping(EmployeeMapping.EntryTime)
    private Date entryTime;//入职时间
    @DataMapping(EmployeeMapping.QuitTime)
    private Date QuitTime;//退出时间
    private String preferPwd;//原来密码


    public Employee() { }

    public int getEmpId()
    {
        return empId;
    }

    public void setEmpId(int empId)
    {
        this.empId = empId;
    }
    public int getParentId()
    {
        return parentId;
    }

    public void setParentId(int parentId)
    {
        this.parentId = parentId;
    }
    public java.lang.String getEmpName()
    {
        return empName;
    }

    public void setEmpName(java.lang.String empName)
    {
        this.empName = empName;
    }
    public java.lang.String getAccount()
    {
        return account;
    }

    public void setAccount(java.lang.String account)
    {
        this.account = account;
    }
    public java.lang.String getEmpCode()
    {
        return empCode;
    }

    public void setEmpCode(java.lang.String empCode)
    {
        this.empCode = empCode;
    }
    

	public java.lang.Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(java.lang.Integer dutyId) {
		this.dutyId = dutyId;
	}

	public java.lang.String getParentName()
    {
        return parentName;
    }

    public void setParentName(java.lang.String parentName)
    {
        this.parentName = parentName;
    }
    public java.lang.String getDepName()
    {
        return depName;
    }

    public void setDepName(java.lang.String depName)
    {
        this.depName = depName;
    }
    public java.lang.String getCityPermission()
    {
        return cityPermission;
    }

    public void setCityPermission(java.lang.String cityPermission)
    {
        this.cityPermission = cityPermission;
    }
    public int getIsUsed()
    {
        return isUsed;
    }

    public void setIsUsed(int isUsed)
    {
        this.isUsed = isUsed;
    }
    public int getCityId()
    {
        return cityId;
    }

    public void setCityId(int cityId)
    {
        this.cityId = cityId;
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
    public java.lang.String getUserName()
    {
        return userName;
    }

    public void setUserName(java.lang.String userName)
    {
        this.userName = userName;
    }
    public java.lang.String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(java.lang.String passWord)
    {
        this.passWord = passWord;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

	public int getRan() {
		return ran;
	}

	public void setRan(int ran) {
		this.ran = ran;
	}

	public static Employee Employee() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getPreferPwd() {
		return preferPwd;
	}

	public void setPreferPwd(String preferPwd) {
		this.preferPwd = preferPwd;
	}

	public Date getQuitTime() {
		return QuitTime;
	}

	public void setQuitTime(Date quitTime) {
		QuitTime = quitTime;
	}

    
}
