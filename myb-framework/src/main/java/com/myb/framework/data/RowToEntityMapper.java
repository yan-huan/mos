package com.myb.framework.data;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RowToEntityMapper<T> implements RowMapper<T> {

	private Class<T> resultType;


	
	public RowToEntityMapper(Class<T> resultType) {
		this.resultType = resultType;
	}


	public T mapRow(ResultSet rs, int rowNum) {

		T t = null;
		try {
			t = this.resultType.newInstance();
			// EntityBuilder.getPropertyInfo(this.resultType, columnName)
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i < columnCount+1; i++) {
				String columnName = rsmd.getColumnName(i);
				
				AnnotationDataBindingInfo annotationDataBindingInfo = EntityBuilder
						.getPropertyInfo(this.resultType, columnName);
				if (annotationDataBindingInfo != null) {
					annotationDataBindingInfo.getFieldInfo().set(t, ConvertType(rs,i,annotationDataBindingInfo.getFieldInfo().getType()));
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}


		return t;
	}
	
	@SuppressWarnings("hiding")
	private <T> Object ConvertType(ResultSet rs,int i,Class<T> type) throws SQLException, UnsupportedEncodingException {
		if (type==Integer.class||type==int.class)
		{
			return rs.getInt(i);
		}
		if (type==long.class)
		{
			return rs.getLong(i);
		}
		if(rs.getMetaData().getColumnTypeName(i)=="VARBINARY")
		{
			return rs.getBytes(i);
		}
		Object obj = rs.getObject(i);
		if(obj instanceof BigInteger){
			return ((BigInteger)obj).longValue();
		}
		return obj;
	}

}
