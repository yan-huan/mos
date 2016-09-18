package com.myb.mos.VO;

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class CrmVisitRecodeVO extends EntityBase{

   private String xiaozu;
   private int  empId;
   private String xingming;
   private int count;
public String getXiaozu() {
	return xiaozu;
}
public void setXiaozu(String xiaozu) {
	this.xiaozu = xiaozu;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getXingming() {
	return xingming;
}
public void setXingming(String xingming) {
	this.xingming = xingming;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
   


}
