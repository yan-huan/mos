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
				
				url:"../channelInfo/allOpenAccountList.jhtml?isqd=isqudao&finance="+finance+"&pageIndex="+pageIndex,
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
	    						str+="<tr>"
    							if(data.finance == 1){
    	    					str+="<td><a href=\"../Account/index.jhtml?type=2&finance=1&accountId="+data.accountId+"\" id=\"beautifulName\">"+data.beautifulyard+"</a></td>";
    	    						}
   	    						if(data.finance != 1){
   	    						str+="<td ><a href=\"../Account/index.jhtml?type=2&accountId="+data.accountId+"\" id=\"beautifulName\">"+data.beautifulyard+"</a></td>";
   	    						}
	    						
	    						str+="<td id=\"province\">"+data.provinceName+"</td>";
	    						str+="<td id=\"city\">"+data.cityName+"</td>";
	    						str+="<td id=\"mobile\">"+data.openNumber+"</td>";
	    						str+="<td id=\"openCount\">"+data.shopCount+"</td>";
	    						str+="<td id=\"payDate\">"+data.payDate.split(" ")[0]+"</td>";
	    						str+="<td id=\"sellPerson\">"+data.market+"</td>";
	    						str+="<td><a href=\"../channelInfo/findAllChannelInfo.jhtml?qudao=1&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">查看详情</a></td>";
								if (data.isShowQudaoList == 0){
								str+="<td class=\"text-status-gray\">未提交</td>";
								}
								if (data.isShowQudaoList == 1 && data.approvalStatus == 1){
								str+="<td class=\"text-status-normal\">待审批</td>";
								}
								if (data.isShowQudaoList == 1 && data.approvalStatus == 2){
								str+="<td class=\"text-status-success\">已开通</td>";
								}
								if (data.isShowQudaoList == 1 && data.approvalStatus == 3){
								str+="<td class=\"text-status-danger\">退回 &nbsp;&nbsp;";
								str+="<img  src=\"../images/yuanyin.png\" title=\""+data.refuseInfo+"\" width= 21px;></td>";
								}
								if (data.isShowQudaoList == 1 && data.approvalStatus == 4){
									str+="<td class=\"text-status-normal\">待审批</td>";
									}
	    						//审批状态
 	    						//1未审批，2审批通过，3审批未通过
	    						str+="</tr>";
	    						$("#allData").html(str);
	    						$("#allpage").html("");
	    					}else  {
	    						alertInfo("不存在当前手机号的美容院！");
	    					}
	    					
	    				},error:function(){
	    					//展示错误提示的弹框
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
					<h3 class="page-header">账号列表</h3>
						
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
									<th>审批状态</th>
								</tr>
							</thead>
								<tbody id="allData">
									<c:forEach items="${openAccountPageList.content}" var="openAccountPageList">
										
											<tr>
												<td><a href="../Account/index.jhtml?type=2&isqudao=isqudao&accountId=${openAccountPageList.accountId}" target="view_window">${openAccountPageList.beautifulyard}</a></td>
												<td>${openAccountPageList.provinceName}</td>
												<td>${openAccountPageList.cityName}</td>
												<td>${openAccountPageList.openNumber}</td>
												<td>${openAccountPageList.shopCount}</td>
												<td><fmt:formatDate value="${openAccountPageList.payDate}" type="date" dateStyle="default"/> </td>
												<td>${openAccountPageList.market}</td>
												
												<!--渠道  -->
												<td><a href="../channelInfo/findAllChannelInfo.jhtml?qudao=1&accountId=${openAccountPageList.accountId}" class="btn btn-xs btn-info">查看详情</a></td>
												<c:if test="${openAccountPageList.isShowQudaoList eq 0}">
													<td class="text-status-gray">
													未提交
													</td>
												</c:if>
												
												<c:if test="${openAccountPageList.approvalStatus == 1 and openAccountPageList.isShowQudaoList eq 1}">
													<td class="text-status-normal">
													待审批
													</td>
												</c:if>
												
												<c:if test="${openAccountPageList.approvalStatus == 2 and openAccountPageList.isShowQudaoList eq 1}">
													<td class="text-status-success">
													已开通
													</td>
												</c:if>
												
												<c:if test="${openAccountPageList.approvalStatus == 3 and openAccountPageList.isShowQudaoList eq 1}">
													<td class="text-status-danger">
													退回 &nbsp;
													&nbsp;<img alt="" src="../images/yuanyin.png" title="${openAccountPageList.refuseInfo}" width= 21px;>
													</td>
												</c:if>
												
												<c:if test="${openAccountPageList.approvalStatus == 4 and openAccountPageList.isShowQudaoList eq 1}">
													<td class="text-status-normal">
													待审批
													</td>
												</c:if>
												
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
								
						 </ul>
						</nav>
					</div>
				</div>
			</div>
		</section>
		<form action="http://localhost:8080/myb-mos/contract/test.jhtml" method="post">
		<input name="aaa" value="ddddd"/>
		<input type="submit" value="tj" />
		</form>
		<!--/#contact-page-->

		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p class="text-muted pull-right">美业邦 (北京) 科技有限公司 Copyright®2016</p>
			</div>
		</footer>
	</body>
</html>