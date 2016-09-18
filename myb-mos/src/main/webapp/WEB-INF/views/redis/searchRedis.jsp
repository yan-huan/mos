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
				
				var redisKey = $(".key").val();
				if (redisKey == "") {
					
					alertInfo("请输入key");
					return false;
				} else {
					
					$.ajax({
						type:"POST",
						data:{"redisKey":redisKey},
						dataType:"text",
						url:"../redis/getRedisContent.jhtml",
						success:function(data){
							if (data == "0") {
								alertInfo("不存在当前的key");
							} else {
								
							$(".redisContent").html(data);
							}
						},error:function(){
							//展示错误提示的弹框
							alertInfo("连接超时了");
						}
						
					});
				}
			});
			
			$("#clearRedisKey").click(function(){
				var redisKey = $(".key").val();
				if (redisKey == "") {
					
					alertInfo("请输入key");
					return false;
				} else {
					
					$.ajax({
						type:"POST",
						data:{"redisKey":redisKey},
						dataType:"text",
						url:"../redis/clearRedisKey.jhtml",
						success:function(data){
							if (data == "0") {
								alertInfo("清空失败");
							} else if (data == "1"){
								alertInfo("清空成功");
							$(".redisContent").html("");
							}
						},error:function(){
							//展示错误提示的弹框
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
					<h3 class="page-header">缓存查询</h3>
						<div class="row head">
							<div class="col-md-8">
								<table class="table-nobordered">
									<tbody>
									  <tr>
										<td>
											<input type="text" class="form-control key"  placeholder="查询Redis的key" >
										</td>
										<td><a href="javascript:void(0)" id="searchBeautiful" class="btn btn-info btn-sm">查询</a></td>
										<td><a href="javascript:void(0)" id="clearRedisKey" class="btn btn-info btn-sm">清空当前key的内容</a></td>
									   </tr>
									</tbody>
								</table>
								<table class="redisContent" style="margin-bottom: 0px;">
								
								</table>
								
							</div>
						</div>
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