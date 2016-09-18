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
		<link rel="stylesheet" type="text/css" href="../css/calendar/jquery.datetimepicker.css"/>
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
		
		<script type="text/javascript">
		$(function(){
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
						<h3 class="page-header">渠道信息添加</h3>
						<form id="formChannel" name="channelVO" role="form" class="form-horizontal"  method="post">
							<table class="table table-bordered" style="width: 40%;">
								<tbody><tr>
									<th width="30%">公司名称 <span>*</span>
									</th><td>
									<c:if test="${channelInfo.channelId ne 0 and channelInfo.channelId ne null}">
										<input type="hidden" value="${channelInfo.channelId}" name="channelId" class="form-control">
									</c:if>
										<input type="text" value="${channelInfo.companyName}" class="form-control" maxlength="50" name="companyName" placeholder="公司名称" dataType="Require" msg="请输入公司名称">
									</td>
								</tr>
								<tr>
									<th width="30%">公司地址 <span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.companyAddress}" class="form-control" maxlength="50" name="companyAddress" placeholder="公司地址"   dataType="Require" msg="请输入公司地址">
									</td>
								</tr>
								<tr>
									<th width="30%">负责人 <span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.personInCharge}" class="form-control" name="personInCharge" placeholder="负责人"  dataType="Require" msg="请输入负责人">
									</td>
								</tr>
								<tr>
									<th width="30%">联系电话 <span></span></th>
									<td>
										<input type="text" value="${channelInfo.phone}" maxlength="11" class=" form-control" name="phone" placeholder="联系电话"  >
									</td>
								</tr>
								<tr>
								<th width="30%">渠道代表<span>*</span></th>
									<td>
									<div id="demo" style="width: 100%;height: 36px;">
								        <div class="">
								            <div id="search-form"  style="width: 100%;" ></div>
								            <input type="hidden"  name="salesName" id="salesName"/>
								        </div>
								    </div>
									</td>
								</tr>
								<tr>
									<th width="30%">合同金额<span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.contractMoney}" maxlength="10" class=" form-control" name="contractMoney" placeholder="首次交款 "  dataType="Require" msg="请输入首次交款 ">
									</td>
								</tr>
								<tr>
									<th width="30%">保证金 <span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.marginMoney}" maxlength="10" class=" form-control" name="marginMoney" placeholder="冻结金额"  dataType="Require" msg="请输入冻结金额">
									</td>
								</tr>
								<tr>
									<th width="30%">预存款 <span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.depositPaymentMoney}" maxlength="10" class=" form-control" name="depositPaymentMoney" placeholder="预存款"  dataType="Require" msg="请输入预存款">
									</td>
								</tr>
								<tr>
									<th width="30%">账户余额<span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.readyDepositMoney}" maxlength="10" class=" form-control" name="readyDepositMoney" placeholder="账户余额"  dataType="Require" msg="请输入账户余额">
									</td>
								</tr>
								<tr>
									<th width="30%">折扣率 <span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.discountRate}" maxlength="3" class=" form-control" name="discountRate" placeholder="折扣率大于0小于100"  dataType="IntegerNum" msg="请输入合法折扣率大于0小于100">
									</td>
								</tr>
								<tr>
									<th width="30%">合同生效日期<span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.openTime}" class="datetimepicker form-control" name="openTime" placeholder="开始日期"  dataType="Require" msg="开始日期"/>
									</td>
								</tr>
								<tr>
									<th width="30%">合同到期日期<span>*</span></th>
									<td>
										<input type="text" value="${channelInfo.endTime}" class="datetimepicker form-control" name="endTime" placeholder="截止日期"  dataType="Require" msg="截止日期" />
									</td>
								</tr>
								<tr>
									<th width="30%">备注<span></span></th>
									<td>
										<input type="text" value="${channelInfo.remark}" class="form-control" name="remark" placeholder="备注"  />
									</td>
								</tr>
								<tr>
									<th width="30%"></th>
									<td>
										<a href="javascript:void(0)" id="saveChannel" class="btn btn-success btn-sm">保存</a>
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
   	    <script type="text/javascript">
   	    
   	    $(function(){
   	 	
   	   	   $("#saveChannel").click(function(){
   	   	   	$("#saveChannel").attr("disabled",true);

   	   		if(Validator.Validate(document.getElementById('formChannel'),3)){
	   	   	$("#saveChannel").attr("disabled",false);
			   	 $.ajax({
						type:"POST",
						dataType:"json",
						data:$("#formChannel").serialize(),
						url:"../channelInfo/saveChannelInfo.jhtml",
						success:function(data){
							$("#saveChannel").attr("disabled",false);
							if(data == "1"){
								alertInfoAndHref("保存成功了","../channelInfo/searchChannelList.jhtml");
							}else{
								alertInfo("保存失败了，请联系大为先生");
							}
							
						},error:function(){
							$("#saveChannel").attr("disabled",false);
							//展示错误提示的弹框
							alertInfo("连接超时了");
						}
			   	   });
	   	   	}else{
	   	   		$("#saveChannel").attr("disabled",false);
	   	   		return false;
	   	   	}
   	   		
   	    });
   	   	   
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
	   						alertInfo("请输入渠道代表");
	   						return false;
	   					}
	   					
	   				}
	   			});
	   	    	
	   	  $(".autocomplete-input").attr("datatype","Require").attr("msg","请输入渠道代表").css("width","100%");
	   	  $(".autocomplete-container").css("width","100%");
	   	  var salesName = "${channelInfo.salesName}";
	   	  $(".autocomplete-input").val(salesName);
	   	  $("#salesName").val(salesName);
   	  });
   	    
   	    </script>
	</body>
</html>