package ${services.packageName};

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryParameter;
import com.myb.framework.data.QueryCondition;

import ${dao.packageName}.${firstUpperClassName}Dao;
import ${pojo.packageName}.${firstUpperClassName};

public interface ${firstUpperClassName}Service {


    public int insert(${firstUpperClassName} ${firstLowerClassName});

    public int update(${firstUpperClassName} ${firstLowerClassName});

    public int delete(<#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>);

    public ${firstUpperClassName} searchBy<#list fields as row><#if row_index == 0>${row.firstUpperName}</#if></#list>(<#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>);

    public PagedList<${firstUpperClassName}> searchByPage(QueryCondition queryCondition);

    public List<${firstUpperClassName}> searchList(QueryParameter queryParameter);
}

