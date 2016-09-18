<%@ page language="java" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String port= request.getServerPort()==80?"":String.valueOf(request.getServerPort());
String basePath = request.getScheme()+"://"+request.getServerName()+":"+port+path+"/";
%>
<form id="form_edit" method="post">
    <table cellpadding="5" align="center">
            <tr>
            <td>:</td>
            <td>
                <input class="easyui-textbox"  type="text" name="id" data-options="required:true" readonly value="0" />
            </td>
        </tr>
        <tr>
            <td>:</td>
            <td>
                <input class="easyui-textbox"  type="text" name="name" data-options="required:true"  />
            </td>
        </tr>



    </table>
</form>
<div style="text-align:center;padding:5px">
    <a href="javascript:void(0)" class="easyui-linkbutton" id="btn_submit">Submit</a>

</div>
<script language="JavaScript">

    var edit_url="UserEdit.jhtml";

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

        var data=<%=request.getAttribute("user")%>;
        $('#form_edit').form('load',data);

        $("#btn_submit").click(function(){
            $('#form_edit').form('submit');
        })
        $("#btn_clear").click(function(){
            $('#form_edit').form('clear');
        })

    })
</script>
