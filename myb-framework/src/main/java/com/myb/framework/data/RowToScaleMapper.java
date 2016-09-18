package com.myb.framework.data;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.springframework.jdbc.core.RowMapper;

/**
 * Created by admin on 2015/10/30.
 */
public class RowToScaleMapper<T> implements RowMapper<T> {
    @SuppressWarnings("unused")
	private Class<T> resultType;



    public RowToScaleMapper(Class<T> resultType) {
        this.resultType = resultType;
    }


    @SuppressWarnings("unchecked")
	public T mapRow(ResultSet rs, int rowNum) {

        T t = null;
        try {
            // EntityBuilder.getPropertyInfo(this.resultType, columnName)
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if(columnCount>0)
            {
                t= (T) rs.getObject(1);
            }


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }


        return t;
    }
}
