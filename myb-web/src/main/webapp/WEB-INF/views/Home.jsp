
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <meta charset="UTF-8">
    <title>系统</title>
    <jsp:include page="shared/header.jsp"></jsp:include>


</head>
<body>


<div class="easyui-layout" style="width:100%;height:500px;" data-options="fit:true">

    <div data-options="region:'north'" style="height:80px">




        logo


    </div>


    <div data-options="region:'west',split:true" class ="site_menu"title="菜单" style="width:200px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            
            <div title="User" style="padding:10px;" >
                <p><a href="#" url="User/UserSearch.jhtml">User管理</a></p>

            </div>

        </div>
    </div>
    <div data-options="region:'center',title:'',iconCls:'icon-ok'">



        <div class="easyui-tabs" data-options="fit:true" style="width:100%;height:250px">

            <div title="Help"  style="padding:10px">
                This is the help content.
            </div>
        </div>


    </div>
</div>

<div id="p-tools">

    <a href="javascript:void(0)" class="icon-mini-refresh" onclick="alert('refresh')"></a>
</div>

<script language="javascript">
    function addPanel(link_menu){

        var refresh_tab = $('.easyui-tabs').tabs('getTab',$(link_menu).html());

        if(refresh_tab==null)
        {
            $(".easyui-tabs").tabs('add',{
                title: $(link_menu).html(),
                content: '<iframe  frameborder="0"  src="'+$(link_menu).attr("url")+'" style="width:100%;height:100%;"></iframe>',
                closable: true,
                height: "auto",

                tools:[{
                    iconCls:'icon-mini-refresh',
                    handler: function(){
                        alert('refresh');
                    }
                }]

            });
        }
        else
        {
            refresh_tab=$('.easyui-tabs').tabs('select','Tab'+$(link_menu).html());

        }
    }



    $(document).ready(function(){
        $('.site_menu p a').click(function(){
            addPanel(this);
        })

    })
</script>
</body>
</html>