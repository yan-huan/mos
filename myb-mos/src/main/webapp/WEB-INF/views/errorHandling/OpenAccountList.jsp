<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en"><head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>升级老板号错误处理</title>

		<!-- Bootstrap -->
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/back-style.css" rel="stylesheet">
		<link href="../css/dashboard.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="../css/calendar/jquery.datetimepicker.css"/>
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		
		<script type="text/javascript">
		
		//分页公共方法
		function pageForword(pageIndex){
			
			if(pageIndex < 5){
				$(".pagination li").addClass("active").siblings().removeClass("active");
			}
			if(pageIndex <= 0){
				pageIndex=1;
			}
			console.info(pageIndex);
			$.ajax({
				type:"GET",
				data:"",
				datatype:"json",
				url:"../Account/showListOpenAccount.jhtml?pageIndex="+pageIndex,
				success:function(data){
					$(".table-striped").html($(data).find(".table-striped").html());
					$(".pagination").html($(data).find(".pagination").html());
				},error:function(){
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
		
		function upBoss(upBoss) {
			$.ajax({
				
				url:"../Account/isUpBoos.jhtml?upBossErrId="+upBoss,
				dataType:"json",
				type:"GET",
				success:function(data){
					console.info(data);
					if(data=="upBossOk") {
						alert("升级老板号成功了");
					}else {
						alert("升级老板号失败了");
					}
				},error:function(){
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
									<tbody>
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
								<tbody>
							<c:forEach items="${upbosslogsList}" var="upbosslogsList">
									<tr>
										<td>${upbosslogsList.beautifulYard}</td>
										<td>${upbosslogsList.provinceName}</td>
										<td>${upbosslogsList.cityName}</td>
										<td>${upbosslogsList.openNumber}</td>
										<td>${upbosslogsList.shopCount}</td>
										<td><fmt:formatDate value="${upbosslogsList.payDate}" type="date" dateStyle="default"/> </td>
										<td>${upbosslogsList.marker}</td>
										<td><a href="java.script:void(0)" onclick="upBoss('${upbosslogsList.upBossId}')">升级老板号</a></td>
									</tr>
							</c:forEach>
								</tbody>
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