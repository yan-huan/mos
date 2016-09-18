package com.myb.framework.data;

import java.util.ArrayList;
import java.util.List;


public class QueryParameter {
	private List<SqlExpression> parameters;
	public List<SqlExpression> getParameters() {
		return parameters;
	}


	public void setParameters(List<SqlExpression> parameters) {
		this.parameters = parameters;
	}


	
	public QueryParameter getQueryParameter() {
		return this;
	}


	public QueryParameter()
	{
		parameters=new ArrayList<SqlExpression>();
	}
	
	//
	public QueryParameter eq(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.EQ,field,value,false);
		parameters.add(expression);
		return this;
	}
	
	//
	public QueryParameter gt(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.GT,field,value,false);
		parameters.add(expression);
		return this;
	}
	

	public QueryParameter ge(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.GE,field,value,false);
		parameters.add(expression);
		return this;
	}
	

	public QueryParameter ne(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.NE,field,value,false);
		parameters.add(expression);
		return this;
	}
	

	public QueryParameter lt(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.LT,field,value,false);
		parameters.add(expression);
		return this;
	}
	

	public QueryParameter le(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.LE,field,value,false);
		parameters.add(expression);
		return this;
	}
	

	public QueryParameter bw(String field,Object start,Object end) {
		Object[] values=new Object[]{start,end};
		SqlExpression expression=new SqlExpression(SqlRelation.BW,field,values,true);
		parameters.add(expression);
		return this;
	}
	
	//in
	public QueryParameter in(String field,Object[] values) {
		SqlExpression expression=new SqlExpression(SqlRelation.IN,field,values,true);
		parameters.add(expression);
		return this;
	}
	
	//not in
	public QueryParameter nin(String field,Object[] values) {
		SqlExpression expression=new SqlExpression(SqlRelation.NIN,field,values,true);
		parameters.add(expression);
		return this;
	}
	
	//startwith
	public QueryParameter sw(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.LK,field,value+"%",true);
		parameters.add(expression);
		return this;
	}
	
	//endwith
	public QueryParameter ew(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.LK,field,"%"+value,true);
		parameters.add(expression);
		return this;
	}
	
	//co
	public QueryParameter co(String field,Object value) {
		SqlExpression expression=new SqlExpression(SqlRelation.LK,field,"%"+value+"%",true);
		parameters.add(expression);
		return this;
	}
	
	public QueryParameter or()
	{
		SqlExpression sqlExpression= new SqlExpression(SqlRelation.OR,null,null,true);
		
		this.parameters.add(sqlExpression);
		return this;
	}
	
	public QueryParameter and()
	{
		SqlExpression sqlExpression= new SqlExpression(SqlRelation.AND,null,null,true);
		this.parameters.add(sqlExpression);
		return this;
	}
	
	public QueryParameter or(QueryParameter queryParameter)
	{
		SqlExpression sqlExpression= new SqlExpression(SqlRelation.OR,null,null,true);
		sqlExpression.setChildSqlExpression(queryParameter.parameters);
		this.parameters.add(sqlExpression);
		return this;
	}
	
	public QueryParameter and(QueryParameter queryParameter)
	{
		SqlExpression sqlExpression= new SqlExpression(SqlRelation.AND,null,null,true);
		sqlExpression.setChildSqlExpression(queryParameter.parameters);
		this.parameters.add(sqlExpression);
		return this;
	}
	


}
