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
				var sj0="";
				var sj1="";
				var accountName = $(".accountName").val();
				var dh = $(".dh").val();
				var mobile =$(".mobile").val();
				var beautifulName = $(".beautifulName").val();
				if (beautifulName !=""){
					sj0="beautifulName";
					sj1=beautifulName;
				}else if(accountName !=""&&dh==""&&mobile==""){
					sj0="accountName";
					sj1=accountName;
				}
				else if(accountName ==""&&dh!=""&&mobile==""){
					sj0="dh";
					sj1=dh;
				}
				else if(accountName ==""&&dh==""&&mobile!=""){
					sj0="mobile";
					sj1=mobile;
				} else {
					alertInfo("只能填写一项!<font color=\"red\" size=\"4\">下次可要记住了。</font>");
					return false;
				}
				if(Validator.Validate(document.getElementById('yanzheng'),3)){
				$.ajax({
	    				type:"POST",
	    				dataType:"json",
	    				url:"../Account/findByBeautifulId.jhtml?finance=${finance}"+"&"+sj0+"="+sj1,
	    				success:function(data){
	    					console.info(data);
	    					if(data != "-1"){
	    						$("#searchContent").html("");
	    						var str="";
	    						for (var s = 0; s <data.length; s++) {
	    						str+="<tr>"
    							if(data[s].finance == 1){
    	    					str+="<td><a href=\"../Account/index.jhtml?type=2&finance=1&accountId="+data[s].accountId+"\" id=\"beautifulName\" >"+data[s].beautifulyard+"</a></td>";
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
	    							
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data[s].finance+"&accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">查看合同</a>&nbsp;<a href=\"../ExceptionCompany/CompanyInfo.jhtml?accountId="+data[s].accountId+"\" target=\"_blank\" class=\"btn btn-xs btn-info\">修改美容院</a></td>";	
	    						}if(data[s].isAddAccount == 1 && data[s].finance ==1){
	    							/*财务看的  */
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data[s].finance+"&accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">查看合同</a>&nbsp;<a href=\"../ExceptionCompany/CompanyInfo.jhtml?accountId="+data[s].accountId+"\" target=\"_blank\" class=\"btn btn-xs btn-info\">修改美容院</a></td>";	
	    						}
	    						if(data[s].isAddAccount == 2 ){
	    							str+="<td><a href=\"../utils/contractSave.jhtml?accountId="+data[s].accountId+"\" class=\"btn btn-xs btn-info\">添加合同</a>&nbsp;<a href=\"../ExceptionCompany/CompanyInfo.jhtml?accountId="+data[s].accountId+"\" target=\"_blank\" class=\"btn btn-xs btn-info\">修改美容院</a></td>";	
	    						}
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
	    						str+="</tr>";
	    						}
	    						$("#allData").html(str);
	    						$("#allpage").html("");
	    					}else  {
	    						alertInfo("不存在当前手机号的美容院！");
	    					}
	    					
	    				},error:function(){
	    					alertInfo("连接超时了");
	    				}
	    			});
				}
				
			});
			
		});
		</script>
		
	</head>
	<body>
		<jsp:include page="../menu/header.jsp"></jsp:include>
		<section id="contact-page">
			<div class="container1">
				<div class="row">
					<jsp:include page="../menu/headerNext.jsp"></jsp:include>
					<div class="col-lg-offset-2 main">
					  <h3 class="page-header">异常账号处理</h3>
						<div class="row head">
							<div class="col-md-8">
							<form id="yanzheng">
								<table class="table-nobordered">
									<tbody><tr>
										<td>
											<input type="text" class="form-control beautifulName"  placeholder="美容院名称" >
										</td>
										<td>
											<input type="text" class="form-control mobile"  placeholder="手机号" >
										</td>
										<td>
											<input type="text" class="form-control accountName"  placeholder="账户名称" >
										</td>
										<td>
											<input type="text" class="form-control dh"  placeholder="单号" >
										</td>
										<td style="width: 243px;"><a href="javascript:void(0)" id="searchBeautiful" class="btn btn-info btn-sm">查询</a>&nbsp;<a href="../ExceptionCompany/showExceptionAccountList.jhtml?pageIndex=1" class="btn btn-info btn-sm">点击查询异常账号列表</a></td>&nbsp;<font color="red">查询条件必须唯一</font>
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
								</tr>
							</thead>
								<tbody id="allData"></tbody>
							<tbody id="searchContent"></tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
	</body>
</html>