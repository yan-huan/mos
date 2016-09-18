package ${packageName};

public class ${firstUpperClassName}Mapping {

    <#list fields as row>
    public final static String ${row.firstUpperName} = "${row.name}";
    </#list>

}
