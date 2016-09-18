package com.myb.framework.data;

import java.lang.reflect.Field;

public class AnnotationDataBindingInfo {
	
	private String column;
	
	private Field fieldInfo;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Field getFieldInfo() {
		return fieldInfo;
	}

	public void setFieldInfo(Field fieldInfo) {
		this.fieldInfo = fieldInfo;
	}

}
