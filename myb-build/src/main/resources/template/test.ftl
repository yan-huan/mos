<#list fields as row><#if row_index == 0>readonly</#if></#list>






<#list fields as row><#if row_index gt 0>${row.name}</#if><#if row_has_next>,</#if></#list>

<#list fields as row><#if row_index == 0>${row.name}=@{${row.name}}</#if></#list>


<#list fields as row><#if row_index gt 0>${row.name}=@{${row.name}}</#if><#if row_has_next>,</#if></#list>

