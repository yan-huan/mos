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
   	    				url:"../Account/findByBeautifulId.jhtml",
   	    				success:function(data){
   	    					console.info(data);
   	    					if(data != "-1"){
   	    						$("#searchContent").html("");
   	    						var str="";
   	    						str+="<tr>"
   	    						str+="<td id=\"beautifulName\"></td>";
   	    						str+="<td id=\"province\"></td>";
   	    						str+="<td id=\"city\"></td>";
   	    						str+="<td id=\"mobile\"></td>";
   	    						str+="<td id=\"openCount\"></td>";
   	    						str+="<td id=\"payDate\"</td>";
   	    						str+="<td id=\"sellPerson\"></td>";
   	    						str+="<td><a href=\"../Account/index.jhtml?type=2&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">查看</a></td>";
   	    						str+="</tr>";
								$("#searchContent").append(str);
   	    						
   	    						$("#beautifulName").html(data.beautifulyard);
   	    						$("#province").html(data.provinceName);
   	    						$("#city").html(data.cityName);
   	    						$("#mobile").html(data.openNumber);
   	    						$("#openCount").html(data.shopCount);
   	    						console.info(222222222222);
   	    						$("#payDate").html((data.payDate).split(" ")[0]);
   	    						$("#sellPerson").html(data.market);
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
						<h3 class="page-header">账号查询</h3>
						<div class="row head">
							<div class="col-md-8">
							<form id="yanzheng">
								<table class="table-nobordered">
									<tbody><tr>
										<td>
											<input type="text" class="form-control mobile"  placeholder="手机号" dataType="Mobile" msg="请输入正确手机号">
										</td>
										<td><a href="javascript:void(0)" id="searchBeautiful" class="btn btn-info btn-sm">查询</a></td>
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
									<th>销售</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="searchContent">
								
								
							</tbody>
						</table>
						
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