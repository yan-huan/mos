package com.myb.framework.data;

/**
 * Created by Administrator on 2016/1/29.
 */
public class SqlParameterForInsert {
    private int pIndex = 0;
    private String paramName = "U";
    private UpdateParameter updateParameter;
    private SqlParameter sqlParameter=new SqlParameter();

    public SqlParameter getSqlParameter() {
        return sqlParameter;
    }

    public SqlParameterForInsert(UpdateParameter updateParameter)
    {
        this.updateParameter=updateParameter;
    }


    public String getSql()
    {
        String sql=buildSql();
        return sql;
    }

    public String buildSql()
    {
        StringBuffer stringBuffer = new StringBuffer();

        if(updateParameter.getParameters().size()>0)
        {
            stringBuffer.append("(");
            int count=updateParameter.getParameters().size();
            for(int i=0;i<count;i++) {
                stringBuffer.append(updateParameter.getParameters().get(i).getField());
                if(i<count-1)
                {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(")VALUES(");
            count=updateParameter.getParameters().size();
            for(int i=0;i<count;i++) {
                stringBuffer.append(getParameterName(updateParameter.getParameters().get(i)));
                if(i<count-1)
                {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(")");

        }

        return stringBuffer.toString();
    }

    private String getParameterName(SqlExpression sqlExpression) {
        String parameterName;
        parameterName="@{"+paramName+pIndex+"}";
        sqlParameter.add(paramName+pIndex, sqlExpression.getValue());
        pIndex++;
        return parameterName;
    }
}
