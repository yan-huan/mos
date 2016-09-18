package com.myb.framework.data;

import java.util.List;

import com.myb.framework.util.StringUtil;


public class SqlParameterForQuery {
	
    private int pIndex = 0;

    private String paramName = "P";

	private QueryParameter queryParameter;
	
	private SqlParameter sqlParameter=new SqlParameter();

	public SqlParameterForQuery(QueryParameter queryParameter) {
		this.queryParameter = queryParameter;
	}

	public String getSql() {
		String whereString= buildSql(this.queryParameter.getParameters());
		if(!StringUtil.isNullOrEmpty(whereString))
		{
			whereString=" WHERE "+whereString;
		}
		return whereString;
	}

	
	public SqlParameter getSqlParameter() {
		return this.sqlParameter;
	}
	
	private String buildSql(List<SqlExpression> sqlExpressions) {
		StringBuffer stringBuffer = new StringBuffer();
		int count = sqlExpressions.size();
		for (int i = 0; i < count; i++) {

			SqlExpression itemParameter = sqlExpressions.get(i);
			List<SqlExpression> childSqlExpressions = itemParameter.getChildSqlExpression();
			switch (itemParameter.getSqlRelation()) {
			case AND:
				stringBuffer.append(getSqlRelation(SqlRelation.AND));
				if (childSqlExpressions != null) {
				
					if(childSqlExpressions.size()>0)
					{
						stringBuffer.append("(");
						stringBuffer.append(buildSql(childSqlExpressions));
						stringBuffer.append(")");
					}
				}
				break;
			case OR:
				stringBuffer.append(getSqlRelation(SqlRelation.OR));
				if (childSqlExpressions != null){
					if(childSqlExpressions.size()>0)
					{
						stringBuffer.append("(");
						stringBuffer.append(buildSql(childSqlExpressions));
						stringBuffer.append(")");
					}
				}
				break;
			default:
				stringBuffer.append(itemParameter.getField());
				stringBuffer.append(getSqlRelation(itemParameter.getSqlRelation()));
				stringBuffer.append(getParameterName(itemParameter));
				break;
			}
		}

		return stringBuffer.toString();
	}
	
	private String getParameterName(SqlExpression sqlExpression) {
		StringBuffer sbBuffer=new StringBuffer();
		Object[] valuesObjects;
		String parameterName;
		switch (sqlExpression.getSqlRelation()) {
		case IN:
		case NIN:
			valuesObjects=(Object[])sqlExpression.getValue();
			sbBuffer.append(" (");
			for (int i = 0; i < valuesObjects.length; i++) {
				parameterName="@{"+paramName+pIndex+"}";
				sqlParameter.add(paramName+pIndex, valuesObjects[i]);
				sbBuffer.append(parameterName);
				if(i!=valuesObjects.length-1)
				{
					sbBuffer.append(",");
				}
				pIndex++;
			}
			sbBuffer.append(")");
			break;
		case BW:
			valuesObjects=(Object[])sqlExpression.getValue();
			sbBuffer.append(" BETWEEN ");
			parameterName="@{"+paramName+pIndex+"}";
			sqlParameter.add(paramName+pIndex, valuesObjects[0]);
			pIndex++;
			sbBuffer.append(parameterName);
			sbBuffer.append(" AND ");
			parameterName="@{"+paramName+pIndex+"}";
			sqlParameter.add(paramName+pIndex, valuesObjects[1]);
			sbBuffer.append(parameterName);
			pIndex++;
			break;
		default:
			parameterName="@{"+paramName+pIndex+"}";
			sqlParameter.add(paramName+pIndex, sqlExpression.getValue());
			sbBuffer.append(parameterName);
			pIndex++;
			break;
		}
		return sbBuffer.toString();
	}
	
	
	
	@SuppressWarnings("incomplete-switch")
	private String getSqlRelation(SqlRelation sqlRelation) {
		String relationString="";
		switch (sqlRelation) {
		case EQ:
			relationString="=";
			break;
		case GT:
			relationString=">";
			break;
		case GE:
			relationString=">=";
			break;
		case NE:
			relationString="!=";
			break;
		case LT:
			relationString="<";
			break;
		case LE:
			relationString="<=";
			break;
		case IN:
			relationString=" IN ";
			break;
		case NIN:
			relationString=" NOT IN ";
			break;
		case OR:
			relationString=" OR ";
			break;
		case AND:
			relationString=" AND ";
			break;
			
		case LK:
			relationString=" LIKE ";
			break;
		}
		return relationString;
		
	}

}
