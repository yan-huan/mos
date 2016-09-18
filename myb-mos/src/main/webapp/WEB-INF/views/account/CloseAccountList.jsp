<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>MOS-美业邦</title>

		<!-- Bootstrap -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/back-style.css" rel="stylesheet">
		<link href="../css/dashboard.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="../css/calendar/jquery.datetimepicker.css"/>
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
		
		<script type="text/javascript">
		
		$(function(){
			$("#searchBeautiful").click(function(){
				
				if(Validator.Validate(document.getElementById('yanzheng'),3)){
				$.ajax({
	    				type:"POST",
	    				dataType:"json",
	    				data:{"mobile":$(".mobile").val()},
	    				url:"../Account/findByBeautifulId.jhtml?finance=${finance}",
	    				success:function(data){
	    					console.info(data);
	    					if(data != "-1"){
	    						$("#searchContent").html("");
	    						var str="";
	    						for (var s = 0; s <data.length; s++) {
	    						str+="<tr>"
    							if(data[s].finance == 1){
    	    					str+="<td><a href=\"../Account/index.jhtml?type=2&finance=1&accountId="+data[s].accountId+"\" id=\"beautifulName\">"+data[s].beautifulyard+"</a></td>";
    	    						}
   	    						if(data[s].finance != 1){
   	    						str+="<td ><a href=\"../Account/index.jhtml?type=2&accountId="+data[s].accountId+"\" id=\"beautifulName\">"+data[s].beautifulyard+"</a></td>";
   	    						}
	    						
	    						str+="<td id=\"province\">"+data[s].provinceName+"</td>";
	    						str+="<td id=\"city\">"+data[s].cityName+"</td>";
	    						str+="<td id=\"mobile\">"+data[s].openNumber+"</td>";
	    						str+="<td id=\"openCount\">"+data[s].shopCount+"</td>";
	    						str+="<td id=\"payDate\">"+(data[s].payDate).split(" ")[0]+"</td>";
	    						str+="<td id=\"updateDate\">"+(data[s].updateDate).split(" ")[0]+"</td>";
	    						str+="<td id=\"sellPerson\">"+data[s].market+"</td>";
	    						if(data[s].isAddAccount == 1 && data[s].finance != 1){
	    							
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data[s].finance+"&accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">查看合同</a></td>";	
	    						}if(data[s].isAddAccount == 1 && data[s].finance ==1){
	    							/*财务看的  */
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data[s].finance+"&accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">查看合同</a></td>";	
	    						}
	    						if(data[s].isAddAccount == 2 ){
	    							str+="<td><a href=\"../utils/contractSave.jhtml?accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">添加合同</a></td>";	
	    						}
	    						//样咧
// 	    						str+="<td><a href=\"../Account/index.jhtml?type=2&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">查看</a></td>";
	    						
	    						console.info(data[s].approvalStatus+"审批状态");
	    						//审批状态
 	    						//1未审批，2审批通过，3审批未通过
 	    						console.info("审批状态"+data[s].approvalStatus);
	    						console.info("合同"+data[s].isAddAccount);
								if(data[s].approvalStatus == 1 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-normal\">待审批</td>";
								}
								if(data[s].approvalStatus == 4 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-normal\">待审批</td>";
								}
								if(data[s].approvalStatus == 2 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-success\">已开通</td>";
								}
								if(data[s].approvalStatus == 3 && data[s].isAddAccount != 2){
									str+="<td class=\"text-status-danger\">退回</td>";
								}
								if(data[s].isAddAccount == 2){
									str+="<td class=\"text-status-danger\">请添加合同</td>";
								}
	    						str+="<td ><a href=\"../Account/closeAccount.jhtml?type=1&mobile="+data[s].openNumber+"\">关闭</a></td>";
	    						str+="</tr>";
	    						}
	    						$("#allData").html(str);
	    						$("#allpage").html("");
	    						
	    					}else  {
	    						alertInfo("不存在当前手机号的美容院");
	    					}
	    					
	    				},error:function(){
	    					//展示错误提示的弹框
	    					alertInfo("连接超时了");
	    				}
	    			});
				}
				
			});
			
			//saas关闭账号
			$("#saas").click(function(){
				
			});
			
		});
		
		function closeAccount(mobile){
			$.ajax({
				type:"GET",
				dataType:"json",
				data:{"mobile":mobile,"type":"1"},
				url:"../Account/closeAccount.jhtml",
				success:function(data){
					if(data=="ygb"){
						alertInfo("此账号已关闭");
					}else{
						alertInfo("操作失败");
					}
				},error:function(){
					alertInfo("连接超时");
				}
			});
		}
		</script>
		
	</head>
	<body>
		<jsp:include page="../menu/header.jsp"></jsp:include>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<jsp:include page="../menu/headerNext.jsp"></jsp:include>
					<div class="col-lg-offset-2 main">
					<h3 class="page-header">关闭账号</h3>
						
						<div class="row head">
							<div class="col-md-8">
							<form id="yanzheng">
								<table class="table-nobordered">
									<tbody><tr>
										<td>
											<input type="text" class="form-control mobile"  placeholder="手机号" dataType="Mobile" msg="请输入正确手机号">
										</td>
										<td><a href="javascript:void(0)" id="searchBeautiful" class="btn btn-info btn-sm">查询</a></td>
										
										<td>
											<input type="text" class="form-control mobile"  placeholder="手机号" >
										</td>
										<td><a href="javascript:void(0)" id="saas" class="btn btn-info btn-sm">saas账号关闭</a></td>
									</tr>
								</tbody>
								</table>
								</form>
							</div>
						</div>
						<br>
						<table class="table table-striped table-bordered " style="margin-bottom: 0px;">
							<thead>
								<tr>
									<th>美容院名称</th>
									<th>省份</th>
									<th>城市</th>
									<th>老板手机号</th>
									<th>店数</th>
									<th>付款日期</th>
									<th>开通日期</th>
									<th>销售</th>
									<th>操作</th>
									<th>审批状态</th>
									<th>关闭账号</th>
								</tr>
							</thead>
								<tbody id="allData">
						      </tbody>
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
	</body>
</html>