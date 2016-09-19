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
		console.info(${aaa});
		//分页公共方法
		function pageForword(pageIndex){
			
			if(pageIndex < 5){
				$(".pagination li").addClass("active").siblings().removeClass("active");
			}
			if(pageIndex <= 0){
				pageIndex=1;
			}
			$.ajax({
				type:"POST",
				data:"",
				datatype:"html",
				url:"../free/showFreeListOpenAccount.jhtml?pageIndex="+pageIndex,
				success:function(data){
					$(".table-striped").html($(data).find(".table-striped").html());
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
		
		function  isOk(type,accountId) {
				$.ajax({
					type:"POST",
					data:{"type":type,"accountId":accountId},
					dataType:"json",
					url:"../free/freeIsOk.jhtml",
					success:function(data){
						if (data == "1") {
							alertInfoAndHref("操作成功","../free/showFreeListOpenAccount.jhtml");
						} else {
							alertInfo("操作失败了");
						}
					},error:function(){
						//展示错误提示的弹框
						alertInfo("连接超时了");
					}
					
					
				});
				
		}
		$(function(){
			
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
					<h3 class="page-header">免费版注册审核</h3>
						<!-- <div class="row head">
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
										<td><a href="javascript:void(0)" id="searchBeautiful" class="btn btn-info btn-sm">查询</a></td>
									</tr>
								</tbody>
								</table>
								</form>
							</div>
						</div> -->
						<br>
						<table class="table table-striped table-bordered " style="margin-bottom: 0px;">
							<thead>
								<tr>
									<th>美容院名称</th>
									<th>省份</th>
									<th>城市</th>
									<th>老板手机号</th>
									<th>开通日期</th>
									<th>操作</th>
									<th>审批状态</th>
								</tr>
							</thead>
								<tbody id="allData">
									<c:forEach items="${openAccountPageList.content}" var="openAccountPageList">
											<tr>
												<td>${openAccountPageList.beautifulyard}${openAccountPageList.approvalStatus}</td>
												<td>${openAccountPageList.provinceName}</td>
												<td>${openAccountPageList.cityName}</td>
												<td>${openAccountPageList.openNumber}</td>
												<td><fmt:formatDate value="${openAccountPageList.updateDate}" type="date" dateStyle="default"/> </td>
												<td>
												<c:if test="${openAccountPageList.approvalStatus eq 1}">
												<a href="javascript:void(0)" id="ispass" onclick="isOk('ispass','${openAccountPageList.accountId}')" class="btn btn-info btn-sm">通过</a>
												<a href="javascript:void(0)" id="isrefuse" onclick="isOk('isrefuse','${openAccountPageList.accountId}')" class="btn btn-info btn-sm">拒绝</a>
												</c:if>
												<c:if test="${openAccountPageList.approvalStatus ne 1}">
												已审批
												</c:if>
												
												</td>
												<td>
												<c:choose>
													<c:when test="${openAccountPageList.approvalStatus eq 2 }">
													通过
													</c:when>
													<c:when test="${openAccountPageList.approvalStatus eq 1 }">
													未审批
													</c:when>
													<c:otherwise>
													未通过
													</c:otherwise>
												</c:choose>
												</td>
											</tr>
									</c:forEach>
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
		<!--/#contact-page-->

		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
	</body>
</html>