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
				url:"../Account/showListOpenAccount.jhtml?isqd=isqudao&finance="+finance+"&pageIndex="+pageIndex,
				success:function(data){
					$(".table-striped").html($(data).find(".table-striped").html());
					$(".pagination").html($(data).find(".pagination").html());
				},error:function(){
					//展示错误提示的弹框
					alertInfo("连接超时了");
				}
				
				
			});
		}
		
		function toForWord(accountId){
			console.info(111);
			$.ajax({
				type:"POST",
				data:{"channelId":-1,"accountId":accountId},
				dataType:"json",
				url:"../channelInfo/toForword.jhtml",
				success:function(data){
					if (data=="1") {
						alertInfo("操作成功了");
						location.reload();
					}else {
						alertInfo("操作失败了");
					}
				},error:function(){
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
    							str+="<td><a href=\"../Account/index.jhtml?type=2&isqudao=isqudao&finance=1&accountId="+data.accountId+"\" target=\"view_window\">"+data.beautifulyard+"</a></td>"	
    	    						}
   	    						if(data.finance != 1){
   	    							str+="<td><a href=\"../Account/index.jhtml?type=2&isqudao=isqudao&accountId="+data.accountId+"\" target=\"view_window\">"+data.beautifulyard+"</a></td>"
   	    						}
	    						str+="<td id=\"province\">"+data.provinceName+"</td>";
	    						str+="<td id=\"city\">"+data.cityName+"</td>";
	    						str+="<td id=\"mobile\">"+data.openNumber+"</td>";
	    						str+="<td id=\"openCount\">"+data.shopCount+"</td>";
	    						str+="<td id=\"payDate\">"+data.payDate.split(" ")[0]+"</td>";
	    						str+="<td id=\"sellPerson\">"+data.market+"</td>";
	    						if(data.approvalStatus == 1 && data.finance != 1){
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data.finance+"&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">查看详情</a></td>";	
	    						}
	    						if(data.approvalStatus == 3 && data.finance != 1){
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data.finance+"&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">查看详情</a></td>";	
	    						}
	    						if(data.approvalStatus == 4 && data.finance != 1){
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data.finance+"&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">查看详情</a></td>";	
	    						}
	    						if(data.approvalStatus == 1 && data.finance ==1){
	    							/*财务看的  */
	    							str+="<td><a href=\"../contract/contractInfo.jhtml?type=2&finance="+data.finance+"&accountId="+data.accountId+"\" class=\"btn btn-xs btn-info\">审核</a></td>";	
	    						}
	    						if(data.approvalStatus == 2 ){
	    							str+="<td></td>";	
	    						}
	    						//样咧
								if(data.approvalStatus == 1){
	    						str+="<td class=\"text-status-normal\">待审批</td>";
								}				
								if(data.approvalStatus == 2){
	    						str+="<td class=\"text-status-success\">已开通</td>";
								}				
								if(data.approvalStatus == 3){
	    						str+="<td class=\"text-status-danger\">退回 &nbsp;&nbsp; <a href=\"../utils/contractSave.jhtml?edit=1&accountId="+data.accountId+"\" class=\"glyphicon glyphicon-pencil\" style=\"color: #999\"><img  src=\"../images/yuanyin.png\" title=\""+data.refuseInfo+"\" width=\"21px;\"></a>";
								str+="</td>";
								}				
								if(data.approvalStatus == 4){
								str+="<td class=\"text-status-normal\">待审批</td>";
								}				
	    						//审批状态
 	    						//1未审批，2审批通过，3审批未通过
	    						str+="</tr>";
	    						$("#allData").html(str);
	    						$("#allpage").html("");
	    					}else  {
	    						alert("不存在当前手机号的美容院！");
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
					<c:if test="${finance eq 1}">
					<h3 class="page-header">渠道开号</h3>
					</c:if>
					<c:if test="${finance ne 1}">
					<h3 class="page-header">账号列表</h3>
					</c:if>
						
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
							<c:choose>
								<c:when test="${finance eq 1 }">
										<c:forEach items="${openAccountPageList}" var="openAccountPageList">
										
											<tr>
											
												<c:if test="${finance eq 1}">
												<td><a href="../Account/index.jhtml?type=2&finance=1&accountId=${openAccountPageList.accountId}" target="view_window">${openAccountPageList.beautifulyard}</a></td>
												</c:if>
												<td>${openAccountPageList.provinceName}</td>
												<td>${openAccountPageList.cityName}</td>
												<td>${openAccountPageList.openNumber}</td>
												<td>${openAccountPageList.shopCount}</td>
												<td><fmt:formatDate value="${openAccountPageList.payDate}" type="date" dateStyle="default"/> </td>
												<td>${openAccountPageList.market}</td>
												
												<td>
													
													<c:if test="${openAccountPageList.approvalStatus == 1}">
													<a href="../channelInfo/findAllChannelInfo.jhtml?accountId=${openAccountPageList.accountId}" class="btn btn-xs btn-info">审核</a>
													</c:if>
												</td>
												
												<c:if test="${openAccountPageList.approvalStatus == 1}">
													<td class="text-status-normal">
													待审批
													</td>
												</c:if>
												
												<c:if test="${openAccountPageList.approvalStatus == 2}">
													<td class="text-status-success">
													已开通
													</td>
												</c:if>
												
												<c:if test="${openAccountPageList.approvalStatus == 3}">
													<td class="text-status-danger">
													退回 &nbsp;&nbsp; <a href="../utils/contractSave.jhtml?edit=1&accountId=${openAccountPageList.accountId}" class="glyphicon glyphicon-pencil" style="color: #999"></a>
													</td>
												</c:if>
												
												<c:if test="${openAccountPageList.approvalStatus == 4}">
													<td class="text-status-normal">
													待审批
													</td>
												</c:if>
												
											</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${openAccountPageList}" var="openAccountPageList">
										
											<tr>
												<c:if test="${finance ne 1}">
												<td><a href="../Account/index.jhtml?type=2&isqudao=isqudao&accountId=${openAccountPageList.accountId}">${openAccountPageList.beautifulyard}</a></td>
												</c:if>
												<td>${openAccountPageList.provinceName}</td>
												<td>${openAccountPageList.cityName}</td>
												<td>${openAccountPageList.openNumber}</td>
												<td>${openAccountPageList.shopCount}</td>
												<td><fmt:formatDate value="${openAccountPageList.payDate}" type="date" dateStyle="default"/> </td>
												<td>${openAccountPageList.market}</td>
												
												<td>
												<!--渠道  -->
												<c:if test="${qudao eq 1 }">
													<a href="../channelInfo/findAllChannelInfo.jhtml?qudao=1&accountId=${openAccountPageList.accountId}" class="btn btn-xs btn-info">查看详情</a>
													<a href="java:void(0)" onclick="toForWord('${openAccountPageList.accountId}')" class="btn btn-xs btn-info">转移直营</a>
												</c:if>
												<!--财务  -->
												<c:if test="${qudao ne 1 }">
													<a href="../channelInfo/findAllChannelInfo.jhtml?accountId=${openAccountPageList.accountId}" class="btn btn-xs btn-info">查看详情</a>
													<a href="java:void(0)" onclick="toForWord('${openAccountPageList.accountId}')" class="btn btn-xs btn-info">转移直营</a>
												</c:if>
												</td>
												
												<c:if test="${openAccountPageList.approvalStatus == 1 and openAccountPageList.isShowQudaoList eq 0}">
													<td class="text-status-normal">
													待完善
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
													退回 &nbsp;&nbsp; <a href="../utils/contractSave.jhtml?edit=1&accountId=${openAccountPageList.accountId}&th=1" class="glyphicon glyphicon-pencil" style="color: #999"></a>
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
								</c:otherwise>
							</c:choose>
							
						</tbody>
						</table>
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