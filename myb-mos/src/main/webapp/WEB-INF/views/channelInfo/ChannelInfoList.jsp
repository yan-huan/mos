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
				url:"../channelInfo/searchChannelList.jhtml?pageIndex="+pageIndex,
				success:function(data){
					$(".table-striped").html($(data).find(".table-striped").html());
					$(".pagination").html($(data).find(".pagination").html());
				},error:function(){
					//展示错误提示的弹框
					alertInfo("连接超时了");
				}
			});
		}
		
		$(function(){
			
			//搜索渠道
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
					<c:if test="${finance eq 1}">
					<h3 class="page-header">和款开号</h3>
					</c:if>
					<c:if test="${finance ne 1}">
					<h3 class="page-header">渠道管理</h3>
					</c:if>
						
						<div class="row head">
						<a href="../utils/AddChannelInfo.jhtml"  class="btn btn-info btn-sm" style="float: right;margin-right: 10px;">渠道添加</a>
							<div class="col-md-8">
								<table class="table-nobordered">
									<tbody><tr>
										<td>
<!-- 											<input type="text" class="form-control mobile"  placeholder="手机号" dataType="Mobile" msg="请输入正确手机号"> -->
											<div id="demo" style="width: 100%;height: 36px;">
										        <div class="">
										            <div id="search-form"  style="width: 100%;"></div>
										        </div>
								   			 </div>
										</td>
										<td><a href="javascript:void(0)" id="searchQuDao" class="btn btn-info btn-sm">查询</a></td>
									</tr>
								</tbody>
								</table>
							</div>
						</div>
						<br>
						<table class="table table-striped table-bordered " style="margin-bottom: 0px;">
							<thead>
								<tr>
									<th>公司名称</th>
									<th>公司地址</th>
									<th>负责人 </th>
									<th>联系电话</th>
									<th>合同金额</th>
									<th>预存款</th>
									<th>折扣率</th>
									<th>保证金</th>
									<th>生效日期</th>
									<th>到期日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id="allData">
								<c:forEach items="${pagedList.content}" var="channelInfoPageList">
								
									<tr>
										<td><a href="../Account/showListOpenAccountChannel.jhtml?channelId=${channelInfoPageList.channelId}" target="view_window">${channelInfoPageList.companyName}</a></td>
										<td>${channelInfoPageList.companyAddress}</td>
										<td>${channelInfoPageList.personInCharge}</td>
										<td>${channelInfoPageList.phone}</td>
										<td>${channelInfoPageList.contractMoney}</td>
										<td>${channelInfoPageList.readyDepositMoney}</td>
										<td>${channelInfoPageList.discountRate}</td>
										<td>${channelInfoPageList.marginMoney}</td>
										<td><fmt:formatDate value="${channelInfoPageList.openTime}" type="date" dateStyle="default"/></td>
										<td><fmt:formatDate value="${channelInfoPageList.endTime}" type="date" dateStyle="default"/></td>
										<td>
										<a href="../channelInfo/modifyChannel.jhtml?channelId=${channelInfoPageList.channelId}">修改</a>&nbsp;&nbsp;<a href="../utils/OpenAccount.jhtml?isqd=isqudao&channelId=${channelInfoPageList.channelId}" class="" id="openAccount">创建账号</a>
										&nbsp;<a href="../utils/channelAccountToChannel.jhtml?channelId=${channelInfoPageList.channelId}">直营转渠道</a>&nbsp;<img alt="" src="../images/yuanyin.png" title="直营账号转给渠道当前公司名下" width= 21px;>
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
								<c:if test="${pagedList.totalPage >1}">
									<a href="javascript:void(0)" aria-label="Previous" onclick="pageForword(${pagedList.pageIndex -1})"><span aria-hidden="true">«</span></a>
								</c:if>
								</li>
								
							<!--开总页数小于5   -->
							<c:if test="${pagedList.totalPage<=5 }">
								<c:forEach begin="1" end="${pagedList.totalPage}" var="currentPage">
								<li  <c:if test="${currentPage ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
								</c:forEach>
							</c:if>
								
							<!--总页数大于5  -->
							<c:if test="${pagedList.totalPage > 5}">
								<!--当前索引小于3  -->
								<c:if test="${pagedList.pageIndex <= 3}">
									<c:forEach begin="1" end="5" var="currentPage"> 
									<li  <c:if test="${currentPage ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
									</c:forEach>
								</c:if>
								
								<!--当前索引大于3  -->
								<c:if test="${pagedList.pageIndex > 3}">
									<li><a href="javascript:void(0)" onclick="pageForword(1)">1</a></li>
									<li><a href="javascript:void(0)" >...</a></li>
									<!--当前页加2小于total  -->
									
									<c:choose>
										<c:when test="${pagedList.pageIndex*1 + 2 < pagedList.totalPage }">
											<c:forEach begin="${pagedList.pageIndex -2 }" end="${pagedList.pageIndex + 2}" var="currentPage"> 
											<li  <c:if test="${currentPage ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${currentPage})">${currentPage}</a></li>
											</c:forEach>
											<li><a href="javascript:void(0)" >...</a></li>
											<li><a href="javascript:void(0)" onclick="pageForword(${pagedList.totalPage})">${pagedList.totalPage}</a></li>
										</c:when>
										<c:otherwise>
											<c:forEach begin="${pagedList.totalPage -4}" end="${pagedList.totalPage}" var="current">
												<li  <c:if test="${current ==  pagedList.pageIndex}">class="active"</c:if>><a href="javascript:void(0)" onclick="pageForword(${current})">${current}</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</c:if>
							</c:if>
								
							<!--点击过之后的分页start当前页小于5  -->
							<c:if test="${pagedList.pageIndex < pagedList.totalPage}">
								<li>
									<a href="javascript:void(0)" aria-label="Next" onclick="pageForword(${pagedList.pageIndex+1})"><span aria-hidden="true">»</span></a>
								</li>
							</c:if>
								
						 </ul>
						</nav>
					</div>
				</div>
			</div>
			
			<div class="modal" id="mymodal" style="display: none;">
							<div class="modal-dialog" style="width: 900px;">
								<div class="modal-content" style="width: 386px;margin: auto;">
									<div class="modal-body">
										<table class="table table-bordered">
											<tbody>
											<tr>
												<th width="20%">拒绝原由</th>
												<td width="30%">
													<input type="text" id="refuseInfo" class="form-control" placeholder="必填内容" datatype="Require" msg="请输入内容">
												</td>
											</tr>
										</tbody>
									</table>
									</div>
									<div class="modal-footer" >
										<button type="button" class="btn btn-success" id="saveRefuseInfo">保存</button>
										<button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeWin()">关闭</button>	
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
		<script src="../js/time/timeUnix.js"></script>
		<script src="../js/autocomplete/autocompleteQudao.js"></script>
   	    <script type="text/javascript">
   	    
   	    $(function(){
   	 	
   	   	   		 //销售的autocomplate
   	   	    	var arr = new Array();
   	   	    	$('#search-form').autocomplete({
   	   				hints: arr,
   	   				width: 386,
   	   				height: 35,
   	   				onSubmit: function(text){
   	   					
   	   					var inp = $(".autocomplete-input").val();
   	   					if (inp == null ||$.trim(inp) == ""){
   	   						//展示错误提示的弹框
   	   						alertInfo("请输入渠道名称");
   	   						return false;
   	   					}
   	   					
   	   				}
   	   			});
   	   	    	
   	   	  $(".autocomplete-input").attr("datatype","Require").css("width","100%");
   	   	  $(".autocomplete-container").css("width","100%");
   	   	  	//
   			$(".autocomplete-input").focus(function(){
   				arr.length=0;
   				$.ajax({
   	   				url:"../channelInfo/searchAllChannel.jhtml",
   	   				type:"GET",
   	   				dataType:"json",
   	   				success:function(data){
   	   					console.info(data);
   	   					for(var s=0; s<data.length; s++){
   	   						arr.push(data[s].companyName+"-("+data[s].channelId+")");
   	   					}
   	   					return false;
   	   					},error:function(){
   	   						//展示错误提示的弹框
   	   						alertInfo("连接超时了");
   	   				}
   	   				
   	   			});
			});
   	    });
   	    
   	    </script>
	</body>
</html>