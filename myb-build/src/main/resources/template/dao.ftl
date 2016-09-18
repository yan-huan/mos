package ${packageName};

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import com.myb.framework.data.DataCommand;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.data.SqlParameter;
import com.myb.framework.data.suport.MySqlCommandBase;

import ${pojo.packageName}.${firstUpperClassName};

import ${pojo.packageName}.${firstUpperClassName}Mapping;

@Repository("${firstLowerClassName}Dao")
public class ${firstUpperClassName}Dao extends MySqlCommandBase
{

    @Resource(name = "datacommand")
    private DataCommand dataCommand;

    @PostConstruct
    public void initDataCommand()
    {
        super.setDataCommand(dataCommand);
    }
    @Override
    public String getTableName()
    {
        return "${tableName}";
    }


    public int insert(${firstUpperClassName} ${firstLowerClassName})
    {
        String sql="INSERT INTO "+getTableName()+" (<#list fields as row>${row.name}<#if row_has_next>,</#if></#list>)VALUES(<#list fields as row>@{${row.name}}<#if row_has_next>,</#if></#list>)";
        SqlParameter sqlParameter=new SqlParameter();
        <#list fields as row>
        sqlParameter.add(${firstUpperClassName}Mapping.${row.firstUpperName}, ${firstLowerClassName}.get${row.firstUpperName}());
        </#list>
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int update(${firstUpperClassName} ${firstLowerClassName})
    {
        String sql="UPDATE "+getTableName()+" set <#list fields as row><#if row_index gt 0>${row.name}=@{${row.name}}<#if row_has_next>,</#if></#if></#list> WHERE <#list fields as row><#if row_index == 0>${row.name}=@{${row.name}}</#if></#list>";
        SqlParameter sqlParameter=new SqlParameter();
        <#list fields as row>
        sqlParameter.add(${firstUpperClassName}Mapping.${row.firstUpperName}, ${firstLowerClassName}.get${row.firstUpperName}());
        </#list>
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public int delete(<#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>)
    {
        String sql="DELETE FROM "+getTableName()+" WHERE <#list fields as row><#if row_index == 0>${row.name}=@{${row.name}}</#if></#list>";
        SqlParameter sqlParameter=new SqlParameter();
        <#list fields as row>
            <#if row_index == 0>
        sqlParameter.add(${firstUpperClassName}Mapping.${row.firstUpperName},<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>);
            </#if>
        </#list>
        return this.getDataCommand().executeNonQuery(sql, sqlParameter);
    }

    public ${firstUpperClassName} searchBy<#list fields as row><#if row_index == 0>${row.firstUpperName}</#if></#list>(<#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>)
    {
        String sql="SELECT * FROM "+getTableName()+" WHERE <#list fields as row><#if row_index == 0>${row.name}=@{${row.name}}</#if></#list>";
        SqlParameter sqlParameter=new SqlParameter();
        <#list fields as row>
            <#if row_index == 0>
        sqlParameter.add(${firstUpperClassName}Mapping.${row.firstUpperName},<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>);
            </#if>
        </#list>
        return this.dataCommand.executeEntity(sql, sqlParameter, ${firstUpperClassName}.class);
    }
    public PagedList<${firstUpperClassName}> searchByPage(QueryCondition queryCondition) {
        PagedList<${firstUpperClassName}> pagedList=this.searchByPage(queryCondition, ${firstUpperClassName}.class);
        return pagedList;
    }
    public List<${firstUpperClassName}> searchList(QueryParameter queryParameter) {
                List<${firstUpperClassName}> list=this.searchList(queryParameter, ${firstUpperClassName}.class);
                    return list;
    }
}
