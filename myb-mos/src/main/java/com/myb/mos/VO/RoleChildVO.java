package com.myb.mos.VO;

import com.myb.framework.data.EntityBase;

public class RoleChildVO extends EntityBase{

    private int childId;//
    private int roleId;//
    private java.lang.String childName;//
    private String openUrl;
    
    private int status;//


    public RoleChildVO() { }

    public int getChildId()
    {
        return childId;
    }

    public void setChildId(int childId)
    {
        this.childId = childId;
    }
    public int getRoleId()
    {
        return roleId;
    }

    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }
    public java.lang.String getChildName()
    {
        return childName;
    }

    public void setChildName(java.lang.String childName)
    {
        this.childName = childName;
    }
    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

	public String getOpenUrl() {
		return openUrl;
	}

	public void setOpenUrl(String openUrl) {
		this.openUrl = openUrl;
	}
    

}
