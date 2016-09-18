package com.myb.mos.VO;

import java.util.List;

import com.myb.entity.pojo.mos.RoleChild;
import com.myb.framework.data.EntityBase;

public class RoleVO extends EntityBase{

    private int roleId;//
    private java.lang.String roleName;//
    private int status;//
    private java.util.Date createTime;//
    //权限子模块
    private List<RoleChild> roleChild;
    private int zhiyingCount;//直营消息数量
    private int qudaoCount;//渠道消息数量
    private int exceptionModify;//异常修改
    private int exceptionDelay;//异常延期

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public java.lang.String getRoleName() {
		return roleName;
	}

	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
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

	public List<RoleChild> getRoleChild() {
		return roleChild;
	}

	public void setRoleChild(List<RoleChild> roleChild) {
		this.roleChild = roleChild;
	}

	public int getZhiyingCount() {
		return zhiyingCount;
	}

	public void setZhiyingCount(int zhiyingCount) {
		this.zhiyingCount = zhiyingCount;
	}

	public int getQudaoCount() {
		return qudaoCount;
	}

	public void setQudaoCount(int qudaoCount) {
		this.qudaoCount = qudaoCount;
	}

	public int getExceptionModify() {
		return exceptionModify;
	}

	public void setExceptionModify(int exceptionModify) {
		this.exceptionModify = exceptionModify;
	}

	public int getExceptionDelay() {
		return exceptionDelay;
	}

	public void setExceptionDelay(int exceptionDelay) {
		this.exceptionDelay = exceptionDelay;
	}


	

   
}
