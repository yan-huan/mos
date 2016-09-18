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
	    			
	    			$.ajax({
   	    				type:"POST",
   	    				dataType:"json",
   	    				data:$("#saveAccount").serialize(),
   	    				url:"../Account/saveAccount.jhtml?sell="+inp2+"&channelId="+channelId,
   	    				success:function(data){
   	    					console.info(data);
   	    					$("#base-save").attr("disabled",false);
   	    					if(data == "1"){
   	    						$("#showErr").hide();
   	    						if(isqudao=="isqudao"){
   	    							$("#saveAccount").attr("action","../Account/index.jhtml?isqudao=isqudao");
   	    		    			}else{
   	    		    				$("#saveAccount").attr("action","../Account/index.jhtml");
   	    		    			}
   	    						
   	    						$("#saveAccount").submit();
   	    						
   	    					}else if(data == "3")  {
   	    						console.info("手机号重复");
   	    						$("#showErr").html("开通账号已重复(手机号)").show();
   	    					} else if(data == "5"){
   	    						$("#showErr").html("此账号已存在").show();
   	    					} else if (data == "6"){
   	    						$("#showErr").html("保存日志信息失败了").show();
   	    					} else if (data == "7"){
   	    						$("#showErr").html("手机号已存在了").show();
   	    					} else if (data == "11"){
   	    						$("#showErr").html("手机号格式不正确").show();
   	    					}else if (data == "12"){
   	    						$("#showErr").html("美容院格式不正确").show();
   	    					}else if (data == "13"){
   	    						$("#showErr").html("开店数量格式不正确").show();
   	    					}else if (data == "14"){
   	    						$("#showErr").html("付款日期格式不正确").show();
   	    					}else if (data == "15"){
   	    						$("#showErr").html("销售名称格式不正确").show();
   	    					}else if (data == "16"){
   	    						$("#showErr").html("客服电话格式不正确").show();
   	    					}else if (data == "17"){
   	    						$("#showErr").html("城市格式不正确").show();
   	    					}else if (data == "18"){
   	    						$("#showErr").html("省份格式不正确").show();
   	    					}else if (data == "19"){
   	    						$("#showErr").html("总部地址格式不正确").show();
   	    					}else{
   	    						$("#showErr").html("保存信息失败了").show();
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
		/*搜索城市列表  */
		function searchCity(){
			$(".cityList").remove();
			$("#provinceName").val($("#provinceCode :selected").html());
			$.ajax({
    				type:"POST",
    				dataType:"json",
    				data:{"parentCode":$("#provinceCode").val()},
    				url:"../utils/getCityList.jhtml",
    				success:function(data){
    					
    					if(data != "0"){
    						for(var s=0;s<data.length;s++){
    						$("#cityCode").append("<option class=\"cityList\" value='"+data[s].code+"'>"+data[s].objName+"</option>");
    						}
    					}else  {
    						//展示错误提示的弹框
    						alertInfo("调取城市失败了");
    					}
    				},error:function(){
    					$("#base-save").attr("disabled",false);
    					//展示错误提示的弹框
    					alertInfo("连接超时了");
    				}
    			});
		}
   	    </script>
	</head>

	<body>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<div class="col-lg-offset-2 main">
						<h3 class="page-header">创建账号</h3>
						<form id="saveAccount" name="openAccount" role="form" class="form-horizontal"  method="post">
						<input type="hidden" class="form-control" name="consumerId" id="consumerId">
						<input type="hidden" name="isChannel" value="${isqudao}" id="qudao"/>
							<table class="table table-bordered" style="width: 40%;">
								<tbody>
								<tr>
									<th width="30%" style="color: blue">关联CRM客户名称 <span></span>
									<td>
										<div id="demo1" style="width: 100%;height: 36px;">
									        <div class="">
									            <div id="search-form1"  style="width: 100%;"></div>
									        </div>
									    </div>
									</td>
								</tr>
								<tr>
									<th width="30%">美容院名称 <span>*</span>
									</th><td>
										<input type="text" class="form-control" maxlength="50" name="beautifulyard" id="beautifulyard" placeholder="美容院名称" dataType="Require" msg="请输入美容院名称">
									</td>
								</tr>
								<tr>
									<th width="30%">开通账号 <span>*</span></th>
									<td>
										<input type="text" maxlength="11" name="openNumber" placeholder="手机号" id="openNumber"  class="form-control" dataType="Mobile" msg="请输入正确手机号">
									</td>
								</tr>
								<tr>
									<th width="30%">购买店数 <span>*</span></th>
									<td>
										<input type="text" class="form-control" name="shopCount" id="shopCount" placeholder="购买店数" maxlength="3" dataType="Number" msg="请输入数字">
									</td>
								</tr>
								<tr>
									<th width="30%">付款日期 <span>*</span></th>
									<td>
										<input type="text" class="form_datetime form-control" name="payDate" id="payDate" placeholder="付款日期" dataType="Require" msg="请输入付款日期 ">
									</td>
								</tr>
								<tr>
									<th width="30%">销售 <span>*</span></th>
									<td>
									<div id="demo" style="width: 100%;height: 36px;">
								        <div class="">
								            <div id="search-form"  style="width: 100%;"></div>
								        </div>
								    </div>
									</td>
								</tr>
								<tr>
									<th width="30%">省市区 <span>*</span></th>
									<td>
									<select class="select form-control" name="province"  onchange="searchCity()" id="provinceCode" style="width: 48%;float: left;" dataType="Require" msg="请选择省份">
											<option value="">请选择省份</option>
											<c:forEach items="${addressAreaDefParent}" var="addressAreaDefParent">
													<option value="${addressAreaDefParent.code}">${addressAreaDefParent.objName}</option>
											</c:forEach>
									</select>
									
									<select class="select form-control" name="city" id="cityCode"  style="width: 48%;float: right;" dataType="Require" msg="请选择城市">
										<option value="">请选择城市</option>
									</select>
									</td>
								</tr>
								<tr>
									<th width="30%">总部地址<span>*</span></th>
									<td>
										<input type="text" name="zongbuAddress" maxlength="80" id="zongbuAddress"  class="form-control required" placeholder="总部地址" dataType="Require" msg="请输入总部地址 ">
									</td>
								</tr>
								<tr>
									<th width="30%">备注</th>
									<td>
										<input type="text"  class="form-control" name="remark" id="remark" placeholder="备注" >
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
   	   	  $(".autocomplete-input").attr("datatype","Require").attr("msg","请输入签约代表").css("width","100%");
   	   	  $(".autocomplete-container").css("width","100%");
   	   	
   	       var arr1 = new Array();
	   	   var arr2 = new Array();
			//CRM
			
			window.onload =function (){
				
				$.ajax({
					url:"../crm/consumer.jhtml",
					type:"GET",
					dataType:"json",
					success:function(data){
						if (data != "0") {
	  					for(var s=0;s<data.length;s++){
	  						arr2.push(openAccount(data[s].consumerId,data[s].beautifulyard,data[s].market,data[s].zongbuAddress));
	  						arr1.push(data[s].beautifulyard+"("+data[s].consumerId+")");
	  					}

	  				  $('#search-form1').autocomplete1(arr2,{
	  					hints: arr1,
	  					height: 35,
	  					onSubmit: function(arr2){
	  						
	  						var inp = $(".autocomplete-input1").val();
	  						if (inp == null ||$.trim(inp) == ""){
	  							//展示错误提示的弹框
	  							alertInfo("请输入销售名称");
	  							return false;
	  						}
	  						
	  					}
	  				});
	  				  
						}
						$(".autocomplete-input1").focus();
					},error:function(){
							//展示错误提示的弹框
							alertInfo("连接超时了");
					}
					
				});
				
			}
   	    });
   	    
   	 function openAccount(consumerId,beautifulyard,market,zongbuAddress,payDate){ //use factory 
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