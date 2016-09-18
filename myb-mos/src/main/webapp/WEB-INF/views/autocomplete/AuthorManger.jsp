<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户添加权限</title>
<script type="text/javascript" src="../js/jquery-2.1.1.min.js"></script>
<script src="../js/alertInfo.js"></script>
<script>

	$(document).ready(function(){
		
		 $(".selectAll").click(function () {//全选  
			$(".sel").prop("checked", $(this).prop("checked"));
         });  
		 
	});
</script>
</head>

<body>
		<div id="demo">
	        <div class="wrapper">
	            <h3>添加权限</h3>
	            <div id="search-form"></div>
	            
	        </div>
	    </div>
    
	    <div style="width:1106px;margin-left: 327px; ">
	    
		  <table class="table table-striped table-bordered " style="margin-bottom: 0px;">
							<thead>
								<tr>
									<th width="5%"><input type="checkbox" class="selectAll"></th>
									<th>权限名称</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${roleList}" var="role">
							
								<tr>
									<td><input type="checkbox"  class="sel" value="${role.roleId}"/>${role.roleId}</td>
									<td><a href="javascript:void(0)" target="_blank">${role.roleName}</a></td>
								</tr>
							
							</c:forEach>
								
								
							</tbody>
				</table>
    	</div>
    	 <script src="../js/autocomplete/autocomplete.js"></script>
    	<script type="text/javascript">
    	$(function(){

    		
    		var arr = new Array();
    		//默认调取员工的手机号
    		$.ajax({
    			url:"../role/roleAddMenu.jhtml",
    			type:"POST",
    			dataType:"json",
    			success:function(data){
    				
    				for(var s=0; s<data.length; s++){
    					arr.push(data[s]);
    				}
    				
    				},error:function(){
    					//展示错误提示的弹框
    					var dialog = jDialog.alert('连接超时了',{},{
    		   				showShadow: false,// 不显示对话框阴影
    		   				buttonAlign : 'center',
    		   				events : {
    		   					show : function(evt){
    		   						var dlg = evt.data.dialog;
    		   					},
    		   					close : function(evt){
    		   						var dlg = evt.data.dialog;
    		   					},
    		   					enterKey : function(evt){
    		   					},
    		   					escKey : function(evt){
    		   						evt.data.dialog.close();
    		   					}
    		   				}
    		   			  });
    			}
    			
    		});
    		
    		$('#search-form').autocomplete({
    			hints: arr,
    			width: 300,
    			height: 30,
    			onSubmit: function(text){
    				
    				var inp = $(".autocomplete-input").val();
    				if (inp == null ||$.trim(inp) == ""){
    					//展示错误提示的弹框
    					var dialog = jDialog.confirm('请输入用户名',{
    						handler : function(button,dialog) {
    							dialog.close();
    						}
    					},{
    						handler : function(button,dialog) {
    							dialog.close();
    						}
    					});
    					return false;
    				}
    					
    				var inp1 = inp.split("(")[1];
    				var inp2= inp1.split(")")[0];
    				var arr1 = new Array();
    				
    				$(".sel:checked").each(function(){
    					arr1.push($(this).val());
    				});
    				
    				if(arr1.length<=0){
    					//展示提示的弹框
       					var dialog = jDialog.confirm('请选择权限',{
       						handler : function(button,dialog) {
       							dialog.close();
       						}
       					},{
       						handler : function(button,dialog) {
       							dialog.close();
       						}
       					});
    					return false;
    				}
    				//添加权限
    				$.ajax({
    					url:"../role/addMenuByEmp.jhtml",
    					data:{"roleListId":arr1,"mobile":inp2},
    					type:"POST",
    					dataType:"json",
    					
    					success:function(data){
    						console.info(data);
    						if(data == "1"){
    							//展示提示的弹框
    		   					var dialog = jDialog.confirm('添加权限成功',{
    		   						handler : function(button,dialog) {
    		   							dialog.close();
    		   						}
    		   					},{
    		   						handler : function(button,dialog) {
    		   							dialog.close();
    		   						}
    		   					});
    							$(".autocomplete-input").val("");
    							$(".sel").removeAttr("checked");
    						}else {
    							//展示提示的弹框
    		   					var dialog = jDialog.confirm('添加权限失败了',{
    		   						handler : function(button,dialog) {
    		   							dialog.close();
    		   						}
    		   					},{
    		   						handler : function(button,dialog) {
    		   							dialog.close();
    		   						}
    		   					});
    						}
    						
    						},error:function(){
    							//展示提示的弹框
    							var dialog = jDialog.alert('连接超时了',{},{
    				   				showShadow: false,// 不显示对话框阴影
    				   				buttonAlign : 'center',
    				   				events : {
    				   					show : function(evt){
    				   						var dlg = evt.data.dialog;
    				   					},
    				   					close : function(evt){
    				   						var dlg = evt.data.dialog;
    				   					},
    				   					enterKey : function(evt){
    				   					},
    				   					escKey : function(evt){
    				   						evt.data.dialog.close();
    				   					}
    				   				}
    				   			  });
    					}
    					
    				});
    				
    			}
    		});
    	});
    	</script>
</body>
</html>
