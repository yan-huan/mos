package ${packageName};

import com.myb.framework.data.DataMapping;
import com.myb.framework.data.EntityBase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myb.framework.serialization.JsonLongDateFormatSerializer;

public class ${firstUpperClassName} extends EntityBase{

    <#list fields as row>
    @DataMapping(${firstUpperClassName}Mapping.${row.firstUpperName})
    private ${row.javaType} ${row.firstLowerName};//${row.comment}
    </#list>


    public ${firstUpperClassName}() { }

    <#list fields as row>
        <#if row.javaType=="java.sql.Timestamp">
    @JsonSerialize(using = JsonLongDateFormatSerializer.class)
        </#if>
    public ${row.javaType} get${row.firstUpperName}()
    {
        return ${row.firstLowerName};
    }

    public void set${row.firstUpperName}(${row.javaType} ${row.firstLowerName})
    {
        this.${row.firstLowerName} = ${row.firstLowerName};
    }
    </#list>

}
