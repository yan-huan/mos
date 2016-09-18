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
		<link href="../css/dashboard.css" rel="stylesheet">
    	<link href="../css/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
   	    <script type="text/javascript">
   	    var isqudao = "${isqudao}"
   	    $(function(){
   	    });
   	    
   	    function saveContract(type){
   	    		
   	    		var tuihui = "${tuihui}";
   	    		var zhifu = $("#zhifu").val();
   	    		console.info($("#zhifu").val());
   	    		if(zhifu == 3 || zhifu == 4){
   	    		    $("#zfdh").removeAttr("dataType");
   	    		}else {
   	    		    $("#zfdh").attr("dataType","Require");
   	    		}
   	    		if (zhifu != 4) {
   	    			$("#zfyhm").removeAttr("dataType");
   	    		}else {
   	    			$("#zfyhm").attr("dataType","Require");
   	    		}
   	    		
   	    		
   	    		//验证表单
   	    		Validator.Validate(document.getElementById('demo'),3);
   	    		if(Validator.Validate(document.getElementById('demo'),3)){
   	    			$(".btn-save").each(function(){
   	    			$(this).attr("disabled",true);
   	    			});
	    			var sell = $(".autocomplete-input").val();
	   	    		var inp1 = sell.split("(")[1];
					var inp2= inp1.split(")")[0];
	   	    		var shopId = $("#shopId").val();
	   	    		if (type=="delay" && isqudao == "isqudao") {
	   	    			var url="../contract/saveContract.jhtml?isqudao=isqudao&shopId="+shopId+"&type=delay&sell="+inp2+"&th="+tuihui;
	   	    		}
	   	    		if (type!="delay" && isqudao == "isqudao") {
	   	    			var url="../contract/saveContract.jhtml?isqudao=isqudao&shopId="+shopId+"&type=delay&sell="+inp2+"&th="+tuihui;
	   	    		}
					if (type=="delay" && isqudao != "isqudao") {
	   	    			var url="../contract/saveContract.jhtml?shopId="+shopId+"&type=delay&sell="+inp2+"&th="+tuihui;
	   	    		} else if (type!="delay" && isqudao != "isqudao"){
	   	    			var url="../contract/saveContract.jhtml?type=0&sell="+inp2+"&th="+tuihui;
	   	    		}
   	    			//表单提交信息
   	    			$.ajax({
   	    				type:"POST",
   	    				dataType:"json",
   	    				data:$("#demo").serialize(),
   	    				url:url,
   	    				success:function(data){
   	    						$(".btn-save").each(function(){
   	    	   	    				$(this).attr("disabled",false);
   	    	   	    			});
   	    					if (data == "5") {
   	    						alertInfo("当前账号的店没有加全呢");
   	    						return false;
   	    					}
   	    					if(data == "1"){
	   	    					//展示提示的弹框
	   	    					alertInfoAndHref("合同提交成功，等待财务审核!","../Account/showListOpenAccount.jhtml");
   	    					} else if (data=="6"){
   	    						alertInfoAndHref("合同提交成功，等待财务审核!","../Account/showListOpenAccount.jhtml");
   	    					}else   if (data=="189"){
   	    						alertInfoAndHref("合同提交成功，等待财务审核!","../channelInfo/allOpenAccountList.jhtml");
   	    					} else   if (data=="689"){
   	    						alertInfoAndHref("合同提交成功，等待财务审核!","../channelInfo/allOpenAccountList.jhtml");
   	    					} else {
   	    						//展示提示的弹框
   	    						alertInfo("保存信息失败了");
   	    					}
   	    					
   	    				},error:function(){
   	    						$(".btn-save").each(function(){
   	    	   	    			$(this).attr("disabled",false);
   	    	   	    			});
   	    					//展示提示的弹框
   	    					alertInfo("连接超时了");
   	    				}
   	    			});
   	    		}else{
   	    				$(".btn-save").each(function(){
   	   	    			$(this).attr("disabled",false);
   	   	    			});
   	    			return false;
   	    		}
   	    }
   	 </script>
   	    
	</head>
	<body>
		<!--包含左侧菜单  -->
		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<!--包含左侧菜单  -->
					<div class="col-lg-offset-2 main">

						<h3 class="page-header">新增合同</h3>
							<form class="form-horizontal" id="demo" name="contract"  method="POST" >
							<!--form表单上部分start  -->
							<table style="width: 100%;" class="table table-bordered">
								<tbody><tr>
								<input type="hidden" name="accountId"  value="${openAccount.accountId}" />
								<input type="hidden" id="shopId"  value="${shopId}" />
								<c:if test="${contract.contractId ne null}">
									<input type="hidden" name="contractId"  value="${contract.contractId}">
								</c:if>
									<th width="20%">合同编号</th>
									<td width="30%">
										<input type="text" name="contractCode"maxlength="80" value="${contract.contractCode}" class="form-control" placeholder="" dataType="Require" msg="请输入正确的合同编号"> 
									</td>
									<th width="20%">公司名称</th>
									<td width="30%">
										<input type="text" name="companyName" maxlength="50" value="${openAccount.beautifulyard}" class="form-control" placeholder="" dataType="Require" msg="请输入合法的公司名称">
									</td>
								</tr>
								<tr>
									<th>甲方</th>
									<td>
										<input type="text" name="contractBody" maxlength="30" class="form-control" placeholder="" value="${contract.contractBody}" dataType="Require" msg="请输入甲方名称">
									</td>
									<th>老板姓名</th>
									<td>
										<input type="text" name="bossName" maxlength="10" class="form-control" value="${contract.bossName}"  placeholder="" dataType="Require" msg="请输入姓名">
									</td>
								</tr>
								<tr>
									<th>签约代表</th>
									<td>
									<div id="demo" style="width: 100%;height: 10px;">
								        <div class="wrapper" style="width: 100%">
								            <div id="search-form" ></div>
								        </div>
								    </div>
										
									</td>
									<th>开通账户</th>
									<td>
										<input type="text" name="openNumber" readonly="readonly" class="form-control" value="${openAccount.openNumber}" placeholder="" dataType="Require" msg="请输入开通的账户">
									</td>
								</tr>
								<tr>
									<th>手机号</th>
									<td>
										<input type="text" name="bossAccount" id="xiaoshouMobile" value="${contract.bossAccount}" class="form-control" placeholder="" dataType="Mobile" msg="请输入合法手机号" maxlength="11">
									</td>
									<th>店面数量</th>
									<td>
										<input type="text" class="form-control" readonly="readonly" value="${openAccount.shopCount}" name="shopCount" placeholder="" dataType="Number" msg="请输入数字类型">
									</td>
								</tr>
								<tr>
									<th>签约日期</th>
									<td>
										<input type="text" name="beginDate" placeholder="" class="form_datetime form-control" id="beginDate"  dataType="Require" msg="请输入合法日期"/>
									</td>
									<th>合同金额</th>
									<td>
										<input type="text" name="contractMoney" value="${contract.contractMoney}" class="form-control" placeholder="" dataType="Number" msg="请输入数字类型金额">
									</td>
								</tr>
								<tr>
									<th>备注</th>
									<td colspan="3">
										<input type="text" name="remark" class="form-control" placeholder="" value="${contract.remark}">
									</td>
								</tr>
							</tbody>
						</table>
						<!--form表单上部分end  -->
						<!--form表单下部分Start  -->
						<c:if test="${isqudao ne 'isqudao'}">
							<table class="table table-bordered">
								<tbody><tr>
									<th width="20%">支付日期</th>
									<td width="30%">
										<input type="text"  placeholder="" class="form_datetime form-control" name="payDate" dataType="Require" msg="请输入合法支付日期" value="${contract.payDate}">
									</td>
									<th width="20%">实际支付金额</th>
									<td width="30%">
									
										<input type="text" name="payMoney" class="form-control" placeholder="这里是财务填写" readonly="readonly"  value="${contract.payMoney}">
									
									</td>
								</tr>
								<tr>
									<th>支付账户名</th>
									<td>
										<input type="text" id="zfyhm" name="payAccountName" value="${contract.payAccountName}" class="form-control" placeholder="" dataType="Require" msg="请输入支付账户名">
									</td>
									<th>支付单号</th>
									<td>
										<input type="text" id="zfdh" name="payNumber" value="${contract.payNumber}" class="form-control" placeholder="" dataType="Require" msg="请输入支付单号">
									</td>
								</tr>
								<tr>
									<th>支付方式</th>
									<td>
									
										<select class="dropdown form-control" name="payType" id="zhifu">
										
											<option value="1" <c:if test="${contract.payType eq 1}"> selected="selected"</c:if> >支付宝</option>
											<option value="2" <c:if test="${contract.payType eq 2}"> selected="selected"</c:if>>微信</option>
											<option value="3" <c:if test="${contract.payType eq 3}"> selected="selected"</c:if>>刷卡</option>
											<option value="4" <c:if test="${contract.payType eq 4}"> selected="selected"</c:if>>银行转账</option>
										</select>
									
									</td>
									<th>付款备注</th>
									<td><input type="hidden" name="contractAnnex" id="filePath" value="${contract.contractAnnex}"/>
										<input type="text" name="payRemark" class="form-control" placeholder="" value="${contract.payRemark}"  maxlength="99">
									</td>
								</tr>
							</tbody>
						</table>
					</c:if>
						<!--form表单下部分end  -->
							<div class="form-group">
								<div class="col-sm-offset-7 col-sm-10 col-sm-5" style="float: left; top: 120px">
								<c:if test="${type eq 'delay' }">
									<button type="button" class="btn btn-save pull-right" onclick="saveContract('delay')">续签合同</button>
								</c:if>
								<c:if test="${type ne 'delay' }">
									<button type="button" class="btn btn-save pull-right"  onclick="saveContract('0')">提交</button>
								</c:if>
								</div>
							</div>
							
						</form>
						
						<iframe name="ajaxUpload" style="display:none" id='hiddenIFrame'></iframe>
							<form name="from1" id="from1" method="post" action="../contract/fileUpload.jhtml" enctype="multipart/form-data" target="ajaxUpload">
								<table class="table table-bordered" style="margin-bottom: 100px">
									<tr>
										<th width="20%">附件 </th>
										<td width="60%">
											<input type="file" name="myfile" id="myfile" />
											<input type="text" name="contractId" value="${contract.contractId}"/>
										</td>
										<td>
											<font color="red" style="float: left;">小于10M附件</font>&nbsp;&nbsp;
											<input type="submit" class="btn btn-primary btn-xs" value="上传" id="filebtn">
										</td>
									</tr>
								</table>
							</form>
					</div>
				</div>
			</div>
			
		</section>
		<!--/#contact-page-->

		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
   	    <script src="../js/autocomplete/autocompleteSell.js"></script>
   	    <script type="text/javascript">
   		
  		//日期格式化插件
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
   	    	var payDate = "${openAccount.payDate}";
   	    	if (payDate != null) {
   	    	payDate.split(' ')[0];
   	    	$("#beginDate").val(payDate.split(' ')[0]);
   	    	}
   	    	$("#hiddenIFrame").load(function(){
   	    		    var wnd = this.contentWindow;
   	    		    var str = $(wnd.document.body).html();
   	    		$("#result").remove();
   	    		if($(wnd.document.body).find("#siz").html() == "0") {
   	    			alertInfo("请选择文件");
	   	    		//展示错误提示的弹框
   	    			return false;
   	    		}
   	    		if($(wnd.document.body).find("#sizMax").html() == "0") {
   	    			alertInfo("请上传小于10M的合同");
	   	    		//展示错误提示的弹框
   	    			return false;
   	    		}
   	    		
   	    		if($(wnd.document.body).find("#www").html() == "success") {
   	    			console.info($(wnd.document.body).find("#filePath").html());
   	    			$("#filePath").val($(wnd.document.body).find("#filePath").html());
   	    			alertInfo("上传成功了");
   	    			$("#myfile").before("<span style='color: green;' class='pull-right' id='result'>上传成功</span>");
   	    			
   	    		}else {
   	    			alertInfo("上传失败了");
   	    			$("#myfile").before("<span style='color: red;' class='pull-right' id='result'>上传失败</span>");
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
 	   				width: 414,
 	   				height: 34,
 	   				onSubmit: function(text){
 	   					
 	   					var inp = $(".autocomplete-input").val();
 	   					if (inp == null ||$.trim(inp) == ""){
 	   					//展示错误提示的弹框
 	   					alertInfo("请输入销售名称");
 	   						return false;
 	   					}
 	   					
 	   				}
 	   			});
 	   			var market = "${openAccount.market}";
 	   	    	$(".autocomplete-input").val(market);
	 	   	    var inp1 = market.split("(")[1];
				var inp2= inp1.split(")")[0];
 	   	    	$("#xiaoshouMobile").val(inp2);
 	   	    	$(".autocomplete-input").attr("datatype","Require").attr("msg","请输入签约代表	").css("width","100%");
 	   	    	$(".autocomplete-container").css("width","100%");
   	   	    	
   	    });
   	    
   	    
   	    </script>
</body></html>

