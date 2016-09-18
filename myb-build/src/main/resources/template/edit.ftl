<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String port= request.getServerPort()==80?"":String.valueOf(request.getServerPort());
String basePath = request.getScheme()+"://"+request.getServerName()+":"+port+path+"/";
%>
<form id="form_edit" method="post">
    <table cellpadding="5" align="center">
    <#list fields as row>
        <#if row.isEditShow=='true'>
        <tr>
            <td>${row.comment}:</td>
            <td>
        <#if (row.columnLinkInfo!"null")=="null">
                <input class="<#if row.javaType=="java.sql.Timestamp">easyui-datetimebox<#else>easyui-textbox</#if>"  type="text" name="${row.firstLowerName}" data-options="required:true" <#if row_index == 0>readonly value="0"</#if> />
        <#else>

                <select class="easyui-combogrid" id="${row.firstLowerName}" style="width:150px" name="${row.firstLowerName}" data-options="
			panelWidth: 500,
			idField: '${row.columnLinkInfo.linkValueField}',
			textField: '${row.columnLinkInfo.linkTextField}',
			url: '<%=basePath%>${row.columnLinkInfo.linkTable}/${row.columnLinkInfo.linkTable}SearchResult.jhtml?rows=1000',
			method: 'get',
			columns: [[
				{field:'${row.columnLinkInfo.linkValueField}',title:'${row.columnLinkInfo.linkValueField}',width:80},
				{field:'${row.columnLinkInfo.linkTextField}',title:'${row.columnLinkInfo.linkTextField}',width:120},
			]],
			fitColumns: true,required:true
		">
                </select>
        </#if>
            </td>
        </tr>
        </#if>
    </#list>



    </table>
</form>
<div style="text-align:center;padding:5px">
    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn_submit">Submit</a>

</div>
<script language="JavaScript">

    var edit_url="${firstUpperClassName}Edit.jhtml";

    $('#form_edit').form({
        url:edit_url,
        onSubmit: function(){
            return $(this).form('enableValidation').form('validate');
        },
        success:function(result){
            result = $.parseJSON(result);
            jQuery.messager.alert('消息',result.message);
            $('#datagrid').datagrid("reload");
            $('#edit').dialog('close');
        }
    });

    $(document).ready(function(){

        var data=<%=request.getAttribute("${firstLowerClassName}")%>;
        <#list fields as row>
            <#if (row.columnLinkInfo!"null")!="null">
        $('#${row.firstLowerName}').combogrid({
            onLoadSuccess:function(result){
                $('#${row.firstLowerName}').combogrid("setValue",data.${row.firstLowerName});
            }
        });
            </#if>
        </#list>
        $('#form_edit').form('load',data);

        $("#btn_submit").click(function(){
            $('#form_edit').form('submit');
        })
        $("#btn_clear").click(function(){
            $('#form_edit').form('clear');
        })

    })
</script>
