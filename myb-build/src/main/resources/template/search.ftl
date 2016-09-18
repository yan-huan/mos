<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<head>
    <title></title>
    <%@ include file="shared/header.jsp"%>
</head>
<body>
<table id="datagrid" class="easyui-datagrid" title="${firstUpperClassName}"
       data-options="rownumbers:true,singleSelect:true,checkbox:true,toolbar:'#tb',pagination:true">
    <thead>
    <tr>
    <#list fields as row>
        <#if row.isListShow=='true'>
        <th data-options="field:'${row.firstLowerName}',width:80,">${row.comment}</th>
        </#if>
    </#list>


    </tr>
    </thead>
</table>

<div id="tb" style="padding:2px 5px;">
    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn_add" >添加</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn_edit" >编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn_del" >删除</a>
</div>


<div id="edit"></div>


<script language="javascript">

    $(document).ready(function(){

        search();

        $("#btn_edit").click(function(){
            var row = $('#datagrid').datagrid('getSelected');
            if(row==null)
            {
                jQuery.messager.alert('消息',"请选中一条记录");
                return;
            }
            var edit_url="${firstUpperClassName}EditView.jhtml?<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>="+row.<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>;
            console.log(edit_url);
            $('#edit').dialog({title: '编辑信息', width: 400,height: 250,closed: false, cache: false, href:edit_url, modal: true });
        })

        $("#btn_del").click(function(){
            var row = $('#datagrid').datagrid('getSelected');
            if(row==null)
            {
                jQuery.messager.alert('消息',"请选中一条记录");
                return;
            }
            var edit_url="${firstUpperClassName}Delete.jhtml?<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>="+row.<#list fields as row><#if row_index == 0>${row.firstLowerName}</#if></#list>;
            $.messager.confirm('消息', '确认删除?', function(result){
                if (result){
                    $.get(edit_url,function(result){
                        jQuery.messager.alert('消息',result.message);
                        $('#datagrid').datagrid("reload");
                    });
                }
            });
        })

        $("#btn_add").click(function(){
            var add_url="${firstUpperClassName}EditView.jhtml";
            $('#edit').dialog({title: '添加信息', width: 400, height: 250, closed: false, cache: false, href:add_url , modal: true});
        })

        $(window).resize(function(){
            $('#datagrid').datagrid('resize');
        });
    })


    function search()
    {
        var search_url="${firstUpperClassName}SearchResult.jhtml";
        $('#datagrid').datagrid({"url":search_url,method:'get',pageSize:10,pageList:[10,20,30]});
    }
</script>

</body>
</html>
