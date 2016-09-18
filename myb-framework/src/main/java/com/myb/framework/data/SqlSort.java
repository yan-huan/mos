package com.myb.framework.data;

public class SqlSort {

	private String field;

	private SqlOrder order;

	public SqlSort(String field, SqlOrder order) {
		this.field = field;
		this.order = order;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public SqlOrder getSqlOrder() {
		return order;
	}

	public void setSqlOrder(SqlOrder order) {
		this.order = order;
	}

}
