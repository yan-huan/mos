package ${servicesimpl.packageName};

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;

import ${dao.packageName}.${firstUpperClassName}Dao;
import ${pojo.packageName}.${firstUpperClassName};
import ${services.packageName}.${firstUpperClassName}Service;

@Service("${firstLowerClassName}Service")
public class ${firstUpperClassName}ServiceImpl implements ${firstUpperClassName}Service{

    @Autowired
    private ${firstUpperClassName}Dao ${firstLowerClassName}Dao;

    public int insert(${firstUpperClassName} ${firstLowerClassName})
    {
        return ${firstLowerClassName}Dao.insert(${firstLowerClassName});
    }
    public int update(${firstUpperClassName} ${firstLowerClassName})
    {
        return ${firstLowerClassName}Dao.update(${firstLowerClassName});
    }

    public int delete(<#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>)
    {
        return ${firstLowerClassName}Dao.delete(<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>);
    }

    public ${firstUpperClassName} searchBy<#list fields as row><#if row_index == 0>${row.firstUpperName}</#if></#list>(<#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>) {
        return ${firstLowerClassName}Dao.searchBy<#list fields as row><#if row_index == 0>${row.firstUpperName}</#if></#list>(<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>);
    }
    public PagedList<${firstUpperClassName}> searchByPage(QueryCondition queryCondition)
    {
        return ${firstLowerClassName}Dao.searchByPage(queryCondition);
    }
    public List<${firstUpperClassName}> searchList(QueryParameter queryParameter)
    {
        return ${firstLowerClassName}Dao.searchList(queryParameter);
    }
}

