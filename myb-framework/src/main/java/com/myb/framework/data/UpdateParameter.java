package com.myb.framework.data;

import java.util.*;

/**
 * Created by Administrator on 2016/1/29.
 */
public class UpdateParameter {

    public QueryParameter queryParameter;
    @SuppressWarnings("unused")
	private HashMap<String,HashMap<String,Object>> map;
    private List<SqlExpression> parameters;

    public UpdateParameter()
    {
        this.map= new HashMap<String, HashMap<String, Object>>();
        this.parameters=new ArrayList<SqlExpression>();
        this.queryParameter=new QueryParameter();
    }

    public QueryParameter getQueryParameter() {
        return queryParameter;
    }

    public void setQueryParameter(QueryParameter queryParameter) {
        this.queryParameter = queryParameter;
    }

    public List<SqlExpression> getParameters() {
        return parameters;
    }


    public UpdateParameter add(String field,Object value)
    {
        SqlExpression expression=new SqlExpression(SqlRelation.EQ,field,value,false);
        parameters.add(expression);
        return this;
    }



}
