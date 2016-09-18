package com.myb.framework.data;

import java.util.List;


public class SqlExpression {
	
	private SqlRelation sqlRelation;
	
	private String field;
	
	private Object value;
	
	private boolean isValueArray;
	
	
	private List<SqlExpression> childSqlExpression;

	public List<SqlExpression> getChildSqlExpression() {
		return childSqlExpression;
	}

	public void setChildSqlExpression(List<SqlExpression> childSqlExpression) {
		this.childSqlExpression = childSqlExpression;
	}

	public SqlRelation getSqlRelation() {
		return sqlRelation;
	}

	public void setSqlRelation(SqlRelation sqlRelation) {
		this.sqlRelation = sqlRelation;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isValueArray() {
		return isValueArray;
	}

	public void setValueArray(boolean isValueArray) {
		this.isValueArray = isValueArray;
	}
	
	public SqlExpression(SqlRelation sqlRelation,String field,Object value,boolean isValueArray)
	{
		this.sqlRelation=sqlRelation;
		this.field=field;
		this.value=value;
		this.isValueArray=isValueArray;
	}
	
	


}
