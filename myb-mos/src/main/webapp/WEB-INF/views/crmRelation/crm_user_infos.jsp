<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MOS-美业邦</title>

		<!-- Bootstrap -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/back-style.css" rel="stylesheet">
		<link href="../css/account/dashboard.css" rel="stylesheet">
    	<link href="../css/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
		<script type="text/javascript">
		$(function(){
	    	$("#base-save").click(function(){
	    		//验证表单
	    		if(Validator.Validate(document.getElementById('saveAccount'),3)){
	    			var sell = $(".autocomplete-input").val();
	    			$("#noemp").remove();
	    			if(sell.indexOf("(") <= 0 ){
	    				$(".autocomplete-input").after("<span id=\"noemp\" style=\"color:red;\">此销售人员不存在</span>");
	    				
	    				return false;
	    			}else{
	    				$(this).attr("disabled",true);
	    			}
	    			var inp1 = sell.split("(")[1];
					var inp2= inp1.split(")")[0];
	    			var channelId="${channelId}";
	    			
	    			var isqudao=$("#qudao").val();
	    			var xsry=$(".autocomplete-input").val();
	    			$.ajax({
   	    				type:"POST",
   	    				dataType:"json",
   	    				data:$("#saveAccount").serialize(),
   	    				url:"../crm/saveManageUserInfo.jhtml?xsry="+xsry,
   	    				success:function(data){
   	    					console.info(data);
   	    					$("#base-save").attr("disabled",false);
   	    					if(data == "1"){
   	    						alertInfoAndHref("保存成功","../utils/crm_user_infos.jhtml");
   	    					} else if (data == "2") {
   	    						alertInfo("此用户已经注册过了");
   	    					} else {
   	    						alertInfo("保存失败,请联系管理员");
   	    					}
   	    				},error:function(){
   	    					$("#base-save").attr("disabled",false);
   	    					$("#showErr").html("连接超时了").show();
   	    				}
   	    			});
	    		} else {
	    			 return false;
	    		};
	    	});
		});
   	    </script>
	</head>

	<body>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<div class="col-lg-offset-2 main">
						<h3 class="page-header">销售人员管理</h3>
						<form id="saveAccount" name=crmUserinfoVO role="form" class="form-horizontal"  method="post">
						<input type="hidden" class="form-control" name="consumerId" id="consumerId">
						<input type="hidden" name="isChannel" value="${isqudao}" id="qudao"/>
							<table class="table table-bordered" style="width: 40%;">
								<tbody>
								<tr>
									<th width="30%">新增销售人员 <span>*</span></th>
									<td>
									<div id="demo" style="width: 100%;height: 36px;">
								        <div class="">
								            <div id="search-form"  style="width: 100%;"></div>
								        </div>
								    </div>
									</td>
								</tr>
								<tr>
									<th width="30%">部门 <span>*</span>
									</th><td>
									<select id="bumen" class=" form-control" name="bumen">
										<option>请选择部门</option>
									</select>
									</td>
								</tr>
								<tr>
									<th width="30%">岗位 <span>*</span></th>
									<td>
										<select id="gangwei" class=" form-control" name="gangwei">
											<option>请选择岗位</option>
										</select>
									</td>
								</tr>
								<tr>
									<th width="30%">付款日期 <span>*</span></th>
									<td>
									<!-- dataType="Require" msg="请输入付款日期 " -->
										<input type="text" class="form_datetime form-control" name="payDate" id="payDate" placeholder="付款日期" />
									</td>
								</tr>
								<tr>
									<th width="30%">所属大区<span>*</span></th>
									<td>
									<select id="quyu" class=" form-control" name="quyu">
											<option>请选择大区</option>
										</select>
									</td>
								</tr>
								<tr>
									<th width="30%">销售小组<span>*</span></th>
									<td>
									<select id="xz" class=" form-control" name="xiaozu">
											<option>请选择小组</option>
										</select>
									</td>
								</tr>
								<tr>
									<th width="30%"></th>
									<td>
										<a href="javascript:void(0)" id="base-save" class="btn btn-success btn-sm">保存</a>
										<font color="red" id="showErr" style="display: none;">开通账号已存在(手机号)</font>
									</td>
								</tr>
							</tbody>
						</table>
					 </form>
					</div>
				</div>
			</div>
		</section>
		<!--/#contact-page-->

		<footer cass="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
		<script src="../js/calendar/jquery.js"></script>
   	    <script src="../js/calendar/jquery.datetimepicker.js"></script>
   	    <script src="../js/calendar/calendar.js"></script>
   	    <script src="../js/autocomplete/autocompleteSell.js"></script>
   	    <script src="../js/autocomplete/autocompleteSell1.js"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
   	    <script type="text/javascript">

  	     $('.form_datetime').datetimepicker({
			 	minView: 'month',     //设置时间选择为年月日 去掉时分秒选择
		        format:'yyyy-mm-dd',
		        weekStart: 1,
		        todayBtn:  1,
		        autoclose: 1,
		        todayHighlight: 1,
		        startView: 2,
		        forceParse: 0,
		        showMeridian: 1,
		        language: 'zh-CN'    //设置时间控件为中文
		    });
  	     
   	    $(function(){
   	     
   	   	    //销售的autocomplate
   	   	    var arr = new Array();
   			//默认调取员工的手机号
   			$.ajax({
   				url:"../role/roleAddMenu.jhtml",
   				type:"POST",
   				dataType:"json",
   				success:function(data){
   					console.info(data);
   					for(var s=0; s<data.length; s++){
   						arr.push(data[s]);
   					}
   					
   					},error:function(){
   						//展示错误提示的弹框
   						alertInfo("连接超时了");
   				}
   			});
   	   	   
	    	$('#search-form').autocomplete({ 
				hints: arr,
				width: 386,
				height: 35,
				onSubmit: function(text){
					
					var inp = $(".autocomplete-input").val();
					if (inp == null ||$.trim(inp) == ""){
						//展示错误提示的弹框
						alertInfo("请输入销售名称");
						return false;
					}
					
				}
			});
   	   	  $(".autocomplete-input").attr("datatype","Require").attr("msg","请输入销售人员").css("width","100%");
   	   	  $(".autocomplete-container").css("width","100%");
   	   	  
   	   	  
	   	 //部门岗位和小组
				$.ajax({
					type:"GET",
					dataType:"json",
					url:"../crm/manageUserInfo.jhtml",
					success:function(data){
						if (data != "0") {
							for (var i = 0; i < data.bumen.length; i++) {//部门
							
								$("#bumen").append("<option value=\""+data.bumen[i].argName+"\">"+data.bumen[i].argName+"</option>");
							}
							for (var i = 0; i < data.gangwei.length; i++) {//岗位
								$("#gangwei").append("<option value=\""+data.gangwei[i].argName+"\">"+data.gangwei[i].argName+"</option>");
							}
							for (var i = 0; i < data.quyu.length; i++) {//大区
								$("#quyu").append("<option value=\""+data.quyu[i].argValue+"\">"+data.quyu[i].argName+"</option>");
							}
							for (var i = 0; i < data.xz.length; i++) {//小组
								$("#xz").append("<option value=\""+data.xz[i].argName+"\">"+data.xz[i].argName+"</option>");
							}
							
						}
// 							alertInfo("下载成功");
					},error:function(){
						//展示错误提示的弹框
						alertInfo("连接超时了");
					}
				});
   	   	
   	    });
   	    
   	 function openAccount(consumerId,beautifulyard,market,zongbuAddress,payDate){ //use factory 
   		 console.info(market+"sssssssss");
   		var obj=new Object(); 
   		obj.consumerId=consumerId; 
   		obj.beautifulyard=beautifulyard; 
   		obj.market=market;
   		obj.zongbuAddress=zongbuAddress;
   	    var   d=new  Date(payDate);     
   		obj.payDate=formatDate(d);
   		return obj; 
   		} 
   	 
   	function   formatDate(now)   {     
        var   year=now.getFullYear();     
        var   month=now.getMonth()+1;     
        var   date=now.getDate();     
        var   hour=now.getHours();     
        var   minute=now.getMinutes();     
        var   second=now.getSeconds();     
        return   year+"-"+month+"-"+date;     
        }     
   	
   	    </script>
	</body>
</html>