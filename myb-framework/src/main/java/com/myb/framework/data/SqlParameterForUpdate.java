package com.myb.framework.data;

import com.myb.framework.util.StringUtil;

import java.util.Map;

/**
 * Created by Administrator on 2016/1/29.
 */
public class SqlParameterForUpdate {

    private int pIndex = 0;
    private String paramName = "U";
    private UpdateParameter updateParameter;
    private SqlParameter sqlParameter=new SqlParameter();
    public SqlParameter getSqlParameter() {
        return this.sqlParameter;
    }

    public SqlParameterForUpdate(UpdateParameter updateParameter) {

        this.updateParameter = updateParameter;
    }


    @SuppressWarnings("unused")
	public String getSql()
    {
        String sql="";
        return buildSql();
    }

    public String buildSql()
    {
        StringBuffer stringBuffer = new StringBuffer();
        for(SqlExpression item:updateParameter.getParameters())
        {
            stringBuffer.append(String.format("%s=%s",item.getField(),getParameterName(item)));
            stringBuffer.append(",");
        }
        String sql=StringUtil.trimEnd(stringBuffer.toString(),",");
        if(!StringUtil.isNullOrEmpty(sql)) {
            SqlParameterForQuery sqlParameterForQuery = new SqlParameterForQuery(updateParameter.getQueryParameter());
            String where = sqlParameterForQuery.getSql();
            for (Map.Entry<String, Object> item : sqlParameterForQuery.getSqlParameter().getParameters().entrySet()) {
                sqlParameter.add(item.getKey(), item.getValue());
            }
            sql=sql+where;
        }
        return sql;
    }

    private String getParameterName(SqlExpression sqlExpression) {
        String parameterName;
        parameterName="@{"+paramName+pIndex+"}";
        sqlParameter.add(paramName+pIndex, sqlExpression.getValue());
        pIndex++;
        return parameterName;
    }
}
