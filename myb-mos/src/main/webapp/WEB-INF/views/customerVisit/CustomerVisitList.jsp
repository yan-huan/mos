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
		<link href="../css/bootstrap/bootstrap-datetimepicker.min.css?v=2016817" rel="stylesheet" media="screen">
		<script src="../js/jquery-2.1.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../js/validate.js"></script>
		<script src="../js/alertInfo.js"></script>
		<script type="text/javascript">
		
		//分页公共方法
		function pageForword(pageIndex){
			if(pageIndex < 5){
				$(".pagination li").addClass("active").siblings().removeClass("active");
			}
			if(pageIndex <= 0){
				pageIndex=1;
			}
			var finance = "${finance}";
			$.ajax({
				type:"GET",
				data:"",
				datatype:"html",
				url:"../crm/showListCustomer.jhtml?pageIndex="+pageIndex,
				success:function(data){
					$(".table-striped").html($(data).find(".table-striped").html());//******
					$(".pagination").html($(data).find(".pagination").html());
				},error:function(){
					//展示错误提示的弹框
					alertInfo("连接超时了");
				}
			});
		}
		
		function go (){
			var pageIndex = $(".goPageIndex").val();
			pageForword(pageIndex);
		}
		
		$(function(){
			var endDate = "${endDate}";
			var startDate = "${startDate}";
			
			$(".startDate").val(startDate);
			$(".endDate").val(endDate);
			$(".downExcel").click(function(){
				$.ajax({
					type:"GET",
					data:"",
					datatype:"json",
					url:"http://192.168.2.108:8989/myb-mos-api/file/customerExcel?area=1",
					success:function(data){
						if (data=="1"){
							alertInfo("下载成功");
						}else {
							alertInfo("下载失败");
							
						}
					},error:function(){
						//展示错误提示的弹框
						alertInfo("连接超时了");
					}
				});
				
				
			});
			
			$.ajax({
				type:"GET",
				dataType:"json",
				url:"../crm/manageUserInfo.jhtml?visitRecode=1",
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
					var belongTeam = "${belongTeam}"
					if (belongTeam != "" && belongTeam =="belongTeamBossBj") {
						
					} else if (belongTeam != "" && belongTeam =="belongTeamBj") {
						
					}
				},error:function(){
					//展示错误提示的弹框
					alertInfo("连接超时了");
				}
			});
			
			
			$(".search").click(function(){
				var startDate = $(".startDate").val();
				var endDate =$(".endDate").val();
				var xiaozu = $("#xz option:selected").val();
				$.ajax({
					type:"GET",
					dataType:"html",
					data:{"startDate":startDate,"endDate":endDate,"xiaozu":xiaozu},
					url:"../crm/crmVisitRecode.jhtml",
					success:function(data){
						console.info(data);
							$(".table-striped").html($(data).find(".table-striped").html());
//								alertInfo("下载成功");
					},error:function(){
						//展示错误提示的弹框
						alertInfo("连接超时了");
					}
				});
				
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
					<h3 class="page-header">拜访管理列表</h3>
						<div class="row head">
							<div class="col-md-8">
							<form id="yanzheng">
								<table class="table-nobordered">
									<tbody><tr>
										<td>
											<input type="text" class="form_datetime form-control startDate"  placeholder="开始时间" >
										</td>
										<td>
											<input type="text" class="form_datetime form-control endDate"  placeholder="截止时间" >
										</td>
										<td>
										<select id="xz" class=" form-control" name="xiaozu">
											<option value="all">全部</option>
										</select>
										</td>
										
										<td><a href="javascript:void(0)"  class="btn btn-info btn-sm search">查询</a></td>
										<%--<c:if test="${employee.userName eq 'admin' }">
											<td><a href="http://101.201.42.115:8989/myb-mos-api/file/customerExcel?area=1"   class="btn btn-info btn-sm">下载excel</a></td>
										</c:if>--%>
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
									<th>城市</th>
									<th>团队</th> 
									<th>人员</th>
									<th>拜访数</th>
									<th>有效数</th>
									<th>拜访店数</th>
									<th>有效店数</th>
								</tr>
							</thead>
								<tbody id="allData">
										<c:forEach items="${visitrecords}" var="visitrecords">
											<tr>
												<td>
													<a href="JavaScript:void(0)" target="view_window"> ${fn:substring(visitrecords.xiaozu, 0, 2)}</a>
												</td>
												<td>
												${visitrecords.xiaozu}
												</td>
												<td>${visitrecords.xingming}</td>
												<td>${visitrecords.allCount}</td>
												<td>${visitrecords.isValideCount}</td>
												<td>${visitrecords.shopAllCount}</td>
												<td>${visitrecords.shopValideCount}</td>
											</tr>
									</c:forEach>
										<tr>
											<td>
												合计
											</td>
											<td>

											</td>
											<td></td>
											<td>${visitTotal}</td>
											<td>${visitValidTotal}</td>
											<td>${shopTotal}</td>
											<td>${shopValidTotal}</td>
										</tr>
						</tbody>
					<tbody id="searchContent">
						
					</tbody>
						</table>
						<nav id="allpage">
							<ul class="pagination pull-right">
								<li >
									<a href="javascript:void(0)" aria-label="Previous" onclick="pageForword(${openAccountPageList.pageIndex -1})"><span aria-hidden="true">«</span></a>
								</li>
								
							<!--开总页数小于5   -->
							<c:if test="${openAccountPageList.totalPage<=5 }">
								<c:forEach begin="1" end="${openAccountPageList.totalPage}" var="currentPage">
								<li  <c:if test="${currentPage ==  openAccountPageList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
								</c:forEach>
							</c:if>
								
							<!--总页数大于5  -->
							<c:if test="${openAccountPageList.totalPage > 5}">
								<!--当前索引小于3  -->
								<c:if test="${openAccountPageList.pageIndex <= 3}">
									<c:forEach begin="1" end="5" var="currentPage"> 
									<li  <c:if test="${currentPage ==  openAccountPageList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
									</c:forEach>
								</c:if>
								
								<!--当前索引大于3  -->
								<c:if test="${openAccountPageList.pageIndex > 3}">
									<li><a href="javascript:void(0)" onclick="pageForword(1)">1</a></li>
									<li><a href="javascript:void(0)" >...</a></li>
									<!--当前页加2小于total  -->
									
									<c:choose>
										<c:when test="${openAccountPageList.pageIndex*1 + 2 < openAccountPageList.totalPage }">
											<c:forEach begin="${openAccountPageList.pageIndex -2 }" end="${openAccountPageList.pageIndex + 2}" var="currentPage"> 
											<li  <c:if test="${currentPage ==  openAccountPageList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
											</c:forEach>
											<li><a href="javascript:void(0)" >...</a></li>
											<li><a href="javascript:void(0)" onclick="pageForword(${openAccountPageList.totalPage})">${openAccountPageList.totalPage}</a></li>
										</c:when>
										<c:otherwise>
											<c:forEach begin="${openAccountPageList.totalPage -4}" end="${openAccountPageList.totalPage}" var="current">
												<li  <c:if test="${current ==  openAccountPageList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${current})">${current}</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:if>
								
							<!--点击过之后的分页start当前页小于5  -->
							<c:if test="${openAccountPageList.pageIndex < openAccountPageList.totalPage}">
								<li>
									<a href="javascript:void(0)" aria-label="Next" onclick="pageForword(${openAccountPageList.pageIndex+1})"><span aria-hidden="true">»</span></a>
								</li>
							</c:if>
							
							<li style="display:inline-flex;">
								<input type="text"  class="form-control goPageIndex" style="width: 31%"/>
								<button onclick="go()">GO</button>
							</li>
						 </ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.js" charset="UTF-8"></script>
		<script type="text/javascript" src="../js/bootstrap/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
		
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
		
		</script>
		<!--/#contact-page-->
		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
	</body>
</html>