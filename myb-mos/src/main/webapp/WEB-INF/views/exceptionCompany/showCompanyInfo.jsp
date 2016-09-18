<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
   	    				url:"../ExceptionCompany/updateCompanyInfo.jhtml",
   	    				success:function(data){
   	    					$("#base-save").attr("disabled",false);
   	    					if(data == "1"){
   	    						alertInfo1("修改成功了");
   	    						
   	    					}else if(data == "0")  {
   	    						alertInfo("失败了");
   	    					}else if(data == "3"){
   	    						alertInfo("修改的手机号在系统中已存在！");
   	    					}
   	    				},error:function(){
   	    					$("#base-save").attr("disabled",false);
   	    					alertInfo("连接超时了");
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
    						$("#cityCode").html("");
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
						<h3 class="page-header">修改账号</h3>
						<form id="saveAccount" name="openAccount" role="form" class="form-horizontal"  method="post">
						<input type="hidden" class="form-control" name="consumerId" id="consumerId">
						<input type="hidden" name="isChannel" value="${isqudao}" id="qudao"/>
						<input type="hidden" name="accountId" value="${openAccount.accountId}" />
							<table class="table table-bordered" style="width: 40%;">
								<tbody>
								<tr>
									<th width="30%">美容院名称 <span>*</span>
									</th><td>
										<input type="text" class="form-control" maxlength="50" value="${openAccount.beautifulyard}" name="beautifulyard" id="beautifulyard" placeholder="美容院名称" dataType="Require" msg="请输入美容院名称">
									</td>
								</tr>
								<tr>
									<th width="30%">开通账号 <span>*</span></th>
									<td>
										<input type="text" maxlength="11" name="openNumber" value="${openAccount.openNumber}" placeholder="手机号" id="openNumber"  class="form-control" dataType="Mobile" msg="请输入正确手机号">
									</td>
								</tr>
								<tr>
									<th width="30%">购买店数 <span>*</span></th>
									<td>
										<input type="text" class="form-control" name="shopCount" value="${openAccount.shopCount}" id="shopCount" placeholder="购买店数" maxlength="3" dataType="Number" msg="请输入数字">
									</td>
								</tr>
								<tr>
									<th width="30%">付款日期 <span>*</span></th>
									<td>
										<input type="text" class="form_datetime form-control"  value=<fmt:formatDate value="${openAccount.payDate}" type="date" dateStyle="default"/> name="payDate" id="payDate" placeholder="付款日期" dataType="Require" msg="请输入付款日期 ">
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
											
													<option value="${addressAreaDefParent.code}"  <c:if test="${addressAreaDefParent.code eq openAccount.province}">selected="selected"</c:if>>${addressAreaDefParent.objName}</option>
											
											</c:forEach>
									</select>
									
									<select class="select form-control" name="city" id="cityCode"  style="width: 48%;float: right;" dataType="Require" msg="请选择城市">
										<option value="">请选择城市</option>
										<c:forEach items="${cityList}" var="cityList">
											<option  value="${cityList.code}" <c:if test="${cityList.code eq openAccount.city}">selected="selected"</c:if>>${cityList.objName}</option>
										</c:forEach>
									</select>
									</td>
								</tr>
								<tr>
									<th width="30%">总部地址<span>*</span></th>
									<td>
										<input type="text" name="zongbuAddress" maxlength="80" id="zongbuAddress" value="${openAccount.zongbuAddress}"  class="form-control required" placeholder="总部地址" dataType="Require" msg="请输入总部地址 ">
									</td>
								</tr>
								<tr>
									<th width="30%">备注</th>
									<td>
										<input type="text"  class="form-control" value="${openAccount.remark}" name="remark" id="remark" placeholder="备注" >
									</td>
								</tr>
								<tr>
									<th width="30%">修改账号的备注</th>
									<td>
										<input type="text"  class="form-control" value="${openAccount.operationReason}" name="operationReason" id="operationReason" placeholder="修改账号的备注" >
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
		  $(".autocomplete-input").val("${openAccount.market}");
		  
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