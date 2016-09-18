package ${packageName};

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myb.framework.data.PagedList;
import com.myb.framework.data.QueryCondition;
import com.myb.framework.serialization.JsonSerializer;
import com.myb.framework.util.RequestUtil;
import com.myb.framework.util.StringUtil;
import com.myb.framework.web.models.JsonModel;
import ${project_name}.common.Converter;

import ${pojo.packageName}.${firstUpperClassName};
import ${pojo.packageName}.${firstUpperClassName}Mapping;
import ${services.packageName}.${firstUpperClassName}Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ${firstUpperClassName}Controller {
    @Autowired
    private ${firstUpperClassName}Service ${firstLowerClassName}Service;

    @RequestMapping("${firstUpperClassName}/${firstUpperClassName}Search.jhtml")
    public ModelAndView search(HttpServletRequest request)
    {
        return new ModelAndView("${firstUpperClassName}Search");
    }
    @RequestMapping("${firstUpperClassName}/${firstUpperClassName}SearchResult.jhtml")
    public @ResponseBody  Map<String,Object> SearchResult(HttpServletRequest request)
    {
        QueryCondition queryCondition=new QueryCondition();
        queryCondition.setPageSize(RequestUtil.getIntParameter(request,"rows",10));
        queryCondition.setPageIndex(RequestUtil.getIntParameter(request,"page",1));
        PagedList<${firstUpperClassName}> pagedList=${firstLowerClassName}Service.searchByPage(queryCondition);
        return Converter.toMap(pagedList);
    }


    @RequestMapping("${firstUpperClassName}/${firstUpperClassName}EditView.jhtml")
    public ModelAndView EditView(HttpServletRequest request) throws JsonProcessingException
    {
        <#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>=RequestUtil.getIntParameter(request, "<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>", 0);
        ${firstUpperClassName} ${firstLowerClassName}= ${firstLowerClassName}Service.searchBy<#list fields as row><#if row_index == 0>${row.firstUpperName}</#if></#list>(<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>);
        request.setAttribute("${firstLowerClassName}",JsonSerializer.serializeObject(${firstLowerClassName}));
        return new ModelAndView("${firstUpperClassName}EditView");
    }


    @RequestMapping("${firstUpperClassName}/${firstUpperClassName}Edit.jhtml")
    public @ResponseBody JsonModel  edit(@ModelAttribute("${firstUpperClassName}") ${firstUpperClassName} ${firstLowerClassName},HttpServletRequest request)
    {
        JsonModel jsonModel=new JsonModel();
        jsonModel.setStatus(JsonModel.JsonModelStatus.SUCCESS);
        if(${firstLowerClassName}.get<#list fields as row><#if row_index == 0>${row.firstUpperName}</#if></#list>()>0)
        {
            if(${firstLowerClassName}Service.update(${firstLowerClassName})<1)
            {
                jsonModel.setStatus(JsonModel.JsonModelStatus.FAIL);
            }
        }
        else
        {
            if(${firstLowerClassName}Service.insert(${firstLowerClassName})<1)
            {
                jsonModel.setStatus(JsonModel.JsonModelStatus.FAIL);
            }
        }
        if(jsonModel.getStatus().equals(JsonModel.JsonModelStatus.FAIL))
        {
            jsonModel.setMessage("保存失败");
        }
        else
        {
            jsonModel.setMessage("保存成功");
        }
        return jsonModel;
    }


    @RequestMapping("${firstUpperClassName}/${firstUpperClassName}Delete.jhtml")
    public @ResponseBody JsonModel  delete(@RequestParam <#list fields as row><#if row_index == 0>${row.javaType}</#if></#list> <#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>)
    {
        JsonModel jsonModel=new JsonModel();
        jsonModel.setStatus(JsonModel.JsonModelStatus.SUCCESS);
        if(<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>>0)
        {
            if(${firstLowerClassName}Service.delete(<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>)<1)
            {
                jsonModel.setStatus(JsonModel.JsonModelStatus.FAIL);
            }
        }
        else
        {
            jsonModel.setStatus(JsonModel.JsonModelStatus.FAIL);
        }
        if(jsonModel.getStatus().equals(JsonModel.JsonModelStatus.FAIL))
        {
            jsonModel.setMessage("删除失败");
        }
        else
        {
            jsonModel.setMessage("删除成功");
        }
        return jsonModel;
    }
}
